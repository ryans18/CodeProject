package Test;

/**
 * Author : Ryans
 * Date : 2022/9/16
 * Introduction : 位图——适应于布隆过滤器等。判断ur是否加入过
 */
public class Bitmap {

    private int[] bits;

    public Bitmap() {
        bits = new int[10];
    }

    // 把所选位置置位1
    private  void add(int num) {
        int arrIndex = num / 32;
        int bitIndex = num % 32;
        bits[arrIndex] = bits[arrIndex] | (1 << bitIndex);
    }

    // 把所选位置置位0
    private void delete(int num) {
        int arrIndex = num / 32;
        int bitIndex = num % 32;
        // 1 & 0 = 0
        bits[arrIndex] = bits[arrIndex] & ( ~(1 << bitIndex));
    }

    private boolean contains(int num) {
        int arrIndex = num / 32;
        int bitIndex = num % 32;
        // 把当前数右移后，会去掉右边的信息，右边第一个就是bitIndex的信息。
        return ((bits[arrIndex] >> bitIndex) & 1) == 1;
    }

    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap();
        bitmap.add(178);
        bitmap.add(89);
        bitmap.add(99);
        System.out.println(bitmap.contains(178));
        bitmap.delete(178);
        System.out.println(bitmap.contains(178));
    }

}
