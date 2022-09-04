package tanxin;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author：Ryans
 * Date：Created in 2022/9/4 14:54
 * Introduction：字符拼接最小连接序
 */
public class StringUnion {

    public static void main(String[] args) {
        String[] strings = new String[] {
          "acg","fah","otes","fawq","hafaz", "yzss"
        };

    }

    private static String lowestString(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        Arrays.sort(strings, new StringUnionComparator());
        for (String string : strings) {
            result.append(string);
        }
        return result.toString();
    }

    private static class StringUnionComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }
}