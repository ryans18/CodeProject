package Middle.Class1;

/**
 * Author : Ryans
 * Date : 2022/9/28
 * Introduction :  重新染色，使得左边只能为G，右边只能为R，最小需要染几个色
 *  技巧：预处理
 */
public class RGQuestion {

    public static void main(String[] args) {
        String s = "RGGRGGRRRG";
        System.out.println(getMinStepForColor(s));
    }

    private static int getMinStepForColor(String s) {
        char[] chars = s.toCharArray();
        int min = Integer.MAX_VALUE;
        int[] gArray = getGArray(chars);
        int[] rArray = getRArray(chars);
        for (int i = 0; i < chars.length; i++) {
            int num = rArray[i] + gArray[i];   // 左边几个R需要染色，右边几个G需要染色
            min = Math.min(min, num);
        }
        return min;
    }

    // G 到右边越来越少
    private static int[] getGArray(char[] chars) {
        int[] array = new int[chars.length];
        int index = chars.length - 1;
        if (chars[index] == 'G') {
            array[index] = 1;
        }
        index--;
        while (index >= 0 ) {
            if (chars[index] == 'G') {
                array[index] = array[index + 1] + 1;
            } else {
                array[index] = array[index + 1];
            }
            index--;
        }
        return array;
    }

    private static int[] getRArray(char[] chars) {
        int[] array = new int[chars.length];
        int index = 0;
        if (chars[index] == 'R') {
            array[index] = 1;
        }
        index++;
        while (index < chars.length) {
            if (chars[index] == 'R') {
                array[index] = array[index - 1] + 1;
            } else {
                array[index] = array[index - 1];
            }
            index++;
        }
        return array;
    }
}
