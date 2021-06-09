package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws OverfillException {
	// write your code here
        Ship s1 = Ship.createShip();
        RefrigeratedContainer r1 = new RefrigeratedContainer(13,12,13,14,15);
        LiquidContainer l1 = new LiquidContainer(11,11,11,10,true);
        GasContainer g1 = new GasContainer(11,11,11,20,15);
        List<Container> test = new ArrayList<>();
        test.add(r1);
        test.add(l1);
        test.add(g1);
        s1.addContainer(test);
        Ship s2 = Ship.createShip();
        Ship.moveContainers(s1,s2);
        System.out.println(s2.getContainers().size());
        s2.removeContainer(test);
        System.out.println(s2.getContainers().size());
    }
}

abstract class Container{
    private double weight;
    private double height;
    private double length;
    private int serialNumber;
    private double maxWeight;


    {
        List<Integer> numbers = new ArrayList<>();
        for(int i=0; i<=22503; i++){
            numbers.add(i);
        }
        Random random = new Random();
        int id = random.nextInt(numbers.size());
        this.serialNumber=numbers.get(id);
        numbers.remove(id);
    }

    public Container(double weight, double height, double length, double maxWeight) {
        this.weight = weight;
        this.height = height;
        this.length = length;
        this.maxWeight = maxWeight;

    }

    public void clear(){
        this.setWeight(0);
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void load (double loadWeight) throws OverfillException {
        if(loadWeight+this.getWeight()>maxWeight){
            throw new OverfillException("Maksymalna waga "+maxWeight+ " została przekroczona");
        }else{
            this.setWeight(this.getWeight()+loadWeight);
        }
    }
}

class LiquidContainer extends Container implements Explosible{
    private boolean isDangerous;

    public LiquidContainer(double weight, double height, double length, double maxWeight, boolean isDangerous) {
        super(weight, height, length, maxWeight);
        this.isDangerous=isDangerous;
    }

    @Override
    public void explode() {
        System.out.println("Liquid container with serial number "+this.getSerialNumber()+" exploded!");
    }


    @Override
    public void load(double loadWeight) throws OverfillException {
        if(isDangerous==true && loadWeight+this.getWeight()>(this.getMaxWeight()/2) || isDangerous==false && loadWeight+this.getWeight()>(this.getMaxWeight()*0.9)){
            explode();
            throw new OverfillException("Maksymalna waga "+this.getMaxWeight()+ " została przekroczona");
        }else{
            this.setWeight(this.getWeight()+loadWeight);
        }
    }
}

interface Explosible{
    void explode();
}


class GasContainer extends Container implements Explosible{
    private double pressure;

    public GasContainer(double weight, double height, double length, double maxWeight, double pressure) {
        super(weight, height, length, maxWeight);
        this.pressure=pressure;
    }

    @Override
    public void clear() {
        this.setWeight(this.getWeight()*0.05);
    }

    @Override
    public void explode() {
        System.out.println("Gas container with serial number "+this.getSerialNumber()+" exploded!");
    }

    @Override
    public void load(double loadWeight) throws OverfillException {
        if(loadWeight+this.getWeight()>this.getMaxWeight()){
            explode();
            throw new OverfillException("Maksymalna waga "+this.getMaxWeight()+ " została przekroczona");
        }else{
            this.setWeight(this.getWeight()+loadWeight);
        }
    }
}

class RefrigeratedContainer extends Container{
    private double temperature;
    private List<String> products;

    {
        List<String> products = new ArrayList<>();
        products.add("ryba");
        products.add("mrozona pizza");
        products.add("banany");
        products.add("mieso");
    }


    public RefrigeratedContainer(double weight, double height, double length, double maxWeight, double temperature) {
        super(weight, height, length, maxWeight);
        this.temperature=temperature;
    }
}

class Ship{
    private List<Container> containers = new ArrayList<>();
    private double maxVelocity;
    private static int maxContainers;

    static {
        maxContainers=22503*5;
    }

    public void addContainer(Container container){
            containers.add(container);
    }

    public void addContainer(List<Container> newContainers){
            containers.addAll(newContainers);
        }

    public void removeContainer(Container container){
        containers.remove(container);
    }

    public void removeContainer(List<Container> containerList){
        containers.removeAll(containerList);
    }

    public void replaceContainer(int index, Container container){
        containers.add(index, container);
    }

    public List<Container> getContainers() {
        return containers;
    }

    public static void moveContainers(Ship ship1, Ship ship2){
        ship2.addContainer(ship1.getContainers());
        ship1.removeContainer(ship1.getContainers());
    }

    public static Ship createShip(){
        return new Ship();
    }

    public double getMaxVelocity() {
        return maxVelocity;
    }

    public void setMaxVelocity(double maxVelocity) {
        this.maxVelocity = maxVelocity;
    }

    public static int getMaxContainers() {
        return maxContainers;
    }

    public static void setMaxContainers(int maxContainers) {
        Ship.maxContainers = maxContainers;
    }
}


class OverfillException extends Exception{
    public OverfillException() {
        super();
    }

    public OverfillException(String message) {
        super(message);
    }

    public OverfillException(String message, Throwable cause) {
        super(message, cause);
    }

    public OverfillException(Throwable cause) {
        super(cause);
    }

    protected OverfillException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

