package GOF23.iterator;

/**
 * Author : Ryans
 * Date : 2023/6/8
 * Introduction :
 */
public class MyLinkedList<E> implements MyList<E>{

    class Node<E> {
        Object value;
        Node<E> next;
    }

    Node<E> head;
    private Node<E> tail;
    private int size = 0;

    @Override
    public void add(E e) {
        if (head == null) {
            head = new Node<>();
            head.value = e;
            tail = head;
        } else {
            Node<E> node = new Node<E>();
            node.value = e;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public MyIterator<E> iterator() {
        return new MyLinkedListIterator<>();
    }

    private class MyLinkedListIterator<E> implements MyIterator<E> {
        Node cur;

        MyLinkedListIterator() {
            cur = head;
        }
        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public E next() {
            Node<E> node = cur;
            cur = cur.next;
            return (E)node.value;
        }
    }
}
