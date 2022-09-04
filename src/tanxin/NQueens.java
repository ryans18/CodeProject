package tanxin;

/**
 * Author：Ryans
 * Date：Created in 2022/9/4 17:18
 * Introduction：n皇后问题
 * 再n*n的棋盘上，保证任意两个皇后都不同列，不同行，不同斜线。摆n个皇后，右多少种摆法
 */
public class NQueens {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(getNumQueens(n));
        System.out.println(Integer.MAX_VALUE + 1);
    }

    private static int getNumQueens(int n) {
        if (n == 1) {
            return 1;
        }
        int[] records = new int[n];
        return process(0, records, n);
    }

    /**
     *
     * @param i 当前来到第i行
     * @param records 已经放置皇后的列
     * @param n  n个皇后
     * @return
     */
    private static int process(int i, int[] records, int n) {
        if (i == n) {  // 当 n - 1 都已摆满皇后，这是一种
            return 1;
        }
        int result = 0;
        for (int j = 0; j < n; j++) {
            if (isCanSet(i, j, records)) {
                records[i] = j;
                result+=process(i+1, records, n);
            }
        }
        return result;
    }

    /**
     * @param i 当前行
     * @param j 遍历列
     * @param records
     * @return
     */
    private static boolean isCanSet(int i, int j, int[] records) {
        for(int k= 0; k < i; k++) {
            // 当前列 == 已经放置皇后的列|| 同斜线
            if (j == records[k] || Math.abs(i - k) == Math.abs(j - records[k])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 用位运算加速， n最大32
     * @param n
     * @return
     */
    private static int getNumQueens2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        // limit是个位信息。n后面全是1，前面全是0
        int limit = n == 32? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }

    /**
     *
     * @param limit 全是位信息
     * @param colLim  当前列的限制，为1的不能摆
     * @param leftLim  左斜线的限制，为1的不能摆
     * @param rightLim  右斜线的限制，为1的不能摆
     * @return
     */
    private static int process2(int limit, int colLim, int leftLim, int rightLim) {
        // 当所有列都限制了，此时已经摆满
        if (colLim == limit) {
            return 1;
        }
        // 能够选择皇后的位置  或位不能放皇后的位置，取反则为能放皇后的位置 // limit 截取范围内
        int pos = limit & (~(colLim | leftLim | rightLim));
        int mostRightOne = 0;
        int result = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1); // 找到最右侧的1
            pos = pos - mostRightOne;
            result += process2(
                    limit, colLim | mostRightOne,
                    (leftLim | mostRightOne) << 1,
                    (rightLim | mostRightOne) >>> 1);
        }
        return  result;
    }
}