package GOF23.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Ryans
 * Date : 2023/6/8
 * Introduction : 迭代器模式
 */
public class Client {

    public static void main(String[] args) {
        MyList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(0);
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(9);
        System.out.println(list.size());
        MyIterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
