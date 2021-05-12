package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Vehicle car1 = new Car();
        car1.start();
        car1.stop();

        Vehicle car2 = new Vehicle();
        car2.stop();

        Animal a1 = new Animal();
        a1.makeNoise();

        Animal cat = new Cat();
        cat.makeNoise();

        Animal dog = new Dog();
        dog.makeNoise();

        cat.roam();
        dog.roam();

    }
}

class Vehicle{
    public void start(){
        System.out.println("start");
    }

    public void stop(){
        System.out.println("stop");
    }
}

class Car extends Vehicle{
    int numberOfSeats;

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    @Override
    public void start(){
        System.out.println("car start");
    }
    @Override
    public void stop(){
        System.out.println("car stop");
    }
}


class Animal{
    public void sleep(){
        System.out.println("sleep");
    }

    public void makeNoise(){
        System.out.println("noise");
    }

    public void roam(){
        System.out.println("roam");
    }
}

class Feline extends Animal{
    @Override
    public void roam(){
        System.out.println("feline roam");
    }
}

class Canine extends Animal{
    @Override
    public void roam(){
        System.out.println("canine roam");
    }
}

class Lion extends Feline{
    @Override
    public void makeNoise(){
        System.out.println("lion noise");
    }
}

class Cat extends Feline{
    @Override
    public void makeNoise(){
        System.out.println("cat noise");
    }
}

class Wolf extends Canine{
    @Override
    public void makeNoise(){
        System.out.println("wolf noise");
    }
}

class Dog extends Canine{
    @Override
    public void makeNoise(){
        System.out.println("dog noise");
    }
}
