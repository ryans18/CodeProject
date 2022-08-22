package jinzhi;

/**
 * Author : Ryans
 * Date : 2022/8/17
 * Introduction : 代码实现进制转换
 */
public class Jinzhi {

    public static void main(String[] args) {
        int num = 129;
        System.out.println("十进制转二进制：" + ten2two(num));
        System.out.println("十进制转八进制：" + ten2eight(num));
        int n = 217;
        System.out.println( n + "的二进制： " + Integer.toBinaryString(n));
        System.out.println((217 >> 3 ) & 31);
    }
    // 11111 - 1 + 2  + 4 + 8 + 16

    private static String ten2two(int num) {
        StringBuilder sb = new StringBuilder(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          );
        while (num != 0) {
            sb.append(num % 2);
            num = num / 2;
        }
        return sb.reverse().toString();
    }

    private static String ten2eight(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num % 8);
            num = num / 8;
        }
        return sb.reverse().toString();
    }
}
