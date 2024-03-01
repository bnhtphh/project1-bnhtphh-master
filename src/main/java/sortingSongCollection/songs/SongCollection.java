package sortingSongCollection.songs;

import sortingSongCollection.sortingAlgorithms.SortingAlgorithm;
import java.io.FileWriter;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

/** A class that stores an array of songs and has methods to add songs, sort songs with the
 * given sorting algorithm, etc.
 * FILL IN CODE in sortSongs.
 */
public class SongCollection {
    private Song[] songs; // array of songs
    private int currNumSongs; // the current number of songs that have been added to the array

    private SortingAlgorithm sortingAlgorithm; // which sorting algorithm to use for sorting

    /**
     * Constructor
     * @param maxNumSongs - maximum number of songs this song collection can hold
     */
    public SongCollection(int maxNumSongs) {
        songs = new Song[maxNumSongs];
        this.currNumSongs = 0;
    }

    /**
     * Create a Song and add it to the song collection
     * @param title title of the song
     * @param artist artist of the song
     */
    public void addSong(String title, String artist) {
        Song song  = new Song(title, artist);
        songs[currNumSongs] = song;
        currNumSongs++;
    }

    /**
     * We use a strategy design pattern to pass a reference to the sorting algorithm
     * to the song collection.
     * @param sortingAlgorithm which sorting algorithm to use
     */
    public void setSortingAlgorithm(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    /**
     * Sort a subarray of songs from index low to high (inclusive) either in ascending order
     * (if isAscendingOrder is true) or in descending order (if isAscendingOrder is false).
     * Use the sorting algorithm that was earlier set by the setSortingAlgorithm function.
     * @param low start index
     * @param high end index (inclusive)
     * @param isAscending if true, sort in ascending order, otherwise in descending
     * @param filename write intermediate results of the sorting algorithm to the given file (see pdf for description)
     */
    public void sortSongs(int low, int high, boolean isAscending, String filename) {
        // sorts songs from low to high
        // sorts in ascending order if isAscending is true (otherwise in descending order)
        StringBuilder sb = new StringBuilder();
        // FILL IN CODE: Call the sort method of the SortingAlgorithm set for this collection
        // Write the string from StringBuilder sb to the file with the given filename
        // Call the sort method of the sorting algorithm
        sortingAlgorithm.sort(songs, low, high, isAscending, sb);

        // Write the intermediate results to the file
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(sb.toString());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
