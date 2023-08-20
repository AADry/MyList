import list.CustomList;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;


public class CustomListTest {

    @Test
    public void getElement(){
        List<Integer> customList = getList();
        customList = new Random().ints(100,0,10000).boxed().collect(toList());
        Assert.assertNotNull(customList.get(5));
    }
    @Test
    public void addElement(){
        List<Integer> customList = getList();
        customList.add(15);
        Assert.assertEquals(1,customList.size());
        customList.remove(0);
    }
    public List<Integer> getList() {
        return new CustomList<>();
    }

    @Test
    public void insertElement(){
        getList();
        List<Integer> customList;
        customList = new Random().ints(100, 0, 10000).boxed().collect(toList());
        int a = customList.get(49);
        customList.add(49,12345678);
        Assert.assertNotEquals((Integer) a, (Integer) customList.get(49));

    }

    @Test
    public void removeElement(){
        List<Integer> customList = getList();
        customList.add(15);
        customList.remove(0);
        Assert.assertEquals(0,customList.size());
    }
    @Test
    public void clearList(){
        getList();
        List<Integer> customList;
        customList = new Random().ints(100, 0, 10000).boxed().collect(toList());
        Assert.assertEquals(100, customList.size());
        customList.clear();
        Assert.assertEquals(0,customList.size());
    }
    @Test
    public void sortInts(){
        getList();
        List<Integer> customList;
        customList = new Random().ints(100,0,10000).boxed().collect(toList());
        customList.sort(Integer::compareTo);
        boolean sorted = true;
        for (int i = 1; i < customList.size(); i++) {
            int a = customList.get(i-1);
            int b = customList.get(i);
            if (b < a) {
                sorted = false;
                break;
            }
        }
        Assert.assertTrue(sorted);
    }

}
