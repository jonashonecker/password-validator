import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordGeneratorTest {
    private static String password;

    @BeforeAll
    public static void setup() throws FileNotFoundException {
        password = PasswordGenerator.generatePassword();
        System.out.println("The generated password is: " + password);
    }

    @Test
    void hasPasswordMinimalLength_WhenPasswordGeneratedReturnTrue() {
        assertTrue(PasswordValidator.hasPasswordMinimalLength(password));
    }

    @Test
    void containsDigits_WhenPasswordGeneratedReturnTrue() {
        assertTrue(PasswordValidator.containsDigits(password));
    }

    @Test
    void containsUpperAndLowercaseLetters_WhenPasswordGeneratedReturnTrue() {
        assertTrue(PasswordValidator.containsUpperAndLowercaseLetters(password));
    }

    @Test
    void containsCommonlyUsedPassword_WhenPasswordGeneratedReturnTrue() throws FileNotFoundException {
        assertFalse(PasswordValidator.containsCommonlyUsedPassword(password));
    }


    @Test
    void containsSpecialCharacters_WhenPasswordGeneratedReturnTrue() {
        assertTrue(PasswordValidator.containsSpecialCharacter(password));
    }
}
