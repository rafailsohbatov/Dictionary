package main;


import util.FileUtilities;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        System.out.println("admin or user ?");
        switch (scan.next()) {
            case "admin":
                System.out.println("1.Luget yarat\n2.Lugete soz elave et");
                switch (scan.nextInt()) {
                    case 1:
                        System.out.print("Enter New Dictionary Name: ");
                        String newFileName = scan.next();
                        FileUtilities.createFile(newFileName);
                        break;
                    case 2:
                        System.out.print("Enter Word 1: ");
                        String word1 = scan.next();
                        System.out.print("Enter Word 2: ");
                        String word2 = scan.next();
                        System.out.print("Enter File Name: ");
                        String fileName = scan.next();
                        FileUtilities.writeWordToFile(word1,word2,fileName);
                        break;
                    default:
                        System.out.println("Bu secim yoxdur");
                }
                break;
            case "user":
                System.out.print("Enter Dictionary Name: ");
                String fileName = scan.next();
                System.out.print("Enter Word: ");
                String word = scan.next();
                String result =  FileUtilities.findWord(word,fileName);
                System.out.println("Translated Word: " + result);
                break;
            default:
                System.out.println("Bu istifadeci yoxdur");
        }
        main(args);
    }
}
