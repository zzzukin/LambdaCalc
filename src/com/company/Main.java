package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        System.out.println(Calculate(15, 16, (x1, x2) -> x1 + x2));
        System.out.println(Calculate(15, 16, (x1, x2) -> x1 * x2));
        System.out.println(Calculate(15, 16, (x1, x2) -> x1 / x2));
        System.out.println(Calculate(15, 16, (x1, x2) -> x1 + x2));
        System.out.println(Calculate(15, 16, (x1, x2) -> Math.sqrt(x1 + x2)));

        System.out.println("----------------------------------");

        System.out.println(Calculate(15, 16, Recipient::Sum));
        System.out.println(Calculate(15, 16, Recipient::Denom));

        System.out.println("----------------------------------");

        Thread thread = new Thread(()->System.out.println("Runnable"));

        thread.run();

        System.out.println("----------------------------------");

//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        };



        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable");
            }
        };

        runnable.run();

        System.out.println("-----------------------------------------------------");

        List<String> list = Arrays.asList("123123", "sdfsdf", "sdfdfsd", "dfsdfsd");

        list.forEach((x)-> System.out.println(x));

        System.out.println("-----------------------------------------------------");

        List<String> list1 = Arrays.asList("123123", "sdfsdf", "sdfdfsd", "dfsdfsd");

        ListFilter(list1, (str) -> str.length() < 7);

    }

    public static void ListFilter(List <String> lst, Filterable c){
        for(String s : lst){
            if(c.flt(s)){
                System.out.println(s);
            }
        }
    }


    public static double Calculate(double q1, double q2, Calculator c){

        return c.eval(q1, q2);
    }
}

interface Calculator {
    public double eval(double x1, double x2);
}

interface Filterable{
    public boolean flt(String str);
}

class Recipient {
    public static double Sum(double q1, double q2){
        return q1 + q2;
    }

    public static double Denom(double q1, double q2){
        return q1/q2;
    }
}

interface Printable{
    void print(String s);
}