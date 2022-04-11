package D0409;

import java.util.Arrays;

/**
 * Author：Ryans
 * Date：Created in 2022/4/9 13:27
 * Introduction：快速排序，时间复杂度为n²，通过随机数使得时间复杂度变为nlogn; 空间复杂度：logn
 * 中间排序好，然后递归排序左右两侧
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] {7,4,9,2,0,3,4,5,8,2};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int L, int R) {
        // 随机找一个数, 并与右侧数交换
        if (L < R) {
            int ran = L + (int)(Math.random() * (R - L + 1));
//            int ran = 9;
            swap(arr, ran, R);
            System.out.println(ran);
            int[] pos = partition(arr, L, R);
            quickSort(arr, L, pos[0] - 1);
            quickSort(arr, pos[1] + 1, R);
        }
    }

    /**
     * 处理函数
     * 返回左右边界，两个数
     * 荷兰国旗问题，默认分界为arr[R]
     */
    private static int[] partition(int[] arr, int L, int R) {
        int i = L; // 左侧区域右边界
        int j = R;  // 右侧区域左边界
        int p = L; // 当前数的位置
        while (p < j) {
            if (arr[p] < arr[R]) {
                swap(arr, p, i );
                i++;
                p++;
            } else if (arr[p] > arr[R]) {
                swap(arr, p, j);
                j--;
            } else {
                p++;
            }
        }
//        swap(arr, j, R);
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, L, R + 1)));
        return new int[]{i + 1, j};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}