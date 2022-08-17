package Sort;

import java.util.Arrays;

/**
 * Author : Ryans
 * Date : 2022/8/17
 * Introduction : 归并排序，时间复杂度o(N * logN). 基本思想：分而治之
 * 使用一个辅助数组，在元素组左右开始，比较i,j。选择小的放入辅助数组temp，然后小的那个指针右移，辅助指针右移。
 * 左右两侧递归
 */
public class GuibingSort {

    public static void main(String[] args) {
        int[] array = new int[] {10, 9, 4, 4, 8, 1, 5, 12};
        guibingSort(array, 0 , array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void guibingSort(int[] arr, int L, int R) {
        if (L < R) {
            int middle = L + ((R - L) >> 1); // L + (R - L) / 2 => 2L - L + R
            guibingSort(arr, L, middle);
            guibingSort(arr, middle + 1, R);
            merge(arr, L, R, middle);
        }
    }

    private static void merge(int[] arr, int L, int R, int middle) {
        int[] temp = new int[R - L + 1];
        int p = 0;
        int i = L;
        int j = middle + 1;
        while (i <= middle && j <= R) {
            if (arr[i] <= arr[j]) {
                temp[p++] = arr[i++];
            } else {
                temp[p++] = arr[j++];
            }
        }
        // 可能左边小于的数比较少，右边还没到头
        while (i <= middle) {
            temp[p++] = arr[i++];
        }
        while (j<= R) {
            temp[p++] = arr[j++];
        }
        // temp数组复原到原数组
        for (int k = 0; k < temp.length; k++) {
            arr[L + k] = temp[k];
        }
    }


}
