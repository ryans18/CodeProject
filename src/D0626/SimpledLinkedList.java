package D0626;

/**
 * Author：Ryans
 * Date：Created in 2022/7/3 18:21
 * Introduction：打印两个有序链表的公共部分，两个指针依次移动，谁小谁先动
 */
public class SimpledLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        Node n6 = new Node(7);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        Node head2 = new Node(0);
        Node n21 = new Node(2);
        Node n22 = new Node(4);
        Node n23 = new Node(5);
        Node n24 = new Node(9);
        Node n25 = new Node(10);
        head2.next = n21;
        n21.next = n22;
        n22.next = n23;
        n23.next = n24;
        n24.next = n25;
        simpledList(head, head2);
    }

    private static void simpledList(Node node1, Node node2) {
        while (node1 != null && node2 != null) {
            if (node1.value == node2.value) {
                System.out.println(node1.value);
                node1 = node1.next;
                node2 = node2.next;
            } else if (node1.value > node2.value) {
                node2 = node2.next;
            } else {
                node1 = node1.next;
            }
        }
    }
}