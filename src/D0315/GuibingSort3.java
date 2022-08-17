package D0315;

import java.util.Arrays;

/**
 * Author : Ryans
 * Date : 2022/3/11
 * Introduction :
 */
public class GuibingSort3 {

    public static void main(String[] args) {
        int[] arr =  new int[] {12, 9, 4, 4,8,1,5, 10};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int middle = left + ((right - left) >> 1);
        sort(arr, 0, middle);
        sort(arr, middle + 1, right);
        merge(arr, left, middle, right);
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int pos = 0;
        int[] temp = new int[right - left + 1];
        while (i <= middle && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[pos++] = arr[i++];
            } else {
                temp[pos++] = arr[j++];
            }
        }
        // 左边剩余元素，右边已经加入temp
        while (i <= middle) {
            temp[pos++] = arr[i++];
        }
        while (j <= right) {
            temp[pos++] = arr[j++];
        }
        for (int k = 0; k < temp.length; k++) {
            arr[left + k] = temp[k];
        }
    }


    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
