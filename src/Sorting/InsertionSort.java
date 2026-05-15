package Sorting;

/// //////////////////////////////////////////////////////////////////////////////////////
/// Source: GeeksforGeeks. (2024). Insertion sort algorithm. Retrieved April 17, 2026, from https://www.geeksforgeeks.org/insertion-sort-algorithm/
/// other:
/// Oracle. (2024). System (Java Platform SE 8). Retrieved April 17, 2026, from https://docs.oracle.com/javase/8/docs/api/java/lang/System.html
/// GeeksforGeeks. (2024). Shuffle or randomize a list in Java. Retrieved April 17, 2026, from https://www.geeksforgeeks.org/java/shuffle-or-randomize-a-list-in-java/
/// Differences:
/// Translated to Java
/// Added comparisons++
/// Arr get and arr set instead of array indexing
/// /////////////////////////////////////////////////////////////////////////////////////
import java.util.*;

public class InsertionSort {

    public static int comparisons = 0;

    public static void properInsertionSort(List<Double> arr) {

        for (int i = 1; i < arr.size(); i++){
            double key = arr.get(i);
            int j = i - 1;

        while (j >= 0 && arr.get(j) > key){
            comparisons++;
            arr.set(j + 1, arr.get(j));
            j --;
        }
        arr.set(j + 1, key);
        }
    }
    public static void timeComplexityOfInsertionSort(List<Double> arr) {
        /* b) worst time complexity for insertion sort is O(n²)
        / In this sorting algorithm is when the numbers are sorted from HIGH to LOW.*/
        System.out.println("Comparisons of the sorted Insertion sorted array is: " + comparisons);


        // Calculating the action time
        //using system.nanotime to measure action time
        long startCountingNanoSeconds = System.nanoTime(); //start counting
        properInsertionSort(arr);
        long stopCountingNanoSeconds = System.nanoTime(); //stop counting
        long timeUsed =(stopCountingNanoSeconds-startCountingNanoSeconds);
        System.out.println("Action time for sorting the dataset: " + timeUsed + " nanoseconds.\n");


        // Comparisons after randomizing
        Collections.shuffle(arr); // using Collections to randomize the List
        comparisons = 0;
        System.out.println("Now randomizing the list ...");
        System.out.println("The randomized dataset: "+arr);

        long startCountingNanoSecondsRandom = System.nanoTime(); //start counting
        properInsertionSort(arr);
        long stopCountingNanoSecondsRandom = System.nanoTime(); //stop counting

        System.out.println("Comparisons after radomizing the array: " + comparisons);
        System.out.println("Randomizing the array will give us the estimated average+- comparisons/complexity");

        long timeUsedRandom =(stopCountingNanoSecondsRandom-startCountingNanoSecondsRandom);
        System.out.println("Action time for sorting the randomized dataset: " +timeUsedRandom+ " nanoseconds.");
    }
}
