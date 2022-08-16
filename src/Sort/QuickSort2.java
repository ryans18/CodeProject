package Sort;

import java.util.Arrays;

/**
 * Author : Ryans
 * Date : 2022/8/16
 * Introduction : 快排3.0 依靠random 使得时间复杂度变为 o(NLogN)
 * 每次使得一批数到正确位置
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int[] array = new int[] {10, 9, 4, 4, 8, 1, 5, 12};
//        int[] array = new int[] {7,4,9,2,0,3,4,5,8,2};
        quickSort(array, 0, array.length - 1);
        System.out.println("quick Sort: " + Arrays.toString(array));
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
//            int random = L + (int) (Math.random() * (R - L + 1));
//            swap(arr, random, R);
            int[] pos = partition(arr, L, R);
            quickSort(arr, L, pos[0]);
            quickSort(arr, pos[1], R);
        }
    }

    // 利用荷兰国旗问题, 返回左右边界
    private static int[] partition(int[] arr, int L, int R) {
        int i = L - 1; // 初始化左边界在-1位置
        int j = R + 1; // 初始化右边界在R+1位置
        int p = L;  // 指针
        int temp = arr[R];
        while (p < j) {
            if (arr[p] < temp) {  // 找到<, <边界右移，指针右移
                swap(arr, p++, ++i);
            } else if (arr[p] > temp) { // 找到>, >边界左移，交换与边界的前一个值，但不知道交换的值的大小，所以还需要处理交换的值，指针不移动
                swap(arr, p, --j);
            } else {
                p++;
            }
        }
        return new int[] {i, j};
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
