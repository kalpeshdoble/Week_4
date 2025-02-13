package org.example;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class ImageByteArrayConverter {
    public static void main(String[] args) {
        String inputImagePath = "C:\\Backup\\Streams\\src\\main\\java\\org\\example/sample_image.jpg";  // Change this to your image file path
        String outputImagePath = "C:\\Backup\\Streams\\src\\main\\java\\org\\example/output.jpg"; // The file to be created

        try {
            // Convert Image to Byte Array
            byte[] imageBytes = convertImageToByteArray(inputImagePath);

            // Write Byte Array to Image
            writeByteArrayToImage(imageBytes, outputImagePath);

            // Verify if the images are identical
            if (verifyFilesAreIdentical(inputImagePath, outputImagePath)) {
                System.out.println("Success: The output image is identical to the original image.");
            } else {
                System.out.println("Error: The output image differs from the original.");
            }

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    // Convert image file to byte array
    private static byte[] convertImageToByteArray(String imagePath) throws IOException {
        File file = new File(imagePath);
        try (FileInputStream fis = new FileInputStream(file);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    // Write byte array to an image file
    private static void writeByteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    // Verify that two files are identical
    private static boolean verifyFilesAreIdentical(String filePath1, String filePath2) throws IOException {
        byte[] file1Bytes = Files.readAllBytes(new File(filePath1).toPath());
        byte[] file2Bytes = Files.readAllBytes(new File(filePath2).toPath());
        return Arrays.equals(file1Bytes, file2Bytes);
    }
}
