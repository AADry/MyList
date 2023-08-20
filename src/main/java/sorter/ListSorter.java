package sorter;

import java.util.Comparator;
import java.util.List;

public class ListSorter {
    private ListSorter(){

    }
    public static <T> void sort(List<T> list, Comparator<? super T> c) {
        list.sort(c);
    }
}
