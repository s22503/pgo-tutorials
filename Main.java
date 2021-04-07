package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Product woda = new Product("woda", 1.2, 5);
        Product baton = new Product("baton", 2.2, 10);
        Product owoc = new Product("owoc", 1.0, 15);
        List<Product> products = new ArrayList<>(3);
        products.add(woda);
        products.add(baton);
        products.add(owoc);

        woda.setQuantity(6);
        Category jedzenie = new Category("jedzenie", products);
        Product chipsy = new Product("chipsy", 5.0, 8);
        jedzenie.add(chipsy);

        Basket bas1 = new Basket(products, "Maciej");
        System.out.println(bas1.getItems());
        bas1.remove(chipsy);
        System.out.println(bas1.getItems());
        double pay = bas1.pay();
        System.out.println(pay);


    }
}

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class Category {
    private String categoryName;
    private List<Product> products = new ArrayList<>();

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(String categoryName, List<Product> products) {
        this.categoryName = categoryName;
        this.products = products;
        }

        public void add(Product product){
            this.products.add(product);
        }

        public void remove(Product product){
            this.products.remove(product);
        }

    }

class Basket {
    private List<Product> products = new ArrayList<>();
    private String username;
    private int items;

    public Basket(String username) {
        this.username = username;
    }

    public Basket(List<Product> products, String username) {
        this.products = products;
        this.username = username;
        this.items = products.size();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void add(Product product){
        this.products.add(product);
        this.items += 1;
    }

    public void remove(Product product){
        this.products.remove(product);
        this.items -= 1;
    }

    public double pay(){
        double sum = 0d;
        for(Product product: this.products){
            sum = sum + product.getPrice();
        }
        return sum;
    }

    public String getUsername() {
        return username;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }
}

