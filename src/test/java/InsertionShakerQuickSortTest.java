import org.junit.Assert;
import org.junit.Test;
import sortingSongCollection.songs.SongCollection;
import sortingSongCollection.sortingAlgorithms.InsertionSort;
import sortingSongCollection.sortingAlgorithms.RandomizedQuickSort;
import sortingSongCollection.sortingAlgorithms.ShakerSort;
import sortingSongCollection.sortingAlgorithms.SortingAlgorithm;


/** Test file for Insertion Sort, Shaker Sort, and Randomized Quick Sort
 * Provides only the most basic testing - simply tests if the resulting songs are in order, does not check intermediate steps. Passing these tests does not guarantee
 * your implementation is correct.
 * You are responsible for thoroughly testing your code on your own. */
public class InsertionShakerQuickSortTest {
   private SongCollection collection;


    @Test
    public void testInsertionSortBasic() {
        SortingAlgorithm listSorter = new InsertionSort();
        boolean isSorted = TestUtil.testComparisonSortMethod(listSorter);
        if (!isSorted)
            Assert.fail();
    }


    @Test
    public void testShakerSortBasic() {
        SortingAlgorithm listSorter = new ShakerSort();
        boolean isSorted = TestUtil.testComparisonSortMethod(listSorter);
        if (!isSorted)
            Assert.fail();
    }

    @Test
    public void testRandomizedQuickSortBasic() {
        SortingAlgorithm listSorter = new RandomizedQuickSort();
        boolean isSorted = TestUtil.testComparisonSortMethod(listSorter);
        if (!isSorted)
            Assert.fail();
    }


}