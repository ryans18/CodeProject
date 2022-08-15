package D0814;

/**
 * Author：Ryans
 * Date：Created in 2022/8/14 15:50
 * Introduction：二叉树节点结构
 */
public class Node<V> {

    V value;
    Node<V> left;
    Node<V> right;

    public Node(V value) {
        this.value = value;
    }
}
