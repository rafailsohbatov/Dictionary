package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtilities {
    public static void writeWordToFile(String word1, String word2, String fileName) throws Exception {
        BufferedWriter bw = new BufferedWriter(createFile(fileName));
        bw.write(word1 + "-" + word2);
        bw.newLine();
        bw.close();
    }

    public static FileWriter createFile(String fileName) throws Exception {
        FileWriter fw = new FileWriter(fileName,true);
        return fw;
    }

    public static String findWord(String word, String fileName) throws Exception {
        BufferedReader bw = new BufferedReader(new FileReader(fileName));
        Map<String, String> map = new HashMap<>();
        while (bw.ready()) {
            String[] arr = bw.readLine().split("-");
            map.put(arr[0], arr[1]);
            map.put(arr[1], arr[0]);
        }
        String result = map.get(word);
        map.clear();
        return result;
    }

    public static List<String> readFromFile(String filepath) throws Exception{
        BufferedReader bw = new BufferedReader(new FileReader(filepath));
        List<String> list = new ArrayList<>();
        while (bw.ready()){
            list.add(bw.readLine());
        }
        return list;
    }
}
