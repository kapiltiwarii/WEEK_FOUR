package org.example;

import java.util.ArrayList;
import java.util.List;


// Abstract Product Class
abstract class Product<T> {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
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

    public String getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract void displayDetails();
}

// Book Class
class Book extends Product<String> {
    public Book(String name, double price, String category) {
        super(name, price, category);
    }

    @Override
    public void displayDetails() {
        System.out.println("Book: " + getName() + ", Price: $" + getPrice() + ", Category: " + getCategory());
    }
}

// Clothing Class
class Clothing extends Product<String> {
    public Clothing(String name, double price, String category) {
        super(name, price, category);
    }

    @Override
    public void displayDetails() {
        System.out.println("Clothing: " + getName() + ", Price: $" + getPrice() + ", Category: " + getCategory());
    }
}

// Gadget Class
class Gadget extends Product<String> {
    public Gadget(String name, double price, String category) {
        super(name, price, category);
    }

    @Override
    public void displayDetails() {
        System.out.println("Gadget: " + getName() + ", Price: $" + getPrice() + ", Category: " + getCategory());
    }
}

// Generic Product Catalog
class ProductCatalog<T extends Product<?>> {
    private List<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
    }

    public List<T> getProducts() {
        return products;
    }

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
    }
}

// Main Class
public class OnlineMarketplace {
    public static void main(String[] args) {
        ProductCatalog<Book> bookCatalog = new ProductCatalog<>();
        ProductCatalog<Clothing> clothingCatalog = new ProductCatalog<>();
        ProductCatalog<Gadget> gadgetCatalog = new ProductCatalog<>();

        // Adding products with String categories
        Book book1 = new Book("Java Programming", 50.0, "Science");
        Clothing shirt = new Clothing("T-Shirt", 20.0, "Men's Fashion");
        Gadget phone = new Gadget("Smartphone", 500.0, "Electronics");

        bookCatalog.addProduct(book1);
        clothingCatalog.addProduct(shirt);
        gadgetCatalog.addProduct(phone);

        // Applying discount
        ProductCatalog.applyDiscount(book1, 10);  // 10% off
        ProductCatalog.applyDiscount(shirt, 15);  // 15% off
        ProductCatalog.applyDiscount(phone, 5);   // 5% off

        // Displaying updated product details
        System.out.println("Updated Product Details:");
        book1.displayDetails();
        shirt.displayDetails();
        phone.displayDetails();
    }
}

