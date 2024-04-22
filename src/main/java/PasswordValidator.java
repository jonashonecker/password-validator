public class PasswordValidator {
    public static boolean hasPasswordMinimalLength(String password) {
        return password.length() > 7;
    }

    public static boolean containsDigits(String password) {
        return password.matches(".*\\d.*");
    }
}
