package org.example.SetInterface;

import java.util.*;

public class SubsetChecker {
    public static boolean isSubset(Set<Integer> subset, Set<Integer> superset) {
        return superset.containsAll(subset); // Check if superset contains all elements of subset
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3)); // Potential subset
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4)); // Superset

        boolean result = isSubset(set1, set2);
        System.out.println("Is subset: " + result); // Output: true
    }
}
