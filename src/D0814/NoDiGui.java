package D0814;

import java.util.Stack;

/**
 * Author：Ryans
 * Date：Created in 2022/8/14 16:46
 * Introduction：
 */
public class NoDiGui {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.print("先序:\t");
        pre(node1);
        System.out.print("\n中序:\t");
        in(node1);
        System.out.print("\n后序:\t");
        post(node1);
    }

    /**
     * 非递归，先序,  头左右
     * 1. 从栈中弹出一个节点
     * 2. 打印节点
     * 3. 先右后左，依次加入栈
     * 4. 循环
     * @param node
     */
    private static void pre(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.value + "\t");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 非递归，后序，左头右
     * 先依次把左边界放入栈中，
     * 到头后弹出一个节点。打印，并指向右节点后继续压栈进左边界循环
     * @param node
     */
    private static void in(Node node) {
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.value + "\t");
                node = node.right;
            }
        }
    }

    /**
     * 非递归，后序，左右头
     * 利用两个栈，栈1
     * stack弹出，记为cur，放到栈2中
     * 从左到右，放入栈1
     * @param node
     */
    private static void post(Node node) {
        Stack<Node> stack = new Stack();
        Stack<Node> stack2 = new Stack();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            stack2.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            node = stack2.pop();
            System.out.print(node.value + "\t");
        }
    }
}