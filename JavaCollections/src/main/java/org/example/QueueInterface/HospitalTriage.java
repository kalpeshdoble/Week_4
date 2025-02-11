package org.example.QueueInterface;

import java.util.PriorityQueue;

class Patient implements Comparable<Patient> {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    // Compare based on severity (higher severity first)
    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity); // Descending order
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriage {
    public static void main(String[] args) {
        // PriorityQueue automatically orders based on Comparable implementation
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>();

        // Adding patients
        triageQueue.offer(new Patient("kalpesh", 3));
        triageQueue.offer(new Patient("Nishant", 5));
        triageQueue.offer(new Patient("kapil", 2));

        // Processing patients in order of severity
        System.out.println("Order of Treatment:");
        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.poll());
        }
    }
}
