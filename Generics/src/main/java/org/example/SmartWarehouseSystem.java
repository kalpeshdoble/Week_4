package org.example;

import java.util.ArrayList;
import java.util.List;

// Abstract class for warehouse items
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void displayDetails();  // Abstract method to display item details
}

// Electronics class extending WarehouseItem
class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }

    @Override
    public void displayDetails() {
        System.out.println("Electronics: " + getName());
    }
}

// Groceries class extending WarehouseItem
class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }

    @Override
    public void displayDetails() {
        System.out.println("Groceries: " + getName());
    }
}

// Furniture class extending WarehouseItem
class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }

    @Override
    public void displayDetails() {
        System.out.println("Furniture: " + getName());
    }
}

// Storage class to store items, utilizing Generics and bounded types
class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        items = new ArrayList<>();
    }

    // Method to add item to storage
    public void addItem(T item) {
        items.add(item);
    }

    // Method to display all items using wildcards
    public void displayAllItems() {
        for (T item : items) {
            item.displayDetails();
        }
    }
}

// Main class to test the functionality
public class SmartWarehouseSystem {
    public static void main(String[] args) {
        // Create a storage for Electronics
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        // Create a storage for Groceries
        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Apple"));
        groceriesStorage.addItem(new Groceries("Bread"));

        // Create a storage for Furniture
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Sofa"));
        furnitureStorage.addItem(new Furniture("Dining Table"));

        // Display all items in each storage
        System.out.println("Electronics Storage:");
        electronicsStorage.displayAllItems();

        System.out.println("\nGroceries Storage:");
        groceriesStorage.displayAllItems();

        System.out.println("\nFurniture Storage:");
        furnitureStorage.displayAllItems();
    }
}
