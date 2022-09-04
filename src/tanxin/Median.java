package tanxin;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Author：Ryans
 * Date：Created in 2022/9/4 16:20
 * Introduction：中位数问题，非贪心问题
 * 大根堆和小根堆的配合
 * 第一个数字直接进大根堆，
 * 再个一个数字，先看num是<=大根堆顶，入大根堆，否则，如小根堆
 * 看看大根堆和小根堆的size，如果一个的size超过了另一个两个，教大弹出进教小
 */
public class Median {

    public static void main(String[] args) {
        int[] arr = {5,8,12,4,9, 0,23, 9,3};
        // 0, 3, 4, 5, 8, 9, 9, 12, 23
        System.out.println(getMedian(arr));
    }

    private static int getMedian(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int sizeMin = 0;
        int sizeMax = 0;
        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(new MaxComparator());
        maxQueue.add(arr[0]);
        sizeMax++;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= maxQueue.peek()) {
                maxQueue.add(arr[i]);
                sizeMax++;
            } else {
                minQueue.add(arr[i]);
                sizeMin++;
            }
            if (sizeMin - sizeMax == 2) {
                maxQueue.add(minQueue.poll());
                sizeMax++;
                sizeMin--;
            }
            if (sizeMax - sizeMin == 2) {
                minQueue.add(maxQueue.poll());
                sizeMax--;
                sizeMin++;
            }
        }
        return sizeMax > sizeMin ? maxQueue.peek() : sizeMax < sizeMin ? minQueue.peek() : (minQueue.peek() + maxQueue.peek()) / 2;
    }

    private static class MaxComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

}