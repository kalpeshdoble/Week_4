package org.example.QueueInterface;


public class CircularBuffer {
    private int[] buffer;
    private int head = 0;  // Points to the oldest element
    private int tail = 0;  // Points to the next insert position
    private int size = 0;  // Current number of elements
    private int capacity;  // Maximum buffer size

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
    }

    // Add an element (overwrite if full)
    public void enqueue(int value) {
        if (size == capacity) {
            // Overwrite the oldest element (move head forward)
            head = (head + 1) % capacity;
        } else {
            size++;
        }

        buffer[tail] = value;
        tail = (tail + 1) % capacity; // Move tail forward
    }

    // Remove an element (return -1 if empty)
    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Buffer is empty");
        }

        int value = buffer[head];
        head = (head + 1) % capacity;
        size--;
        return value;
    }

    // Get the front element
    public int front() {
        if (size == 0) {
            throw new IllegalStateException("Buffer is empty");
        }
        return buffer[head];
    }

    // Check if the buffer is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the buffer is full
    public boolean isFull() {
        return size == capacity;
    }

    // Display buffer contents
    public void display() {
        System.out.print("Buffer: ");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(head + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.enqueue(1);
        cb.enqueue(2);
        cb.enqueue(3);
        cb.display(); // Output: Buffer: 1 2 3

        cb.enqueue(4); // Overwrites the oldest element (1)
        cb.display(); // Output: Buffer: 2 3 4
    }
}
