package util;


import method.Methods;

import java.util.Scanner;

public class MainUtilities {
    private Scanner scanner;

    public MainUtilities(Scanner scanner) {
        this.scanner = scanner;
    }

    public void processAdmin() {
        try {
            System.out.print("Enter Username: ");
            String username = scanner.next();
            System.out.print("Enter Password: ");
            String password = scanner.next();
            Methods.logIn(username, password);
            System.out.println("1.Create Dictionary\n2.Add Word To Dictionary\n3.Create Admin");
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
                    System.out.print("Enter File Name: ");
                    String fileName = scanner.next();
                    FileUtilities.writeWordToFile(word1, word2, fileName);
                    break;
                case 3:
                    System.out.print("Enter Username: ");
                    String newUserName = scanner.next();
                    System.out.print("Enter Password: ");
                    String newPassword = scanner.next();
                    if (Methods.signUp(newUserName, newPassword)) {
                        System.out.println("Success");
                    }
                    break;
                default:
                    System.out.println("There Is No Such Option");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void processUser() {
        try {
            System.out.println("1.See All Dictionaries\n2.To Translate The Word");
            switch (scanner.nextInt()) {
                case 1:
                    Methods.seeAllDictName();
                    break;
                case 2:
                    System.out.print("Enter Dictionary Name: ");
                    String fileName = scanner.next();
                    System.out.print("Enter Word: ");
                    String word = scanner.next();
                    String result = Methods.findWord(word, fileName);
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
