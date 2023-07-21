package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class FileUtilities {
    public static void writeWordToFile(String word1, String word2, String fileName) throws Exception {
        BufferedWriter bw = createFile(fileName);
        bw.write(word1 + "-" + word2);
        bw.newLine();
        bw.close();
    }

    public static void writeWordToFile(String word1, String fileName) throws Exception {
        BufferedWriter bw = createFile(fileName);
        bw.write(word1);
        bw.newLine();
        bw.close();
    }
    public static BufferedWriter createFile(String fileName) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName+".txt", true));
        return bw;
    }

    public static List<String> readFromFile(String filepath) throws Exception {
        BufferedReader bw = new BufferedReader(new FileReader(filepath + ".txt"));
        List<String> list = new ArrayList<>();
        while (bw.ready()) {
            list.add(bw.readLine());
        }
        return list;
    }
}
