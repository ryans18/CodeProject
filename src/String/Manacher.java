package String;

/**
 * Author：Ryans
 * Date：Created in 2022/9/18 16:26
 * Introduction：马拉车算法，解决回文字符串问题。时间复杂度为O(N)，比暴力for循环内部判断是否为回文O(N²)更好
 */
public class Manacher {

    public static void main(String[] args) {
//        String s = "abcdcba";
        String s = "abcdefg";
        System.out.println(manacher(s));
    }

    private static int manacher(String s) {
      int max = 0;
      char[] strs = manacherString(s);
      int[] arr = new int[strs.length];  // 回文半径数组, 回文半径是包含中心点的，所有最小为1.

      int C = -1; // 回文中心
      int R = -1;  // 回文的下一个位置，处于边界
      // 0 1 2 3 4 5 6 7 8 9 10 11 12
      /*for (int i = 1; i < strs.length - 1; i++) {
         arr[i] = R > i ? Math.min(arr[2 * C - i], R - i) : 1;	//进行三种情况的判断
         while (strs[i + arr[i]] == strs[i - arr[i]]) arr[i]++;	//中心拓展
         if (i + arr[i] > R) {                           	//如果当前回文串已经覆盖到了原先没有覆盖到的地方，则更新标记
            R = i + arr[i];
            C = i;
         }
         max = Math.max(max, arr[i]);
      }*/
      for (int i = 0; i < strs.length; i++) {
          // 不用验的区域
          // 1. i 在R外面，需要暴力左右验证。不用验证的只有自己
          // 2. i 在R内，i`在R的左边界内，那么i的位置的半径与i`的半径相等。————arr[2 * C - i]。此时半径必小于R-i。
          // 3. i 在R内，i`(i在左边堆成的点)的回文半径在R左边界的外面。那么i位置的半径最大到R。———— R - i。此时arr[2 * C - i] > R - i
          // 4. i 在R内，i`与R的左边界对齐，那么i位置的半径必在R右边界外边或者与有边界对其。————arr[2 * C - i] = R - i。右边还有
          arr[i] = R > i ? Math.min(arr[2 * C - i], R - i) : 1;  // i 是否包含在回文内。 2C-1为i`的位置
          while (i + arr[i] < strs.length && (i - arr[i]) > -1) {   // while循环确定R，当R达到数组长度后，便不再进入，所以时间复杂度是O(N)
              if (strs[i + arr[i]] == strs[i - arr[i]]) {   // 当i+arr(i) 到头后便不再进入
                  arr[i]++;
              } else {
                  break;
              }
          }
          if (i + arr[i] > R) {
              R = i + arr[i];
              C = i;
          }
          max = Math.max(max, arr[i]);
      }
        return max - 1;  // 加入了特殊字符#，最终求回文字符串的长度。需要回文半径 - 1
    }

    private static char[] manacherString(String s) {
        char[] chars = s.toCharArray();
        char[] strs = new char[2 * chars.length + 1];
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            strs[i] = (i & 1) == 0 ? '#' : chars[index++];
        }
        return strs;
    }
}