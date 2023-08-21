package sorter;

import java.util.*;

/**
 * Вспомогательный класс для сортровки интерфейса List
 * Доступна ортировка списков, элементы которых реализуют Comparable. Для сортировки других классов, необходимо передать компаратор.
 */
public class ListSorter {
    /**
     * Переопределение публичного конструктора. Убирает возможность создавать экземпляр класса для пользователей
     */
    private ListSorter() {

    }

    /**
     * Сортировка всего списка
     * Работает только со списками, содержащими классы, реализующие Comparable интерфейс
     *
     * @param list - список
     * @param <T>  - тип элементов списка
     */
    public static <T extends Comparable<T>> void quickSort(List<T> list) {
        quickSort(list, 0, list.size() - 1);
    }

    /**
     * Сортировка списка в указанных границах
     * Работает только со списками, содержащими классы, реализующие Comparable интерфейс
     * Быстрая сортировка, сортировка Хоара (англ. quicksort), часто называемая qsort (по имени в стандартной библиотеке языка Си) — алгоритм сортировки, разработанный английским информатиком Тони Хоаром во время своей работы в МГУ в 1960 году.
     * <a href="https://clck.ru/FpDFQ"><Быстрая сортировка - Википедия></a>
     * Один из самых быстрых известных универсальных алгоритмов сортировки массивов: в среднем O(n log n) обменов при упорядочении
     * n элементов; из-за наличия ряда недостатков на практике обычно используется с некоторыми доработками.
     * Алгоритм состоит из трёх шагов:
     * 1) Выбрать элемент из массива. Назовём его опорным.
     * 2) Разбиение: перераспределение элементов в массиве таким образом, что элементы, меньшие опорного, помещаются перед ним, а большие или равные - после.
     * 3) Рекурсивно применить первые два шага к двум подмассивам слева и справа от опорного элемента. Рекурсия не применяется к массиву, в котором только один элемент или отсутствуют элементы.
     * <p>
     * Реализация алгоритма взята из статьи <a href="https://www.baeldung.com/java-quicksort">Quicksort Algorithm Implementation in Java</a>
     *
     * @param list  - список
     * @param <T>   - тип элементов списка
     * @param begin - индекс начала сортировки
     * @param end   - индекс конца сортировки
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @throws IllegalArgumentException  {@inheritDoc}
     */
    public static <T extends Comparable<T>> void quickSort(List<T> list, int begin, int end) {
        if (begin < end) {
            //Выбор опорного элемента
            int partitionIndex = partition(list, begin, end);
            //Рекурсивное применение алгоритма к левому и правому подмассивам
            quickSort(list, begin, partitionIndex - 1);
            quickSort(list, partitionIndex + 1, end);
        }
    }

    /**
     * Сортировка списков, содержащих не Comparable классы
     * Тот же алгоритм, но вместо сравнения элементов напрямую используется компаратор.
     *
     * @param list  - список
     * @param begin - индекс начала
     * @param end   - индекс конца
     * @param c     - компаратор для сравнения элементов между собой
     * @param <T>   - тип элементов списка
     */
    public static <T> void quickSort(List<T> list, int begin, int end, Comparator<T> c) {
        if (begin < end) {
            int partitionIndex = partition(list, begin, end, c);

            quickSort(list, begin, partitionIndex - 1, c);
            quickSort(list, partitionIndex + 1, end, c);
        }
    }

    /**
     * Вспомогательный метод для реализации алгоритма быстрой сортировки с использованием компаратора
     *
     * @param arr   - список
     * @param begin - индекс начала
     * @param end   - индекс конца
     * @param c     - компаратор
     * @param <T>   - тип массива
     * @return индекс опорного элемента
     */
    private static <T> int partition(List<T> arr, int begin, int end, Comparator<T> c) {
        T pivot = arr.get(end);
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (c.compare(arr.get(j), pivot) <= 0) {
                i++;

                T swapTemp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, swapTemp);
            }
        }

        T swapTemp = arr.get(i + 1);
        arr.set(i + 1, arr.get(end));
        arr.set(end, swapTemp);

        return i + 1;
    }

    /**
     * Вспомогательный метод для реализации алгоритма быстрой сортировки. Сравнивает только Comparable классы
     *
     * @param arr   - список
     * @param begin - индекс начала
     * @param end   - индекс конца
     * @param <T>   - тип массива
     * @return индекс опорного элемента
     */
    private static <T extends Comparable<T>> int partition(List<T> arr, int begin, int end) {
        T pivot = arr.get(end);
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr.get(j).compareTo(pivot) <= 0) {
                i++;

                T swapTemp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, swapTemp);
            }
        }

        T swapTemp = arr.get(i + 1);
        arr.set(i + 1, arr.get(end));
        arr.set(end, swapTemp);

        return i + 1;
    }

}
