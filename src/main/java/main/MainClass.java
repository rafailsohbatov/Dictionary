package main;


import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("admin or user ?");
        switch (scan.next()){
            case "admin":
                System.out.println("1.Luget yarat\n2.Lugete soz elave et");
                break;
            case "user":
                break;
            default:
                System.out.println("Bu istifadeci yoxdur");
        }
        main(args);
    }
}
