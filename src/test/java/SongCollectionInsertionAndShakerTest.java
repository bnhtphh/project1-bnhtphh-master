import org.junit.Assert;
import org.junit.Test;
import sortingSongCollection.songs.SongCollection;
import sortingSongCollection.sortingAlgorithms.InsertionSort;
import sortingSongCollection.sortingAlgorithms.ShakerSort;

import java.nio.file.Paths;

public class SongCollectionInsertionAndShakerTest {

    @Test
    public void testIntermediateStepsOfInsertionSort() {
        // Tests intermediate steps of insertion sort on the whole array of songs
        SongCollection collection = TestUtil.createSongCollection();
        collection.setSortingAlgorithm(new InsertionSort());
        collection.sortSongs(0, 11, true, "studentInsertionResult");
        int numEqualLines = TestUtil.compareFiles(Paths.get("studentInsertionResult"),  Paths.get("expectedInsertionResult"));
        if (numEqualLines <= 0)
            Assert.fail();
    }

    @Test
    public void testIntermediateStepsOfInsertionSortSubArray() {
        // Tests intermediate steps of insertion sort on the subarray of songs from 3 to 7
        SongCollection collection = TestUtil.createSongCollection();
        collection.setSortingAlgorithm(new InsertionSort());
        collection.sortSongs(3, 7, true, "studentInsertionResult3_7");
        int numEqualLines = TestUtil.compareFiles(Paths.get("studentInsertionResult3_7"),  Paths.get("expectedInsertionResult3_7"));
        if (numEqualLines <= 0)
            Assert.fail();
    }

    @Test
    public void testIntermediateStepsOfShakerSort() {
        // Tests intermediate steps of shaker sort on the whole array of songs
        SongCollection collection = TestUtil.createSongCollection();
        collection.setSortingAlgorithm(new ShakerSort());
        collection.sortSongs(0, 11, true, "studentShakerResult");
        int numEqualLines = TestUtil.compareFiles(Paths.get("studentShakerResult"),  Paths.get("expectedShakerResult"));
        if (numEqualLines <= 0)
            Assert.fail();
    }

    @Test
    public void testIntermediateStepsOfShakerSortSubarray() {
        // Tests intermediate steps of shaker sort on the subarray of songs
        SongCollection collection = TestUtil.createSongCollection();
        collection.setSortingAlgorithm(new ShakerSort());
        collection.sortSongs(2, 8, true, "studentShakerResult2_8");
        int numEqualLines = TestUtil.compareFiles(Paths.get("studentShakerResult2_8"),  Paths.get("expectedShakerResult2_8"));
        if (numEqualLines <= 0)
            Assert.fail();
    }
}
