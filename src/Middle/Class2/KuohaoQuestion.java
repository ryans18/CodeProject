package Middle.Class2;

/**
 * Author : Ryans
 * Date : 2022/9/30
 * Introduction : 完整的括号字符串：有一个括号字符串S，现在需要在其中任意位置尽量少的添加括号，将其转化为一个完整的括号字符串。请问至少需要多少个括号
 */
public class KuohaoQuestion {

    private static int minCount(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        int leftRemains = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                count++;
            } else {
                if (count == 0) { // 已经减到0了。 此时还差左括号
                    leftRemains++;
                } else {
                    count--;
                }
            }
        }
        return leftRemains + count;
    }

    public static void main(String[] args) {
        String s = "(()()(()(())(()))(";
        String s2 = "((";
        System.out.println(minCount(s));
    }
}
