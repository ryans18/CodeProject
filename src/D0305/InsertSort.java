package D0305;

import java.util.Arrays;

public class InsertSort {
    /*
    * 插入排序，时间复杂度为 O(n²)
    * 依次排序左边，然后光标向右移动
    * */
    public static void main(String[] args) {
        int [] array = new int[] {12, 9, 4, 4,8,1,5, 10};
        // [0,1], [0,2], [0,3]
        for (int i = 1; i < array.length; i++) { // 1,2,3
            for (int j = i - 1; j >= 0 && array[j] > array[j+1];j--) {   //排序左边的，依次向左
                swap(array, j, j +1);
                System.out.println(Arrays.toString(array));
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void swap(int [] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
