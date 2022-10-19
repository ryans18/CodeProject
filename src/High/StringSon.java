package High;

/**
 * Author：Ryans
 * Date：Created in 2022/10/15 15:01
 * Introduction：给定两个字符串str1和str2，求两个字符串的最长公共子串
 *  应用：动态规划空间压缩技巧，有限几个变量
 */
public class StringSon {
    public static void main(String[] args) {
        String s1 = "abafabag";
        String s2 = "bgabafaced";
        System.out.println(getMaxLengthDp(s1.toCharArray(), s2.toCharArray()));
        System.out.println(getMaxLength(s1.toCharArray(), s2.toCharArray()));
    }

    // 拿到dp问题，先分析可能性
    // dp[i][j] str1的子串必须以i位置结尾，str2的子串必须以j位置结尾，最长公共子串的长度
    // 初始化：第一行、第一列相等就是1， 不等就是0
    // 1. i和j不等的话，直接为0
    // 2. 相等的话：dp[i-1][j-1]+1 ——>只依赖左上角的值
    private static int getMaxLengthDp(char[] str1, char[] str2) {
        int M = str1.length;
        int N = str2.length;;
        int[][] dp = new int[M][N];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            if (str1[i] == str2[0]) {
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j < N; j++) {
            if (str1[0] == str2[j]) {
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    // 根据上面，只与左上角有关，那我们从左下角斜线开始。 row先从M-1开始--，col先从0开始不变。到左上角后。row为0不变，col递增
    private static int getMaxLength(char[] str1, char[] str2) {
        int len1 = str1.length;;
        int len2 = str2.length;
        int max = 0;
        int row = len1 - 1;
        int col = 0;
        while (row != 0 || col != len2 - 1) {
            int i = row;
            int j = col;
            int pre = 0;
            // 遍历从坐上到右下的过程
            while (i < len1 && j < len2) {
                if (str1[i] == str2[j]) {
                    pre++;
                    max = Math.max(max, pre);
                } else {
                    pre = 0;
                }
                i++;
                j++;
            }
            if (row > 0) {
                row--;
            } else {
                col++;
            }
        }
        return max;
    }
}