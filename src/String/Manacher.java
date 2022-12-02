package String;

/**
 * Author：Ryans
 * Date：Created in 2022/9/18 16:26
 * Introduction：马拉车算法，解决回文字符串问题。时间复杂度为O(N)，比暴力for循环内部判断是否为回文O(N²)更好
 * 利用一个中心和半径跳加快速率。
 */
public class Manacher {
    public static void main(String[] args) {
        String s = "fafauonbauabopmab";
        System.out.println(getMaxHuiwen(s));
    }

    private static String getMaxHuiwen(String s) {
        // 将奇数和偶数都变为奇数，2n+1
        char[] str = manacherStr(s);
        int[] arr = new int[str.length];  // 回文半径数组, 回文半径是包含中心点的，所有最小为1.
        int C = -1;   // 回文中心
        int R = -1;  // 右侧区域， 回文边界+1位置。
        int max = 0;  // 最大回文半径
        int maxC = 0;  // 最大回文半径时的中心
        // for循环找到一个更右的区域
        // 不用验的区域， 需要验证的区域则由下面的while处理
        // 1. i 在R外面，需要暴力左右验证。不用验证的只有自己
        // 2. i 在R内，i`在R的左边界内，那么i的位置的半径与i`的半径相等。————arr[2 * C - i]。此时半径必小于R-i。
        // 3. i 在R内，i`(i在左边堆成的点)的回文半径在R左边界的外面。那么i位置的半径到右边界R。———— R - i。此时arr[2 * C - i] = R - i
        // 4. i 在R内，i`与R的左边界对齐，那么i位置的半径必在R右边界外边或者与有边界对其。————arr[2 * C - i] = R - i。右边还有
        for (int i = 0; i < str.length; i++) {
            arr[i] = R > i ? Math.min(arr[2 * C - i], R - i) : 1; // 不用验证的区域
            while (i + arr[i] < arr.length && i - arr[i] > -1) {
                if (str[i + arr[i]] == str[i - arr[i]]) {
                    arr[i]++;
                } else {
                    break;
                }
            }
            if (i + arr[i] > R) {
                R = i + arr[i];
                C = i;
            }
            if (arr[i] > max) {
                max = arr[i];
                maxC = i;
            }
        }
        // max - 1即为回文长度 加入了特殊字符#，最终求回文字符串的长度。需要回文半径 - 1
        char[] result = new char[max - 1];
        int index = 0;
        for (int i = maxC - max + 2; i <= maxC + max - 2; i+=2 ) {
            result[index++] = str[i];
        }
        return new String(result);
    }

    private static char[] manacherStr(String s) {
        char[] chars = s.toCharArray();
        char[] str = new char[2 * chars.length + 1];
        int index = 0;
        for (int i = 0; i < str.length; i++) {
            str[i] = (i & 1) == 0 ? '#' : chars[index++];
        }
        return str;
    }
}
