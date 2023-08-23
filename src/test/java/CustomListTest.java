import list.CustomList;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import static java.util.stream.Collectors.toList;


public class CustomListTest {

    @Test
    public void getElement() {
        List<Integer> customList;
        customList = new Random().ints(100, 0, 10000).boxed().collect(toList());
        Assert.assertNotNull(customList.get(5));
    }

    @Test
    public void setElement() {
        List<Integer> customList = getList();
        customList.add(15);
        customList.set(0, 22);
        Assert.assertEquals(22, (int) customList.get(0));
    }

    @Test
    public void addElement() {
        List<Integer> customList = getList();
        customList.add(15);
        Assert.assertEquals(1, customList.size());
        customList.remove(0);
    }

    public List<Integer> getList() {
        return new CustomList<>();
    }

    @Test
    public void insertElement() {
        CustomList<Object> objects = new CustomList<>();
        for (int i = 0; i < 10000; i++) {
            objects.add( 0, new Object());
        }
        for (int i = 0; i < 10000; i++) {
            Assert.assertNotNull(objects.get(i));
        }
    }

    @Test
    public void removeElement() {
        List<Integer> customList = getList();
        customList.add(15);
        customList.remove(0);
        Assert.assertEquals(0, customList.size());
    }

    @Test
    @SuppressWarnings("SameParameterValue")
    public void clearList() {
        List<Integer> customList = getList();
        customList.add(15);
        customList.add(20);
        Assert.assertEquals(2, customList.size());
        customList.clear();
        Assert.assertEquals(0, customList.size());
    }

    @Test
    public void sortInts() {
        List<Integer> customList = getList();
        for (int i = 16; i > 0; i--) {
            customList.add(i);
        }

        customList.sort(Integer::compareTo);
        boolean sorted = true;
        for (int i = 1; i < customList.size(); i++) {
            int a = customList.get(i - 1);
            int b = customList.get(i);
            if (b < a) {
                sorted = false;
                break;
            }
        }
        Assert.assertTrue(sorted);
    }

}
