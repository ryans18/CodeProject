package DiGui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author : Ryans
 * Date : 2022/9/14
 * Introduction : n皇后问题
 */
public class NQueen {

    public static void main(String[] args) {
        getQueens(4);
    }

    private static List<List<String>> result = new ArrayList<>();
    public static void getQueens(int n) {
        int limit = 1 << n;
        char[][] chars = new char[n][n];
        for (char[] aChar : chars) {
            Arrays.fill(aChar, '.');
        }
        backtrack(chars, n, 0);
        System.out.println(result);
    }

    private static void backtrack(char[][] chars, int n,  int row) {
        if (row >= chars.length) {
            List<String> list = new ArrayList<>();
            for (char[] aChar : chars) {
                list.add(String.copyValueOf(aChar));
            }
            result.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(chars, row, i)) {
                chars[row][i] = 'Q';
                backtrack(chars, n, row + 1);
                chars[row][i] = '.';
            }
        }
    }

    private static boolean isValid(char[][] chars, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (chars[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) { // 45
            if (chars[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < chars[0].length; i--, j++) { // 135
            if (chars[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private static void getQueen2(int n) {
        int limit = 1 << n;
        process(limit, 0, 0, 0);
    }

    private static List<String> result2 = new ArrayList<>();
    private static void process(int limit, int colLim, int leftLim, int rightLim) {
        if (colLim == limit) {
            return;
        }
        // 能够选取的点
        int pos = limit & (~(colLim | leftLim | rightLim));
        int mostRightOne = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1); /// 找到最右侧为1的点
            pos = pos - mostRightOne;
            process(limit,
                    colLim | mostRightOne,
                    (leftLim | mostRightOne) << 1,
                    (rightLim >> mostRightOne) >>> 1);
        }

    }
}
