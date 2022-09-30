package Struct;

/**
 * Author : Ryans
 * Date : 2022/9/28
 * Introduction :  给定一个有序数组arr，代表数轴上从左到右有n个点arr[0],arr[1],...,arr[n-1]，给定一个正数L，代表一根长度为L的绳子，求绳子最多能覆盖其中的几个点。
 * 滑动窗口解决：O(N)
 */
public class WindowsQuestion {

    /**
     *
     * @param arr 有序数组arr
     * @param L  绳子长度
     * @return
     */
    private static int process(int[] arr, int L, int curLeft) {
        if (curLeft == arr.length - 1) {
            return 1;
        }
        int right = curLeft;
        int num = 1;
        while (right < arr.length && arr[curLeft] + L > arr[right] ) {
            right++;
            num++;
        }
        // 此时right刚好在大于L的最左边;
        return Math.max(num, process(arr, L, curLeft + 1));
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 5, 7, 9, 10, 15, 17};
        int L = 5;
        int num = process(arr, L, 0);
        System.out.println(num);
    }
}
