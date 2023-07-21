package method;

import util.FileUtilities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Methods {
    public static boolean logIn(String username, String password) throws Exception {
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

    public static boolean signUp(String username, String password) throws Exception {
        if (logIn(username, password)) {
            System.err.println("Admin Already Exist");
            return false;
        }
        FileUtilities.writeWordToFile(username, password, "admin.txt");
        return true;
    }

    public static void seeAllDictName() throws Exception{
        List<String> list  = FileUtilities.readFromFile("dictnames");
        list.stream().forEach(s -> System.out.println(s));
    }

    public static String findWord(String word, String fileName) throws Exception {
        Iterator<String> iterator = FileUtilities.readFromFile(fileName).iterator();
        Map<String, String> map = new HashMap<>();
        while (iterator.hasNext()) {
            String[] arr = iterator.next().split("-");
            map.put(arr[0],arr[1]);
            map.put(arr[1],arr[0]);
        }
        String result = map.get(word);
        map.clear();
        return result;
    }
}
