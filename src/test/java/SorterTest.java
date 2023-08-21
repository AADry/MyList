import list.CustomList;
import org.junit.Assert;
import org.junit.Test;
import sorter.ListSorter;

import java.util.ArrayList;
import java.util.List;

public class SorterTest {
    @Test
    public void sortCustomListTest() {
        List<Integer> list = new CustomList<>();
        for (int i = 16; i > 0; i--) {
            list.add(i);
        }
        ListSorter.quickSort(list);
        Assert.assertTrue(isSorted(list));
    }

    @Test
    public void sortWithComparator() {
        List<Integer> list = new CustomList<>();
        for (int i = 16; i > 0; i--) {
            list.add(i);
        }
        ListSorter.quickSort(list, 0, list.size() - 1, Integer::compareTo);
        Assert.assertTrue(isSorted(list));
    }

    @Test
    public void sortArrayListTest() {
        List<Integer> list = new ArrayList<>();
        for (int i = 16; i > 0; i--) {
            list.add(i);
        }
        ListSorter.quickSort(list);
        Assert.assertTrue(isSorted(list));
    }

    private boolean isSorted(List<Integer> list) {
        boolean sorted = true;
        for (int i = 1; i < list.size(); i++) {
            int a = list.get(i - 1);
            int b = list.get(i);
            if (b < a) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }
}
