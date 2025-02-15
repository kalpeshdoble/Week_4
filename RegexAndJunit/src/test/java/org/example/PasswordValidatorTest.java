package org.example;

import org.example.Junit.PasswordValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Secure123"), "Password should be valid");
    }

    @Test
    void testShortPassword() {
        assertFalse(PasswordValidator.isValid("Ab1"), "Password should be invalid (too short)");
    }

    @Test
    void testMissingUppercase() {
        assertFalse(PasswordValidator.isValid("secure123"), "Password should be invalid (missing uppercase letter)");
    }

    @Test
    void testMissingDigit() {
        assertFalse(PasswordValidator.isValid("SecurePass"), "Password should be invalid (missing digit)");
    }

    @Test
    void testEmptyPassword() {
        assertFalse(PasswordValidator.isValid(""), "Password should be invalid (empty)");
    }

    @Test
    void testNullPassword() {
        assertFalse(PasswordValidator.isValid(null), "Password should be invalid (null value)");
    }
}
