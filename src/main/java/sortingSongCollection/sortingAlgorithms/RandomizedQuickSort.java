package sortingSongCollection.sortingAlgorithms;

import sortingSongCollection.songs.Song;
import java.util.Arrays;

public class RandomizedQuickSort implements SortingAlgorithm {

    // FILL IN CODE: Add helper methods partition and computePivot to this class.
    // In computePivot, the pivot value should be computed as the median of values at three random indices of the subarray from low to high

    /**
     * Sort the given subarray of songs from low to high using randomized quick sort (recursive), where the pivot
     * is picked as the median of values at three random indices from low to high.
     *
     * @param songs       array of songs
     * @param low         index of the first element of the subarray we need to sort
     * @param high        index of the last element of the subarray we need to sort
     * @param isAscending if true, sort in increasing order, otherwise in decreasing order
     * @param sb          StringBuilder that should store the string showing the array after each partition of randomized quick sort.
     *                    Show only the first letter of the title of each song in the songs array,
     *                    and "highlight" the pivot element that was used for the partition
     *                    by showing it in lower case.
     *                    For instance, for input UCFWHABOVPRL and low = 0, high = 11, your result *may* look like this (assuming that we print only the first letter of the title of each song):
     *                    AbFWHULOVPRC
     *                    ABFRHCLOPuWV
     *                    ABCfHPLORUWV
     *                    ABCFHLoRPUWV
     *                    ABCFHlORPUWV
     *                    ABCFHLOpRUWV
     *                    ABCFHLOPRUVw
     *                    <p>
     *                    Note that your result will likely be different from what is shown here, since the randomized quicksort algorithm chooses 3 indices randomly before deciding on the "median" pivot.
     *                    The first line shows the result after partitioning the array by b;
     *                    the second line shows the result after partitioning the right subarray by u
     *                    (since the left subarray has only one element which is the base case), and so on.
     */
    @Override
    public void sort(Song[] songs, int low, int high, boolean isAscending, StringBuilder sb) {
        if (low < high) {
            // Partition the array
            int pi = partition(songs, low, high, isAscending, sb);

            // Recursively sort the left and right subarrays
            sort(songs, low, pi - 1, isAscending, sb);
            sort(songs, pi + 1, high, isAscending, sb);
        }
    }

    private int partition(Song[] songs, int low, int high, boolean isAscending, StringBuilder sb) {
        int pivotIndex = high;
        // Swap pivot with the last element
        swap(songs, pivotIndex, high);
        // Choose pivot value
        Song pivot = songs[high];

        int i = low - 1;
        for (int j = low; j < high; j++) {
            // Compare songs[j] with pivot
            if ((isAscending && songs[j].getTitle().compareToIgnoreCase(pivot.getTitle()) <= 0) ||
                    (!isAscending && songs[j].getTitle().compareToIgnoreCase(pivot.getTitle()) >= 0)) {
                i++;
                // Swap songs[i] and songs[j]
                swap(songs, i, j);
            }
        }

        // Swap songs[i+1] and songs[high] (pivot)
        swap(songs, i + 1, high);
        // Return partition index
        return i + 1;
    }

    private void swap(Song[] songs, int i, int j) {
        Song temp = songs[i];
        songs[i] = songs[j];
        songs[j] = temp;
    }
}

