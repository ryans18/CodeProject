package Middle.Class7;

/**
 * Author：Ryans
 * Date：Created in 2022/10/4 15:03
 * Introduction：获取最大子数组的累加和，子数组是连续的
 * 解决此问题用到的方法：假设答案法。此时还不懂其原理
 */
public class SubArraySum {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, -1, -10, 11, 4, -6, 9, 20, -10, -2};
        System.out.println(getMaxSum(arr));
    }
    private static int getMaxSum(int[] arr) {
        int curSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            curSum = curSum + arr[i];
            if (curSum <= 0) {
                curSum = 0;
            } else {
                max = Math.max(max, curSum);
            }
        }
        return max;
    }
}