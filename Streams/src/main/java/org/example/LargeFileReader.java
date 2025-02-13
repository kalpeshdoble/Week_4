package org.example;

import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        String filePath = "large_log.txt"; // Change this to your file path
        String keyword = "error"; // Case-insensitive keyword to search for

        try {
            readLargeFile(filePath, keyword);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to read a large file line by line
    public static void readLargeFile(String filePath, String keyword) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println(line);
                }
            }
        }
    }
}
