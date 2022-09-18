package String;

import java.util.Arrays;

/**
 * Author：Ryans
 * Date：Created in 2022/9/17 18:34
 * Introduction：KMP算法。解决类似indexOf的问题
 *
 */
public class KMP {

    public static void main(String[] args) {
//        String a = "faafa234559j";
//        String b = "a234";
//        System.out.println(indexOf(a, b));
        String num = "abaajifsabaabs";
        System.out.println(Arrays.toString(getNextArray(num.toCharArray())));
    }

    private static int indexOf(String a, String b) { // length : N M
        if (a.length() < b.length()) {
            return -1;
        }
        char[] chars1 = a.toCharArray();
        char[] chars2 = b.toCharArray();
        int index1 = 0;
        int index2 = 0;
        int[] nums = getMaxPreLengthArray(chars2); // O(M)
        while (index1 < chars1.length && index2 < chars2.length) { // O(N)
            if (chars1[index1] == chars2[index2]) {
                index1++;
                index2++;
            } else if (index2 == 0) {
                index1 = index1 + 1;
            } else {
                index2 = nums[index2];
            }
        }
        // 跳出循环，index1或者index2越界
        // 如果index2没到str2的长度，说明数组1越界，没查完
        return index2 == chars2.length ? index1 - index2 : -1;
    }

    // 自己写的，时间复杂度很高
    private static int[] getMaxPreLengthArray(char[] chars) {
        int[] nums = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                nums[i] = -1;
            } else if (i == 1) {
                nums[i] = 0;
            } else {
                int index1 = 0;
                int index2 = i - 1;
                while (index1 < index2 && chars[index1] == chars[index2]) {
                    index1++;
                    index2--;
                }
                nums[i] = index1;
            }
        }
        return nums;
    }

    private static int[] getNextArray(char[] chars) {
        int[] nums = new int[chars.length];
        nums[0] = -1;
        if (chars.length > 1) {
            nums[1] = 0;
            int index = 2;
            int compare = 0;
            while (index < chars.length) {
                if (chars[index - 1] == chars[compare]) { // 相等
                    nums[index++] = ++compare;
                } else if (compare > 0) {   // 不相等
                    compare = nums[compare];  // 匹配不上，就继续匹配这个数的前缀数。往前跳
                } else {   // 不相等 compare = 0   到头了，都没找到，则为0
                    nums[index++] = 0;
                }
            }
        }
        return nums;
    }
}