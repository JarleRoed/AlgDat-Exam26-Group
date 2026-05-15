package Sorting;

/// //////////////////////////////////////////////////////////////////////////////////////
/// Source: GeeksforGeeks. (2024). QuickSort algorithm. Retrieved April 19, 2025, from https://www.geeksforgeeks.org/quick-sort-algorithm/
/// GeeksforGeeks. (2024). QuickSort using random pivoting. Retrieved April 19, 2026, from https://www.geeksforgeeks.org/dsa/quicksort-using-random-pivoting/
/// Differences:
/// Translated to Java
/// We are using List<Double> instead of int[]
/// No pointers
/// Added the use of comparisons++
/// Using muliple pivot stategies
/// //////////////////////////////////////////////////////////////////////////////////////

import java.util.List;

public class QuickSort {

    // counts total comparisons
    public static int comparisons = 0;

    //------------------------------------------------------------------------------------------------
    // First element as pivot
    //------------------------------------------------------------------------------------------------

    public static void properQuickSort(List<Double> arr, int low, int high) {
        // nothing to sort if low >= high
        if (low < high) {
            int pivotIndex = partitionFirst(arr, low, high);
            properQuickSort(arr, low, pivotIndex - 1);  // left side
            properQuickSort(arr, pivotIndex + 1, high); // right side
        }
    }

    private static int partitionFirst(List<Double> arr, int low, int high) {
        double pivot = arr.get(low); // grab first element as pivot
        int i = low + 1; // i tracks where smaller elements go

        for (int j = low + 1; j <= high; j++) {
            comparisons++;
            if (arr.get(j) < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, low, i - 1); // drop pivot into correct spot
        return i - 1;
    }

    //---------------------------------------------------------------------------------------------------
    // Last element as pivot
    //---------------------------------------------------------------------------------------------------
    public static void quickSortLast(List<Double> arr, int low, int high) {
        if (low >= high) return;

        int pivotIndex = partitionLast(arr, low, high);
        quickSortLast(arr, low, pivotIndex - 1);
        quickSortLast(arr, pivotIndex + 1, high);
    }

    private static int partitionLast(List<Double> arr, int low, int high) {
        double pivot = arr.get(high); // last element is pivot
        int i = low - 1; // starts one before low

        for (int j = low; j < high; j++) {
            comparisons++;
            if (arr.get(j) <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high); // pivot goes here
        return i + 1;
    }

    //---------------------------------------------------------------------------------------------------
    // --- Random element as pivot ---
    //---------------------------------------------------------------------------------------------------

    public static void randomQuickSort(List<Double> arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionRandom(arr, low, high);
            randomQuickSort(arr, low, pivotIndex - 1);
            randomQuickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partitionRandom(List<Double> arr, int low, int high) {
        // pick something random and move it to front
        int randomIndex = low + (int)(Math.random() * (high - low + 1));
        swap(arr, randomIndex, low);
        double pivot = arr.get(low);
        int i = low + 1;

        for (int j = low + 1; j <= high; j++) {
            comparisons++;
            if (arr.get(j) < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, low, i - 1);
        return i - 1;
    }

    //----------------------------------------------------------------------------------------------------
    //  Median of three as pivot
    //----------------------------------------------------------------------------------------------------

    public static void quickSortMedian(List<Double> arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionMedian(arr, low, high);
            quickSortMedian(arr, low, pivotIndex - 1);
            quickSortMedian(arr, pivotIndex + 1, high);
        }
    }

    private static int partitionMedian(List<Double> arr, int low, int high) {
        int mid = low + (high - low) / 2;

        // sort low, mid, high so median ends up at mid
        if (arr.get(low) > arr.get(mid)) swap(arr, low, mid);
        if (arr.get(mid) > arr.get(high)) swap(arr, mid, high);
        if (arr.get(low) > arr.get(mid)) swap(arr, low, mid);

        // move median to front
        swap(arr, mid, low);
        double pivot = arr.get(low);
        int i = low + 1;

        for (int j = low + 1; j <= high; j++) {
            comparisons++;
            if (arr.get(j) < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, low, i - 1);
        return i - 1;
    }

    // swaps two elements
    private static void swap(List<Double> arr, int a, int b) {
        double temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }
}