package Sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Author : Ryans
 * Date : 2022/8/17
 * Introduction : 堆排序-时间复杂度O(NlogN),额外空间复杂度O(N)
 * 利用大根堆的特性，第一个数字最大，每次取出后再heapify
 * 父： (i- 1) / 2
 * 左孩子： 2 * i + 1；右孩子：2 * i + 2
 */
public class HeapSort2 {

    public static void main(String[] args) {
        int[] array = new int[] {10, 9, 4, 4, 8, 1, 5, 12, 0, 20, 3, 18, 9};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 通过heapInsert变成大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        // heapify ,把头放到最后，使前面形成一个新的大根堆
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) { //  当前节点的值与父节点的值相比
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 从0-i heapify， index为右边边界，只需要把左边形成大根堆
    private static void heapify(int[] arr, int index) {
        int p = 0;
        int left = 2 * p + 1;
        while (left < index) {  // 还有孩子的时候
            int larget = left + 1 < index && arr[left] < arr[left + 1] ? left + 1: left;
            larget = arr[larget] > arr[p] ? larget : p;
            // 如果larget与p相等就不用向下进行了
            if (larget == p) {
                break;
            }
            swap(arr, larget, p);
            p = larget;
            left = 2 * p + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
