package Tree;

import com.sun.org.apache.regexp.internal.RE;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author : Ryans
 * Date : 2022/8/17
 * Introduction :
 */
public class TreeTest2 {

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
        System.out.println("递归序:");
        diguiOrder(node1);
        System.out.print("\n先序：");
        preOrder(node1);
        System.out.print("\n中序：");
        inOrder(node1);
        System.out.print("\n后序：");
        postOrder(node1);
        System.out.println("最小公共祖先");
        System.out.println("判断二叉树是否我搜索二叉树");
        isSearch(node1);
        System.out.println("判断二叉树是否为满二叉树");
        isFull(node1);
        System.out.println("判断二叉树是否为平衡二叉树");
        isBalance(node1);
        System.out.println("寻找后继节点-改造二叉树(parent)");
        System.out.println("二叉树的序列化与反序列化");
        System.out.println("折痕凹凸问题");
        printAllZhehen();
    }

    private static void diguiOrder(Node node) {
        if (node == null) {
            return;
        }
        diguiOrder(node.left);
        diguiOrder(node.right);
        System.out.print(node.value + "\t");
    }

    private static void preOrder(Node node) {
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

    private static void inOrder(Node node) {
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

    private static void postOrder(Node node) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(node);
        while (!stack1.isEmpty()) {
            node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + "\t");
        }
    }


    private static Node findMinGrandFather(Node head, Node node1, Node node2) {
        // 找到node1或者node2返回
        if (head == null || head == node1 || head == node2) {
            return head;
        }
        Node left = findMinGrandFather(head.left, node1, node2);
        Node right = findMinGrandFather(head.right, node1, node2);
        if(left != null && right != null) {
            return head;
        }
        // 左数找到返回左数的公共点
        return left != null ? left : right;
    }

    private static boolean isSearch(Node head) {
        boolean isSearch = isS(head).isSearch;
        return isSearch;
    }

    private static ResultSearch isS(Node head) {
        if (head == null) {
            return null;
        }
        ResultSearch leftResult= isS(head.left);
        ResultSearch rightResult = isS(head.right);
        boolean isSearch = true;
        int min = (int) head.value;
        int max = (int) head.value;
        if (leftResult != null) {
            min = Math.min(min, leftResult.min);
        }
        if (rightResult != null) {
            max = Math.max(max, rightResult.max);
        }
        if (leftResult != null && (!leftResult.isSearch || leftResult.max >= (int) head.value)) {
            isSearch = false;
        }
        if (rightResult != null && (!rightResult.isSearch || rightResult.min <= (int) head.value)) {
            isSearch = false;
        }
        return new ResultSearch(isSearch, min, max);
    }

    private static class ResultSearch{
        boolean isSearch;
        int min;
        int max;

        public ResultSearch(boolean isSearch, int min, int max) {
            this.isSearch = isSearch;
            this.min = min;
            this.max = max;
        }
    }
    /********************************************************************/
    private static void isFull(Node head) {
        ResultFull resultFull = isF(head);
        boolean result = resultFull.num == (1<< resultFull.deep) - 1;
        System.out.println(result);
    }

    private static ResultFull isF(Node head) {
        if (head == null) {
            return new ResultFull(true, 1, 1);
        }
        ResultFull leftResult = isF(head.left);
        ResultFull rightResult = isF(head.right);
        boolean isFull = true;
        if (!leftResult.isFull || !rightResult.isFull) {
            isFull = false;
        }
        // num = (2 ^ 1) - 1
        int num = leftResult.num + rightResult.num + 1;
        int deep = Math.max(leftResult.deep, rightResult.deep) + 1;
        return new ResultFull(isFull, deep, num);
    }

    private static class ResultFull {
        boolean isFull;
        int deep;
        int num;

        public ResultFull(boolean isFull, int deep, int num) {
            this.isFull = isFull;
            this.deep = deep;
            this.num = num;
        }
    }

    private static void isBalance(Node head) {
        boolean result = isB(head).isBalance;
        System.out.println(result);
    }

    private static ResultBalance isB(Node head) {
        if (head == null) {
            return new ResultBalance(true, 1);
        }
        ResultBalance leftResult = isB(head.left);
        ResultBalance rightResult = isB(head.right);
        boolean isBalance = true;
        if (!leftResult.isBalance || !rightResult.isBalance) {
            isBalance = false;
        }
        if (Math.abs(leftResult.height) - rightResult.height > 1) {
            isBalance = false;
        }
        int height = Math.max(leftResult.height, rightResult.height) + 1;
        return new ResultBalance(isBalance, height);
    }

    private static class ResultBalance{
        boolean isBalance;
        int height;

        public ResultBalance(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    private static HasParentNode getNextNodeInOrder(HasParentNode node) {
        if (node == null) {
            return null;
        }
        if (node.right!= null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            HasParentNode parentNode = node.parent;
            while (node != parentNode.left) {
                node = node.parent;
                parentNode = node.parent;
            }
            return parentNode;
        }

    }

    private static class HasParentNode{
        int value;
        HasParentNode left;
        HasParentNode right;
        HasParentNode parent;
    }

    private static void printAllZhehen() {
        printAllZhehen(1, 7, true);
    }

    private static void printAllZhehen(int curHeight, int maxHeight, boolean down) {
        if (curHeight <= maxHeight) {
            printAllZhehen(curHeight + 1, maxHeight, true);
            System.out.print(down ? "凹\t" : "凸\t");
            printAllZhehen(curHeight + 1, maxHeight, false);
        }
    }





}
