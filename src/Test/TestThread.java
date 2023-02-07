package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Author : Ryans
 * Date : 2023/2/2
 * Introduction : 测试ArrayList是线程不安全的。通过线程往list里添加1万条数据，最终size<1万，
 * 换成Vector则正确
 */
public class TestThread {

    static List<String> list = new ArrayList<>();
//    static List<String> list = new Vector<>();

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        for (int i = 0; i < 10000; i++) {
            new Thread(() ->{
               list.add("");
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
