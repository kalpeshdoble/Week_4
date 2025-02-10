package org.example;

import java.util.ArrayList;
import java.util.List;

abstract class WareHouseItem{
    private String name;

    public WareHouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void displayDetails();
}

class Electronics extends WareHouseItem{

    private String brand;

    public Electronics(String name,String brand) {
        super(name);
        this.brand=brand;
    }

    @Override
    public void displayDetails() {
       System.out.println("Electronics : "+getName()+", Brand : "+brand);
    }
}

class Groceries extends WareHouseItem{
    private String expiryDate;

    public Groceries(String name,String expiryDate) {
        super(name);
        this.expiryDate =expiryDate;
    }

    @Override
    public void displayDetails() {
        System.out.println("Groceries : "+ getName() +", Expiry Date : "+expiryDate);
    }
}

class Furniture extends WareHouseItem {
    private String material;

    public Furniture(String name, String material) {
        super(name);
        this.material = material;
    }

    @Override
    public void displayDetails() {
        System.out.println("Furniture: " + getName() + ", Material: " + material);
    }
}

class Storage <T extends WareHouseItem>{
    private List<T> items = new ArrayList<>();

    public void addItem(T item){
        items.add(item);
    }

    public List<T> getItems(){
       return items;
    }

    public static void displayAllItems(List<? extends WareHouseItem> items) {
        for (WareHouseItem item : items) {
            item.displayDetails();
        }
    }
}
public class SmartWarehouseSystem {
    public static void main(String[] args) {
        // Creating storage instances for different item types
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Adding items to respective storage
        electronicsStorage.addItem(new Electronics("Laptop", "Dell"));
        electronicsStorage.addItem(new Electronics("Smartphone", "Samsung"));

        groceriesStorage.addItem(new Groceries("Milk", "2025-01-01"));
        groceriesStorage.addItem(new Groceries("Apple", "2024-12-15"));

        furnitureStorage.addItem(new Furniture("Chair", "Wood"));
        furnitureStorage.addItem(new Furniture("Table", "Metal"));

        // Displaying all stored items
        System.out.println("Electronics:");
        Storage.displayAllItems(electronicsStorage.getItems());

        System.out.println("\nGroceries:");
        Storage.displayAllItems(groceriesStorage.getItems());

        System.out.println("\nFurniture:");
        Storage.displayAllItems(furnitureStorage.getItems());
    }
}
