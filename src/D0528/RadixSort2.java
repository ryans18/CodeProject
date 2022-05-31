package D0528;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author：Ryans
 * Date：Created in 2022/5/29 16:33
 * Introduction：
 */
public class RadixSort2 {

    public static void main(String[] args) {
        int[] arr = new int[] { 9,2,6,402,6,8,12,0,3};
        radix(arr);
    }

    private static void radix(int[] arr) {
        int digit = getMaxDigit(arr);
        int[] help = new int[arr.length];
        for (int d = 1; d <= digit; d++) {
            Queue<Integer>[] count  = new LinkedList[10];
            for (int i = 0; i < arr.length; i++) {
                int num = getDigit(arr[i], d);
                count[num].add(arr[i]);
            }
            int num = 0;
            int h = 0;
            while (!count[num].isEmpty() && num <= 9) {
                if (count[num].isEmpty()) {
                    num++;
                } else {
                    help[h++] = count[num].poll();
                }
            }
            for (int i = 0; i < help.length; i++) {
                arr[i] = help[i];
            }
            System.out.println(Arrays.toString(count));
        }
    }

    private static int getMaxDigit(int[] arr) {
        int digit = 1;
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(i, max);
        }
        while (max / 10 > 0) {
            max = max / 10;
            digit++;
        }
        return digit;
    }

    private static  int getDigit(int num, int d) {
        int result = 0;
        try {
            result = ((num / ((int)Math.pow(10, d - 1))) % 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}