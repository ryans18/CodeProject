package Sort;

import java.util.Arrays;

/**
 * Author : Ryans
 * Date : 2022/8/16
 * Introduction : 快排1.0 与 快排 3.0
 */
public class QuickSort3 {
    public static void main(String[] args) {
        int[] array = new int[] {10, 9, 4, 4, 8, 1, 5, 12};
        quickSort1(array, 0 , array.length - 1);
        System.out.println(Arrays.toString(array));
        array = new int[] {12, 9, 4, 4,8,1,5, 10};
        quickSort2(array, 0 , array.length - 1);
        System.out.println(Arrays.toString(array));
        array = new int[] {12, 9, 4, 4,8,1,5, 10};
        quickSort3(array, 0 , array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    // 快排1.0
    private static void quickSort1(int[] arr, int L, int R) {
        if (L < R) {
            int i = L;
            int j = R;
            int temp = arr[R];
            while (i < j) {
                while (arr[i] <= temp && i < j) i++;
                while (arr[j] >= temp && i < j) j--;
                // 找到arr[i] > temp, arr[j] < temp， 但此时i, j 还未相遇
                if (i <j) {
                    int num = arr[i];
                    arr[i] = arr[j];
                    arr[j] = num;
                }
            }
            // 此时i，j相遇。
            // 交换temp,使其到i位置。后，左边都比temp小，右边都比temp大
            arr[R] = arr[i];
            arr[i] = temp;
            quickSort1(arr, L, i - 1);
            quickSort1(arr, j + 1, R);
        }
    }

    // 快排2.0 简化版, 目的让num到达正确位置
    private static void quickSort2(int[] arr, int L, int R) {
        if (L < R) {
            int i = L;
            int j = R; // 默认R-1所有数都小于等于num
            int num = arr[R];
            while (i < j) {
                if (arr[i] > num) {  // 小于等于不动，指针右移
                    swap(arr, i, --j);  //交换到右侧,大于区域左移
                } else {
                    i++;
                }
            }
            // 交换最后一个数与大于区域的第一个数
            swap(arr, R, j);
//            System.out.println(Arrays.toString(arr));
//            int potion = partitionOne(arr, L, R);
            // 此时，temp这一个值到了正确位置，左侧是小于等于temp的，右侧是大于temp的
            quickSort2(arr, L, i - 1);
            quickSort2(arr, i + 1, R);
        }
    }

    public static int partitionOne(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr, ++lessEqual, R);
        return lessEqual;
    }

    // 快排3.0，一次把相等的数都排到正确位置，比2.0更快。随机数使得时间复杂度趋近与O(N * LogN)
    private static void quickSort3(int[] arr, int L, int R) {
        if (L < R) {
            int temp = L + (int)(Math.random() * (R - L));
            swap(arr, temp, R); // 把一个随机的temp放到最右侧
            int[] pos = partition(arr, L, R);
            quickSort3(arr, L, pos[0]);
            quickSort3(arr, pos[1], R);
        }
    }

    private static int[] partition(int[] arr, int L, int R) {
        int i = L - 1;
        int j = R + 1;
        int p = L;
        int temp = arr[R];
        while (p < j) {
            if (arr[p] < temp) {
                swap(arr, ++i, p++);
            } else if (arr[p] > temp) {
                swap(arr, --j, p);
            } else {
                p++;
            }
        }
        return new int[]{i, j};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
