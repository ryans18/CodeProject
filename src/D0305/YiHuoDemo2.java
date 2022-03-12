package D0305;

public class YiHuoDemo2 {

    public static void main(String[] args) {
        // 两个数出现奇数次，其它数出现偶数次
        /*
        * 1. 所有数字全部异或，最终结果为两奇数异或的结果  a ^ b
        * 2. a ^ b, a != b, 说明 a ^ b不为0，则在某一位上一定不等于0；那么 a 或者b在这一位上不等于0才能结果为1
        * */
        int [] array = new int[] {1, 3, 4, 5, 3, 1,2, 2};
        int eor = 0;
        for (int item : array) {
            eor ^= item;
        }
        // 找出eor最右边为1    ~eor 取反
        int rightOne = eor & (~eor + 1);
        //  eor:  1010111100
        // ~eor:  0101000011
        //~eor+1: 0101000100
        //        0000000100  提取出最右侧的1
        int eor2 = 0;
        for (int item : array) {
            if ((item & rightOne) == 1) {  // 如果 item的那一位上为1（a或b的这一位上为1）
                eor2 ^= item;
            }
        }
        // eor2即为a或b
        System.out.println(eor2 + "\t" + (eor ^ eor2));

    }
}
