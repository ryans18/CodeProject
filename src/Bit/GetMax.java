package Bit;

/**
 * Author : Ryans
 * Date : 2022/9/23
 * Introduction : 位运算求两个数的大小，要求不要用任何比较。
 */
public class GetMax {

    // 正数返回1， 负数返回0
    private static int sign(int num) {
        return flip((num >> 31) & 1);
    }

    // 1 -> 0;  0 -> 1
    private static int flip(int n) {
        return n ^ 1;
    }

    // 缺点，如果溢出会错误。 最大正数 - 最大负数相当于加了1个最大正数
    private static int getMax(int a, int b) {
        int c = a - b;
        int scA = sign(c);
        int scB = flip(scA);
        // 要么c为1、r为0返回a，要么r为1、c为0返回b
        return a * scA + b * scB;
    }

    // 如果a和b符号一样，a - b不会溢出。a - b > 0返回
    // 如果a和b符号不一样，a大于0，返回a。
    private static int getMax2(int a, int b) {
        int c = a - b;
        int sA = sign(a);   // 判断a是否为正数
        int sB = sign(b);
        int sC= sign(c);
        int difSab = sA ^ sB;  // a和b符号一样，返回0，a和b符号不一样，返回1
        int sameSab = flip(difSab); // a和b符号一样，返回1， a和b符号不一样，返回0;
        int returnA = sameSab * sC + difSab * sA;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;

    }

    public static void main(String[] args) {
        System.out.println(getMax2(90,-11));
    }

}
