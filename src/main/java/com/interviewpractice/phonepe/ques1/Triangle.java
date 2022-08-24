package com.interviewpractice.phonepe.ques1;


import java.util.Scanner;

//Given an array A[] of n elements , You'd like to know how many triangles can be formed with side lengths equal to adjacent
//        elemnts from A[].
//Construct an array of integers of length N-2 ,
//        where ith element is equal to 1 if it is possible to form a triangle with side lengths
//A[i],A[i+1] and a[i+2] , otherwise 0.
//
//Note : A triangle can be formed with the side lengths a , b, and c if a+b>c and a+c >b and b+c>a.
public class Triangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array length : ");
        int lengthArray = sc.nextInt();
        int[] arrayA = new int[lengthArray];
        int[] newArray = new int[lengthArray-2];
        System.out.println("Enter the elements for "+lengthArray+" length");
        for(int i=0;i<lengthArray;i++)
        {
            arrayA[i]=sc.nextInt();
        }
        System.out.println();
        for(int i :arrayA)
            System.out.print(" "+i);
        System.out.println();
        for(int i=0;i<lengthArray-2;i++)
        {
            int a = arrayA[i];
            int b = arrayA[i+1];
            int c = arrayA[i+2];
            System.out.println("Group "+i+" : "+a+" "+b+" "+c);
            if((a+b>c)&& (b+c>a)&&(a+c>b))
            {
                newArray[i] =1;
            }
            else
                newArray[i]=0;
        }

        System.out.println();
        for(int i :newArray)
            System.out.print(" "+i);
        }
    }

