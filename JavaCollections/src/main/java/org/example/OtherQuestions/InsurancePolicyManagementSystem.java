package org.example.OtherQuestions;

import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Policy {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyholderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", coverageType='" + coverageType + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}

public class InsurancePolicyManagementSystem {

    // Set to store policies with HashSet, LinkedHashSet, and TreeSet
    Set<Policy> hashSetPolicies = new HashSet<>();
    Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    Set<Policy> treeSetPolicies = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));

    // Method to add policy to all sets
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Retrieve all unique policies
    public void displayAllPolicies() {
        System.out.println("All Policies:");
        System.out.println("HashSet:");
        hashSetPolicies.forEach(System.out::println);
        System.out.println("LinkedHashSet:");
        linkedHashSetPolicies.forEach(System.out::println);
        System.out.println("TreeSet (Sorted by Expiry Date):");
        treeSetPolicies.forEach(System.out::println);
    }

    // Retrieve policies expiring soon (within the next 30 days)
    public void displayPoliciesExpiringSoon() {
        LocalDate today = LocalDate.now();
        System.out.println("Policies Expiring Soon (Within 30 Days):");
        hashSetPolicies.stream()
                .filter(policy -> ChronoUnit.DAYS.between(today, policy.getExpiryDate()) <= 30)
                .forEach(System.out::println);
    }

    // Retrieve policies with a specific coverage type
    public void displayPoliciesByCoverageType(String coverageType) {
        System.out.println("Policies with Coverage Type: " + coverageType);
        hashSetPolicies.stream()
                .filter(policy -> policy.getCoverageType().equalsIgnoreCase(coverageType))
                .forEach(System.out::println);
    }

    // Retrieve duplicate policies based on policy numbers
    public void displayDuplicatePolicies() {
        Set<String> seenPolicyNumbers = new HashSet<>();
        System.out.println("Duplicate Policies:");
        hashSetPolicies.stream()
                .filter(policy -> !seenPolicyNumbers.add(policy.getPolicyNumber()))
                .forEach(System.out::println);
    }

    // Performance Comparison for HashSet, LinkedHashSet, and TreeSet
    public void comparePerformance() {
        // Adding performance test
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            addPolicy(new Policy("P" + i, "Holder " + i, LocalDate.now().plusDays(i), "Health", 1000));
        }
        long endTime = System.nanoTime();
        System.out.println("Time to add 100,000 policies: " + (endTime - startTime) + " nanoseconds");

        // Searching performance test for HashSet
        startTime = System.nanoTime();
        hashSetPolicies.contains(new Policy("P5000", "Holder 5000", LocalDate.now(), "Health", 1000));
        endTime = System.nanoTime();
        System.out.println("HashSet search time: " + (endTime - startTime) + " nanoseconds");

        // Searching performance test for TreeSet (sorted by expiry date)
        startTime = System.nanoTime();
        treeSetPolicies.contains(new Policy("P5000", "Holder 5000", LocalDate.now(), "Health", 1000));
        endTime = System.nanoTime();
        System.out.println("TreeSet search time: " + (endTime - startTime) + " nanoseconds");

        // Removing performance test for HashSet
        startTime = System.nanoTime();
        hashSetPolicies.remove(new Policy("P5000", "Holder 5000", LocalDate.now(), "Health", 1000));
        endTime = System.nanoTime();
        System.out.println("HashSet remove time: " + (endTime - startTime) + " nanoseconds");

        // Removing performance test for TreeSet
        startTime = System.nanoTime();
        treeSetPolicies.remove(new Policy("P5000", "Holder 5000", LocalDate.now(), "Health", 1000));
        endTime = System.nanoTime();
        System.out.println("TreeSet remove time: " + (endTime - startTime) + " nanoseconds");
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        // Adding some sample policies
        system.addPolicy(new Policy("P1001", "John Doe", LocalDate.now().plusDays(10), "Health", 1200));
        system.addPolicy(new Policy("P1002", "Jane Doe", LocalDate.now().plusDays(20), "Auto", 800));
        system.addPolicy(new Policy("P1003", "Mary Smith", LocalDate.now().plusDays(5), "Home", 1000));
        system.addPolicy(new Policy("P1004", "James Brown", LocalDate.now().plusDays(15), "Health", 1100));
        system.addPolicy(new Policy("P1005", "Emily White", LocalDate.now().plusDays(25), "Auto", 950));

        // Displaying all policies
        system.displayAllPolicies();

        // Displaying policies expiring soon
        system.displayPoliciesExpiringSoon();

        // Displaying policies with a specific coverage type
        system.displayPoliciesByCoverageType("Auto");

        // Displaying duplicate policies
        system.displayDuplicatePolicies();

        // Comparing performance
        system.comparePerformance();
    }
}
