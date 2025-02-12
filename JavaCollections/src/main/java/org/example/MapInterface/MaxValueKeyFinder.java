package org.example.MapInterface;

import java.util.*;

public class MaxValueKeyFinder {

    public static void main(String[] args) {
        // Original map
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        // Find the key with the maximum value
        String keyWithMaxValue = findKeyWithMaxValue(map);

        // Print the key with the highest value
        System.out.println("Key with highest value: " + keyWithMaxValue);
    }

    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        // Initialize variables to store the key with the max value
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        // Iterate through the map to find the key with the max value
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }
}
