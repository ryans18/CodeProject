package Middle.Class3;

import java.util.Arrays;

/**
 * Author：Ryans
 * Date：Created in 2022/10/1 15:50
 * Introduction：旋转一个正方形矩阵90°
 */
public class RotateMatrix {

    private static void rotateMatrix(int[][] arr) {
        // 左上角为a,b. 右下角为c,d
        int a = 0, b = 0;
        int c = arr.length - 1, d = arr[0].length - 1;
        while (a < c) {
            for (int i = 0; i < d - b; i++) {
                swap(arr, a, b + i, a + i, d, c, d - i, c - i, b);
            }
            a = a + 1;
            c = c - 1;
            b = b + 1;
            d = d - 1;
        }
    }

    private static void swap(int[][] arr, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // a,b   -> d,a
        // d,c   -> c,b
        int temp = arr[x1][y1];
        arr[x1][y1] = arr[x4][y4];
        arr[x4][y4] = arr[x3][y3];
        arr[x3][y3] = arr[x2][y2];
        arr[x2][y2] = temp;
//        int tempA = arr[x1][y1];
//        int tempB = arr[x2][y2];
//        int tempC = arr[x3][y3];
//        int tempD = arr[x4][y4];
//        arr[x1][y1] = tempD;
//        arr[x2][y2] = tempA;
//        arr[x3][y3] = tempB;
//        arr[x4][y4] = tempC;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {5, 7, 9, 2},
                {4, 3, 1, 8},
                {2, 5, 3, 7},
                {0, 9, 8, 1}
        };
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        rotateMatrix(arr);
        System.out.println("-------------------------------------");
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

}