package Middle.Class9;

import java.util.Arrays;

/**
 * Author：Ryans
 * Date：Created in 2022/10/6 18:38
 * Introduction：给定 n 种物品和一个容量为 bag的背包，物品 i 的重量是 weights[i]，其价值为 values[i] ———————01背包问题
 * 问：应该如何选择装入背包的物品，使得装入背包中的物品的总价值最大？
 */
public class Package01 {

    public static void main(String[] args) {
        int bag = 10;
        int[] weights = new int[] {2, 2, 6, 5, 4};
        int[] values = {1, 3, 5, 4, 6};
//        System.out.println(packageMoreValue(bag, weights, values));
//        System.out.println(getMaxValue(bag, weights, values));
        System.out.println(getMaxValue2(bag, weights, values));
    }

    private static int packageMoreValue(int bag, int[] weights, int[] values){
        return process(bag, weights, values, 0, 0, 0);
    }

    private static int process(int bag, int[] weights, int[] values, int index, int curWeight, int curValue) {
        if (curWeight == bag) {
            return curValue;
        }
        if (curWeight > bag) {
            return Integer.MIN_VALUE;
        }
        if (index == weights.length) {
            return curValue;
        }
        // 千万不能用index++，会停在原地
        int p1 = process(bag, weights, values, index + 1, curWeight, curValue);
        int p2 = process(bag, weights, values, index + 1, curWeight + weights[index], curValue+ values[index]) ;
        return Math.max(p1, p2);
    }

    private static int getMaxValue(int bag, int[] weights, int[] values) {
        int[][] dp = new int[weights.length][bag + 1];
        for (int j = 0; j <= bag; j++) {
            if (j >= weights[0]) {
                dp[0][j] = values[0];
            }
        }
        for(int i = 1; i < weights.length; i++) { // 遍历物品
            for(int j = 0; j <= bag; j++) { // 遍历背包容量
                if (j < weights[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }
        return dp[weights.length - 1][bag];
        /*int[][] dp = new int[weights.length + 1][bag + 1];
        // 物品多一行，可解决第一行初始化问题
        for(int i = 1; i <= weights.length; i++) { // 遍历物品
            for(int j = 0; j <= bag; j++) { // 遍历背包容量
                if (j < weights[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[weights.length][bag];*/
    }

    // 一维数组，滚动数组
    private static int getMaxValue2(int bag, int[] weights, int[] values) {
        int[] dp = new int[bag + 1];
        int[] dp2 = new int[bag + 1];
        for (int i = 0; i < weights.length; i++) {
            for (int j = bag; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
            System.out.println("dp: " + Arrays.toString(dp));
        }
        System.out.println("_____________________");
        for (int j = bag; j >= 0; j--) {
            for (int i = 0; i < weights.length; i++) {
                if(j >= weights[i]) {
                    dp2[j] = Math.max(dp2[j], dp2[j - weights[i]] + values[i]);
                }
            }
            System.out.println("dp2: " + Arrays.toString(dp2));
        }
        return dp[bag];
    }
}