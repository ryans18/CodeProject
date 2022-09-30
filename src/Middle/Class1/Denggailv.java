package Middle.Class1;

/**
 * Author : Ryans
 * Date : 2022/9/29
 * Introduction : 给定一个函数f，可以1~5等概率返回一个，请加工出1~7的数字等概率返回一个的函数g
 * 先根据1,5等概率返回0,1。再用位运算等概率返回其它
 */
public class Denggailv {

    private static int f() {
        return (int)(Math.random() * 5) + 1;
    }

    private static int r01() {
        int res = 0;
        do {
            res = f();
        }while (res == 3);
        return res < 3 ? 0 : 1;
    }

    // 1 - 7 -> 0 - 6 : 1 + 2 + 4
    private static int g17() {
        int res = 0;
        do {
            res = (r01() << 2) + (r01() << 1) + r01();
        } while (res == 7);
        // res为0-6
        return res + 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(g17());
        }
    }
}
