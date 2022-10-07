package Middle.Class9;

/**
 * Author：Ryans
 * Date：Created in 2022/10/5 14:18
 * Introduction：编辑字符串问题，str1与str2两个字符串，str1可通过str2添加，删除，替换，拷贝操作变成。每种操作代价不同，求最小代价
 */
public class EditStrs {

    public static void main(String[] args) {
        int cost = getMinCost("abd", "adc", 5, 3, 100);
        System.out.println(cost);
    }

    private static int minCost(String str1, String str2, int addCost, int delCost, int replaceCost) {
        if (str1.equals(str2)) {
            return 0;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        return process(chars1, chars2, addCost, delCost, replaceCost, chars1.length - 1, chars2.length - 1);
    }

    private static int process(char[] str1, char[] str2, int addCost, int delCost, int reCost, int index1, int index2) {
        if (str1[index1] == str2[index2]) {
            return 0;
        }
        // 此时i - 1 位置已经相等了。
        int p1 = process(str1, str2, addCost, delCost, reCost, index1,  index2 - 1) + addCost;
        int p2 = process(str1, str2, addCost, delCost, reCost, index1, index2) + delCost;
        int p3 = process(str1, str2, addCost, delCost, reCost, index1, index2) + reCost;
        return Math.min(p1, Math.min(p2, p3));
    }

    // 动态规划
    private static int getMinCost(String s1, String s2, int addCost, int delCost, int reCost ) {
        if (s1.equals(s2)) {
            return 0;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[][] dp = new int[str2.length + 1][ str1.length + 1];
        for (int j = 1; j < str1.length; j++) {
            dp[0][j] = addCost * j;
        }
        for (int i = 1; i < str2.length; i++) {
            dp[i][0] = delCost * i;
        }
        // 每个格子跟自己上面和左面有关
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                if (str1[i - 1] == str2[j - 1]) {  // 如果i - 1 已经等于j - 1了，前面已经不用动了。
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + reCost;  // i - 1变成 j - 1, 然后替换最后一位。
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + addCost); // 我先变成j - 1，然后再加一位
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + delCost); // i - 1 变成j，然后我再删掉最后一位
            }
        }
        return dp[str2.length - 1][str1.length - 1];
    }
}