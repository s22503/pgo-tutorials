package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //zad1
        User u1 = new User("Maciej", "Gajewicz", "s22503", "123");
        System.out.println(u1.getIsRegistered());

        User u2 = new User("s123");
        System.out.println(u2.getIsRegistered());

        User u3 = new User("s987");
        User u4 = new User (u3,"Mateusz","ABC","xyz");
        System.out.println(u4.getIsRegistered());
        System.out.println(u4.getEmail());

        //zad2
        Product p1 = new Product("Baton", 2.30, "a12");
        System.out.println(p1.getQuantity());

        Product p2 = new Product("Woda", 1.30, "b12", 10);
        p2.setPrice(2.45);
        System.out.println(p2.getPrice());

        Product p3 = new Product("Chipsy", 5.20, "c12");
        p3.setQuantity(5);
        System.out.println(p3.getQuantity());

    }
}

class User{
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isRegistered;

    public User(String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isRegistered = true;
    }

    public User(String email){
        this.email = email;
        this.isRegistered = false;
    }

    public User(User x, String firstName, String lastName, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email =x.getEmail();
        this.password = password;
        this.isRegistered = true;
    }

    public boolean getIsRegistered(){
        return this.isRegistered;
    }
    public String getEmail(){
        return this.email;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getPassword(){
        return this.password;
    }
}

class Product {
    private String name;
    private double price;
    private String code;
    private int quantity;

    public Product(String name, double price, String code) {
        this.name = name;
        this.price = price;
        this.code = code;
        this.quantity = 0;
    }

    public Product(String name, double price, String code, int quantity) {
        this.name = name;
        this.price = price;
        this.code = code;
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        }
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public String getCode(){
        return this.code;
    }

    public int getQuantity(){
        return this.quantity;
    }
}