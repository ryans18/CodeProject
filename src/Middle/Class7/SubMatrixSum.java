package Middle.Class7;

/**
 * Author : Ryans
 * Date : 2022/10/10
 * Introduction : 子矩阵最大累加和
 *  思路：由之前的数组最大累加和。 一行一行的求， 第二行 + 第一行组成一个新的行。 第三行+第二行组成一个新的行
 */
public class SubMatrixSum {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {-2, 4, 6, -5, 8, 3},
                {5, 3, -4, -2, 6, 1},
                {9, 0, 4, 3, 2, -1},
                {8, 1, -7, -5, 4, 5},
        };
        System.out.println(subMatrixSumMax(matrix));
    }

    private static int subMatrixSumMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int[] arr = new int[matrix[0].length];
            extracted(matrix, matrix[i], arr);
            max = Math.max(max, getSubArraySumMax(arr));
            for (int j = i + 1; j < matrix.length; j++) {
                extracted(matrix, matrix[j], arr);
                max = Math.max(max, getSubArraySumMax(arr));
                if (max == 46) {
                    System.out.println();
                }
            }
        }
        return max;
    }

    private static void extracted(int[][] matrix, int[] matrix1, int[] arr) {
        for (int col = 0; col < matrix[0].length; col++) {
            arr[col] += matrix1[col];
        }
    }


    private static int getSubArraySumMax(int[] arr) {
        int curSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];
            max = Math.max(max, curSum);
            curSum = curSum < 0 ? 0 : curSum;
        }
        return max;
    }
}
