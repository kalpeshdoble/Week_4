package org.example;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "C:\\Backup\\Streams\\src\\main\\java\\org\\example\\source.txt";  // Change this to your source file path
        String destinationFile = "C:\\Backup\\Streams\\src\\main\\java\\org\\example\\destination.txt";  // Change this to your destination file path

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("File copied successfully!");

        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An error occurred while processing the file: " + e.getMessage());
        }
    }
}
