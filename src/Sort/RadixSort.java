package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author : Ryans
 * Date : 2022/8/18
 * Introduction : 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 9,2,6,402,6,8,12,0,3};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        int maxDigits = getMaxDigits(arr);
        int[] help = new int[arr.length];
        for (int i = 1; i <= maxDigits; i++) {
            int[] counts = new int[10];
            for (int j = 0; j < arr.length; j++) {
                int num = getDigit(arr[j], i);
                counts[num]++;
            }
            // 把count处理成前缀和，方便后面处理数据。要不然得多重循环
            // 0号桶：3个，3号桶：1个，5号桶：1个 总数：5；那么 5号桶的数必然在序号为5；
            for (int j = 1; j < 10; j++) {
                counts[j] = counts[j - 1] + counts[j];
            }
            // 把数依照桶放到help中
            // 从右边开始：先进先出。如果从左边开始，count[num]会把左边的数放右边,将导致10位数出桶时大的9放在左边。counts数组是通过--，放置前面的数字的
            // 从右边开始，把右边的数放右边。前缀和是从左向右的。
            for (int j = arr.length - 1; j >= 0; j--) {
                int num = getDigit(arr[j], i);
                // counts[num] --,用完这个count，这个桶里的数--
                // counts里的个数是从1开始的，arr的序号是从0开始的，所以-1；
                help[counts[num]-- - 1] = arr[j];
            }
            for (int j = 0; j < help.length; j++) {
                arr[j] = help[j];
            }
        }
    }

    private static int getDigit(int num, int index){
        // 402 , 2 0 4,
        // 第一位不需要整除
        for (int i = 1; i < index; i++) {
            num = num / 10;
        }
        return  num % 10;
    }

    private static int getDigit2(int num, int index) {
        char[] array = String.valueOf(num).toCharArray();
//        index = index > array.length ? array.length - 1 : index;
        // 402  index = 0;
        return index > array.length - 1 ? 0 :array[array.length - index - 1] - '0';
    }

    private static int getMaxDigits(int[] arr) {
        int d = 1;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        // 402; 40 = 4
        while (max != 0) {
            max = max / 10;
            if (max != 0) d++;
        }
        return d;
    }

    private static int getMaxDigits2(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        return String.valueOf(max).length();
    }
}
