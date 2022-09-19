package Struct;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author : Ryans
 * Date : 2022/9/19
 * Introduction : 滑动窗口，用队列的方式————双端队列
 * 双指针思想，两个指针中间形成一个窗口，L,R 都可以向右移，不能往右动，L不能超过右边界。  从头到尾部，从大变小。
 * 解决问题，求窗口内的最大值。比暴力遍历O(N)时间复杂度低，平均为O(1)
 */
public class WindowQueue {
    private int L;
    private int R;
    private int[] arr;
    private LinkedList<Integer> queue;  // 存放索引

    public WindowQueue(int[] arr) {
        L = -1;
        R = 0;
        this.arr = arr;
        queue = new LinkedList<>(); // 队列中放置从大到小的数，如果新加入的数字比之前大，则弹出最后一个
    }

    // 把数组中的数字放进窗口
    public void addNumFromRight() {
        if (R == arr.length) {
            return;
        }
        while (!queue.isEmpty() && arr[R] > arr[queue.peekLast()]) {
            queue.removeLast();
        }
        queue.addFirst(R);
        R++;
    }

    // L向右移动
    // 大的数始终在头节点，如果头节点不是L的位置，说明已经被丢弃了
    public void removeNumFromLeft() {
        if (L >= R - 1) {
            return;
        }
        L++;
        if (queue.peekFirst() == L) {
            queue.removeFirst();
        }
    }

    public Integer getMax() {
        if (!queue.isEmpty()) {
            return arr[queue.peekFirst()];
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr  = new int[] {2,2,4,6,1,0,7};
        WindowQueue windowQueue = new WindowQueue(arr);
        windowQueue.addNumFromRight();
        windowQueue.addNumFromRight();
        windowQueue.addNumFromRight();
        System.out.println(windowQueue.getMax());

    }
}
