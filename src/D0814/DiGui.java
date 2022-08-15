package D0814;

/**
 * Author：Ryans
 * Date：Created in 2022/8/14 16:06
 * Introduction：二叉树的递归序，是先序，中序，后序的基础
 *  每个节点都会到3次
 *  先序（头，左，右），每一颗子树都满足。第一次递归序时打印
 *  中序（左，头，右），第二次递归序打印
 *  后序（左，右，头）。第三次打印
 */
public class DiGui {

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

    // 递归序
    private static void f(Node node) {
        if (node == null) {
            return;
        }
        f(node.left);
        // 掉完左侧会返回
        f(node.right);
        // 掉完右侧返回
    }

    // 先序
    private static void pre(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + "\t");
        pre(node.left);
        // 掉完左侧会返回
        pre(node.right);
        // 掉完右侧返回
    }

    // 中序
    private static void in(Node node) {
        if (node == null) {
            return;
        }
        in(node.left);
        // 掉完左侧会返回
        System.out.print(node.value + "\t");
        in(node.right);
        // 掉完右侧返回
    }

    // 后序
    private static void post(Node node) {
        if (node == null) {
            return;
        }
        post(node.left);
        // 掉完左侧会返回
        post(node.right);
        // 掉完右侧返回
        System.out.print(node.value + "\t");
    }


}