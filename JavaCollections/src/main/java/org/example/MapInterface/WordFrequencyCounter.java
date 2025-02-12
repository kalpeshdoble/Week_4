package org.example.MapInterface;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        // Path to the text file
        String fileName = "C:\\Backup\\JavaCollections\\src\\main\\java\\org\\example\\MapInterface//input.txt";

        // Call the function to count word frequency
        Map<String, Integer> wordCount = countWordFrequency(fileName);

        // Print the word frequency
        System.out.println(wordCount);
    }

    public static Map<String, Integer> countWordFrequency(String fileName) {
        // Create a map to store the word frequency
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Reading the file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Convert line to lowercase and remove punctuation
                line = line.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");

                // Split the line into words
                String[] words = line.split("\\s+");

                // Count the frequency of each word
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return wordCountMap;
    }
}
