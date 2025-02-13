package org.example;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String fileName = "C:\\Backup\\Streams\\src\\main\\java\\org\\example/source.txt"; // Change this to your actual file name

        Map<String, Integer> wordCountMap = new HashMap<>();

        int totalWords = countWords(fileName, wordCountMap);
        if (totalWords == -1) return; // Error case

        System.out.println("\nTotal Words in File: " + totalWords);
        displayTopWords(wordCountMap, 5);
    }

    // Reads file and counts word occurrences
    private static int countWords(String fileName, Map<String, Integer> wordCountMap) {
        int wordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                        wordCount++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return -1;
        }

        return wordCount;
    }

    // Sorts and displays the top N most frequent words
    private static void displayTopWords(Map<String, Integer> wordCountMap, int topN) {
        List<Entry<String, Integer>> sortedWords = new ArrayList<>(wordCountMap.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue())); // Descending order

        System.out.println("\nTop " + topN + " Most Frequent Words:");
        for (int i = 0; i < Math.min(topN, sortedWords.size()); i++) {
            Entry<String, Integer> entry = sortedWords.get(i);
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " times");
        }
    }
}
