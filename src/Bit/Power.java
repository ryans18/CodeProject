package Bit;

/**
 * Author : Ryans
 * Date : 2022/9/23
 * Introduction : 判断一个数是不是2的幂函数，4的幂函数
 */
public class Power {

    private static boolean power2(int num) {
        return (num & num - 1) == 0;
    }

    private static boolean power22(int num) {
        int mostRightOne = num & (~num + 1);
        return num  == mostRightOne;
    }

    // 是否为4的幂
    // 只有1的情况下且1在4的幂位上
    private static boolean power4(int num) {
                                                // ...101010101
        return (num & num - 1) == 0 && (num & 0x55555555) != 0;
    }
}
