package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Furniture table = new Furniture("table", 20.0);
        Furniture chair = new Furniture("chair", 10.0);
        System.out.println(chair.getPriceWithVAT());
        List<Furniture> furniture = new ArrayList<>(2);
        furniture.add(table);
        furniture.add(chair);
        Room kitchen = new Room(8.0, furniture);
        System.out.println(kitchen.totalPrice());

        Room bathroom = new Room(12.0, furniture);
        List<Room> rooms = new ArrayList<>(2);
        rooms.add(kitchen);
        rooms.add(bathroom);
        House h1 = House.createHouse("Kwiatowa", rooms);
        System.out.println(House.getRoomCount());
        Room bedroom = new Room(10.0, furniture);
        h1.addRoom(bedroom);
        System.out.println(House.getRoomCount());







    }
}

class Furniture{
    private String name;
    private double price;
    private final static double VAT = 0.23;

    public Furniture(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public double getPriceWithVAT(){
        return price+price*VAT;
    }
}

class Room{
    private double area;
    private List<Furniture> furniture;

    public Room(double area, List<Furniture> furniture) {
        this.area = area;
        this.furniture = furniture;
    }

    public double totalPrice(){
        double sum = 0d;
        for(Furniture furniture: this.furniture){
            sum = sum + furniture.getPriceWithVAT();
        }
        return sum;
    }
}

class House{
    private static List<Room> rooms;
    private static int roomCount;
    private static String address;

    private House(List<Room> rooms, String address) {
        this.rooms = rooms;
        this.address = address;
        this.roomCount = rooms.size();
    }

    public static House createHouse(String address, List<Room> rooms){
        House h1 = new House(rooms, address);
        return h1;
    }

    public void addRoom(Room room){
        this.rooms.add(room);
        this.roomCount +=1;
    }

    public void addRooms(List<Room> rooms){
        this.rooms.addAll(rooms);
        this.roomCount = roomCount + rooms.size();
    }

    public static int getRoomCount() {
        return roomCount;
    }
}

