package High;

/**
 * Author：Ryans
 * Date：Created in 2022/10/15 15:01
 * Introduction：给定两个字符串str1和str2，求两个字符串的最长公共子串
 */
public class StringSon {
    public static void main(String[] args) {
        String s1 = "abafabag";
        String s2 = "bgabafced";

    }

    // 拿到dp问题，先分析可能性
    // 1. 以i结尾，以j结尾(前提：i和j相等) dp[i-1][j-1] + 1;
    // 2. 以i结尾，不以j结尾    dp[i][j-1]
    // 3. 不以i结尾，以j结尾    dp[i-1][j]
    // 4. 不以i结尾，不以j结尾
    private static int getMaxLengthDp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        return dp[str1.length-1][str2.length-1];
    }
}