package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Engine engine = new Engine(20000, 2001);
        Airplane airplane = new Airplane("Boeing", 200, engine);

        System.out.println(airplane.getBrand());

        System.out.println(airplane.getSeats());
        airplane.setSeats(250);
        System.out.println(airplane.getSeats());

        System.out.println(engine.getHorsepower());

        System.out.println(engine.getProductionYear());

        int horsepower = airplane.getEngine().getHorsepower();
        System.out.println(horsepower);

        int productionYear = airplane.getEngine().getProductionYear();
        System.out.println(productionYear);

        boolean isEco = airplane.getEngine().isEco();
        System.out.println("Is the plane eco?: " +isEco);


    }
}

class Airplane {
    private String brand;
    private int seats;
    Engine engine;

    public Airplane(String brand, int seats, Engine engine){
        this.brand = brand;
        this.seats = seats;
        this.engine=engine;
    }

    public String getBrand(){
        return this.brand;
    }
    public int getSeats(){
        return this.seats;
    }

    public void setSeats(int seats){
        this.seats = seats;
    }

    public Engine getEngine(){
        return this.engine;
    }
}

class Engine {
    private int horsepower;
    private int productionYear;

    public Engine(int horsepower, int productionYear){
        this.horsepower = horsepower;
        this.productionYear = productionYear;
    }

    public int getProductionYear(){
        return this.productionYear;
    }

    public int getHorsepower(){
        return this.horsepower;
    }

    protected boolean isEco(){
        if(this.horsepower<=20000 && this.productionYear>2000){
            return true;
        }else{
            return false;
        }
    }
}