package com.company;


import java.util.Arrays;

public class Main {
    private static int[] tab= {1,2,10,2,7,2,5,3};

    public static void main(String[] args) {
        int n = tab.length;
        quicksort(0, n - 1);
        System.out.println("Finally \n" + Arrays.toString(tab));
    }
//  without duplicates
    private static void quicksort(int startIndex, int endIndex) {
//        interrupts the possibility of crossing indexes
        if (startIndex >= endIndex){
            return;
        }
        System.out.println("First print startIndex " + startIndex + "; endIndex " + endIndex);
//      int pivotIndex = getPivotIndex(n);
        int pivotIndex = endIndex;
        int pivot = tab[pivotIndex];

        int leftIndex = startIndex;
        int rightIndex = endIndex;

        while (leftIndex < rightIndex) {
            while (tab[rightIndex] > pivot) {
                rightIndex--;
            }
            while (tab[leftIndex] < pivot) {
                leftIndex++;
            }
//            another condition added if tab elements are not equal
            if (leftIndex <= rightIndex && tab[leftIndex]!=tab[rightIndex]) {
                System.out.println("Swap " + leftIndex + "; and " + rightIndex);
                swap(tab, leftIndex, rightIndex);
            }
//            if they are equal break while loop
            else break;
        }


        //swap(tab, leftIndex, pivotIndex);
        System.out.println(Arrays.toString(tab));
        quicksort(startIndex,leftIndex -1);
        quicksort(leftIndex +1 , endIndex);
        System.out.println("Second print RightIndex " + rightIndex + "; LeftIndex " + leftIndex);

    }

    private static int getPivotIndex(int n) {
        return n - 1;
    }

    private static void swap(int[] tab, int i, int j) {
        int temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
    }
    // not working
    private static void swapXOR(int[] tab, int i, int j) {
        tab[i] = tab[i] ^ tab[j];
        tab[j] = tab[i] ^ tab[j];
        tab[j] = tab[i] ^ tab[j];
    }
}
