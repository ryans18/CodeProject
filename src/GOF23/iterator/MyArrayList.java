package GOF23.iterator;

import java.util.Arrays;

/**
 * Author : Ryans
 * Date : 2023/6/8
 * Introduction :
 */
public class MyArrayList<E> implements MyList<E>{

    private Object[] array;
    private int size = 0;

    public MyArrayList() {
        array = new Object[5];
    }

    @Override
    public void add(E e) {
        if (size == array.length - 1) {
            array = Arrays.copyOf(array, size * 2);
        }
        array[size] = e;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public MyIterator<E> iterator() {
        return new MyArrayListIterator<>();
    }

    class MyArrayListIterator<E> implements MyIterator<E> {
        int cur;
        @Override
        public boolean hasNext() {
            if (cur == size) {
                return false;
            }
            return true;
        }

        @Override
        public E next() {
            return (E) array [cur++];
        }
    }

}
