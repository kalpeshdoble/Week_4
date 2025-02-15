package org.example.JunitQuestionsTest;

import org.example.JunitQuestions.DatabaseConnection;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {
    private DatabaseConnection db;

    @BeforeEach
    void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    void tearDown() {
        db.disconnect();
    }

    @Test
    void testConnectionIsEstablished() {
        assertTrue(db.isConnected(), "Database should be connected.");
    }

    @Test
    void testConnectionIsClosedAfterEachTest() {
        db.disconnect();
        assertFalse(db.isConnected(), "Database should be disconnected.");
    }
}
