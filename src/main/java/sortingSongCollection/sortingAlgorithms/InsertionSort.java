package sortingSongCollection.sortingAlgorithms;

import sortingSongCollection.songs.Song;

public class InsertionSort implements SortingAlgorithm {

    /**
     * Sorts a subarray of songs from index low to index high (inclusive).
     * using insertion sort. The rest of the array should not change.
     *
     * @param songs       array of songs
     * @param low         index of the first element of the subarray we need to sort
     * @param high        index of the last element of the subarray we need to sort
     * @param isAscending if true, sort in ascending order, otherwise in descending
     * @param sb StringBuilder. After the function executes, it should contain a string that shows the array of songs after each pass of insertion sort.
     * Show only the first letter of each song's title. Show each pass on a new line.
     * For instance, if low = 0, high = n - 1, and isAscending = true,
     * then for the following array of songs UCFWHABOVPRL (where the title of the first song starts with "U", the title of the second one starts with "C" and so on), we should get the following intermediate results showing each pass of the insertion sort:
    CUFWHABOVPRL
    CFUWHABOVPRL
    CFUWHABOVPRL
    CFHUWABOVPRL
    ACFHUWBOVPRL
    ABCFHUWOVPRL
    ABCFHOUWVPRL
    ABCFHOUVWPRL
    ABCFHOPUVWRL
    ABCFHOPRUVWL
    ABCFHLOPRUVW
     */
    @Override
    public void sort(Song[] songs, int low, int high, boolean isAscending, StringBuilder sb) {
       // FILL IN CODE
            for (int i = low + 1; i <= high; i++) {
                Song key = songs[i];
                int j = i - 1;
                while (j >= low && (
                        (isAscending && songs[j].getTitle().charAt(0) > key.getTitle().charAt(0)) ||
                                (!isAscending && songs[j].getTitle().charAt(0) < key.getTitle().charAt(0)))) {
                    songs[j + 1] = songs[j];
                    j--;
                }
                songs[j + 1] = key;
                // Append the current state of the array to the StringBuilder
                for (int k = low; k <= high; k++) {
                    sb.append(songs[k].getTitle().charAt(0));
                }
                sb.append("\n");
            }
        }
    }

