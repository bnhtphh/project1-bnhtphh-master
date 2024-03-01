import org.jetbrains.annotations.NotNull;
import sortingSongCollection.songs.Song;
import sortingSongCollection.songs.SongCollection;
import sortingSongCollection.sortingAlgorithms.SortingAlgorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;

/** Helper class that contains methods that are used for various tests. */
public class TestUtil {
    public final static int SIZE = 32; // number of elements in the list
    public final static int NUM_ITERS = 10; // how many times to test it

    /**
     * Create a new song collection
     * @return song collection
     */
    public static @NotNull SongCollection createSongCollection() {
        SongCollection collection = new SongCollection(12);
        collection.addSong("Unstoppable", "Sia");
        collection.addSong("Calm Down", "Rema");
        collection.addSong("Flowers", "Miley Cyrus");
        collection.addSong("What was I made for?","Billie Eilish");
        collection.addSong("Hero", "Enrique Iglesias");
        collection.addSong("Anti Hero", "Taylor Swift");
        collection.addSong("Blank Space", "Taylor Swift");
        collection.addSong("Only Girl", "Rihanna");
        collection.addSong("Vampire", "Olivia Rodrigo");
        collection.addSong("Piyala", "AIGEL");
        collection.addSong("Roar", "Katy Perry");
        collection.addSong("Last Friday Night", "Katy Perry");
        return collection;
    }


    /**
     * Checks if the subarray (from startIndex to endIndex)
     * of songs is sorted (if isAscending is true, checks if sorted in ascending order,
     * otherwise checks if sorted in descending order).
     * @param songs array of records (of type Song)
     * @param startIndex the starting index of a subarray
     * @param endIndex the end index of a subarray
     * @return true if sorted
     */
    private static boolean isSongArraySorted(Song[] songs, int startIndex, int endIndex, boolean isAscending) {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println(songs[i] + " " + songs[i+1] + " " + songs[i].compareTo(songs[i + 1]));
            if (isAscending && songs[i].compareTo(songs[i + 1]) > 0) {
                return false;
            }
            if (!isAscending && songs[i].compareTo(songs[i + 1]) < 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Generates random arrays of songs, calls the given sorting algorithm, and
     * checks if the resulting list is sorted
     * @param listSorter reference to SortingAlgorithms
     * @return whether the test was successful
     */
    public static boolean testComparisonSortMethod(SortingAlgorithm listSorter) {
        Song[] arr1 = new Song[SIZE];
        Song[] arr2 = new Song[SIZE];
        Song[] arr1Copy = new Song[SIZE];
        Song[] arr2Copy = new Song[SIZE];
        Random r = new Random();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < NUM_ITERS; i++) {
            for (int j = 0; j < SIZE; j++) {
                String titleLetter1 = generateRandomOneLetterString();
                String titleLetter2 = generateRandomOneLetterString();

                //System.out.println(titleLetter1 + " " + titleLetter2);
                arr1[j] = new Song(titleLetter1, titleLetter1);
                arr1Copy[j] = arr1[j];
                arr2[j] = new Song(titleLetter2, titleLetter2);
                arr2Copy[j] = arr2[j];
            }

            //System.out.println(Arrays.toString(arr1));
            //System.out.println(Arrays.toString(arr2));

            // Randomly generate low and high
            // Not trying to explore the full range of lowindex/highindex, just
            // some range
            int lowindex = r.nextInt(arr2.length / 2);
            int highindex = arr2.length / 2 + r.nextInt(arr2.length / 2);
            listSorter.sort(arr1, lowindex, highindex, true, sb1);
            listSorter.sort(arr2, lowindex, highindex, false, sb2);
            System.out.println(Arrays.toString(arr1));
            System.out.println(isSongArraySorted(arr1, lowindex, highindex, true));
            if (!isSongArraySorted(arr1, lowindex, highindex, true)) {
                System.out.println("------- Not sorted correctly---------");
                System.out.println("Before sort: arr1 = " + Arrays.toString(arr1Copy));
                System.out.println("After sort, for range: low =  " + lowindex + ", high = " + highindex
                        + ", arr1 =" + Arrays.toString(arr1));

                return false;
            }

            if (!isSongArraySorted(arr2, lowindex, highindex, false)) {
                System.out.println("------- Not sorted correctly---------");
                System.out.println("Before sort: arr2 = " + Arrays.toString(arr2Copy));
                System.out.println("After sort, for range: low = " + +lowindex + " high = "
                        + highindex + ", arr2 = " + Arrays.toString(arr2));

                return false;
            }

            // Check elements of the array  < startIndex and > endIndex - they should not have changed
            for (int l1 =  0; l1 < arr1.length; l1++ ){
                if ((l1 < lowindex && l1 > highindex) && (arr1[l1] != arr1Copy[l1]))
                    return false;
                if ((l1 < lowindex && l1 > highindex) && (arr2[l1] != arr2Copy[l1]))
                    return false;

            }

        }

        return true;
    }


    private static String generateRandomOneLetterString() {
        Random r = new Random();
        char titleFirstLetterCh1 = (char) (r.nextInt(26) + 'A');
        String titleAsFirstLetter1 = String.valueOf(titleFirstLetterCh1);
        return titleAsFirstLetter1;
    }

    /** Compares files line by line. Returns a positive value if files are the same. */
    public static int compareFiles(Path filepath1, Path filepath2) {
        Charset charset = java.nio.charset.StandardCharsets.UTF_8;
        int count = 0;
        try (BufferedReader br1 = Files.newBufferedReader(filepath1, charset);
             BufferedReader br2 = Files.newBufferedReader(filepath2, charset)) {
            String line1, line2;
            line1 = br1.readLine();
            line2 = br2.readLine();

            while (true) {
                        count++;
                        // compare lines
                        if ((line1 != null) && (line2 != null)) {
                            // use consistent path separators
                            line1 = line1.replaceAll(Matcher.quoteReplacement(File.separator), "/");
                            line2 = line2.replaceAll(Matcher.quoteReplacement(File.separator), "/");

                            // remove trailing spaces
                            line1 = line1.trim();
                            line2 = line2.trim();

                            // check if lines are equal
                            if (!line1.equals(line2)) {
                                return -count;
                            }

                            line1 = br1.readLine();
                            line2 = br2.readLine();
                        } else {
                            // discard extra blank lines at end of file 1
                            while ((line1 != null) && line1.trim().isEmpty()) {
                                line1 = br1.readLine();
                            }

                            // discard extra blank lines at end of file 2
                            while ((line2 != null) && line2.trim().isEmpty()) {
                                line2 = br2.readLine();
                            }

                            if (line1 == line2) {
                                // only true if both are null, otherwise one file had
                                // extra non-empty lines
                                return count;
                            } else {
                                // extra blank lines found in one file
                                return -count;
                            }
                        }
            }
        } catch (IOException e) {
            System.out.println(e);
            return -1; // could not compare the files
        }
    }
}
