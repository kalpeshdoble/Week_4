package org.example.MapInterface;

import java.util.*;

public class MapMerger {

    public static void main(String[] args) {
        // Initialize the two maps
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merge the maps
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);

        // Print the merged map
        System.out.println(mergedMap);
    }

    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        // Create a new map to store the result
        Map<String, Integer> mergedMap = new HashMap<>(map1);

        // Merge map2 into map1
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            // For each entry in map2, merge it into map1 (mergedMap)
            mergedMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        return mergedMap;
    }
}
