package list;

import java.util.*;

public class CustomList<E> extends AbstractList<E> implements List<E> {
    /**
     * Буферный массив для хранения элементов списка
     */
    private Object[] elementData;
    /**
     * Количество элементов в списке
     */
    private int size;
    public CustomList(){
        elementData = new Object[10];
        size = 0;
    }

    /** Возвращает количество элементов в списке
     * @return количество элементов в списке
     */
    public int size() {
        return size;
    }

    /**
     * Возвращает из списка элемент с указанным индексом
     * @param index индекс возвращаемого элемента
     * @return элемент из списка с указанным индексом
     * @throws IndexOutOfBoundsException если индекс меньше нуля и больше длины списка
     */
    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) elementData[index];
    }

    /**
     * Добавляет в конец списка новый элемент
     * @param e Добавляемый элемент
     * @return {@code true} Добавление элементов не ограничено условиями
     */
    @Override
    public boolean add(E e) {
        size++;
        int s = elementData.length;
        if(s < size) grow();
        elementData[size] = e;
        return true;
    }

    /**
     * Вставляет в список элемент с указанным индексом, сдвигая элементы, идущие после, на один вправо
     * @param e Добавляемый элемент
     * @param index Индекс, под которым добавляется новый элемент
     */
    public void add(E e, int index){
        Objects.checkIndex(index,size);
        size++;
        int s = elementData.length;
        elementData = Arrays.copyOf(elementData,s+1);
        System.arraycopy(elementData, index,
                elementData, index + 1,
                s - index);
        elementData[index] = e;
    }

    /**
     * Удаляет элемент с указанным индексом
     * @param index индексы удаляемого элемента
     * @return Удалённый элемент
     */
    @Override
    public E remove(int index) {
        Objects.checkIndex(index, size);
        final Object[] es = elementData;

        @SuppressWarnings("unchecked") E oldValue = (E) es[index];
        fastRemove(es, index);

        return oldValue;
    }
    /**
     * Удаляет элемент с указанным индексом. Не проверяет границы массива, не возвращает удалённый элемент
     */
    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[newSize] = null;
        size = newSize;
    }

    /**
     * Очищает весь список
     */
    @Override
    public void clear() {
        final Object[] es = elementData;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }
    /**
     * Увеличивает буферный массив
     */
    public void grow(){
        elementData = Arrays.copyOf(elementData,elementData.length+5);
    }
    /**
     * Каст Object в дженерик вынесен сюда, чтобы избежать предупреждений(warning) по всему коду
     */
    @Override
    @SuppressWarnings("unchecked")
    public void sort(Comparator<? super E> c) {
        Arrays.sort((E[]) elementData, 0, size, c);
    }
}
