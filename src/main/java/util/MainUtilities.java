package util;

import java.util.Iterator;
import java.util.List;

public class MainUtilities {
    public static boolean logIn(String username, String password) throws Exception {
        List<String> list = FileUtilities.readFromFile("admin.txt");
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
}
