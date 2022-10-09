package Middle.Class9;

import java.util.Map;

/**
 * Author：Ryans
 * Date：Created in 2022/10/4 22:54
 * Introduction：给一个只有0（假）、1（真）、&（与）、|（或）和^（异或）五种字符组成的字符串express，给再一个布尔值desired，返回express有多少种组合方式（加小括号），可以达到desired的结果
 */
public class ExpressionNums {

    public static void main(String[] args) {

    }

    private static int methods(String s, boolean desired) {
        char[] str = s.toCharArray();
        if (!isValid(str)) {
            return 0;
        }
        return process(str, 0, str.length - 1, desired);
    }

    // 动态规划
    private static int getMethods(String s, boolean desired) {
        char[] str = s.toCharArray();
        if (!isValid(str)) {
            return 0;
        }
        int len = str.length;
        int[][] trueMap = new int[len][len];
        int[][] falseMap = new int[len][len];
        // 对角线位置。
        for (int i = 0; i < len; i += 2) {
            trueMap[i][i] = str[i] == '1' ? 1 : 0;
            falseMap[i][i] = str[i] == '0' ? 0 : 1;
        }
        // N-1 位置为对角线，已经填了，N-2不用填
        for (int row = len - 3; row >= 0; row -= 2) {
            for (int col = row + 2; col < len; col += 2) {  // col不能小于row，col等于row已经填了，col+1为符号位不用填
                for (int i = row + 1; i < col; i += 2) {
                    switch (str[i]) {
                        case '&':
                            trueMap[row][col] += trueMap[row][i - 1] * trueMap[i + 1][col];
                            break;
                        case '|':
                            trueMap[row][col] = trueMap[row][i - 1];
                    }
                }
            }
        }
        return desired ? trueMap[0][len - 1] : falseMap[0][len - 1];
    }

    private static int process(char[] str, int L, int R,  boolean desired) {
        if (L == R) {
            if (str[L] == '1') {
                return desired ? 1 : 0;
            } else {
                return desired ? 0 : 1;   // 需要返回false， 且当前位置是0，有1种方法。
            }
        }
        int res = 0;
        if (desired) {
            // 遍历每一个符号
            for (int i = L + 1; i < str.length; i += 2) {
                switch (str[i]) {
                    case '&':
                        res += process(str, L, i - 1, true) * process(str, i + 1, R, true);
                        break;
                    case '|':
                        res += process(str, L, i - 1, true) * process(str, i + 1, R, true);
                        res += process(str, L, i - 1, true) * process(str, i + 1, R, false);
                        res += process(str, L, i - 1, false) * process(str, i + 1, R, true);
                        break;
                    case '^': // 异或，两个不同返回true
                        res += process(str, L, i - 1, true) * process(str, i + 1, R, false);
                        res += process(str, L, i - 1, false) * process(str, i + 1, R, true);
                        break;
                }
            }
        } else {
            for (int i = L + 1; i < str.length; i += 2) {
                switch (str[i]) {
                    case '&':
                        res += process(str, L, i - 1, true) * process(str, i + 1, R, false);
                        res += process(str, L, i - 1, false) * process(str, i + 1, R, true);
                        break;
                    case '|': // 俩个都为false
                        res += process(str, L, i - 1, false) * process(str, i + 1, R, false);
                        break;
                    case '^':
                        res += process(str, L, i - 1, true) * process(str, i + 1, R, true);
                        res += process(str, L, i - 1, true) * process(str, i + 1, R, false);
                        break;
                }
            }
        }
        return res;
    }

    private static boolean isValid(char[] chars) {
        // 0&1|0^1
        // 长度为奇数
        if (chars.length % 2 == 0) {
            return false;
        }
        // 0，2，4位位0或1
        for (int i = 0; i < chars.length; i += 2) {
            if (chars[i] != '0' && chars[i] != '1') {
                return false;
            }
        }
        for (int i = 1; i < chars.length; i += 2) {
            if (chars[i] != '&' && chars[i] != '|' && chars[i] != '^') {
                return false;
            }
        }
        return true;
    }

}