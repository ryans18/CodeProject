package D0315;

import java.util.Arrays;

/**
 * 归并排序 时间复杂度 O(NlogN)
 *
 */
public class GuiBingSort {

    public static void main(String[] args) {
        int[] array = new int[]{20,6,7, 10,4,8,6,9,5};
        sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        int middle = left + ((right - left) >> 1) ;
        sort(array, left, middle);
        sort(array, middle + 1, right);
        merge(array, left, middle, right);
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        // 归并
        int i = left;
        int j = middle + 1;
        int x = 0; // 临时数组指针
        while (i<=middle && j <= right) {  // 将所有左边小的放到temp中
            if (array[i] <= array[j]) {
                temp[x++] = array[i++];
            } else {
                temp[x++] = array[j++];
            }
        }
        // 此时左边可能还有比右边小的数（右边指针已经到了最右侧）
        while (i<= middle) {
            temp[x++] = array[i++];
        }
        while (j<= right) {
            temp[x++] = array[j++];
        }
        // 把临时数组数据拷回原数组
        for (int k = 0; k < temp.length; k++) {
            array[left+k] = temp[k];
        }
    }
}
