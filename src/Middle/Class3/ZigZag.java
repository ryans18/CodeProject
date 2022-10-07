package Middle.Class3;

/**
 * Author：Ryans
 * Date：Created in 2022/10/1 17:42
 * Introduction：打印一个二维数组成蛇形
 * a,b两个点起始在0，0位置，a向右走，b向下走，打印a，b之间的所有点。a走到右边边界了，a向下走。b走到下方边界了，b向上走
 */
public class ZigZag {

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {2, 5, 7, 3, 5, 8},
                {4, 6, 2, 7, 1, 0},
                {3, 5, 7, 2, 4, 1},
                {4, 5, 2, 1, 8, 7}
        };
        zigZag(arr);
    }

    private static void zigZag(int[][] arr) {
        int aX = 0, aY = 0;
        int bX = 0, bY = 0;
        boolean flag = false;
        int endX = arr.length - 1;
        int endY = arr[0].length - 1;
        while (aX != endX + 1) {
            printPoints(arr, aX, aY, bX, bY, flag);
            aX = aY == endY ? aX + 1 : aX;  // 0, 0, 0, 1
            aY = aY == endY ? aY : aY + 1;  // 0, 1, 2, 4
            bX = bX == endX ? bX : bX + 1;  // 0, 1, 2, 3, 3
            // 先 Y后X。 原因：当X = endX - 1时。此时 bX ！= end， bX + 1；导致下面bY会判断到头了，从而增加Y，
            // 下一次循环又会判断会导致y加2次
            bY = bX == endX ? bY + 1 : bY;  // 0, 0, 0, 4
            flag = !flag;
        }
    }
    private static void printPoints(int[][] arr, int aX, int aY, int bX, int bY, boolean flag) {
        if (flag) {
            // 从下往上打
            while (aX != bX + 1) {
                System.out.print(arr[aX++][aY--] + "\t");
            }
        } else {
            while (bX != aX - 1) {
                System.out.print(arr[bX--][bY++] + "\t");
            }
        }
    }
    public static void printMatrixZigzag(int[][] matrix){
        int ar = 0;
        int ac = 0;
        int br = 0;
        int bc = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while(ar != endR + 1){
            printPoints(matrix, ar, ac, br, bc, fromUp);
            ar = ac == endC ? ar + 1 : ar;
            ac = ac == endC ? ac : ac + 1;
            bc = br == endR ? bc + 1 : bc;
            br = br == endR ? br : br + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    public static void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean f){
        if(f){
            while(tR != dR + 1){
                System.out.print(m[tR++][tC--] + " ");
            }
        }else{
            while(dR != tR - 1){
                System.out.print(m[dR--][dC++] + " ");
            }
        }

    }

}