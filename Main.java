package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Telephone tel1=new Telephone("Samsung",5,"123 456 789");
        System.out.println(tel1.brand);
        tel1.message("Hello");

        Car c=new Car("red", "Ford", 1.6);
        String color = c.getColor();
        String brand = c.getCarBrand();
        System.out.println("Samochód o kolorze: " +color+ ", marki: " +brand);
        System.out.println(c.color);
        c.isWysokoObrotowy();
        System.out.println(c.isWysokoObrotowy());
        c.setCapacity(2.0);
        c.isWysokoObrotowy();
        System.out.println(c.isWysokoObrotowy());
    }
}

class Telephone {
    String brand;
    int resolution;
    String number;

    public Telephone(String brand, int resolution, String number){
        this.brand = brand;
        this.resolution = resolution;
        this.number = number;
    }

    public void message(String yourMessage){
        System.out.println("Wysyłam wiadomość '" +yourMessage+ "' na numer " +number);
    }


}

class Car {
    String color;
    String carBrand;
    double capacity;

    public Car(String color, String carBrand, double capacity){
        this.color = color;
        this.carBrand = carBrand;
        this.capacity = capacity;
    }

    public String getColor(){
        return this.color;
    }

    public String getCarBrand() {
        return this.carBrand;
    }

    public void setCapacity(double capacity){
        this.capacity = capacity;
    }

    public boolean isWysokoObrotowy(){
        if(capacity>=2){
            return true;
        }else
            return false;
    }
}