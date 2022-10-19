package High;

/**
 * Author：Ryans
 * Date：Created in 2022/10/15 15:01
 * Introduction：给定两个字符串str1和str2，求两个字符串的最长公共子序列
 */
public class StringSonXulie {

    public static void main(String[] args) {
        String s1 = "fabgyafaoc";
        String s2 = "dabaface";
        System.out.println(getMaxSonXulieDp(s1.toCharArray(), s2.toCharArray()));
    }

    // 以i结尾，以j结尾 dp[i-1][j-1]+1  左上角
    // 以i结尾，不以j结尾 dp[i][j-1]  左
    // 不以i结尾，以i结尾 dp[i-1][j]  上
    // 不以i结尾，不以j结尾 dp[i-1][j-1] 左上角
    private static int getMaxSonXulieDp(char[] str1, char[] str2) {
        int max = Integer.MIN_VALUE;
        int M = str1.length;
        int N = str2.length;
        int[][] dp = new int[M][N]; // 以i，j结尾的最大公共子序列长度
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
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], dp[i][j-1]));
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}