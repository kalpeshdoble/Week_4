package org.example.ListInterface;

import java.util.*;

public class RemoveDuplicates {

    private static List<Integer> removeDuplicate(List<Integer> input) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> answer = new ArrayList<>();
        for (int num : input){
            if(!seen.contains(num)){
                seen.add(num);
                answer.add(num);
            }
        }
        return answer;
    }
    
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3,1,2,2,3,4);

        List<Integer> result = removeDuplicate(input);

        System.out.println(result);
    }
}
