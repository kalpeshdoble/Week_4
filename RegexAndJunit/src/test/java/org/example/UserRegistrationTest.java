package org.example;

import org.example.Junit.UserRegistration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    @Test
    void testValidUserRegistration() {
        assertEquals("User registered successfully!", UserRegistration.registerUser("JohnDoe", "john@example.com", "Secure123"));
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("John", "john@example.com", "Secure123"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("", "john@example.com", "Secure123"));
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("JohnDoe", "invalid-email", "Secure123"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("JohnDoe", "john@com", "Secure123"));
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("JohnDoe", "john@example.com", "short"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("JohnDoe", "john@example.com", "lowercaseonly"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("JohnDoe", "john@example.com", "NOLOWERCASE123"));
    }

    @Test
    void testNullInputs() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser(null, "john@example.com", "Secure123"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("JohnDoe", null, "Secure123"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("JohnDoe", "john@example.com", null));
    }
}
