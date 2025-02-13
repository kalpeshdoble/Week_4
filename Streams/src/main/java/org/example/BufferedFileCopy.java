package org.example;

import java.io.*;

public class BufferedFileCopy {
    private static final int BUFFER_SIZE = 4; // 4 KB

    
    public static void main(String[] args) {
        String sourceFile = "D:\\WEEK4\\Streams\\src\\main\\java\\org\\example/sample_1MB.txt";  // Replace with actual file
        String destinationBuffered =  "C:\\Backup\\Streams\\src\\main\\java\\org\\example\\destination.txt";
        String destinationUnbuffered = "C:\\Backup\\Streams\\src\\main\\java\\org\\example\\sample_1MB.txt";

        System.out.println("Starting file copy comparison...\n");

        // Buffered Streams Copy
        long bufferedTime = copyWithBufferedStreams(sourceFile, destinationBuffered);
        System.out.println("Buffered Streams Copy Time: " + bufferedTime + " nanoseconds");

        // Unbuffered Streams Copy
        long unbufferedTime = copyWithUnbufferedStreams(sourceFile, destinationUnbuffered);
        System.out.println("Unbuffered Streams Copy Time: " + unbufferedTime + " nanoseconds");

        // Performance Comparison
        double speedup = (double) unbufferedTime / bufferedTime;
        System.out.printf("\nBuffered streams are %.2f times faster than unbuffered streams.\n", speedup);
    }

    // Method for Buffered Copy
    private static long copyWithBufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error using Buffered Streams: " + e.getMessage());
        }

        return System.nanoTime() - startTime;
    }

    // Method for Unbuffered Copy
    private static long copyWithUnbufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error using Unbuffered Streams: " + e.getMessage());
        }

        return System.nanoTime() - startTime;
    }
}
