import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class PasswordValidator {
    public static boolean hasPasswordMinimalLength(String password) {
        return password.length() > 7;
    }

    public static boolean containsDigits(String password) {
        return password.matches(".*\\d.*");
    }

    public static boolean containsUpperAndLowercaseLetters(String password) {
        return password.matches(".*[A-Z].*[a-z].*");
    }

    public static boolean containsCommonlyUsedPassword(String password) throws FileNotFoundException {
        String[] commonUsedPasswords = getCommonUsedPasswords();
        for (String pw : commonUsedPasswords) {
            if (pw.contains(password)) {
                return true;
            }
        }
        return false;
    }

    public static String[] getCommonUsedPasswords() throws FileNotFoundException {
        String[] output = new String[10000];
        int counter = 0;
        File commonPasswords = new File("src/main/resources/CommonPasswords.txt");
        Scanner readCommonPasswords = new Scanner(commonPasswords);
        while (readCommonPasswords.hasNextLine()) {
            output[counter] = readCommonPasswords.nextLine();
            counter++;
        }
        return output;
    }
}
