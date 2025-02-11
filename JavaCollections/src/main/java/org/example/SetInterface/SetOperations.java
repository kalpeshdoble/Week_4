package org.example.SetInterface;

import java.util.*;

public class SetOperations {
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2); // Add all elements from set2
        return result;
    }

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.retainAll(set2); // Keep only common elements
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> unionResult = union(set1, set2);
        Set<Integer> intersectionResult = intersection(set1, set2);

        System.out.println("Union: " + unionResult);         // Output: [1, 2, 3, 4, 5]
        System.out.println("Intersection: " + intersectionResult); // Output: [3]
    }
}

