package org.example;

import java.io.*;

public class UpperToLowerConverter {
    public static void main(String[] args) {
        String inputFile = "C:\\Backup\\Streams\\src\\main\\java\\org\\example/input.txt";  // Change this to your input file
        String outputFile = "C:\\Backup\\Streams\\src\\main\\java\\org\\example/output.txt"; // Change this to your output file

        try {
            convertUppercaseToLowercase(inputFile, outputFile);
            System.out.println("File conversion completed successfully!");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public static void convertUppercaseToLowercase(String inputFile, String outputFile) throws IOException {
        // Use UTF-8 encoding to handle different characters properly
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase()); // Convert to lowercase
                writer.newLine(); // Preserve line breaks
            }
        }
    }
}
