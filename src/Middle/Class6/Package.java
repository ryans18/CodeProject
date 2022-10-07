package Middle.Class6;

/**
 * Author：Ryans
 * Date：Created in 2022/10/3 16:39
 * Introduction：牛牛准备参加学校组织的春游, 出发前牛牛准备往背包里装入一些零食, 牛牛的背包容量为w。
 *
 * 牛牛家里一共有n袋零食, 第i袋零食体积为v[i]。
 *
 * 牛牛想知道在总体积不超过背包容量的情况下,他一共有多少种零食放法(总体积为0也算一种放法)。
 *  背包问题
 */
public class Package {

    /**
     * input1: 3 10
     * input2: 1 2 4
     * output: 8
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 4};
        hasMethodInPackage(3, 28, arr);
    }

    private static void hasMethodInPackage(int nums, int weight, int[] arr) {
        System.out.println(process(arr, 0, weight));
        System.out.println(getMethods(arr, weight));
    }

    private static int process(int[] arr, int index, int remains) {
        if (remains < 0) {
            return 0;
        }
        if (index == arr.length) {
            return 1;
        }
        // 放这个零食，剩下remains - arr[index] 与不放这个零食，剩下remains
        return process(arr, index + 1, remains - arr[index]) + process(arr, index + 1, remains);
    }

    /**
     * 初始化：
     * 首列：背包容量为0，说明么都不用放，可能性始终为1
     * 末行：背包容量最后一个物品体积时，放或不放，可能性为2。
     * 其余dp[i][j]:
     * 当剩余容量 < 小于当前物品体积时，不放入背包，可能性为dp[i+1][j]。
     * 当剩余容量 > 小于当前物品体积时，放入或者不放入，可能性相加：dp[i+1][j] + dp[i+1][ j-arr[i] ];
     * @param arr
     * @param w
     * @return
     */
    private static int getMethods(int[] arr, int w) {
        int[][] dp = new int[arr.length][w + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= w; j++) {
            dp[arr.length - 1][j] = 1;// 不放也是一种方法
            if (arr[arr.length - 1] < j) {
                dp[arr.length - 1][j]++;
            }
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = 1; j <= w; j++) {
                int pre = j - arr[i];
                pre = Math.max(pre, 0);  // 边界处理
                dp[i][j] = dp[i+1][j] + dp[i + 1][pre];
            }
        }
        return dp[0][w];
    }
}