package Ex03_Strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EvaluatorTest {

    @Test
    public void testIsValidNum() {
        NumberEvaluator num = new NumberEvaluator();

        assertTrue(num.isValid("123"));
        assertTrue(num.isValid("+123"));
        assertTrue(num.isValid("-123"));
        assertFalse(num.isValid("123+"));
        assertFalse(num.isValid("123-"));
        assertTrue(num.isValid(".123"));
        assertTrue(num.isValid("123."));
        assertFalse(num.isValid("12.3.4"));
        assertTrue(num.isValid("1.123E33"));
        assertTrue(num.isValid(".1E-3"));
        assertTrue(num.isValid("0"));
        assertTrue(num.isValid("-0.0"));
        assertFalse(num.isValid(""));
        assertFalse(num.isValid(" "));
        assertFalse(num.isValid("-"));
        assertFalse(num.isValid("0,0123"));
    }

    @Test
    public void testIsValidMail() {
        EmailEvaluator mail = new EmailEvaluator();

        assertTrue(mail.isValid("user@host"));
        assertTrue(mail.isValid("first.last@host.domain"));
        assertFalse(mail.isValid("first..last@host..domain"));
        assertFalse(mail.isValid("user@@host"));
        assertFalse(mail.isValid(""));
        assertFalse(mail.isValid(" "));
        assertFalse(mail.isValid("user"));
        assertFalse(mail.isValid("user@"));
        assertFalse(mail.isValid("@host"));
        assertFalse(mail.isValid("user@."));
        assertFalse(mail.isValid("user@host."));
        assertFalse(mail.isValid("user@.host"));
        assertFalse(mail.isValid(".@host"));
        assertFalse(mail.isValid(".user@host"));
        assertFalse(mail.isValid("user.@host"));
        assertFalse(mail.isValid("user.a-d@host"));
    }
}
