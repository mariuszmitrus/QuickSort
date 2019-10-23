package com.company;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayHome {
    public static String [] Array;
    public static int size;

    public ArrayHome(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add array lenght");
        int n = scanner.nextInt();
        String [] Str = new String [n];
        for (int k = 0; k < n; k++) {
            System.out.println("Add " + k + " element");
            Str[k] = String.valueOf(scanner.nextInt());//why S[0] element can't be added from keyboard?
            System.out.println("Added " + k + " element " + Str[k]);
        }
        Array = Str;
        size = n;
    }

    static int[] insert(int n) {
        Scanner scanner = new Scanner(System.in);
        //declare array
        int[] S = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Add " + i + " element");
            S[i] = scanner.nextInt();
        }
        return S;
    }

    static String printString(int[] S1) {
        int n = S1.length;
        String str = "";
        String str2 = "";
        for (int i = 0; i < n; i++) {
            str += "  " + S1[i];
            str2 += "A[" + i + "]\t";
            if (i < n - 1) str += ",  \t";
        }
        str = str2 + "\n" + str;
        return str;
    }

    static String printStringArray(String[] S1) {
        int n = S1.length;
        String str = "";
        String str2 = "";
        for (int i = 0; i < n; i++) {
            str += "  " + S1[i];
            str2 += "A[" + i + "]\t";
            if (i < n - 1) str += ",  \t";
        }
        str = str2 + "\n" + str;
        return str;
    }

    static int[] reverseOrder(int[] S1) {
        int n = S1.length;
        System.out.println("REVERSING...");
        int[] S2 = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            S2[j - 1] = S1[i];
            j -= 1;
        }
        System.out.println("REVERSED");
        return S2;
    }

    static public int minimum(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    static public int maximum(int[] array) {
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    static String[] insertStringArray(int n) {
        String[] X = new String[n];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            X[i] = scanner.nextLine();
        }
        return X;
    }

    static String printArrayAlphabet(String [] S1) {
        int n=S1.length;
        String X = "";
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int i = 0; i < n; i++) {
            X += alphabet[i] + "=" + S1[i] + " ";
        }
        return X;
    }

    public static String printArrayAlphabetConstruct(ArrayHome S1) {
        int n=S1.size;
        String X = "";
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int i = 0; i < n; i++) {
            X += alphabet[i] + "=" + S1.Array[i] + " ";
        }
        return X;
    }
    public static void swapArrayConstruct(ArrayHome Array2, ArrayHome Array1) throws InterruptedException {
        /* METOD TO REPAIR
            Notice the user of print as opposed to println:
            the '\b' char cannot go over the new line char.
        */
        System.out.print("Start[          ]");
        System.out.flush(); // the flush method prints it to the screen

        // 11 '\b' chars: 1 for the ']', the rest are for the spaces
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b");
        System.out.flush();
        Thread.sleep(500); // just to make it easy to see the changes
        ArrayHome temp = Array2;
        int j = Array1.size;
        if (Array1.size == Array2.size) {
            for (int i = 0; i < j; i++) {
                System.out.print("."); //overwrites a space
                System.out.flush();
                Thread.sleep(100);
                temp.Array[i] = Array1.Array[i];
                Array1.Array[i] = Array2.Array[i];
                Array2.Array[i] = temp.Array[i];
            }
            System.out.print("] Done\n"); //overwrites the ']' + adds chars
            System.out.flush();
            System.out.println("First array:  \n " + printArrayAlphabetConstruct(Array1));
            System.out.println("Second array:  \n " + printArrayAlphabetConstruct(Array2));
        } else {
            temp.Array[1] = "Error";
            System.out.println("---------------------  \n " + printArrayAlphabetConstruct(temp));
        }
    }

    static String[] swap(String[] Array)  {
        String[] temp = new String[Array.length];
        int j = Array.length;
        for (int i = 0; i < j; i++) {
            temp[j] = Array[i];
            j--;
        }
        return temp;
    }

    static void swapArray(String[] Array1, String[] Array2) throws InterruptedException {
        /*
            Notice the user of print as opposed to println:
            the '\b' char cannot go over the new line char.
        */
        System.out.print("Swaping...\n Let's make some magic.Start[          ]");
        System.out.flush(); // the flush method prints it to the screen

        // 11 '\b' chars: 1 for the ']', the rest are for the spaces
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b");
        System.out.flush();
        Thread.sleep(500); // just to make it easy to see the changes
        String[] temp = new String[Array1.length];
        int j = Array1.length;
        if (Array1.length == Array2.length) {
            for (int i = 0; i < j; i++) {
                System.out.print("."); //overwrites a space
                System.out.flush();
                Thread.sleep(100);
                temp[i] = Array1[i];
                Array1[i] = Array2[i];
                Array2[i] = temp[i];
            }
            System.out.print("] Done\n"); //overwrites the ']' + adds chars
            System.out.flush();
            System.out.println("First array:  \n " + printStringArray(Array1));
            System.out.println("Second array:  \n " + printStringArray(Array2));
        } else {
            temp[1] = "Error";
            System.out.println("---------------------  \n " + printStringArray(temp));
        }
    }


    public static void main(String[] args) throws InterruptedException {
        //Exercise 1. Arrays - print elements of an array in the reverse order
        System.out.println("---------------------------------\nExercise 1. Reverse order.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add array lenght");
        int n = scanner.nextInt();
        int[] ar1 = insert(n);
        System.out.println("You inserted: \n" + printString(ar1));
        int[] ar2 = reverseOrder(ar1);
        System.out.println("Revers order is:  \n " + printString(ar2));
        //Exercise 2. Arrays - find min and max.
        System.out.println("---------------------------------\nExercise 2. Min and max\n");
        System.out.println("Max = " + maximum(ar2));
        System.out.println("Min = " + minimum(ar2));
        //Exercise 3. Swap values.
        System.out.println("---------------------------------\nExercise 3. Swap values.\n\n two variables:");
        //lazy method to swap
        System.out.println("Add X value");
        int x = scanner.nextInt();
        System.out.println("Add Y value");
        int y = scanner.nextInt();
        System.out.println("Your values x=" + x + " y=" + y);
        int temp;
        temp = x;
        x = y;
        y = temp;
        System.out.println("Swaped values x=" + x + " y=" + y);
        System.out.println("---------------------------------\n");
        //array method to swap
        System.out.println("Add array lenght");
        int l=scanner.nextInt();
        System.out.println("Add first array");
        String[] ar3 = insertStringArray(l);
        System.out.println("Add second array");
        String[] ar4 = insertStringArray(l);
        String[] tempArray = new String[ar3.length];
        System.out.println("First array:  \n " + printStringArray(ar3));
        System.out.println("Second array:  \n " + printStringArray(ar4));
        swapArray(ar3, ar4);
        //another display method with constructor
        //this doesn't work as constructor
        System.out.println("---------------------------------\nMethod with constructor");
        System.out.println("First");
        ArrayHome arC11 = new ArrayHome();
        System.out.println("Second");
        ArrayHome arC12 = new ArrayHome();
        System.out.println("First array:  \n " + printArrayAlphabetConstruct(arC11));
        System.out.println("Second array:  \n " + printArrayAlphabetConstruct(arC12));
        System.out.println("Swaping...\n Let's make some magic.\n");
        swapArrayConstruct(arC11, arC12);
       //lost method swaping values in Array
        System.out.println("---------------------------------\nSwap in Array");
        System.out.println("Add array lenght");
        int k=scanner.nextInt();
        System.out.println("Add array's elements");
        String [] ar6 = insertStringArray(k);
        System.out.println("Your values "+ printArrayAlphabet(ar6));
        String [] swaped = swap(ar6);
        System.out.println("Swaped values ");
        System.out.println(printArrayAlphabet(swaped));
        //XOR method make it
        int a = 5; int b = 10;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
}