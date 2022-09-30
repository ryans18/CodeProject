package Middle.Class1;

/**
 * Author : Ryans
 * Date : 2022/9/28
 * Introduction : 给定一个N*N的矩阵，只有0和1两种值，返回边框全是1的最大正方形的边长长度
 *  技巧：预处理. 思路，找到右侧连续的1的个数与下方连续的1的个数，若两个相等则
 */
public class SquareQuestion {

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1, 0, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1},
        };
        System.out.println(getMaxSquareBorder(arr));
    }

    private static int getMaxSquareBorder(int[][] arr) {
        int max = Integer.MIN_VALUE;
        int[][] rightArray = getRightArray(arr);
        int[][] downArray = getDownArray(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr[i].length - 1; j >= 0; j--) {
                if (rightArray[i][j] != 0 &&  downArray[i][j] != 0) {
                    int border = Math.min(rightArray[i][j], downArray[i][j]);
                    max = Math.max(max, border);
                }
            }
        }
        return max;
    }

    private static int[][] getRightArray(int[][] arr) {
        int[][] rightArray = new int[arr.length][arr[0].length];
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr[i].length - 1; j >= 0; j--) {
                int pre = 0;
                if (j + 1 < arr[i].length) {
                    pre = rightArray[i][j + 1];
                }
                if (arr[i][j] == 1) {
                    rightArray[i][j] = pre + 1;
                } else {
                    rightArray[i][j] = 0;
                }
            }
        }
        return rightArray;
    }
    private static int[][] getDownArray(int[][] arr) {
        int[][] downArray = new int[arr.length][arr[0].length];
        for (int j = arr[0].length - 1; j >= 0; j--) {
            for (int i = arr.length - 1; i >= 0; i--) {
                int pre = 0;
                if (i + 1 < arr.length) {
                    pre = downArray[i + 1][j];
                }
                if (arr[i][j] == 1) {
                    downArray[i][j] = pre + 1;
                } else {
                    downArray[i][j] = 0;
                }
            }
        }
        return downArray;
    }
}
