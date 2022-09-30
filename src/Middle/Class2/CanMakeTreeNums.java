package Middle.Class2;

/**
 * Author : Ryans
 * Date : 2022/9/29
 * Introduction : 给定一个整数n，代表二叉树的节点个数，返回能形成多少种不同的二叉树结构
 */
public class CanMakeTreeNums {

    private static int process(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0 || n == 1) {  // 没有节点，形成1种，空数
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int res = 0;
        for (int leftNums = 0; leftNums <= n - 1; leftNums++) {
            int leftWays = process(leftNums);
            int rightWays = process(n - leftNums - 1);
            res += leftWays * rightWays;
        }
        return res;
    }


    // 动态规划
    private static int numsOfTree(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {  // 节点数位i的时候
            for (int j = 0; j <= i - 1; j++) {  // j位左边的个数，那么右边的个数为i-j-1
               dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(process(4));
    }
}
