package org.example.OtherQuestions;

import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteCount = new HashMap<>();
    private Map<String, Integer> voteOrder = new LinkedHashMap<>();
    private TreeMap<String, Integer> sortedResults = new TreeMap<>();

    // Method to cast a vote
    public void castVote(String candidate) {
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
        sortedResults.put(candidate, sortedResults.getOrDefault(candidate, 0) + 1);
    }

    // Display votes in order of voting
    public void displayVoteOrder() {
        System.out.println("\nVotes in Order of Voting:");
        voteOrder.forEach((candidate, votes) -> System.out.println(candidate + " -> " + votes + " votes"));
    }

    // Display results in sorted order (TreeMap)
    public void displaySortedResults() {
        System.out.println("\nResults (Sorted by Candidate Name):");
        sortedResults.forEach((candidate, votes) -> System.out.println(candidate + " -> " + votes + " votes"));
    }

    // Find the winner
    public void findWinner() {
        String winner = Collections.max(voteCount.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println(" Winner: " + winner + " with " + voteCount.get(winner) + " votes!");
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Casting votes
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");

        // Display vote order
        votingSystem.displayVoteOrder();

        // Display sorted results
        votingSystem.displaySortedResults();

        // Find winner
        votingSystem.findWinner();
    }
}
