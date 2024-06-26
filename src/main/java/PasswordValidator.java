import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class PasswordValidator {
    public static boolean hasPasswordMinimalLength(String password) {
        return password.length() > 7;
    }

    public static boolean containsDigits(String password) {
        return password.matches(".*\\d.*");
    }

    public static boolean containsUpperAndLowercaseLetters(String password) {
        return Pattern.compile("(?=.*[a-z])(?=.*[A-Z])").matcher(password).find();
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

    public static boolean containsSpecialCharacter(String password) {
        return !password.matches("[a-zA-Z0-9ß]*");
    }
}
