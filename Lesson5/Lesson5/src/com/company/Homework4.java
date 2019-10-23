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

    public static int [] secondDuplicateSearch(int [] arr)
    {   int size = arr.length;
        int count[] = new int[size];
        int i;

        System.out.println("Repeated elements are : ");
        for (i = 0; i < size; i++)
        {
            if (count[arr[i]] == 1)
                System.out.print(arr[i] + " ");
            else
                count[arr[i]]++;
        }
        return count;
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
    private static <T> String checkForDuplicates(T... array){
        String cfd="";
        // create an empty set
        Set<T> set = new HashSet<T>();
        // do for every element in the array
        for (T e : array)
        {
            // return true if duplicate is found
            if (set.contains(e))
                cfd+=e + ", ";
            // insert current element into a set
            if (e != null)
                set.add(e);
        }
        // no duplicate found
        return cfd;
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
        System.out.println("\n---------------------------------------\nQuick sort 2 : ");
        startTime = System.currentTimeMillis();
        quickSort(A,0,A.length-1);
        endTime = System.currentTimeMillis();
        timeElapsed = endTime - startTime;
        System.out.println(Arrays.toString(A));
        System.out.println("Execution time in milliseconds: " + timeElapsed);
        //method no.2
        System.out.println("\n---------------------------------------\nFind duplicates 2 : ");
        Homework4 duplicate1 = new Homework4();
        startTime = System.currentTimeMillis();
        int [] arr1 = A;
        duplicate1.secondDuplicateSearch(arr1);
        endTime = System.currentTimeMillis();
        timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds: " + timeElapsed);
        //method no.3
        System.out.println("\n---------------------------------------\nFind duplicates 3 : ");
        startTime = System.currentTimeMillis();
        Homework4 duplicate = new Homework4();
        int [] arr2 = A;
        int arr_size = arr2.length;
        duplicate.printRepeating(arr2, arr_size);
        endTime = System.currentTimeMillis();
        timeElapsed = endTime - startTime;
        System.out.println("\nExecution time in milliseconds: " + timeElapsed);
        //method no.4
        int [] arr3 = A;
        System.out.println("Duplicate " + checkForDuplicates(arr3));
    }
}
