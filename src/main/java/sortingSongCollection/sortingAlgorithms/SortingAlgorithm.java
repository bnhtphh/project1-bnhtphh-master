package sortingSongCollection.sortingAlgorithms;

import sortingSongCollection.songs.Song;

public interface SortingAlgorithm {
    void sort(Song[] songs, int low, int high, boolean isAscending, StringBuilder sb);
}
