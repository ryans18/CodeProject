package Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node5.right = node3;
        node3.right = node7;
//        node3.left = node6;
//        node3.right = node7;
//        System.out.println(isBalance(node1));
        System.out.println(findMinParent(node1, node4, node7).value);
        System.out.println(1 << 2);
        System.out.println("######################序列化与反序列化######################################");
        String serialStr = serialByPre(node1);
        System.out.println(serialStr);
        System.out.println(reconByPreStr(serialStr));
        printAllZhehen(3);
    }

    /**
     * 找到两个节点的最小公共祖先
     * 把大树拆成小树，不断往上
     * 遇到n1,往上不断返回n1,。遇到n2，往上不断返回n2，否则返回null
     * A向自己的左树要答案（返回n1，或者n2），
     * @param head
     * @param n1
     * @param n2
     * @return
     */
    private static Node findMinParent(Node head, Node n1, Node n2) {
        if (head == null || head == n1 || head == n2 ) {
            return head;
        }
        Node left = findMinParent(head.left, n1, n2);
        Node right = findMinParent(head.right, n1, n2);
        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }

    /***********************************************************************************/
    /**
     * 判断二叉树是否为搜索树
     * head.left < head < head.right
     * 左边的最大小于 head，右边的最小大于head
     * @param node
     * @return
     */
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
    /***********************************************************************************/
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

    /***********************************************************************************/
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

    /***********************************************************************************/
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
    /***********************************************************************************/

    private static class NodeHasParent{
        int value;
        NodeHasParent left;
        NodeHasParent right;
        NodeHasParent parent;
    }

    // 找到后继节点，中序遍历中下一个节点
    private static NodeHasParent findNextNode(NodeHasParent node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            NodeHasParent parent = node.parent;
            while (parent != null && node != parent.left) {
                node = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    /***********************************************************************************/
    // 二叉树的序列化与反序列化
    private static String serialByPre(Node node) {
        StringBuffer sb = new StringBuffer();
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (node != null) {
                sb.append(node.value).append("_");
                stack.push(node.right);
                stack.push(node.left);
            } else {
                sb.append("#_");
            }
        }
        return sb.toString();
    }

    private static Node reconByPreStr(String str) {
        String[] arr = str.split("_");
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(arr));
        return reconByPre(queue);
    }

    private static Node reconByPre(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(value);
        head.left = reconByPre(queue); // 遇到#退出
        head.right = reconByPre(queue);
        return head;
    }

    /***********************************************************************************/

    private static void printAllZhehen(int max) {
        printAllZhehen(1, max, true);
    }
    /**
     * 微软原题，打印折痕的凹凸, 中序遍历二叉树，左树为凹，右树为凸
     * @param index  当前深度
     * @param max   最大深度
     * @param down  // true：凹， false： 凸
     */
    private static void printAllZhehen(int index, int max, boolean down) {
        if (index > max) {
            return;
        }
        printAllZhehen(index + 1, max, true);
        System.out.print(down ? "凹\t" : "凸\t" );
        printAllZhehen(index + 1, max, false);
    }
}
