package main;


import method.Methods;
import util.FileUtilities;
import util.MainUtilities;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        MainUtilities mainUtilities = new MainUtilities(scanner);
        System.out.println("admin or user ?");
        switch (scanner.next()) {
            case "admin":
                mainUtilities.processAdmin();
                break;
            case "user":
               mainUtilities.processUser();
                break;
            default:
                System.out.println("There Is No Such Option");
        }
        main(args);
    }
}
