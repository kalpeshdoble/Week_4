package org.example.QueueInterface;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    // Push operation
    public void push(int x) {
        queue1.offer(x);
    }

    // Pop operation
    public int pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        // Move all elements except the last one to queue2
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }

        // Last element in queue1 is the top of the stack
        int topElement = queue1.poll();

        // Swap queues (queue2 becomes queue1)
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    // Top operation
    public int top() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        // Move all elements except the last one to queue2
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }

        // Last element is the top of the stack
        int topElement = queue1.peek();
        queue2.offer(queue1.poll());

        // Swap queues (queue2 becomes queue1)
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top()); // Output: 3
        System.out.println("Popped: " + stack.pop()); // Output: 3
        System.out.println("Popped: " + stack.pop()); // Output: 2
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false
    }
}

