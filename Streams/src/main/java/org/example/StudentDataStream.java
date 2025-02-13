package org.example;

import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {
        String fileName = "C:\\Backup\\Streams\\src\\main\\java\\org\\example/students.txt"; // Binary file to store student details

        // Sample student data
        Student[] students = {
                new Student(101, "Alice", 3.8),
                new Student(102, "Bob", 3.5),
                new Student(103, "Charlie", 3.9)
        };

        // Write student data to file
        writeStudentData(fileName, students);

        // Read and display student data from file
        readStudentData(fileName);
    }

    // Method to write student data to a binary file
    public static void writeStudentData(String fileName, Student[] students) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            for (Student student : students) {
                dos.writeInt(student.rollNumber);
                dos.writeUTF(student.name);
                dos.writeDouble(student.gpa);
            }
            System.out.println("Student data written successfully!");
        } catch (IOException e) {
            System.err.println("Error writing student data: " + e.getMessage());
        }
    }

    // Method to read student data from a binary file
    public static void readStudentData(String fileName) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("\nReading Student Data:");
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.err.println("Error reading student data: " + e.getMessage());
        }
    }
}

// Student class to represent student data
class Student {
    int rollNumber;
    String name;
    double gpa;

    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }
}

