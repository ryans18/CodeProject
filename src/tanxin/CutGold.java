package tanxin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Author：Ryans
 * Date：Created in 2022/9/4 15:11
 * Introduction：切金条问题，每次切金条需要花费同样的钱，求最小花费
 * 数组既为金条要分成的块，总金条为数组累加和
 * 哈夫曼编码问题
 */
public class CutGold {

    public static void main(String[] args) {
        int[] golds = new int[]{2,6,3,7,4,2,5 ,9};
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < golds.length; i++) {
            queue.add(golds[i]);
        }
        int sum = 0;
        // 一次取两个数，加和然后重新加入小根堆中,最终只剩一个数
        while (queue.size() > 1) {
            int num = queue.poll() + queue.poll();
            sum += num;
            queue.add(num);
        }
        System.out.println(sum);
    }
}