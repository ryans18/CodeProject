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
        array = new int[] {12, 9, 4, 4,8,1,5, 10};
        quickSort2(array, 0 , array.length - 1);
        System.out.println("quick Sort2: " + Arrays.toString(array));
        array = new int[] {12, 9, 4, 4,8,1,5, 10};
        guibingSort(array);
        System.out.println("guibing Sort: " + Arrays.toString(array));
        array = new int[] {12, 9, 4, 4,8,1,5, 10};
        heapSort(array);
        System.out.println("heap Sort: " + Arrays.toString(array));
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
     * 分而治之。
     * merge:利用一个临时数组，两个指针分别指向左右两侧（middle分开），小于的数放在临时数组中，使得左右两侧小的在前，大的在后
     * 递归使得所有数，小的在前，大的在后
     * @param arr
     */
    private  static void guibingSort(int[] arr) {
        guibingSort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序
     *
     * @param arr
     */
    private  static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 堆排序
     * 利用大根堆的特性，跟节点最大。每次取出根节点，然后其余数重新生成大根堆
     * @param arr
     */
    private static void heapSort(int[] arr) {
        // 生成一个大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        // 把跟节点与最后一个交换，然后使得前面形成一个新的大根堆
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i);
        }
    }

    private static void heapify(int[] arr, int index) {
        // 从0开始heapify
        int p = 0;
        int left = p * 2 + 1;
        while (left < index) { // 当左孩子在边界内时，如果左孩子都不在范围内，那右孩子就不用看了
            int largest = left + 1 < index && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[p] ? largest : p;
            if (largest == p){
                break;
            }
            swap(arr, largest, p);
            p = largest;
            left = p * 2 + 1;
        }
    }

    private static void heapInsert(int[] arr, int index) {
        // 父节点
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr,index, (index - 1) /2);
            index = (index - 1) /2 ;
        }
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

    // 快排2.0，选取一个数num为最右侧的数，然后左侧区域小于num的放左边，大于num放右边，最后交换num与大于区域的第一个数，num就到了正确位置
    private static void quickSort2(int[] arr, int L, int R) {
        if (L < R) {
            int index = R;
            int p = L;
            int num = arr[R];
            while (p < index) {
                if (arr[p] > num) {
                    swap(arr, p, --index);
                } else {
                    p++;
                }
            }
            swap(arr, R, index);
            quickSort2(arr, L, index - 1);
            quickSort2(arr, index + 1, R);
        }
    }

    private static void guibingSort(int[] arr ,int L, int R) {
        if (L < R) {
            int middle = L + ((R - L) >> 1);
            guibingSort(arr, L, middle);
            guibingSort(arr, middle + 1, R);
            guibingMerge(arr, L, R, middle);
        }
    }

    private static void guibingMerge(int[] arr, int L, int R, int middle) {
        int[] temp = new int[R - L + 1];
        int i = L;
        int j = middle + 1;
        int p = 0;
        while (i <= middle && j <= R) {
            if (arr[i] <= arr[j]) {
                temp[p++] = arr[i++];
            } else {
                temp[p++] = arr[j++];
            }
        }
        while (i <= middle) {
            temp[p++] = arr[i++];
        }

        while (j <= R) {
            temp[p++] = arr[j++];
        }
        for (int k = 0; k < temp.length; k++) {
            arr[L + k] = temp[k];
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
