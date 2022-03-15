package D0315;

import java.util.Arrays;

/**
 * Author : Ryans
 * Date : 2022/3/11
 * Introduction :
 */
public class MaopaoSort {

    public static void main(String[] args) {
        int[] arr = new int[]{8,4,5,2,9,6,12};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
