package com.jorgeweiss;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // The following are Primitive Types
        int myAge = 32;
        byte herAge = 2;
        long viewsCount = 3_123_456_789L;
        float price = 10.99F;
        char letter = 'A';
        boolean isEligible = true;

        //The following are Reference Types
        Date now = new Date();
        String myWord = "Hello World";

        // Escape Sequences in Strings
        // to print the following:  He was like "Hey that's my bike"
        System.out.println("He was like \"Hey that's my bike\"");
        // new line are used with \n as follows
        System.out.println("How are you? \nI'm fine thanks.");


        System.out.println("The date is ...");
	    System.out.println(now);
        System.out.println(myWord.replace("World", "Mars"));

        // =====================
        // ARRAYS
        // =====================

        // Old way of initializing arrays
        int [] numbers = new int[5]; // specify the length of the array
        numbers[0] = 1;
        numbers[1] = 4;
        System.out.println(Arrays.toString(numbers)); // not we have to convert to string to print array

        // New way of initializing arrays
        int[] newNumbers = { 2, 3, 5, 1, 4 };
        System.out.println(Arrays.toString(newNumbers));
        System.out.println(newNumbers.length);

        // Multi-dimensional Array (Old way)
        int[][] matrix = new int[2][3];
        matrix[0][1] = 100;
        System.out.println(Arrays.toString(matrix)); // this will not print the matrix itself but rather its reference
        System.out.println(Arrays.deepToString(matrix));  // correct way to print 3D array

        // Multi-dimensional Array (New way)
        int[][] newMatrix = { {1,2,3}, {4,5,6} };
        System.out.println(Arrays.deepToString(newMatrix));


        // ========================
        // CONSTANTS
        // ========================

        // to declare a variable
        float height = 1.70F;

        // to declare a constant (cant change)
        final float pi = 3.14F;  // NOTE the 'final' keyword


        // =========================
        // Arithmetic Expressions
        // =========================

        // division:
        int integerDiv = 10/3;
        System.out.println("Integer division of 10/3:");
        System.out.println(integerDiv);

        double completeDiv = (double)10 / (double)3;
        System.out.println("Complete division of 10/3");
        System.out.println(completeDiv);

        // increments/decrements:
        int year = 2020;
        year++;
        System.out.println("It is now the year: ");
        System.out.println(year);
        // x += 3 augments by 3
        // x-- reduces value by one


        // =========================
        // CASTING
        // =========================

        // string to int:
        String apples = "4";
        int fruits = 5 + Integer.parseInt(apples);
        System.out.println(fruits);

        // implicit casting:
        double m = 1.1;
        double n = m + 2; // m and 2 are different types. 2 is converted to double to avoid data loss;
        System.out.println(n); // 3.1

        // explicit casting:
        double i = 1.1;
        int j = (int)i + 2;  // specify how we want to convert i to do arithmetic
        System.out.println(j); // 3


        // ===========================
        // MATH CLASS
        // ===========================

        int rounded = Math.round(1.3F);
        System.out.println(rounded);

        double guess = Math.random();
        System.out.println(guess);

        // to generate a random number between 1-100:
        int newGuess = (int) Math.round(Math.random()*100);
        System.out.println(newGuess);


        // =========================
        // FORMATTING NUMBERS
        // =========================

        // how to format numbers in java
        // NumberFormat is an abstract class so you cannot create an instance of this class

        // money
        NumberFormat currency = NumberFormat.getCurrencyInstance();  // note no new keyword
        String currencyResult = currency.format(1234567.891);
        System.out.println(currencyResult);

        // percent
        NumberFormat myPercent = NumberFormat.getPercentInstance();
        String percentResult = myPercent.format(0.33);
        System.out.println(percentResult);


        // =========================
        // READING INPUT
        // =========================

        // import java.util.Scanner;
        // Scanner myFirstScanner = new Scanner(System.in);
        // System.out.print("Please enter your age: ");
        // byte yourAge = myFirstScanner.nextByte();
        // System.out.println(yourAge + 4);

        // Scanner myFirstScanner = new Scanner(System.in);
        // System.out.print("Please enter your first name: ");
        // String firstName = myFirstScanner.next();
        // System.out.print("Thank you. Now please enter your last name: ");
        // String lastName = myFirstScanner.next(); // NOTE there are other types of next methods to get the input
        // System.out.println("Nice to meet you " + firstName + " " + lastName);


        // ==========================================
        // EXERCISE: Mortgage Payment Calculator
        // ==========================================
        Scanner secondScanner = new Scanner(System.in);
        System.out.println("Let's calculate your mortgage payment.");
        System.out.print("Enter the loan amount: ");
        int loan = secondScanner.nextInt();
        System.out.print("Great! Now enter your annual interest rate. For example: 3.2 or 4.5: ");
        float interest = secondScanner.nextFloat()/100/12;
        System.out.print("Almost there. How many months is this loan for? ");
        int payments = secondScanner.nextInt();
        System.out.println("Ok. I have all the information I need. Just one second while I calculate this...");
        double monthlyPayment = loan * ( interest * Math.pow((1+interest), payments) ) / ( Math.pow((1 + interest), payments) - 1 );
        System.out.println("Your monthly payment will be: " + currency.format(monthlyPayment));
    }
}
