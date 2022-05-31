package D0528;

import java.util.Arrays;

/**
 * Author：Ryans
 * Date：Created in 2022/5/28 15:05
 * Introduction：基数排序（桶排序）
 * 按进制依次，个位，十位，百位，放进0-9的桶里，每次取出来，
 * 改进版：根据位上的数字，生成一个count数组，count数组每次++，然后把count数组处理成前缀和，然后依次把原数组上的数依次
 * 从右向左出桶
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 9,2,6,402,6,8,12,0,3};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    private static void radixSort(int[] arr) {
        radixSort(arr, 0, arr.length - 1, getMaxDigit(arr));
    }

    private static void radixSort(int[] arr, int L, int R, int digit) {
        int[] help = new int[R - L + 1];
        for (int d = 1; d <= digit; d++) {  // 有多少位就进出桶多少次
            int[] count = new int[10];   // 0-9 个桶
            // 取出当前位数的数字，即个位，百位，千万的数字
            for (int i = L; i <= R; i++) {
                int num = getDigit(arr[i], d);
                count[num]++;
            }
            //int[] arr = new int[] { 9,2,6,402,6,8,12,0,3};
            // 0    1   2   3   4   5   6   7   8   9
            // 1    0   3   1   0   0   1   0   1   1
            for (int i = 1; i < 10; i++) { // 把count计数数组变成前n项和
                count[i] = count[i - 1] + count[i];
            }
            for (int i = R; i >= L; i--) {  // 出桶，从右往左放到help中
                int num = getDigit(arr[i], d);
                try {
                    help[count[num] - 1] = arr[i];
                } catch (Exception e) {
                    e.printStackTrace();
                }
                count[num]--; // 把当前count的值--，使得下一个移到前一位去
            }
            for (int i = 0,  j = L; i < help.length; i++, j++) {
                arr[L + i ] = help[i];
            }
        }
    }

    private static int getMaxDigit(int[] arr) {
        int digit = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        while (max / 10 > 0) {
            max = max / 10;
            digit++;
        }
        return digit;
    }

    // 取出个位，百位，或者千位上的数字
    private static int getDigit(int num, int d) {
       /* while (d > 0) {
            if (d > 1) {
                num = num / 10;
            } else {
                num = num % 10;
            }
            d--;
        }*/
//        return num;
        return ((num / ((int)Math.pow(10, d - 1))) % 10); // pow , d 次方
    }



    
}