package Sorting;

import Data.DataLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/// //////////////////////////////////////////////////////////////////////////////////////
/// source:
/// GeeksforGeeks. (2024). Bubble sort algorithm. Retrieved April 19, 2026, from https://www.geeksforgeeks.org/bubble-sort-algorithm/
/// Differences:
/// Translated to Java
/// Uses List<Double> instead of the int[]
/// Added optimisedPass/randomisedPass counters
/// It uses the Collections.swap()
/// Instead of array indexing it uses arr.get() and set()
/// /////////////////////////////////////////////////////////////////////////////////////

//BubbleSort of Combined Alcohol Values
public class BubbleSort {

    //counting how many passes have been done for each method
    public static int optimisedPass = 0;
    public static int unoptimisedPass = 0;
    public static int randomisedPass = 0;


    // Optimised Algorithm
        //Checks if swapped before executing levels of algorithm.
    public static void optimisedBubbleSort(List<Double> arr) {
        optimisedPass = 0;
        //n is the same as the total length of the arraylist.
        int n = arr.size();

        //Optimised sorting algorithm.
        for (int i = 0; i < n - 1; i++) {

            //if it is not swapped:
            boolean swapped = false;

            //Checks if j at (index 0) is smaller than total array length(indexes)-1. (-i largest element is moved to end)
            //if statement to check if element j at index (x) is larger than element at index (x +1).
            //Collections.swap function for actual swapping of elements.
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    Collections.swap(arr, j, j + 1);
                    swapped = true;
                    optimisedPass ++;
                }
            }
            //If no swaps happened, array is already sorted.
            if (!swapped) {
                break;
            }
        }
    }
    // Non-optimised Algorithm
    public static void unoptimisedBubbleSort(List<Double> arr) {
        unoptimisedPass = 0;
        //n is the same as the total length of the arraylist
        int n = arr.size();

        //No boolean check
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
            unoptimisedPass ++;
                if (arr.get(j) > arr.get(j + 1)) {
                    Collections.swap(arr, j, j + 1);
                }
            }
        }
            //Does not check if already sorted
    }

    public static List<Double> randomisedListBS = new ArrayList<>();

    public static void randomizeBubbleSort(List<Double> arr) {
        randomisedPass = 0;

        //Now shuffling
        Collections.shuffle(arr);
        randomisedListBS = new ArrayList<>(arr);

        int n = arr.size();
        //Using the optimised sorting algorithm for this example.
        for (int i = 0; i < n - 1; i++) {

            //if it is not swapped:
            boolean swapped = false;

            //Checks if j at (index 0) is smaller than total array length(indexes)-1. (-i largest element is moved to end)
            //if statement to check if element j at index (x) is larger than element at index (x +1).
            //Collections.swap function for actual swapping of elements.
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    Collections.swap(arr, j, j + 1);
                    swapped = true;
                    randomisedPass ++;
                }
            }
            //If no swaps happened, array is already sorted.
            if (!swapped) {
                break;

            }
        }
    }
}

