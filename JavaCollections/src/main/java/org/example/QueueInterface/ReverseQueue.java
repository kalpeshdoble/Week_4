package org.example.QueueInterface;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    private static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()){
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()){
            queue.offer(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10,20,30));

        System.out.println("Original Queue : "+ queue);
        reverseQueue(queue);

        System.out.println("Reversed Queue : "+queue);
    }
}
