package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/// //////////////////////////////////////////////////////////////////////////////////////
/// Source: GeeksforGeeks. (2025). Merge sort. Retrieved April 20, 2026, from https://www.geeksforgeeks.org/dsa/merge-sort/
/// Differences:
/// Translated to Java
/// Uses List<Double> and subList() instead of raw arrays
/// //////////////////////////////////////////////////////////////////////////////////////
public class MergeSort {

    // keeps track of how many times we actually merged two halves
    public static int mergeOperations = 0;

    // entry point - resets counters and starts the sort
    public static void properMergeSort(List<Double> arr) {
        mergeOperations = 0;

        if (arr.size() <= 1) return; // nothing to sort

        mergeSort(arr, 0, arr.size() - 1);
    }

    // the recursive part - keep splitting until we hit individual elements,
    // then start merging back up
    private static void mergeSort(List<Double> arr, int left, int right) {
        if (left >= right) return; // base case, single element = already sorted

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);       // sort left half
        mergeSort(arr, mid + 1, right);  // sort right half
        merge(arr, left, mid, right);    // stitch them back together
    }

    // takes two sorted halves and merges them into one sorted chunk
    private static void merge(List<Double> arr, int left, int mid, int right) {
        mergeOperations++;

        // copy both halves out so we can overwrite the original list safely
        List<Double> leftPart  = new ArrayList<>(arr.subList(left, mid + 1));
        List<Double> rightPart = new ArrayList<>(arr.subList(mid + 1, right + 1));

        int i = 0;     // pointer for leftPart
        int j = 0;     // pointer for rightPart
        int k = left;  // where we're writing back into arr

        // pick the smaller of the two front elements each time
        while (i < leftPart.size() && j < rightPart.size()) {
            if (leftPart.get(i) <= rightPart.get(j)) {
                arr.set(k, leftPart.get(i));
                i++;
            } else {
                arr.set(k, rightPart.get(j));
                j++;
            }
            k++;
        }

        // dump whatever's left in either half
        while (i < leftPart.size()) {
            arr.set(k, leftPart.get(i));
            i++;
            k++;
        }

        while (j < rightPart.size()) {
            arr.set(k, rightPart.get(j));
            j++;
            k++;
        }
    }

    // shuffles the list then sorts it - used for part b)
    public static void shuffleAndSort(List<Double> arr) {
        Collections.shuffle(arr);
    }
}