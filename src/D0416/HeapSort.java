package D0416;

import java.util.Arrays;

/**
 * Author：Ryans
 * Date：Created in 2022/4/16 17:27
 * Introduction：
 */
public class HeapSort {
    public static void main(String[] args) {


    }

    private static void heapSort(int[] arr) {

    }

    /**
     * 变成大根堆
     * @param arr
     * @param index
     */
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {  // index位置比父级大时
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1; // 左孩子
        while (left < heapSize) { // 左孩子是否越界-》下边是否还有孩子
            // left + 1 右孩子
            int larget = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1: left;
            // 自己和孩子谁大，把大的下标给larget
            larget = arr[larget] > arr[index] ? larget: index;
            // 当前值就是最大的，不用heapify了
            if (larget == index) {
                break;
            }
            swap(arr, larget, index);
            index = larget;   // 找到了下面的孩子比自己大， index往下走
            left = 2 * index + 1;
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}