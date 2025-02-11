package org.example.ListInterface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyOfElement {

    private static Map<String, Integer> countFrequency(List<String> fruits) {
        Map<String,Integer> frequency = new HashMap<>();

        for (String word : fruits){
            frequency.put(word,frequency.getOrDefault(word,0)+1);
        }
        return frequency;
    }

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple","banana","apple","orange");
        Map<String,Integer> result = countFrequency(fruits);
        System.out.println(result);
    }
}
