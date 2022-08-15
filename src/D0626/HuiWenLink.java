package D0626;

import java.util.Stack;

/**
 * Author：Ryans
 * Date：Created in 2022/6/26 15:04
 * Introduction： 判断一个单链表是否为回文结构： 1， 2， 3， 2， 1
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
        System.out.println("is回路：" + isHuiLu3(head));
        printNode(head, "head");
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
     * n / 2，快慢指针找中点. 快指针一次走两格，慢指针一次走一格
     * 只比较前后，空间上消耗小
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
     * 只用有限几个常数实现，空间复杂度最小，比较考验codding能力，面试时力荐
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
        printNode(n1, "n1");
        printNode(n2, "n2");
        // 后半部分逆序  1, 2, 3, 4, 3, 2, 1
        n2.next = n1.next;
        n1.next = null;  // mid.next 置为null
//        printNode(n1, "n1");
//        printNode(n2, "n2");

        Node n3 = null;
        while (n2 != null) { // 右半部分逆序
            System.out.println("--------------------------------------------------------");
            n3 = n2.next;  // n3 保存下一个node
//            printNode(n3, "n3");
            n2.next = n1;  // 右边 -next 逆序
            n1 = n2;
            n2 = n3;
            printNode(n1, "n1");
            printNode(n2, "n2");
            printNode(n3, "n3");
        }
//        System.out.println("************************************************************");
//        printNode(n1, "n1");
//        printNode(n2, "n2");
//        printNode(n3, "n3");
        n3 = n1;  // 保存最右边node
        n2 = head;  // 保存最左边node
        boolean result = true;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                result = false;
                break;
            }
            n1 = n1.next;   // left -> mid
            n2 = n2.next;  // right -> mid
        }
        // 开始复原node
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return result;
    }

    private static void printNode(Node node, String name) {
        System.out.print(name + ":");
        int index = 0;
        while (node != null && index < 20) {
            System.out.print(node.value + "\t");
            node = node.next;
            index++;
        }
        System.out.println();
    }
}

 class Node {
    public Node next;
    public int value;

    public Node(int data) {
        this.value = data;
    }
}