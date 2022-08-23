package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author : Ryans
 * Date : 2022/8/22
 * Introduction : 关于二叉树的一些问题通用解法, 树形BP，左右分开
 */
public class TreeQuestion {

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
        node4.left = node6;
//        node3.left = node6;
//        node3.right = node7;
        System.out.println(isBalance(node1));
        System.out.println(1 << 2);
    }

    private static boolean isSearchTree(Node node) {
        if (node == null) {
            return false;
        }
        return isS(node).isSearchTree;
    }

    private static ResultSearch isS(Node node) {
        if (node == null) {
            return null;
        }
        ResultSearch leftResult = isS(node.left);
        ResultSearch rightResult = isS(node.right);
        boolean isSearchTree = true;
        int min = 0;
        int max = 0;
        if (leftResult != null) {
            min = Math.min(min, leftResult.min);
        }
        if (rightResult != null) {
            max = Math.max(max, rightResult.max);
        }
        if (leftResult != null && (!leftResult.isSearchTree || leftResult.max >= (int)node.value)) {
            isSearchTree = false;
        }
        if (rightResult != null && (!rightResult.isSearchTree || rightResult.min <= (int)node.value)) {
            isSearchTree = false;
        }
        return new ResultSearch(isSearchTree, min, max);
    }

    private static class ResultSearch{
        boolean isSearchTree;
        int min;
        int max;

        public ResultSearch(boolean isSearchTree, int min, int max) {
            this.isSearchTree = isSearchTree;
            this.min = min;
            this.max = max;
        }
    }

    // 判断二叉树是否是完全二叉树
    private static ResultWanquan isWanquan(Node node) {
        if (node == null) {
            return new ResultWanquan(true, true, 0);
        }
        ResultWanquan leftResult = isWanquan(node.left);
        ResultWanquan rightResult = isWanquan(node.right);
        boolean isWanquan = true;
        boolean isLeaf = true;
        if (!leftResult.isWanquan || !rightResult.isWanquan) {
            isWanquan = false;
        }
        if (!leftResult.isLeaf || !rightResult.isLeaf) {
            isLeaf = false;
        }
        if (node.left == null && node.right != null) {
            isWanquan = false;
        }
        if (leftResult.isLeaf && !rightResult.isLeaf) {
            isWanquan = false;
        }
        return new ResultWanquan(isWanquan, isLeaf, 0);
    }

    private static boolean isWanquan2(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        boolean isLeafBreak = false;
        while (!queue.isEmpty()) {
            node = queue.poll();
            Node left = node.left;
            Node right = node.right;
            if (left == null && right != null) {
                return false;
            }
            if (isLeafBreak && left != null) {
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            if (left == null || right == null) { // 当前节点是叶节点
                isLeafBreak = true;
            }
        }

        return true;
    }

    private static class ResultWanquan {
        boolean isWanquan;
        boolean isLeaf;
        int height;

        public ResultWanquan(boolean isWanquan, boolean isLeaf, int height) {
            this.isWanquan = isWanquan;
            this.isLeaf = isLeaf;
            this.height = height;
        }
    }

    // 是否为满二叉树
    private static boolean isFull(Node node) {
        return (1 << isF(node).height) - 1 == isF(node).count;
    }

    private static ResultFull isF(Node node) {
        if (node == null) {
            return new ResultFull(1, 1);
        }
        ResultFull leftResult = isF(node.left);
        ResultFull rightResult = isF(node.right);
        int height = Math.max(leftResult.height, rightResult.height) + 1;
        int count = leftResult.count + rightResult.count + 1;
        return new ResultFull(height, count);
    }

    private static class ResultFull {
        int height;
        int count;

        public ResultFull(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }

    private static boolean isBalance(Node node) {
        if (node == null) {
            return false;
        }
        return isB(node).isBalance;
    }

    private static ResultBalance isB(Node node) {
        if (node == null) {
            return new ResultBalance(true, 0);
        }
        ResultBalance leftResult = isB(node.left);
        ResultBalance rightResult = isB(node.right);
        boolean isBalance = true;
        int height = Math.max(leftResult.height, rightResult.height) + 1;
        if (!leftResult.isBalance || !rightResult.isBalance) {
            isBalance = false;
        }
        if (Math.abs(leftResult.height - rightResult.height) > 1) {
            isBalance = false;
        }
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
}
