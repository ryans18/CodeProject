package Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Ryans
 * Date : 2022/11/2
 * Introduction :
 */
public class TestHuisuIP {

    public static void main(String[] args) {
        TestHuisuIP test  = new TestHuisuIP();
        String s = "101023";
        List<String> strings = test.restoreIpAddresses(s);
        System.out.println(strings);

    }

    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        String path = "";
        backtracking(s, path, 0);
        return result;
    }

    private void backtracking(String s, String path, int start) {
        if(start == s.length() && path.split("\\.").length == 4) {
            result.add(path);
            return;
        }
        for(int i = start; i < s.length() && i <= start + 3; i++) {
            String str = s.substring(start, i + 1);
            if(path.equals("255.255.11.")) {
                System.out.println();
            }
            if(isValid(str) && path.split("\\.").length < 4) {
                //sb.append(str);
                str = path + str + (i != s.length() - 1 ? ".": "") ;
                backtracking(s, str, i + 1);
            } else {
                return;
            }
        }
    }

    private boolean isValid(String str) {
        if(str.length() == 1) {
            return true;
        } else if(str.length() > 3) {
            return false;
        } else if(str.charAt(0) == '0') {
            return false;
        } else {
            int value = Integer.valueOf(str);
            if(value > 255 || value < 0) {
                return false;
            }
            return true;
        }
    }

}
