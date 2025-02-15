package org.example;

import org.example.Junit.DateFormatter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateFormatterTest {

    @Test
    void testValidDateFormat() {
        assertEquals("15-02-2024", DateFormatter.formatDate("2024-02-15"));
        assertEquals("01-01-2000", DateFormatter.formatDate("2000-01-01"));
        assertEquals("31-12-1999", DateFormatter.formatDate("1999-12-31"));
    }

    @Test
    void testInvalidDateFormat() {
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("15-02-2024"));
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("2024/02/15"));
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("2024.02.15"));
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("abcd-ef-gh"));
    }

    @Test
    void testEmptyOrNullDate() {
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate(""));
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate(null));
    }
}

