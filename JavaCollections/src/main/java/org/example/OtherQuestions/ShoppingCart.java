package org.example.OtherQuestions;

import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private Map<String, Integer> cart = new LinkedHashMap<>();
    private TreeMap<Double, String> sortedByPrice = new TreeMap<>();

    // Add a product to the store
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    // Add item to cart
    public void addToCart(String product, int quantity) {
        if (!productPrices.containsKey(product)) {
            System.out.println("Product not found");
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
        sortedByPrice.put(productPrices.get(product), product);
    }

    // Remove item from cart
    public void removeFromCart(String product) {
        if (cart.containsKey(product)) {
            cart.remove(product);
            sortedByPrice.values().remove(product);
            System.out.println(product + " removed from cart");
        } else {
            System.out.println("Product not found in cart");
        }
    }

    // Display cart in order of addition
    public void displayCart() {
        System.out.println("\nCart Items in Order of Addition:");
        cart.forEach((product, quantity) ->
                System.out.println(product + " x " + quantity + " (Price: " + productPrices.get(product) + " each)")
        );
    }

    // Display cart sorted by price
    public void displayCartSortedByPrice() {
        System.out.println("\nCart Items Sorted by Price:");
        sortedByPrice.forEach((price, product) ->
                System.out.println(product + " (Price: " + price + ")")
        );
    }

    // Calculate total cost
    public void calculateTotal() {
        double total = cart.entrySet().stream()
                .mapToDouble(entry -> productPrices.get(entry.getKey()) * entry.getValue())
                .sum();
        System.out.println("\nTotal Price: " + total);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products to store
        cart.addProduct("Laptop", 999.99);
        cart.addProduct("Phone", 499.99);
        cart.addProduct("Tablet", 299.99);
        cart.addProduct("Headphones", 79.99);

        // Adding items to cart
        cart.addToCart("Laptop", 1);
        cart.addToCart("Phone", 2);
        cart.addToCart("Tablet", 1);
        cart.addToCart("Headphones", 3);

        // Display cart in order of addition
        cart.displayCart();

        // Display cart sorted by price
        cart.displayCartSortedByPrice();

        // Calculate total price
        cart.calculateTotal();

        // Remove an item from cart
        cart.removeFromCart("Phone");

        // Display cart after removal
        cart.displayCart();
    }
}
