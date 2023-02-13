package Test;

/**
 * Author : Ryans
 * Date : 2023/2/10
 * Introduction :
 */
public class TestVolatile {

    volatile static boolean flag = true;
//    static boolean flag = true;
    public static void main(String[] args) {

        new Thread(() -> {
            while (flag) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = false;
                System.out.println("线程1结束了");
            }
        }).start();
        new Thread(() -> {
            while (flag) {

            }
            System.out.println("线程2结束了");
        }).start();
    }
}
