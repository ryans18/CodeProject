package Bit;

/**
 * Author : Ryans
 * Date : 2022/9/23
 * Introduction :
 */
public class MyMath {

    private static int add(int a, int b) {
        int yi = a ^ b;
        int jin = (a & b) << 1;
        if (jin == 0) {
            return yi;
        } else {
            return add(yi, jin);
        }
    }

    private static int jian(int a, int b) {
        return  a + getFan(b);
    }

    private static int plus(int a, int b) {
        int result = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                result = add(result, a);
            }
            a = a << 1;
            b = b >>> 1;
        }
        return result;
    }

    private static int chu(int a, int b) {
        return 0;
    }
    // 相反数
    private static int getFan(int num) {
        return ~num + 1;
    }

    public static void main(String[] args) {
        System.out.println(add(17, 3));
        System.out.println(jian(10, 78));
        System.out.println(plus(2, -3));
    }
}
