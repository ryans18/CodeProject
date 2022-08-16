package D0409;

import java.util.Arrays;

/**
 * Author：Ryans
 * Date：Created in 2022/4/9 12:04
 * Introduction： 荷兰国旗问题：一个数组，和一个数num，小于num的放在左边，等于在中间，大于在右边
 */
public class HelanGuoqi {
    public static void main(String[] args) {
//        int[] arr = new int[] {4,6,3,7,9,2,5,0,4,5};
        int[] arr = new int[] {7, 3, 5, 8, 1, 5, 9, 0};
        int num = 5;
        gq(arr, 0, arr.length -1, num );
        System.out.println(Arrays.toString(arr));
   /*     int p1 = 0;
        int p2 = arr.length - 1;
        int i = 0;*/
        /*while (i <= p2) {  // 当i和大于区域指针撞上的时候过程停止
            if (arr[i] < num) {
                swap(arr, i, p1);
                p1++;
                i++;
            } else if (arr[i] == num) {
                i++;
            } else {
                swap(arr, i, p2);
                p2--;
                // i 不变
            }
        }
*/
//        int p1 = -1;
//        int p2 = arr.length - 1;
//        int p = 0;
//        while (p < p2) {
//            if (arr[p] < num) {
//                p1++;
//                swap(arr, p, p1);
//                p++;
//            } else if (arr[p] > num) {
//                swap(arr, p, p2);
//                p2--;
//            } else {
//                p++;
//            }
//            System.out.println(Arrays.toString(arr));
//        }

    }

    private static void gq(int[] arr, int L, int R, int num) {
        int i = L; // 左侧区域右边界
        int j = R;  // 右侧区域左边界
        int p = L; // 当前数的位置
        while (p < j) {
            if (arr[p] < num) {
                swap(arr, p, i );
                i++;
                p++;
            } else if (arr[p] > num) {
                swap(arr, p, j);
                j--;
            } else {
                p++;
            }
            System.out.println(Arrays.toString(arr));
        }
//        swap(arr, j, R);
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}