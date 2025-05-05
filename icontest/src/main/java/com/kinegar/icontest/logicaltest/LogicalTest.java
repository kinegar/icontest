package com.kinegar.icontest.logicaltest;

import java.util.ArrayList;

public class LogicalTest {
    public static String reverseWords(String string){
        String[] words = string.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String reverse = new StringBuffer(words[i]).reverse().toString();
            result.append(reverse);
            if(i != words.length -1){
                result.append(" ");
            }
        }
        return result.toString();
    }
    public static String fizzBuzz(int n){
        StringBuilder result = new StringBuilder();
        if(n % 3 == 0){
            result.append("Fizz");
        }

        if(n % 5 == 0){
            result.append("Buzz");
        }

        if (result.isEmpty()){
            result.append(n);
        }
        return result.toString();
//        if (i % 3 == 0 && i % 5 == 0){
//            return "FizzBuzz";
//        }
//        else if(i % 3 == 0){
//            return "Fizz";
//        }else if (i % 5 == 0 ){
//            return "Buzz";
//        }
//        return String.valueOf(i);
    }

    public static ArrayList<Integer> fibonacciSequence(int n1, int n2, int limit){
        if(limit<=2){
            throw new RuntimeException("Limit harus lebih dari 2");
        }
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(n1);
        integers.add(n2);
        for (int i = 2; i < limit; i++) {
            Integer nextNumber = integers.get(i-2) + integers.get(i-1);
            integers.add(nextNumber);
        }
        return integers;
    }

    public static int highestStockProfit(int[] stock){
        int highestProfit = 0;
        for (int i = 0; i < stock.length-1; i++) {
            for (int j = i+1; j < stock.length; j++) {
                int profit = stock[j] - stock[i];
                if (highestProfit<profit){
                    highestProfit = profit;
                }
            }
        }
        return highestProfit;
    }

    public static int numberOfInteger(char[] array){
        int total = 0;
        for (char c : array){
            if(c>='0' && c<='9') total = total+1;
        }
        return total;
    }
}
