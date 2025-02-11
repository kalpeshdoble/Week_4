package org.example.ListInterface;

import java.util.LinkedList;
import java.util.ListIterator;

public class NthFromEnd {
    public static String findNthFromEnd(LinkedList<String> list, int n) {
        if (list == null || n <= 0) return null;

        ListIterator<String> first = list.listIterator();
        ListIterator<String> second = list.listIterator();

        // Move the first pointer N steps ahead
        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) return null; // If N is greater than the list size
            first.next();
        }

        // Move both pointers until first reaches the end
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next(); // Nth from the end
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int N = 2;
        String result = findNthFromEnd(list, N);
        System.out.println(result); // Output: D
    }
}

