package Middle.Class8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author：Ryans
 * Date：Created in 2022/10/4 19:17
 * Introduction：求最长递增子序列
 * 子序列：可以不连续。子集：连续的
 * 思路：首先还是动态规划，以i位置结尾的组成递增子序列的长度是多少。然后使用一个ends数组：含义为i+1长度下最小的数字。初始情况下，只有arr[0]为有效区，长度为1.
 * 遍历数组arr，如果大于最后一位，则ends有效区域扩大，dp为当前位置+1；否则就是小于最后一位，二分法(ends数组是有序的)找到刚好大于arr[i]的位置，然后把arr[i]替换
 * 时间复杂度O(N*LogN)优于动态规划O(N²)
 */
public class MaxOrderXulie {

    public static void main(String[] args) {
        int[] arr = new int[] {2, 1, 5, 3, 6, 4, 8, 9, 7};
//        int[] arr = new int[] {10,9,2,5,3,7,101,18};
        getMaxList(arr);
        System.out.println(getMaxOrderList(arr));
    }

    private static int getMaxOrderList(int[] arr) {
        int[] dp = new int[arr.length]; // dp, 以i位置结尾的最长递增子序列的长度
        int[] ends = new int[arr.length]; // 有效区域为i+1长度下最小的数字。 初始情况下都为无效区. e
        dp[0] = 1;
        ends[0] = arr[0];
        int index = 0; // ends数组的index
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > ends[index]) {
                ends[++index] = arr[i];
                dp[i] = index + 1;
                max = Math.max(max, dp[i]);
                continue;
            }
            int left = 0;
            int right = index;
            int mid = left + ((right - left) >> 1);
            while (left != right) {
                if (arr[i] >= ends[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
                mid = left + ((right - left) >> 1);
            }
            // 此时 left = right;
            ends[mid] = arr[i];
            dp[i] = mid + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 刚开始想用一个队列来维护从小到大，但当前两个是10,9.再来一个2就进不来了，正确的应该是2位头部。本想找到一个时间复杂度O(N)的方法。此思路是错误的
    private static int getMaxList(int[] arr) {
        // 以当前位置结尾构成一个子序列的最大长度
        int[] dp = new int[arr.length];
        LinkedList<Integer> queue = new LinkedList<>();
        int pre = -1;
        for (int i = 0; i < arr.length; i++) {
            if (!queue.isEmpty() && arr[i] < queue.peekLast()) {
                if (arr[i] > pre) {
                    pre = queue.peekLast();
                    queue.pollLast();
                    queue.add(arr[i]);
                }
            } else {
                if (!queue.isEmpty()) {
                    pre = queue.peekLast();
                }
                queue.add(arr[i]);
            }
        }
        return queue.size();
    }
}