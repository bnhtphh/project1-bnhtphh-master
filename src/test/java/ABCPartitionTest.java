import sortingABC.ABCPartition;
import org.junit.Assert;
import org.junit.Test;

public class ABCPartitionTest {
    @Test
    public void testSortAndFindWinner() {
        String[] votes1 = { "A", "B", "A", "C", "A", "A", "A", "B", "C", "A", "B"};
        ABCPartition listSorter = new ABCPartition();
        String res = listSorter.sortAndFindWinner(votes1);
        Assert.assertEquals("The winner for the array votes1  was supposed to be \"A\".", "A", res);

        String[] votes2 = { "C", "B", "B", "A", "B", "C", "C", "A", "B", "A", "B", "C", "A", "A", "B", "C", "A", "B"};
        String res2 = listSorter.sortAndFindWinner(votes2);
        Assert.assertEquals("The winner for the array votes2  was supposed to be \"B\".", "B", res2);
    }
}
