import java.io.FileNotFoundException;
import java.util.Random;

public class PasswordGenerator {
    public static String[] characterList = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "+",
            "=", "[", "]", "{", "}", ";", ":", "'", "\"", "\\", "|", ",", ".", "<", ">", "/", "?"
    };

    public static String generatePassword() throws FileNotFoundException {
        Random random = new Random();
        String password = "";
        StringBuilder tempPassword = new StringBuilder();
        do {
            tempPassword.append(characterList[random.nextInt(characterList.length)]);
            password = tempPassword.toString();
        } while (!PasswordValidator.hasPasswordMinimalLength(password) ||
                !PasswordValidator.containsDigits(password) ||
                !PasswordValidator.containsUpperAndLowercaseLetters(password) ||
                PasswordValidator.containsCommonlyUsedPassword(password) ||
                !PasswordValidator.containsSpecialCharacter(password));
        return password;
    }
}
