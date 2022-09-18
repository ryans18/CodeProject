package Digui;

/**
 * Author：Ryans
 * Date：Created in 2022/9/16 21:46
 * Introduction：岛屿问题，给一个二维数组，求有几个岛屿，上下左右连成一片为一个岛。————1个也算岛屿
 * 使用并行算法优化。 假设两个服务器。把数组从中间(col)分成两块, 两个cpu分别计算左右两边的岛屿数量。
 * 然后求左边所有岛屿的右边界，右边岛屿的左边界，如果是同行，说明联通，使用并查集判断是否为同一集合，如果不是同一集合
 * 合并两集合，并使岛屿数量减1。
 */
public class Island {
    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1, 0, 1, 0, 1, 1},
                {0, 0, 1, 1, 0, 1},
                {0, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 0, 1}
        };
        System.out.println(getLands(arr));
        String a = "fafa1234";
        String b = "1234";
        System.out.println(a.contains(b));
        a.indexOf(b);
    }

    private static int getLands(int[][] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
               if (arr[i][j] == 1) {
                   result++;
                   infect(arr, i, j, arr.length, arr[0].length);
               }
            }
        }
        return result;
    }

    private static void infect(int[][] arr, int i, int j, int rowLen, int colLen) {
        if (i < 0 || i >= rowLen || j < 0 || j >= colLen || arr[i][j] != 1) {
            return;
        }
        arr[i][j] = 2;
        infect(arr, i + 1, j, rowLen, colLen);
        infect(arr, i, j + 1, rowLen, colLen);
        infect(arr, i - 1, j, rowLen, colLen);
        infect(arr, i, j - 1, rowLen, colLen);
    }
}