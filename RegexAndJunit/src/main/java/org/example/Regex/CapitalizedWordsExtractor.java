package org.example.Regex;

import java.util.regex.*;
import java.util.*;

public class CapitalizedWordsExtractor {
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        // Define the regex pattern for capitalized words
        String capitalizedWordRegex = "[A-Z][a-z]*";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(capitalizedWordRegex);
        Matcher matcher = pattern.matcher(text);

        // Using while loop to find all matches
        System.out.println("Extracted Capitalized Words:");
        while (matcher.find()) {
            System.out.println(matcher.group());  // Print each matched word
        }
    }
}

