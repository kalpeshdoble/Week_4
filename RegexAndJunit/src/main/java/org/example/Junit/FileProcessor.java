package org.example.Junit;

import java.io.*;
import java.nio.file.*;

public class FileProcessor {

    public static void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }

    public static String readFromFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
}
