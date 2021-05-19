package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.PI;

public class Main {

    public static void main(String[] args) {
	// write your code here
        double radius = 3d;
        Figure circle = new Circle(radius);
        double baseSide = 10d;
        double side = 5d;
        double height = 8d;
        Figure parallelogram = new Parallelogram(baseSide, side, height);
        double sideA = 15d;
        double sideB = 10;
        Figure rectangle = new Rectangle(sideA, sideB);
        List<Figure> figures = new ArrayList<>(3);
        figures.add(circle);
        figures.add(parallelogram);
        figures.add(rectangle);
        for (Figure figure : figures) {
            System.out.println(figure.getType());
            System.out.println("Area: " + figure.getArea() + " units.");
            System.out.println("Perimeter: " + figure.getPerimeter() + " units.\n");
        }

        Cat mruczek = new Cat("Mruczek");
        mruczek.start();
        System.out.println(mruczek.getType());
        mruczek.stop();

        System.out.println("");

        Manager manager = new Manager("Jan", "Kowalski", 1990, 2010, "PJATK", 2000d,
                100d);
        System.out.println(manager);

    }
}

interface Figure{
    double getPerimeter();
    double getArea();
    String getType();
}

class Circle implements Figure{

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        double perimeter = this.radius * PI * 2;
        return perimeter;
    }

    @Override
    public double getArea() {
        double area = this.radius*this.radius * PI;
        return area;
    }
    @Override
    public String getType(){
        return "Circle";
    }
}

class Parallelogram implements Figure{

    private double baseSide;
    private double side;
    private double height;

    public Parallelogram(double baseSide, double side, double height) {
        this.baseSide = baseSide;
        this.side = side;
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        double perimeter = this.baseSide*2 + this.side*2;
        return perimeter;
    }

    @Override
    public double getArea() {
        double area = this.baseSide*this.height;
        return area;
    }
    @Override
    public String getType(){
        return "Parallelogram";
    }
}

class Rectangle implements Figure{

    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double getPerimeter() {
        double perimeter = this.sideA*2 + this.sideB*2;
        return perimeter;
    }

    @Override
    public double getArea() {
        double area = this.sideA*this.sideB;
        return area;
    }
    @Override
    public String getType(){
        return "Rectangle";
    }
}



interface Moveable{
    void start();
    void stop();
}

abstract class Animal{
    private String name;
    abstract String getType();

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Cat extends Animal implements Moveable{

    public Cat(String name) {
        super(name);
    }

    @Override
    public void start() {
        System.out.println("Cat starts!");
    }

    @Override
    public void stop() {
        System.out.println("Cat stopped!");
    }

    @Override
    String getType() {
        return "Cat";
    }
}

abstract class Person{
    private String firstName, lastName;
    private int birthdayYear;

    public Person(String firstName, String lastName, int birthdayYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayYear = birthdayYear;
    }

    public int getAge(){
        int currentYear = LocalDate.now().getYear();
        int age = currentYear-this.birthdayYear;
        return age;
    }

    public String getLastName() {
        return lastName;
    }
}

class Employee extends Person{
    private int hireDate;
    private String companyName;
    private double salary;

    public Employee(String firstName, String lastName, int birthdayYear, int hireDate, String companyName, double salary) {
        super(firstName, lastName, birthdayYear);
        this.companyName = companyName;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public int getJobSeniority(){
        int currentYear = LocalDate.now().getYear();
        int seniority = currentYear - this.hireDate;
        return seniority;
    }
}

final class Manager extends Employee{
    private double bonus;

    public Manager(String firstName, String lastName, int birthdayYear, int hireDate, String companyName, double salary, double bonus) {
        super(firstName, lastName, birthdayYear, hireDate, companyName, salary);
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary()+bonus;
    }

    @Override
    public String toString() {
        return "Manager with last name " +getLastName()+ " and age " +getAge()+ " has salary " +getSalary();
    }
}
