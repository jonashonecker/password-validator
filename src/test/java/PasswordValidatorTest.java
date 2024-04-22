import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1234567", "123456", "12345"})
    void hasPasswordMinimalLength_whenInputStringLengthSmallerThan8ReturnFalse (String password) {
        assertFalse(PasswordValidator.hasPasswordMinimalLength(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456789", "123456789wefhi"})
    void hasPasswordMinimalLength_whenInputStringLengthHigherThan8ReturnTrue (String password) {
        assertTrue(PasswordValidator.hasPasswordMinimalLength(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"ZZ333", "123456789wefhi"})
    void containsDigits_WhenInputStringContainsDigitsReturnTrue (String password) {
        assertTrue(PasswordValidator.containsDigits(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"ZZEFG", "ABCDEF"})
    void containsDigits_WhenInputStringContainsNoDigitsReturnFalse (String password) {
        assertFalse(PasswordValidator.containsDigits(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"ZZEFG", "zzefg", "1aaa"})
    void containsUpperAndLowercaseLetters_WhenInputStringContainsOnlyUpperOrLowercaseReturnFalse (String password) {
        assertFalse(PasswordValidator.containsUpperAndLowercaseLetters(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"ZZEeG", "zzefG", "1aAa"})
    void containsUpperAndLowercaseLetters_WhenInputStringContainsUpperAndLowercaseReturnTrue (String password) {
        assertTrue(PasswordValidator.containsUpperAndLowercaseLetters(password));
    }

    @Test
    void containsCommonlyUsedPassword_WhenInput1monkeyReturnTrue () throws FileNotFoundException {
        // GIVEN
        String password = "1monkey";

        // WHEN
        boolean actual = PasswordValidator.containsCommonlyUsedPassword(password);

        // THEN
        assertTrue(actual);
    }

    @Test
    void containsCommonlyUsedPassword_WhenInputyyyyyReturnTrue () throws FileNotFoundException {
        // GIVEN
        String password = "yyyyy";

        // WHEN
        boolean actual = PasswordValidator.containsCommonlyUsedPassword(password);

        // THEN
        assertTrue(actual);
    }

    @Test
    void containsCommonlyUsedPassword_WhenInputJonas138914781471283ReturnFalse () throws FileNotFoundException {
        // GIVEN
        String password = "Jonas138914781471283";

        // WHEN
        boolean actual = PasswordValidator.containsCommonlyUsedPassword(password);

        // THEN
        assertFalse(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"H1$", "hu.i3&", "h-jdu30ijf", "???'§ldd"})
    void containsSpecialCharacters_WhenInputContainsSpecialCharacterReturnTrue (String password) {
        assertTrue(PasswordValidator.containsSpecialCharacter(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hallo", "admin123", "ßßßj3of32", "qhefohiq831948"})
    void containsSpecialCharacters_WhenInputContainsNoSpecialCharacterReturnFalse (String password) {
        assertFalse(PasswordValidator.containsSpecialCharacter(password));
    }
}
