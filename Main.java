package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Point p1 = Point.createPoint();
        Point.translate(p1,7,5);
        System.out.println(Point.getX());

        System.out.println("");

        System.out.println(RandomNumbers.nextIntFromRange(0,10));
        System.out.println(RandomNumbers.nextEvenIntFromRange(5, 10));
        BigDecimal one = new BigDecimal("1");
        BigDecimal two = new BigDecimal("2");
        List<BigDecimal> numbers = new ArrayList<>();
        numbers.add(one);
        numbers.add(two);
        System.out.println(RandomNumbers.randomElement(numbers));

        System.out.println("");

        CreditCardForm przyklad = new CreditCardForm("123545", 111);
        System.out.println(przyklad.getExpiryYear());
    }
}

final class Point{
    private static int x;
    private static int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private Point() {
    }

    public static Point createPoint(int x, int y){
        return new Point(x, y);
    }

    public static Point createPoint(){
        return new Point();
    }

    public static Point translate(Point point, int a, int b){
        return new Point(x+a, y+b);
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }
}

final class RandomNumbers{

    public static int nextIntFromRange(int start, int stop){
        Random random = new Random();
        return random.nextInt(stop-start)+start;
    }

    public static int nextEvenIntFromRange(int start, int stop){
        int x = nextIntFromRange(start, stop);
        if(x%2==0){
            return x;
        }else{
            return x+1;
        }
    }

    public static BigDecimal randomElement(List<BigDecimal> numbers){
        Random random = new Random();
        return numbers.get(random.nextInt(numbers.size()));
    }
}

class CreditCardForm{
    private String cardNumber;
    private int CVC;
    private int expiryYear;
    private static List<Integer> years = new ArrayList<>();

    static {
        final int n = 20;
        int currentYear = LocalDate.now().getYear();
        for(int i=0; i<n; i++){
            years.add(currentYear+i);
        }
    }


    public CreditCardForm(String cardNumber, int CVC) {
        this.cardNumber = cardNumber;
        this.CVC = CVC;
        Random random = new Random();
        this.expiryYear= years.get(random.nextInt(years.size()));
    }

    public int getExpiryYear() {
        return expiryYear;
    }

}
