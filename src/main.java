import Data.DataLoader;
import Sorting.BubbleSort;
import Sorting.InsertionSort;
import Sorting.MergeSort;
import Sorting.QuickSort;

import java.util.*;
/// //////////////////////////////////////////////////////////////////////////////////////
/// Source: W3Schools. (n.d.). Java LinkedHashSet. Retrieved April 19, 2026, from https://www.w3schools.com/java/java_linkedhashset.asp
/// Differences:
/// Used to extract the unique alcohol values from the dataset and not just the values
/// Combined with List<Double> for further sorting operations
/// //////////////////////////////////////////////////////////////////////////////////////

public class main {
    public static void main(String[] args) {
        System.out.println("\nTesting different sorting algorithms for sorting csv files :D \n");

        //Gets the Arraylists redWine and whiteWine from the DataLoader class.
        List<List<Double>> redWine = DataLoader.loadWineContentRed();
        List<List<Double>> whiteWine = DataLoader.loadWineContentWhite();
        //To check if import is correct.
        /*
            System.out.println("Red wine values:");
            System.out.println(redWine);
            System.out.println("White wine values:");
            System.out.println(whiteWine + "\n");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\n");
        */
        List<List<Double>> combinedWine = new ArrayList<>();
        combinedWine.addAll(redWine);
        combinedWine.addAll(whiteWine);

        //System.out.println(combinedWine);

        List<Double> combinedAlcoholContent = new ArrayList<>();
        for (List<Double> row : combinedWine) {
            combinedAlcoholContent.add(row.get(10)); //index 10 is alcohol column
        }

        // Using LinkedHashSet to store unique elements and keep original insertion order.
        Set<Double> uniquecombinedAlcoholContent = new LinkedHashSet<>(combinedAlcoholContent);
        System.out.println("There is a total of "+ combinedWine.size() + " wines.");
        System.out.println("There are "+uniquecombinedAlcoholContent.size()+" unique values.");
        System.out.println("The unsorted values are: " + uniquecombinedAlcoholContent);

//----------------------------------------------------------------------------------------------------------------------
        //Array copy for use in bubble sorting

        List<Double> BubbleSorted = new ArrayList<>(uniquecombinedAlcoholContent);
        List<Double> BubbleSortedCopy = new ArrayList<>(uniquecombinedAlcoholContent);
        List<Double> randomizedBubbleSort = new ArrayList<>(uniquecombinedAlcoholContent);

        //Using optimized Bubble Sort on combined arrayList of alcohol values:
        BubbleSort.optimisedBubbleSort(BubbleSorted);
        System.out.println("\nRunning the optimized bubble sort ...");
        System.out.println(BubbleSorted);
        System.out.println("The optimised bubble sort has been run a total of " + BubbleSort.optimisedPass + " times on the dataset.");


        //Using unoptimized Bubble sort on combined arrayList of alcohol values;
        BubbleSort.unoptimisedBubbleSort(BubbleSortedCopy);
        System.out.println("\nRunning the non-optimised bubble sort ...");
        System.out.println(BubbleSortedCopy);
        System.out.println("The non-optimised bubble sort has been run a total of " + BubbleSort.unoptimisedPass + " times on the dataset.");

        // Randomizing the numbers then bubble sorting
        BubbleSort.randomizeBubbleSort(randomizedBubbleSort);
        System.out.println("\nNow randomizing the values before bubble sorting ...");
        System.out.println("The randomized values are :" + BubbleSort.randomisedListBS); // + ranomizedBubbleSort legg inn random bubbleverdier
        //vis at det har blitt sortert
        System.out.println("The bubble sort has been run a total of " + BubbleSort.randomisedPass + " times on the randomized dataset.");

//----------------------------------------------------------------------------------------------------------------------
        //Copy for use in InsertionSort
        List<Double> InsertionSorted = new ArrayList<>(uniquecombinedAlcoholContent);

        System.out.println("\nChecking insertion sort ...");
        //Executing the sort:
        InsertionSort.properInsertionSort(InsertionSorted);
        System.out.println(InsertionSorted);
        InsertionSort.timeComplexityOfInsertionSort(InsertionSorted);
//----------------------------------------------------------------------------------------------------------------------
        List<Double> MergeSorted = new ArrayList<>(uniquecombinedAlcoholContent);

        System.out.println("\nChecking merge sort ...");
            System.out.println("This is the un-sorted list: " + MergeSorted);
        MergeSort.properMergeSort(MergeSorted);
            System.out.println("This is the sorted list: " + MergeSorted);
            System.out.println("Total merge operations: " + MergeSort.mergeOperations);

        List<Double> MergeSortedRandomized = new ArrayList<>(MergeSorted);

        System.out.println("Randomizing the array list ...");
        MergeSort.shuffleAndSort(MergeSortedRandomized);
        System.out.println("The randomized array is sorted. Total merge operations are: " + MergeSort.mergeOperations);
        System.out.println("Randomizing the array does not change number of merge operations");


//----------------------------------------------------------------------------------------------------------------------
        //Copy of uniquecombinedAlcoholContent
        List<Double> QuickSortedFirst = new ArrayList<>(uniquecombinedAlcoholContent);
        List<Double> QuickSortedLast = new ArrayList<>(uniquecombinedAlcoholContent);
        List<Double> QuickSortedRandom = new ArrayList<>(uniquecombinedAlcoholContent);
        List<Double> QuickSortedMedian = new ArrayList<>(uniquecombinedAlcoholContent);

        System.out.println("\nChecking quick sort ...");

        //QuickSort from first element:
        //Reset comparisons
        QuickSort.comparisons = 0;
        QuickSort.properQuickSort(QuickSortedFirst, 0, QuickSortedFirst.size() -1);
        System.out.println(QuickSortedFirst);
        System.out.println("First pivot comparisons: " + QuickSort.comparisons);

        //QuickSort from last element:
        //Reset comparisons
        QuickSort.comparisons = 0;
        QuickSort.quickSortLast(QuickSortedLast, 0, QuickSortedLast.size() -1);
        System.out.println(QuickSortedLast);
        System.out.println("Last pivot comparisons: " + QuickSort.comparisons);

        // QuickSort with random pivot:
        QuickSort.comparisons = 0;
        QuickSort.randomQuickSort(QuickSortedRandom, 0, QuickSortedRandom.size() - 1);
        System.out.println(QuickSortedRandom);
        System.out.println("Random pivot comparisons: " + QuickSort.comparisons);

        // QuickSort with median-of-three pivot:
        QuickSort.comparisons = 0;
        QuickSort.quickSortMedian(QuickSortedMedian, 0, QuickSortedMedian.size() - 1);
        System.out.println(QuickSortedMedian);
        System.out.println("Median pivot comparisons: " + QuickSort.comparisons);

    }
}