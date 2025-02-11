package org.example.ListInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateElement {
    private static List<Integer> rotateArray(List<Integer> elements, int k) {
        int n = elements.size();

        k = k % n;

        List<Integer> rotatedList = new ArrayList<>();

        rotatedList.addAll(elements.subList(k,n));
        rotatedList.addAll(elements.subList(0,k));

        return rotatedList;
    }

    public static void main(String[] args) {
        List<Integer> elements = Arrays.asList(10,20,30,40,50);

        int rotateBy = 2;

        List <Integer> result = new ArrayList<>();
        result = rotateArray(elements,rotateBy);
        System.out.println(result);
    }
}
