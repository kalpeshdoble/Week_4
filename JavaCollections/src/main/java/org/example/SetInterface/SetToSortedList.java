package org.example.SetInterface;

import java.util.*;

public class SetToSortedList {
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set); // Convert set to list
        Collections.sort(list); // Sort the list in ascending order
        return list;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        List<Integer> sortedList = convertToSortedList(set);
        System.out.println("Sorted List: " + sortedList); // Output: [1, 3, 5, 9]
    }
}
