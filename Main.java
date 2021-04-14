package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Multiplier x = new Multiplier();
        System.out.println(x.multiply(3,4,5,6));

        BigDecimal two = new BigDecimal ("2");
        BigDecimal five = new BigDecimal ("5");

        System.out.println(x.multiply(two, five));

        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(2);
        numbers.add(5);

        System.out.println(x.multiply(numbers));

        Address y = new Address();
        System.out.println(y.createAddress("Poland", "Warsaw", "01-111"));
    }
}

class Multiplier {

    public int multiply(int a, int b){
        return a*b;
    }

    public int multiply(int a, int b, int c, int d){
        return multiply(a,b)*multiply(c,d);
    }

    public double multiply(double a, double b){
        return a*b;
    }

    public BigDecimal multiply(BigDecimal a, BigDecimal b){
        BigDecimal result = a.multiply(b);
        return result;
    }

    public Integer multiply(List<Integer> numbers){
        Integer result = 1;
        for(Integer number: numbers){
            result = result*number;
        }
        return result;
    }
}

class Adder{
    public int add(int a, int b){
        return a+b;
    }

    public BigDecimal add(List<BigDecimal> numbers){
        BigDecimal result = new BigDecimal ("0");
        for(BigDecimal number:numbers){
            result = result.add(number);
        }
        return result;
    }
}

class Address{
    public String createAddress(String country){
        return String.format("Country: %s", country);
    }

    public String createAddress(String country, String city){
        return String.format("Country: %s, city: %s", country, city);
    }

    public String createAddress(String country, String city, String postalCode){
        return String.format("Country: %s, city: %s, postal code: %s", country, city, postalCode);
    }

    public String createAddress(String country, String city, String postalCode, String street){
        return String.format("Country: %s, city: %s, postal code: %s, street: %s", country, city, postalCode, street);
    }

    public String createAddress(String country, String city, String postalCode, String street, int houseNumber){
        return String.format("Country: %s, city: %s, postal code: %s, street: %s, houseNumber: %d", country, city, postalCode, street, houseNumber);
    }

}