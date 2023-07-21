package method;

import exception.WordNotFoundException;
import util.FileUtilities;

import java.io.FileWriter;
import java.util.*;

public class MethodsImpl implements Methods {
    public boolean logIn(String username, String password) throws Exception {
        List<String> list = FileUtilities.readFromFile("admin");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String[] str = iterator.next().split("-");
            if (username.equalsIgnoreCase(str[0]) && password.equalsIgnoreCase(str[1])) {
                return true;
            }
        }
        return false;
    }

    public boolean signUp(String username, String password) throws Exception {
        if (logIn(username, password)) {
            System.err.println("Admin Already Exist");
            return false;
        }
        FileUtilities.writeWordToFile(username, password, "admin.txt");
        return true;
    }

    public void seeAllDictName() throws Exception {
        List<String> list = FileUtilities.readFromFile("dictnames");
        list.stream().forEach(s -> System.out.println(s));
    }

    public String findWord(String word, String fileName) throws Exception {
        Iterator<String> iterator = FileUtilities.readFromFile(fileName).iterator();
        Map<String, String> map = new HashMap<>();
        while (iterator.hasNext()) {
            String[] arr = iterator.next().split("-");
            map.put(arr[0], arr[1]);
            map.put(arr[1], arr[0]);
        }
        String result = map.get(word);
        map.clear();
        return result;
    }

    @Override
    public void updateWord(String word, String newWord, String fileName) throws Exception {
        List<String> list = FileUtilities.readFromFile(fileName);
        Map<String, String> map = new HashMap<>();
        for (String str : list) {
            String[] arr = str.split("-");
            map.put(arr[0], arr[1]);
        }
        Collection<String> collection = map.values();
        Set<String> keySet = map.keySet();
        map.clear();
        ArrayList<String> arrValues = new ArrayList<>();
        ArrayList<String> arrKeys = new ArrayList<>();
        arrValues.addAll(collection);
        arrKeys.addAll(keySet);

        if (collection.contains(word)) {
            arrValues.set(arrValues.indexOf(word), newWord);
        } else if (keySet.contains(word)) {
            arrKeys.set(arrKeys.indexOf(word), newWord);
        } else {
            throw new WordNotFoundException("Word does not exist");
        }

        FileWriter fw = new FileWriter(fileName + ".txt");
        fw.close();

        for (int i = 0; i < list.toArray().length; i++) {
            String text = arrKeys.get(i) + "-" + arrValues.get(i);
            FileUtilities.writeWordToFile(text, fileName);
        }

    }

    @Override
    public void deleteWord(String word, String fileName) throws Exception {
        List<String> list = FileUtilities.readFromFile(fileName);

        FileWriter fw = new FileWriter(fileName + ".txt");
        fw.close();

        boolean exist = false;

        for (String str : list) {
            String[] arr = str.split("-");
            if (arr[0].equalsIgnoreCase(word) || arr[1].equalsIgnoreCase(word)) {
                exist = true;
                continue;
            }
            FileUtilities.writeWordToFile(str, fileName);
        }
        if(!exist){
            throw new WordNotFoundException("Word does not exist");
        }
    }
}
