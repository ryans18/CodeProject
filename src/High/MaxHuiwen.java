package High;

/**
 * Author：Ryans
 * Date：Created in 2022/10/15 16:26
 * Introduction：给定一个字符串，求最长回文子序列。（注：与回文字串不同，回文字串用马拉车算法）
 * 解法：范围模型：动态规划dp[i][j]表示i到j的最长回文子序列，正方形：其中下半部分为无效区域。对角线位置为i=j，值为1。dp[0][length-1]即为最长回文字串区域。
 * 倒数第二个斜线即i与i+1位置。相等即为2，不相等即为1.
 * dp[i][j]分四种情况：
 * 1：不以i开头，也不以j开头，dp[i+1][j-1],左下角
 * 2: 已i开头，不以j开头, dp[i][j-1]
 * 3：不以i开头，已j开头, dp[i+1][j]
 * 4：以i开头，以j开头，此时i，j位置必相等, dp[i+1][j-1]+2
 */
public class MaxHuiwen {

    public static void main(String[] args) {
        String s = "abd8dcbba";
        System.out.println(getMaxHuiwenSon(s.toCharArray()));
    }

    private static int getMaxHuiwenSon(char[] str) {
        int N = str.length;
        int[][] dp = new int[N][N]; // i到j之间的最长回文
        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;  // i=j时为1
        }
        for (int j = 1; j < N; j++) {
            dp[j-1][j] = str[j-1] == str[j] ? 2 : 1;
        }
        // 依赖下面的，左边的
        for (int i = N; i >= 0; i--) {
            for (int j = i + 2; j < N; j++) {
                if (str[i] == str[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i+1][j-1] + 2);
                } else {
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i+1][j], dp[i][j-1]));
                }
            }
        }
        return dp[0][N-1];
    }

}