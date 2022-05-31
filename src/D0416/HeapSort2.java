package D0416;

import java.util.Arrays;

/**
 * Author：Ryans
 * Date：Created in 2022/5/14 16:44
 * Introduction：时间复杂度：O(N*LogN), 额外空间复杂度：O(1) 。有限几个变量
 * 先把数组变成大根堆，每次取最上面的arr[0]交换到后面，把其余的再变成大根堆
 * 优先级队列的底层是小根堆 PriorityQueue<Integer>
 */
public class HeapSort2 {

    public static void main(String[] args) {
        int[] arr = new int[] { 9,2,6,4,6,8,12,0,3};
        heapSort(arr);
    }

    private static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {  // 把数组变成大根堆
            heapInsert(arr, i);
        }
        // 或
        for (int i = arr.length; i >= 0; i--) {   // 把数组变成大根堆，从后往前，依次heapify,
            heapify(arr, i, arr.length);            // O(N)
        }
        int heapSize = arr.length;
        // 把最大值与最后一位交换
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {                 // O(N)
            heapify(arr, 0, heapSize);  // O(LogN)
            swap(arr, 0, --heapSize);  // O(1)
        }
        System.out.println(Arrays.toString(arr));
    }

    // 把某个数往上移动，形成大根堆
    private static void heapInsert(int[] arr, int index) {   //O(1)
        while (arr[index] > arr[(index - 1) / 2] ) {
            swap(arr, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {  // O(1)
        int left = index * 2 + 1;
        while (left < heapSize) { // 当还有孩子的时候
            int largest = left + 1 < heapSize && arr[left+1] > arr[left] ? left + 1: left; // 左右孩子中的最大值
            largest = arr[index] > arr[largest] ? index: largest;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}