package D0626;

import java.util.Stack;

/**
 * Author：Ryans
 * Date：Created in 2022/6/26 15:04
 * Introduction： 判断一个链表是否为回文结构： 1， 2， 3， 2， 1
 */
public class HuiWenLink {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(3);
        Node n6 = new Node(2);
        Node n7 = new Node(1);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        System.out.println(isHuiLu3(head));
    }

    /**
     * 笔试可用此，用stack放入链表，不考虑空间复杂度。但准确度高
     * @param head
     * @return
     */
    public static boolean isHuiLu(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * n / 2，快慢指针找中点
     * @param head
     * @return
     */
    public static boolean isHuiLu2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node quick = head;
        Node slow = head;
        while (quick.next != null && quick.next.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        Stack<Node> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }

        while (!stack.empty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 只用有限几个常数实现，空间复杂度最小
     * @param head
     * @return
     */
    public static boolean isHuiLu3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head; // slow
        Node n2 = head;  // quick
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;   // n1 来到中点
            n2 = n2.next.next;  // n2 来到尾部
        }
        // 后半部分逆序  1, 2, 3, 4, 3, 2, 1
        n2.next = n1.next;
        n1.next = null;  // mid.next 置为null
        Node n3 = null;
        while (n2 != null) {
            n3 = n2.next;  // n3 保存下一个node
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;
        n2 = head;
        System.out.println(n2);



        return true;
    }
}

 class Node {
    public Node next;
    public int value;

    public Node(int data) {
        this.value = data;
    }
}