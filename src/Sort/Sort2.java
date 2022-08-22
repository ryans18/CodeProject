package Sort;

import java.util.Arrays;

/**
 * Author : Ryans
 * Date : 2022/8/19
 * Introduction :
 */
public class Sort2 {

    public static void main(String[] args) {
        int[] arr = generateArray(20);
//        int [] arr = new int[] {12, 9, 4, 4,8,1,5, 10};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[ j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
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

    private static void maopaoSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort2(arr, 0, arr.length - 1);
    }

    private static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort3(arr, 0, arr.length - 1);
    }

    private static void guibingSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        guibingSort(arr, 0, arr.length - 1);
    }

    private static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            int i = L;
            int j = R;
            int num = arr[L];
            while ( i < j) {
                while (i < j && arr[j] > num) j--;
                while (i < j && arr[i] <= num) i++;
                // 此时还没有相遇。但已经找到了左边比num大的数，右边比num小的数
                if (i < j) {
                    swap(arr, i, j);
                }
            }
            // 此时 i，与j相遇了， 交换num 与i的值。使得i的左边比num小，右边比num大。
            arr[L] = arr[i];
            arr[i] = num;
            quickSort(arr, L, i - 1);
            quickSort(arr, i + 1, R);
        }
    }

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
            swap(arr, index, R);
            quickSort2(arr, L, index - 1);
            quickSort2(arr, index + 1, R);
        }
    }

    private static void quickSort3(int[] arr, int L, int R) {
        if (L < R) {
            int random = L + (int)(Math.random() * (R - L + 1));
            swap(arr ,random, R);
            int[] pos = partition(arr ,L, R);
            quickSort3(arr, L, pos[0]);
            quickSort3(arr, pos[1], R);
        }
    }

    private static void guibingSort(int[] arr, int L, int R) {
        if (L < R) {
            int middle = L + ((R - L) >> 1);
            guibingSort(arr, L, middle);
            guibingSort(arr, middle + 1, R);
            guibingMerge(arr, L, R, middle);
        }
    }

    private static void radixSort(int[] arr, int L, int R) {
        int maxBits = getMaxBits(arr);
        int[] help = new int[R - L + 1];
        for (int i = 1; i <= maxBits; i++) {
            int[] counts = new int[10];
            int exp = (int)Math.pow(10, i - 1);
            for (int j = 0; j < arr.length; j++) {
                int num = arr[j] / exp % 10;
                counts[num]++;
            }
            for (int j = 1; j < counts.length; j++) {
                counts[j] += counts[j - 1];
            }

            for (int j = arr.length - 1; j >= 0; j--) {
                int num = arr[j] / exp % 10;
                help[counts[num]-- - 1] = arr[j];
            }
            for (int j = 0; j < help.length; j++) {
                arr[L + j] = help[j];
            }
        }
    }

    private static int getMaxBits(int[] arr) {
        int d = 1;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        // 402
        while (max / 10 != 0) {
            max = max / 10;
            d++;
        }
        return d;
    }

    private static void guibingMerge(int[] arr, int L, int R, int middle) {
        int[] help = new int[R - L + 1];
        int i = L;
        int j = middle + 1;
        int p = 0;
        while (i <= middle && j <= R) {
            if (arr[i] <= arr[j]) {
                help[p++] = arr[i++];
            } else if (arr[i] > arr[j]) {
                help[p++] = arr[j++];
            }
        }
        while (i  <= middle) {
            help[p++] = arr[i++];
        }
        while (j <= R) {
            help[p++] = arr[j++];
        }
        for (int k = 0; k < help.length; k++) {
            arr[L + k] = help[k];
        }
    }

    private static int[] partition(int[] arr, int L, int R){
        // 荷兰国旗问题
        int i = L - 1;
        int j = R + 1;
        int p = L;
        int num = arr[R];
        while (p < j) {
            if (arr[p] >num) {
                swap(arr, p, --j);
            } else if (arr[p] < num) {
                swap(arr, p++, ++i);
            } else {
                p++;
            }
        }
        return new int[]{i,j};
    }

    private static void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int[] generateArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 1000);
        }
        return arr;
    }
}
