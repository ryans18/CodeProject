package Tree;

/**
 * Author : Ryans
 * Date : 2022/8/15
 * Introduction :
 */
public class Node<V> {
    V value;
    Node<V> left;
    Node<V> right;

    public Node(V value) {
        this.value = value;
    }
}
