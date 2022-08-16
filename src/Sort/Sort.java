package Sort;

import java.util.Arrays;

/**
 * Author : Ryans
 * Date : 2022/8/15
 * Introduction : 主要的排序方法总结
 */
public class Sort {

    public static void main(String[] args) {
        int [] array = new int[] {12, 9, 4, 4,8,1,5, 10};
        System.out.println("原始:" + Arrays.toString(array));
        insertSort(array);
        System.out.println("insert Sort: " + Arrays.toString(array));
        array = new int[] {12, 9, 4, 4,8,1,5, 10};
        maopaoSort(array);
        System.out.println("maopao Sort: " + Arrays.toString(array));
        array = new int[] {12, 9, 4, 4,8,1,5, 10};
        selectSort(array);
        System.out.println("select Sort: " + Arrays.toString(array));
        array = new int[] {12, 9, 4, 4,8,1,5, 10};
        quickSort(array);
        System.out.println("quick Sort: " + Arrays.toString(array));
    }

    /**
     * 插入排序
     * 0,0是有序的，插入一个新的数字[1]，要让增加1的新的数组有序。从而使0,1排序，0,2排序，0,3排序，依次排好序
     * @param arr
     */
    private static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    /**
     * 冒泡排序
     * 把最大数放到最后面，光标向左移动，依次把最大数放到最右侧
     * @param arr
     */
    private static void maopaoSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    /**
     * 选择排序
     *  选择一个最大值为最后一位，依次遍历前面如果找到max，则标记为maxIndex，前面循环完后，交换maxIndex，与最后一位的index
     *  与冒泡比较相似。但选择排序只交换了一次。冒泡左右不停的交换
     * @param arr
     */
    private static void selectSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int maxIndex = i;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            swap(arr, i, maxIndex);
        }
    }

    /**
     * 归并排序
     * @param arr
     */
    private  static void guibingSort(int[] arr) {

    }

    /**
     * 快速排序
     *
     * @param arr
     */
    private  static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int i = left, j = right;
            int point = arr[left];
            while (i < j) {
                while (i < j && arr[j] >= point) {
                    j--;
                }
                while (i < j && arr[i] <= point) {
                    i++;
                }
                // i还在j的左侧
                if (i < j) {
                    swap(arr, i, j);
                }
            }
            // i , j指针跳出循环，相遇
            // 交换基准位置
            arr[left] = arr[i];
            arr[i] = point;
            quickSort(arr, left, i -1 );
            quickSort(arr, j + 1, right);
        }
    }

    private static void mergeQuickSort() {

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
