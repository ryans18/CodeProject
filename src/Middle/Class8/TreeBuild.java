package Middle.Class8;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Author：Ryans
 * Date：Created in 2022/10/4 18:00
 * Introduction：根据一棵树的前序遍历与中序遍历生成后序遍历, 没有重复值
 * 思想：先序pre为 中左右，中序in为 左中右， 后序post为 左右中。 pre第一个元素是头，那么它在in数组中一定是在中间位置，左边全是左树，右边全是右数，
 *  依照这个思想，在in中找到头结点，左边假设右5个元素，那我们在pre数组中头节点下一个找5个，这5个为左数的，剩下的便是右树的。pre数组的头一定在post数组最后一个。
 */
public class TreeBuild {

    public static void main(String[] args) {
        int[] pre = {3,1,4,5,2,7,9};
        int[] in = {4,1,5,3,7,2,9};
        System.out.println(Arrays.toString(getPostOrder(pre, in)));
    }

    private static int[] getPostOrder(int[] pre, int[] in) {
        int N = pre.length;
        int[] post = new int[N];
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inMap.put(in[i], i);
        }
        set(pre, post, inMap,0, N - 1, 0, N - 1, 0, N - 1);
        return post;
    }

    private static void set(int[] pre, int[] post, HashMap<Integer, Integer> inMap,
                            int prei, int prej, int ini, int inj, int posti, int postj) {
        if (prei > prej) {
            return;
        }
        if (prei == prej) {  // pre数组的头一定是pos数组中的最后一个元素。
            post[postj] = pre[prei];
            return;
        }
        post[postj] = pre[prei];
        int find = inMap.get(pre[prei]);
        // post数组：find-ini为左树的长度。-1即为左侧的索引
        set(pre, post, inMap, prei + 1, prei + find - ini, ini, find - 1, posti, posti + find - ini - 1);
        set(pre, post, inMap, prei + find - ini + 1, prej, find + 1, inj, posti + find - ini, postj - 1);
    }

    /**
     *       3
     *     1    2
     *   4  5  7  9
     *   pre：[3,1,4,5,2,7,9]
     *   in: [4,1,5,3,7,2,9]
     *  index[0,1,2,3,4,5,6]
     */
}