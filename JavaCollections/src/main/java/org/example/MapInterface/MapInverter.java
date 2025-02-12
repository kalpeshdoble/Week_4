package org.example.MapInterface;

import java.util.*;

public class MapInverter {

    public static void main(String[] args) {
        // Original map
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        // Call the function to invert the map
        Map<Integer, List<String>> invertedMap = invertMap(originalMap);

        // Print the inverted map
        System.out.println(invertedMap);
    }

    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> originalMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        // Iterate through the original map and invert it
        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();

            // If the value already exists in the inverted map, add the key to the list
            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        return invertedMap;
    }
}
