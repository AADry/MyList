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
        CustomList<Integer> customList = new CustomList<>();
        customList.add(5);
        customList.add(65);
        customList.add(22);
        customList.add(33);
        int a = customList.get(1);
        customList.insert(123456,1);
        Assert.assertNotEquals((Integer) a, (Integer) customList.get(1));

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
        List<Integer> customList = getList();
        customList.add(15);
        customList.add(20);
        Assert.assertEquals(2, customList.size());
        customList.clear();
        Assert.assertEquals(0,customList.size());
    }
    @Test
    public void sortInts(){
        List<Integer> customList = getList();
        for (int i = 16; i > 0; i--) {
            customList.add(i);
        }
        //System.out.println(customList);

        customList.sort(Integer::compareTo);
        boolean sorted = true;
        for (int i = 2; i < customList.size(); i++) {
            int a = customList.get(i-1);
            int b = customList.get(i);
            if (b < a) {
                sorted = false;
                break;
            }
        }
        //System.out.println(customList);
        Assert.assertTrue(sorted);
    }

}
