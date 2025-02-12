package org.example.MapInterface;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

enum Department {
    HR, IT, FINANCE, MARKETING;
}

public class GroupEmployeesByDepartment {

    public static void main(String[] args) {
        // Create some Employee objects
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", Department.HR),
                new Employee("Bob", Department.IT),
                new Employee("Carol", Department.HR),
                new Employee("David", Department.MARKETING)
        );

        // Group the employees by department
        Map<Department, List<Employee>> groupedByDepartment = groupEmployeesByDepartment(employees);

        // Print the grouped map
        groupedByDepartment.forEach((department, employeeList) -> {
            System.out.println(department + ": " + employeeList);
        });
    }

    public static Map<Department, List<Employee>> groupEmployeesByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
