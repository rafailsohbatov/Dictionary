package util;


import exception.WordNotFoundException;
import method.Methods;

import java.util.Scanner;

public class MainUtilities {
    private Scanner scanner;
    private Methods methods;

    public MainUtilities(Scanner scanner, Methods methods) {
        this.scanner = scanner;
        this.methods = methods;

    }

    public void processAdmin() {
        try {
            System.out.print("Enter Username: ");
            String username = scanner.next();
            System.out.print("Enter Password: ");
            String password = scanner.next();
            methods.logIn(username, password);
            System.out.println("1.Create Dictionary\n2.Add Word To Dictionary\n3.Create Admin\n4.Update Word\n5.Delete Word");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.print("Enter New Dictionary Name: ");
                    String newFileName = scanner.next();
                    FileUtilities.writeWordToFile(newFileName, "dictnames");
                    FileUtilities.createFile(newFileName);
                    break;
                case 2:
                    System.out.print("Enter Word 1: ");
                    String word1 = scanner.next();
                    System.out.print("Enter Word 2: ");
                    String word2 = scanner.next();
                    System.out.print("Enter Dictionary Name: ");
                    String fileName = scanner.next();
                    FileUtilities.writeWordToFile(word1, word2, fileName);
                    break;
                case 3:
                    System.out.print("Enter Username: ");
                    String newUserName = scanner.next();
                    System.out.print("Enter Password: ");
                    String newPassword = scanner.next();
                    if (methods.signUp(newUserName, newPassword)) {
                        System.out.println("Success");
                    }
                    break;
                case 4:
                    System.out.println("enter the word to change");
                    String word = scanner.next();
                    System.out.println("enter new word");
                    String newWord = scanner.next();
                    System.out.println("enter dictionary name");
                    String dictName = scanner.next();
                    methods.updateWord(word, newWord, dictName);
                    break;
                case 5:
                    System.out.println("enter  word");
                    String delWord = scanner.next();
                    System.out.println("enter dictionary name");
                    String delWordDictName = scanner.next();
                    methods.deleteWord(delWord, delWordDictName);
                    break;
                default:
                    System.out.println("There Is No Such Option");
            }
        }catch (WordNotFoundException ex){
            ex.printStackTrace();
        }catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void processUser() {
        try {
            System.out.println("1.See All Dictionaries\n2.To Translate The Word");
            switch (scanner.nextInt()) {
                case 1:
                    methods.seeAllDictName();
                    break;
                case 2:
                    System.out.print("Enter Dictionary Name: ");
                    String fileName = scanner.next();
                    System.out.print("Enter Word: ");
                    String word = scanner.next();
                    String result = methods.findWord(word, fileName);
                    System.out.println("Translated Word: " + result);
                    break;
                default:
                    System.out.println("There Is No Such Option");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
