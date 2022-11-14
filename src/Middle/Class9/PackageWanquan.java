package Middle.Class9;

import java.util.Arrays;

/**
 * Author : Ryans
 * Date : 2022/11/14
 * Introduction : 完全背包问题，与01背包区别，每个物品可以放无数次
 */
public class PackageWanquan {

    public static void main(String[] args) {
        int[] weights = new int[] {3, 4, 1};
        int[] values = new int[] {20, 30, 15};
        int output = 12;
        System.out.println(getMaxValue(weights, values, 4));
//        System.out.println(testCompletePack(weights, values, 4));
        System.out.println(getMaxValue2(weights, values, 4));
    }

    // 二维数组, 完全背包要考虑同一行的值；
    private static int getMaxValue(int[] weights, int[] values, int bag) {
        int len = weights.length;
        int[][] dp = new int[len][bag + 1];
        // 初始化第一行

        for (int j = 1; j <= bag; j++) {
            for (int i = 0; i < len; i++) {
                // 先把上一行的值copy下来
                if (i > 0) {
                    dp[i][j] = dp[i-1][j];
                }
                // 处理同行问题。
                if (j - weights[i] >= 0) {  // 放得下， 放0次，1次。。。
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - weights[i]] + values[i]);
                }

            }
        }
//        for (int i = 0; i < len; i++) {
//            for (int j = 1; j <= bag; j++) {
//                // 先把上一行的值copy下来
//                if (i > 0) {
//                    dp[i][j] = dp[i-1][j];
//                }
//                // 处理同行问题。
//                if (j - weights[i] >= 0) {  // 放得下， 放0次，1次。。。
//                    dp[i][j] = Math.max(dp[i][j], dp[i][j - weights[i]] + values[i]);
//                }
//
//            }
//        }
//        for(int i = 0; i < len; i++) {
//            System.out.print("\n");
//            for (int j = 0; j <= bag; j++) {
//                System.out.print(dp[i][j] + "\t");
//            }
//        }
        return dp[len - 1][bag];
    }

    // 一维数组，压缩空间.
    private static int getMaxValue2(int[] weights, int[] values, int bag) {
        int[] dp = new int[bag + 1];
        int[] dp2 = new int[bag + 1];
        for (int i = 0; i < weights.length; i++) {
            // 与0-1背包不同的是，这里是从小到大遍历，从而使得物品被添加多次。如 j==2*weight[i]时，dp[j-weight[i]] 即为value[i]的值。这里就相当于算了两次
            for (int j = weights[i]; j <= bag ; j++) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
            System.out.println(Arrays.toString(dp));
        }

        System.out.println("_______________________");
        // 先遍历背包容量，后遍历物品
        for (int j = 1; j <= bag ; j++) {
            for (int i = 0; i < weights.length; i++) {
                if (j >= weights[i]) {
                    dp2[j] = Math.max(dp2[j], dp2[j - weights[i]] + values[i]);
                }
            }
            System.out.println(Arrays.toString(dp2));
        }

        return dp[bag];
    }
}
