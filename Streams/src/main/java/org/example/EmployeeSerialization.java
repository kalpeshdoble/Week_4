package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Employee class implementing Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // Ensures compatibility
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Display Employee details
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: $" + salary;
    }
}

// Main class for Serialization & Deserialization
public class EmployeeSerialization {
    private static final String FILE_NAME = "C:\\Backup\\Streams\\src\\main\\java\\org\\example89/employees.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        // Add Employees
        System.out.println("Enter employee details (ID, Name, Department, Salary). Type 'done' to finish:");
        while (true) {
            System.out.print("ID: ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("done")) break;

            int id = Integer.parseInt(input);
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Department: ");
            String department = scanner.next();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();

            employees.add(new Employee(id, name, department, salary));
        }

        // Serialize Employees to File
        serializeEmployees(employees);

        // Deserialize and Display Employees
        List<Employee> retrievedEmployees = deserializeEmployees();
        System.out.println("\nEmployees retrieved from file:");
        retrievedEmployees.forEach(System.out::println);

        scanner.close();
    }

    // Serialize Employees
    private static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("\nEmployees saved successfully to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    // Deserialize Employees
    private static List<Employee> deserializeEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error retrieving employees: " + e.getMessage());
        }
        return employees;
    }
}
