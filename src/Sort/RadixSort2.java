package Sort;

import java.util.Arrays;

/**
 * Author : Ryans
 * Date : 2022/8/19
 * Introduction :
 */
public class RadixSort2 {
    public static void main(String[] args) {
        int[] arr = new int[] { 9,2,6,402,6,8,12,0,3};
        radixSort(arr);
//        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        int maxBits = getMaxBits(arr);
        int[] help = new int[arr.length];
        for (int i = 1; i <= maxBits; i++) {
            int exp = (int)Math.pow(10, i - 1);
            int[] counts = new int[10];
            for (int j = 0; j < arr.length; j++) {
                int num = arr[j] / exp % 10;
                counts[num]++;
            }
            for (int j = 1; j < counts.length; j++) {
                counts[j] += counts[j - 1];
            }

//            for (int j = arr.length - 1; j >= 0; j--) {
//                int num = arr[j] / exp % 10;
//                help[counts[num]-- - 1] = arr[j];
//            }
            for (int j = 0; j < arr.length; j++) {
                int num = arr[j] / exp % 10;
                help[counts[num]-- - 1] = arr[j];
            }
            for (int j = 0; j < help.length; j++) {
                arr[j] = help[j];
            }
            System.out.println(i +"-"+Arrays.toString(help));

        }
    }

    private static int getMaxBits(int[] arr) {
        int d  = 1;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        while (max / 10 != 0) {
            max = max / 10;
            d++;
        }
        return d;
    }
}
