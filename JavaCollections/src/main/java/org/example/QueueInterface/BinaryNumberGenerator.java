package org.example.QueueInterface;

import java.util.*;

public class BinaryNumberGenerator {
    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer("1"); // Start with "1"

        for (int i = 0; i < N; i++) {
            String current = queue.poll(); // Remove front element
            result.add(current); // Store it in result list

            // Generate next two binary numbers
            queue.offer(current + "0");
            queue.offer(current + "1");
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        List<String> binaryNumbers = generateBinaryNumbers(N);
        System.out.println("First " + N + " Binary Numbers: " + binaryNumbers);
    }
}

