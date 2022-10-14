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
        return 0;
    }
    // 32, -20, 20, 35, -30
    // k为50
    // 最长子数组最大累加和为K， 数组中全是正数
    private static int getMaxSumForKInZheng(int[] arr, int k) {
        return 0;
    }
}