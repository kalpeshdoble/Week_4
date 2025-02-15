package org.example;

import org.example.Junit.FileProcessor;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

public class FileProcessorTest {
    private static final String TEST_FILE = "testfile.txt";

    @BeforeEach
    void setUp() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_FILE)); // Ensure a fresh start
    }

    @Test
    void testWriteAndReadFromFile() throws IOException {
        String content = "Hello, JUnit!";

        FileProcessor.writeToFile(TEST_FILE, content);
        String result = FileProcessor.readFromFile(TEST_FILE);

        assertEquals(content, result, "File content should match");
    }

    @Test
    void testFileExistsAfterWriting() throws IOException {
        FileProcessor.writeToFile(TEST_FILE, "Some content");
        assertTrue(Files.exists(Paths.get(TEST_FILE)), "File should exist after writing");
    }

    @Test
    void testReadFromFileThrowsExceptionForMissingFile() {
        assertThrows(IOException.class, () -> FileProcessor.readFromFile("nonexistent.txt"),
                "Should throw IOException for missing file");
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_FILE)); // Clean up after each test
    }
}
