package GOF23.iterator;

/**
 * Author : Ryans
 * Date : 2023/6/8
 * Introduction :
 */
public interface MyList<E> {

    void add(E e);

    int size();

    MyIterator<E> iterator();

}
