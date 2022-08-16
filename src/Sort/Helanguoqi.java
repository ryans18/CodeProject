package Sort;

import java.util.Arrays;

/**
 * Author : Ryans
 * Date : 2022/8/16
 * Introduction :
 */
public class Helanguoqi {

    public static void main(String[] args) {
        int[] arr = new int[] {7, 3, 5, 8, 1, 5, 9, 0};
        partition(arr, 0, arr.length - 1, 5);
        System.out.println(Arrays.toString(arr));
    }

    private static void partition(int[] arr, int L, int R, int num) {
        int i = L - 1; // 小于num的左边界，默认为0
        int j = R + 1; // 大于num的右边界
        int p = L; // 指针，检索所有数
        while (p < j) {  // 当p到右边界结束
            if (arr[p] < num) {  // 找到一个比num小的值, 左边界右移
                swap(arr, p++, ++i);
            } else if (arr[p] > num) {  // 当前值大于num, 交换当前值与有边界的前一个。有边界左移动,
                swap(arr, p, --j);
            } else {  // 与num相同，不用改变左右边界，指针右移
                p++;
            }
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("i: " + i + "\tj: " + j);
    }

    private static void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
