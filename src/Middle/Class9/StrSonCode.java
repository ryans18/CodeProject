package Middle.Class9;

/**
 * Author：Ryans
 * Date：Created in 2022/10/5 20:51
 * Introduction：子序列编码a,b,c,d,e....z   子序列可以不连续
 * a为1，b为2，ab为27，。。。az， bc，bd
 */
public class StrSonCode {

    public static void main(String[] args) {
//        getIndex("a");
//        System.out.println(g(1, 2));
        getIndex("bd");
    }

    private static int getIndex(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        int sum = 0;
        // 计算长度为chars的len之前的
        for (int i = 1; i < len; i++) {
            sum += f(i);
        }
        int first = chars[0] - 'a' + 1;

        // 首位之前的
        for (int i = 1; i < first; i++) {
            sum += g(i, len);
        }
        int pre = first;
        // bcd.
        // 计算 以a开头长度为3的、c开头 。 pre：考虑第一位，后面的要从b的后面开始。而第一位得从1开始
        for (int i = 1; i < len; i++) {
            int cur = chars[i] - 'a' + 1;
            for (int j = pre + 1; j < cur; j++) {
                sum += g(j, chars.length - i);
            }
            pre = cur;
        }
        System.out.println(sum);
        return  sum;
    }


    // 返回以i为开头，长度为len有多少个字符
    private static int g(int i, int len) {
        int sum = 0;
        if (len == 1) {
            return 1;
        }
        for (int j = i + 1; j <= 26; j++) {
            sum += g(j, len - 1);
        }
        return sum;
    }

    // 长度为len的子序列有多少个
    private static int f(int len) {
        int sum = 0;
        for (int i = 1; i <= 26; i++) {
            sum += g(i, len);
        }
        return sum;
    }

}