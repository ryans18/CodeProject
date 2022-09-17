package DiGui;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Author : Ryans
 * Date : 2022/9/13
 * Introduction : 切割字符串使其形成回温字符串
 */
public class HuiWenStr {

    public static void main(String[] args) {
        String str = "aabbc";
        backtracking(str, 0);
        System.out.println(result);
    }

    private static List<List<String>> result = new ArrayList<>();
    private static LinkedList<String> path = new LinkedList<>();
    private static void backtracking(String str, int startIndex) {
        if (startIndex >= str.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < str.length(); i++) {
            if (isHuiWen(str, startIndex, i)) {
                path.add(str.substring(startIndex, i + 1));
            } else {
                continue;
            }
            backtracking(str, 0);
            path.removeLast();
        }
    }

    private static boolean isHuiWen(String str, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
