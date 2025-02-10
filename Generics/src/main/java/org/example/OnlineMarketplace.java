package org.example;

// Step 1: Base class for product categories
abstract class ProductCategory {
    private String categoryName;

    public ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

// BookCategory class extending ProductCategory
class BookCategory extends ProductCategory {
    public BookCategory() {
        super("Books");
    }
}

// ClothingCategory class extending ProductCategory
class ClothingCategory extends ProductCategory {
    public ClothingCategory() {
        super("Clothing");
    }
}

// GadgetCategory class extending ProductCategory
class GadgetCategory extends ProductCategory {
    public GadgetCategory() {
        super("Gadgets");
    }
}

// Step 2: Generic Product class
class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Category: " + category.getCategoryName() + ", Price: $" + price;
    }
}

// Step 3: Marketplace class with the applyDiscount method
class Marketplace {

    // Generic method to apply a discount
    public <T extends Product> void applyDiscount(T product, double percentage) {
        double currentPrice = product.getPrice();
        double discountAmount = (currentPrice * percentage) / 100;
        double newPrice = currentPrice - discountAmount;
        product.setPrice(newPrice);
        System.out.println("Applied discount: " + percentage + "%");
        System.out.println("New price for " + product.getName() + ": $" + newPrice);
    }

    // Display the product details
    public void displayProduct(Product<? extends ProductCategory> product) {
        System.out.println(product.toString());
    }
}

// Step 4: Main Class to test the implementation
public class OnlineMarketplace {
    public static void main(String[] args) {
        // Create products with different categories
        Product<BookCategory> book = new Product<>("Java Programming Book", 50.0, new BookCategory());
        Product<ClothingCategory> clothing = new Product<>("Winter Jacket", 120.0, new ClothingCategory());
        Product<GadgetCategory> gadget = new Product<>("Smartphone", 800.0, new GadgetCategory());

        // Create a marketplace instance
        Marketplace marketplace = new Marketplace();

        // Display original product details
        marketplace.displayProduct(book);
        marketplace.displayProduct(clothing);
        marketplace.displayProduct(gadget);

        // Apply discounts
        marketplace.applyDiscount(book, 10);  // 10% discount
        marketplace.applyDiscount(clothing, 15);  // 15% discount
        marketplace.applyDiscount(gadget, 5);  // 5% discount
    }
}
