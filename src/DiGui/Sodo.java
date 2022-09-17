package DiGui;

/**
 * Author : Ryans
 * Date : 2022/9/14
 * Introduction : 数独问题
 */
public class Sodo {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        backtrack(board);
        System.out.println(board);
    }

    public void solveSudoku(char[][] board) {

    }

    private static boolean backtrack(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                try {
                    if (board[row][col] != '.') {
                        continue;
                    }
                } catch (Exception exception) {
                    System.out.println(row+"-" +col);
                    exception.printStackTrace();
                }
                for (char c = '1'; c <= '9'; c++) {
                    if (isValid(c, board, row, col)) {
                        board[row][col] = c;
                        if (backtrack(board)) {
                            return true;
                        }
                        board[row][col] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(char c, char[][] board, int row, int col) {
        for (int i = 0; i < board[0].length && i != col; i++) { // 校验同行
            if (board[row][i] == c) {
                return false;
            }
        }
        for (int i = 0; i < board.length && i != row; i++) {    // 校验同列
            if (board[i][col] == c) {
                return false;
            }
        }
        // 校验 3 * 3；
        // 1,1 -> (0,2), (0,2). 4,5 -> 3,5, 3,5, 。 7,8 -> 6, 8, 6, 8
        int rowStart = row / 3 * 3;
        int colStart = col / 3 * 3;
        for (int i = rowStart; i <= rowStart + 2; i++) {
            for (int j = colStart; j <= colStart + 2; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}
