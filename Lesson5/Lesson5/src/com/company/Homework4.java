package com.company;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Homework4 {

    public static int [] insert(){
        System.out.println("Add aray lenght");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] array = new int [n];
        for (int i=0; i<n;i++){
            System.out.println("Imput A[" + i + "]");
            array[i] = scanner.nextInt();
        }
        return array;
    }
    public static void print (int [] array){
        for (int i=0; i<array.length;i++){
            System.out.println("Output " + array[i] );
        }
    }
    //brute method- first thought
    public static int [] firstDuplicateSearch(int [] array){
        int n = array.length;
        int [] ret = new int [n];
        for (int i=0; i< n;i++){
            for (int j=i+1; j<n; j++ ){
                if (array [i] == array[j]){
                    ret [i] =array [i];
                    //i++;
                }
            }
        }
    return ret;
    }

    public static void quickSort(int[] arr, int start, int end){

        int partition = partition(arr, start, end);

        if(partition-1>start) {
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            quickSort(arr, partition + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];

        for(int i=start; i<end; i++){
            if(arr[i]<pivot){
                int temp= arr[start];
                arr[start]=arr[i];
                arr[i]=temp;
                start++;
            }
        }

        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        return start;
    }

    // Function to print duplicates and find by Math.abs
    void printRepeating(int arr[], int size)
    {
        int i;
        System.out.println("The repeating elements are : ");

        for (i = 0; i < size; i++)
        {
            if (arr[ Math.abs(arr[i])] >= 0)
                arr[ Math.abs(arr[i])] = -arr[ Math.abs(arr[i])];
            else
                System.out.print(Math.abs(arr[i]) + " ");
        }
    }

    // Generic function to check for duplicates in an array
    private static <T> boolean checkForDuplicates(T... array)
    {
        // create an empty set
        Set<T> set = new HashSet<T>();
        // do for every element in the array
        for (T e : array)
        {
            // return true if duplicate is found
            if (set.contains(e))
                return true;
            // insert current element into a set
            if (e != null)
                set.add(e);
        }
        // no duplicate found
        return false;
    }

    public static void main(String[] args) {
        int [] A = insert();
        print(A);
        long startTime = System.currentTimeMillis();
        int [] firstDupicate = firstDuplicateSearch(A);
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("Duplicates 1 : ");
        print(firstDupicate);
        System.out.println("Execution time in milliseconds: " + timeElapsed);
        //QuickSort
        System.out.println("Quick sort 2 : ");
        startTime = System.currentTimeMillis();
        quickSort(A,0,A.length-1);
        endTime = System.currentTimeMillis();
        timeElapsed = endTime - startTime;
        System.out.println(Arrays.toString(A));
        System.out.println("Execution time in milliseconds: " + timeElapsed);
        //method no.2
        startTime = System.currentTimeMillis();
        Homework4 duplicate = new Homework4();
        int [] arr = insert();
        int arr_size = arr.length;
        duplicate.printRepeating(arr, arr_size);
        endTime = System.currentTimeMillis();
        timeElapsed = endTime - startTime;
        System.out.println("\nExecution time in milliseconds: " + timeElapsed);
        //method no.3
        int [] arr2 = insert();
        if (checkForDuplicates(arr2))
            System.out.println("Duplicate Found");
    }
}
