package DiGui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author : Ryans
 * Date : 2022/9/13
 * Introduction : 复原ip地址
 */
public class IPStr {
    public static void main(String[] args) {
//        String s = "25525511135";
        String s = "101023";
        backtracking(s, 0);
        System.out.println(result);
    }

    private static List<String> result = new ArrayList<>();
    private static LinkedList<String> path = new LinkedList<>();
    private static void backtracking(String str, int startIndex) {
        if (startIndex >= str.length()) {
            String s = "";
            for (int i = 0; i < path.size(); i++) {
                if (i != path.size() - 1) {
                    s += path.get(i) + ".";
                } else {
                    s += path.get(i);
                }
            }
            result.add(s);
            return;
        }
        for (int i = startIndex; i < str.length() && i <= startIndex + 3; i++) {
            if (isIpStr(str.substring(startIndex, i + 1)) && path.size() < 4) {
                path.add(str.substring(startIndex, i + 1));
            } else {
                break;
            }
            backtracking(str, i + 1);
            path.removeLast();
        }
    }

    private static boolean isIpStr(String str) {
        if (str.startsWith("0") && str.length() > 1) {
            return false;
        }
        int num = Integer.parseInt(str);
        return num <= 255;
    }
}
