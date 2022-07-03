package D0305;

import java.util.Arrays;

public class XuanZeSort {
    /*
    * 选择排序， 时间复杂度O(n²)， 额外空间复杂度O(1) ,总共就三个变量(i,j,minIndex)，用完就释放
    * 每次选取一个最小值放在最左边，然后光标向右移动
    * */
    public static void main(String[] args) {
        int [] array = new int[] {12, 9, 4, 4,8,1,5, 10};
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {  // 找到最小值的index
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);   // 把最小值放到最左边
        }
        System.out.println(Arrays.toString(array));

    }

    public static void swap(int [] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
