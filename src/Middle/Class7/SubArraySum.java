package Middle.Class7;

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

    // 最长子数组最大累加和为K， 数组中可能有0和负数
    private static int getMaxSumForK(int[] arr, int k) {
        //TODO
        return 0;
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
        int right = 0;
        int max = 0;
        while (right < arr.length) {
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
        }
        return max;
    }
}