package D0626;

/**
 * Author：Ryans
 * Date：Created in 2022/7/3 17:52
 * Introduction：单链表反转，返回head
 */
public class ReverseLinkList {

    public static class Node {
        int value;
        Node next;
        public Node(int data) {
            this.value = data;
        }
    }

    private static class DoubleNode {
        int value;
        DoubleNode next;
        DoubleNode last;
        public DoubleNode(int data) {
            value = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        Node node = reverseLinkedList(head);
        System.out.println(node);

        DoubleNode dhead = new DoubleNode(1);
        DoubleNode dn2 = new DoubleNode(2);
        DoubleNode dn3 = new DoubleNode(3);
        DoubleNode dn4 = new DoubleNode(4);
        DoubleNode dn5 = new DoubleNode(5);
        DoubleNode dn6 = new DoubleNode(6);
        DoubleNode dn7 = new DoubleNode(7);
        dhead.next = dn2;
        dn2.next = dn3;
        dn3.next = dn4;
        dn4.next = dn5;
        dn5.next = dn6;
        dn6.next = dn7;
        DoubleNode dnode = reverseDoubleLinkedList(dhead);
        System.out.println(dnode);
    }

    private static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre; // 之前的pre
            pre = head;
            head = next;
        }
        return pre;
    }

    private static Node reverseLinkedList2(Node head) {
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private static Node reverseLinkedList3(Node head) {
       return reverse(head, null);
    }

    private static Node reverse(Node head, Node pre) {
        if (head == null) {
            return pre;
        }
        Node next = head.next;
        head.next = pre;
        return reverse(next, head);
    }

    private static DoubleNode reverseDoubleLinkedList(DoubleNode head) {
        DoubleNode next = null;
        DoubleNode cur = null;
        while (head != null) {
            next = head.next;
            head.next = cur;   // 上一个
            head.last = next;
            cur = head;
            head = next;
        }
        return  cur;
    }

}