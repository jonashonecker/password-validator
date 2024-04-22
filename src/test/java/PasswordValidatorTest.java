import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    void hasPasswordMinimalLength_whenInputStringABCDEFReturnFalse () {
        // GIVEN
        String password = "ABCDEF";

        // WHEN
        boolean actual = PasswordValidator.hasPasswordMinimalLength(password);

        // THEN
        assertFalse(actual);
    }

    @Test
    void hasPasswordMinimalLength_whenInputStringABCDEFGHReturnTrue () {
        // GIVEN
        String password = "ABCDEFGH";

        // WHEN
        boolean actual = PasswordValidator.hasPasswordMinimalLength(password);

        // THEN
        assertTrue(actual);
    }


    @Test
    void containsDigits_WhenInputStringZZ333ReturnTrue () {
        // GIVEN
        String password = "ZZ333";

        // WHEN
        boolean actual = PasswordValidator.containsDigits(password);

        // THEN
        assertTrue(actual);
    }

    @Test
    void containsDigits_WhenInputStringZZEFGReturnFalse () {
        // GIVEN
        String password = "ZZEFG";

        // WHEN
        boolean actual = PasswordValidator.containsDigits(password);

        // THEN
        assertFalse(actual);
    }
}
