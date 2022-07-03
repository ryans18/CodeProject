package D0305;

import java.util.Arrays;

public class MaopaoSort {

    /*
    *  冒泡排序，时间复杂度为O(n²)，额外空间复杂度O(1)
    *  一轮，把最大数依次交换到最右侧，然后继续交换前面的
    * */
    public static void main(String[] args) {
        int [] array = new int[] {12, 9, 4, 4,8,1,5, 10};
        for (int i = array.length - 1; i > 0; i--) {   // 把最大数放到最后面
            for (int j = 0; j < i; j++) {   // 交换i前面的
                if (array[j] > array[j+1]) {
                    swap(array, j, j + 1);
                }
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
