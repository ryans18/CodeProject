package Middle.Class8;

/**
 * Author : Ryans
 * Date : 2022/10/9
 * Introduction : 路灯问题， 最少需要多少个路灯。 X为障碍物，.为需要点亮的区域. 一个路灯可以照亮3个位置
 *  思路：这种问题，就让index一次跳多个
 */
public class PlaceLamp {

    public static void main(String[] args) {
        String s = "XX...X.X..X....XX.....";
        System.out.println(minLights(s));
    }

    private static int minLights(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int index = 0;
        int light = 0;
        while (index < str.length) {
            if (str[index] == 'X') {
                index++;
            } else {  // 当前位置
                light++;
                if (light == str.length - 1) {
                    break;
                } else if (str[index + 1] == 'X') { // 下一格是障碍，就看下下个
                    index = index + 2;
                } else {  // 当前路灯已经照亮3个位置了，跳到3个以后
                    index = index + 3;
                }
            }
        }
        return light;
    }
}
