import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Policy2 {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy2(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
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

    public String getPolicyholderName() {
        return policyholderName;
    }

    @Override
    public String toString() {
        return "Policy2{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyholderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", coverageType='" + coverageType + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}

public class InsurancePolicyManagementSystem2 {

    // Maps to store policies with different behaviors
    Map<String, Policy2> hashMapPolicies = new HashMap<>();
    Map<String, Policy2> linkedHashMapPolicies = new LinkedHashMap<>();
    Map<String, Policy2> treeMapPolicies = new TreeMap<>(Comparator.comparing((String policyNumber) -> {
        return LocalDate.parse(hashMapPolicies.get(policyNumber).getExpiryDate().toString());
    }));

    // Method to add policy to all maps
    public void addPolicy(Policy2 policy) {
        hashMapPolicies.put(policy.getPolicyNumber(), policy);
        linkedHashMapPolicies.put(policy.getPolicyNumber(), policy);
        treeMapPolicies.put(policy.getPolicyNumber(), policy);
    }

    // Retrieve a policy by its number
    public Policy2 getPolicyByNumber(String policyNumber) {
        return hashMapPolicies.get(policyNumber);  // Using HashMap for quick lookup
    }

    // List all policies expiring within the next 30 days
    public void listPoliciesExpiringSoon() {
        LocalDate today = LocalDate.now();
        System.out.println("Policies Expiring Soon (Within 30 Days):");
        hashMapPolicies.values().stream()
                .filter(policy -> ChronoUnit.DAYS.between(today, policy.getExpiryDate()) <= 30)
                .forEach(System.out::println);
    }

    // List all policies for a specific policyholder
    public void listPoliciesByPolicyholder(String policyholderName) {
        System.out.println("Policies for Policyholder: " + policyholderName);
        hashMapPolicies.values().stream()
                .filter(policy -> policy.getPolicyholderName().equalsIgnoreCase(policyholderName))
                .forEach(System.out::println);
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        System.out.println("Removing expired policies:");
        hashMapPolicies.values().removeIf(policy -> policy.getExpiryDate().isBefore(today));
        linkedHashMapPolicies.values().removeIf(policy -> policy.getExpiryDate().isBefore(today));
        treeMapPolicies.values().removeIf(policy -> policy.getExpiryDate().isBefore(today));
    }

    // Display all policies in different maps
    public void displayAllPolicies() {
        System.out.println("All Policies (HashMap):");
        hashMapPolicies.values().forEach(System.out::println);

        System.out.println("All Policies (LinkedHashMap - Insertion Order):");
        linkedHashMapPolicies.values().forEach(System.out::println);

        System.out.println("All Policies (TreeMap - Sorted by Expiry Date):");
        treeMapPolicies.values().forEach(System.out::println);
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem2 system = new InsurancePolicyManagementSystem2();

        // Adding some sample policies
        system.addPolicy(new Policy2("P1001", "John Doe", LocalDate.now().plusDays(10), "Health", 1200));
        system.addPolicy(new Policy2("P1002", "Jane Doe", LocalDate.now().plusDays(20), "Auto", 800));
        system.addPolicy(new Policy2("P1003", "Mary Smith", LocalDate.now().plusDays(5), "Home", 1000));
        system.addPolicy(new Policy2("P1004", "James Brown", LocalDate.now().plusDays(15), "Health", 1100));
        system.addPolicy(new Policy2("P1005", "Emily White", LocalDate.now().plusDays(25), "Auto", 950));

        // Displaying all policies in different maps
        system.displayAllPolicies();

        // Displaying policies expiring soon
        system.listPoliciesExpiringSoon();

        // Displaying policies by a specific policyholder
        system.listPoliciesByPolicyholder("John Doe");

        // Removing expired policies
        system.removeExpiredPolicies();

        // Displaying all policies after removing expired ones
        system.displayAllPolicies();
    }
}
