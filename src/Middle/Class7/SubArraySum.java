package Middle.Class7;

import java.util.HashMap;
import java.util.Map;

/**
 * Author：Ryans
 * Date：Created in 2022/10/4 15:03
 * Introduction：获取子数组的最大累加和，子数组是连续的，可能为0，为负
 * 解决此问题用到的方法：假设答案法。此时还不懂其原理。
 * 若数组全是正数。则可用滑动窗口解决。
 */
public class SubArraySum {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, -1, -10, 11, 4, -6, 9, 20, -10, -2};
//        int[] arr = new int[] {-2, -3, -5, -1};
        System.out.println(getMaxSum(arr));
        int[] a = new int[] { 2, 6, 3, 1, 4, 3};
        System.out.println(getMaxSumForKInZheng(a, 14));
        int[] nums = new int[] {32, -20, 20, 35, -30};
        System.out.println(getMaxSumForK(nums, 5));
    }
    private static int getMaxSum(int[] arr) {
        int curSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            curSum = curSum + arr[i];
            max = Math.max(max, curSum);
            if (curSum < 0) {  // 小于0， 让cur回归0
                curSum = 0;
            }
        }
        return max;
    }

    // 32, -20, 20, 35, -30
    // k为50
    // 最长子数组最大累加和为K， 数组中全是正数且无序
    // 滑动窗口，刚好是k是比较。如果比k大，left右移，如果比k小，right右移
    private static int getMaxSumForKInZheng(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int sum = arr[0];
        int left = 0;
//        int right = 0; // 把0加进来，默认包含0位置， 最终用 R-L+1来算长度
        int max = 0;
        // [L, R] 左闭右闭。初始为[0,0]
       /* while (right < arr.length) {
            if (sum == k) {
                max = Math.max(max, right - left + 1);
                sum -= arr[left++];
            } else if (sum < k) {
                right++;
                if (right >= arr.length) break;
                sum += arr[right];
            } else { // > k
                sum -= arr[left++];
            }
        }*/

        for (int right = 0; right < arr.length; right++) {  // 以i位置结尾
            sum += arr[right];
            while (sum <= k) {
                if (sum == k) {
                    max = Math.max(max, right - left + 1);
                }
                sum -= arr[left++];
            }
        }
        return max;
    }

    // 最长子数组最大累加和为K， 数组中可能有0和负数
    // 32, -20, 20, 35, -30
    private static int getMaxSumForK(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>(); // sum -> id
        int maxLen = 0;
        for (int i = 0, sum = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {  // 找到一个刚好前部分的前缀和与后面加起来等于k
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            } else {
                if (!map.containsKey(sum)) { // 之前的前部分长度更短，减去后就更长
                    map.put(sum, i);
                }
            }
        }
        return maxLen;
    }

    // 最长子数组的最大累加和小于等于k。数组中可能有0和负数
    //
    private static int getMaxSumLessRhanK(int[] arr, int k) {
       return 0;
    }
}