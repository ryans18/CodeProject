package Sort;

import java.util.Arrays;

/**
 * Author : Ryans
 * Date : 2022/8/15
 * Introduction : 快排1.0，每次使得一个数到正确位置即point。
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[] {12, 9, 4, 4,8,1,5, 10};
        sort(array);
        System.out.println("quick Sort: " + Arrays.toString(array));
    }

    private static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int i = left, j = right;
            int point = arr[left];// 先以左边值为jizhun
            while (i < j) {
                while (i < j && arr[right] >= point) {
                    j--;
                }
                while (i < j && arr[left] <= point) {
                    i++;
                }
                // 此时i，j还未相遇。下一次循环找下一个，左边比point大的值，右边比point小的值
                if (i < j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            // 此时i,j相遇，即i == j, i的左边都比point小或等于，右边都比point大或者等于。
            // 但i位置却不是point，需要交换point与i位置的值
            arr[left] = arr[i];
            arr[i] = point;
            // 继续递归左侧、右侧
            sort(arr, left, i - 1);
            sort(arr, j + 1, right);
        }
    }
}
