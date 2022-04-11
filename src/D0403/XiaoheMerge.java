package D0403;

import java.util.Arrays;

/**
 * Author：Ryans
 * Date：Created in 2022/4/3 17:38
 * Introduction： 小和计算
 */
public class XiaoheMerge {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 2, 5};
        System.out.println(sort(0, arr.length - 1, arr));
        System.out.println(Arrays.toString(arr));
    }

    private static int sort(int left, int right, int[] arr) {
        if (left == right) {
            return 0;
        }
        int middle = left + ((right - left) >> 1);
        return sort(left, middle, arr)
        + sort(middle + 1, right, arr)
        + merge(left, middle, right, arr);
    }

    private static int merge(int left, int middle, int right, int[] arr) {
        int i = left;
        int j = middle + 1;
        int p = 0;
        int res = 0;
        int[] temp = new int[right - left + 1];
        while (i <= middle && j <= right) {
            if (arr[i] < arr[j]) {
                // right - j + 1: 右侧比左指针的数大的个数
                // 只有左边比右边小的时候，才产生小和
                res += (right - j + 1) * arr[i];
                temp[p++] = arr[i++];
            } else {  // 两边相等时，让右边角标++
                temp[p++] = arr[j++];
            }
        }
        while (i <= middle) {
            temp[p++] = arr[i++];
        }

        while (j <= right) {
            temp[p++] = arr[j++];
        }

        for (int k = 0; k < temp.length; k++) {
            arr[left + k] = temp[k];
        }
        return res;
    }
}