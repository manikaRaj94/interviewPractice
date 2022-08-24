package com.interviewpractice.phonepe.ques2;

import java.util.*;

//Given an array numbers[] of N positive integers and a positive integer X
//Task to find the number of ways that X can be obtain writing pairs of integers
//in the array numbers[]  next to each other. In other words, find the number of ordered pairs(i,j)
//        such that i!=j and X is the concatination
//of numbers[i] and numbers[j]
public class FindPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array length : ");
        int lengthArray = sc.nextInt();
        int[] numbers = new int[lengthArray];
        System.out.println("Enter the elements for " + lengthArray + " length");
        for (int i = 0; i < lengthArray; i++) {
            numbers[i] = sc.nextInt();
        }
        System.out.println("Enter value of X : ");
        int x = sc.nextInt();

        for (int i : numbers)
            System.out.print(" " + i);
        System.out.println();
        System.out.println("Pairs count : " + findPairs(numbers, x));
    }

    public static int findPairs(int[] numbers, int x) {
        int pairs = 0;
        String str = String.valueOf(x);
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++)
                if (i != j) {
                    String conct = String.valueOf(numbers[i]) + String.valueOf(numbers[j]);
                    System.out.println("cont : " + conct);
                    if (str.compareTo(conct) == 0) {
                        ++pairs;
                    }
                }
        }



        return pairs;
    }

    public static int findPairsLatest(int[] numbers, int x) {
        int pairs = 0;
        String str = String.valueOf(x);
        Map<String,Integer> map = new LinkedHashMap<>();
        for(int i : numbers)
        {
            if(map.containsKey(String.valueOf(i)))
            map.put(String.valueOf(i), map.get(i)+1);
            else
                map.put(String.valueOf(i),1);
        }

        for(int i=0;i<str.length();i++)
        {
            String p = str.substring(0,i+1);
            String q = str.substring(i+1);
        }

        return pairs;
    }
}
