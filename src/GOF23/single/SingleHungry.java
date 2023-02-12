package GOF23.single;

/**
 * Author：Ryans
 * Date：Created in 2023/2/12 16:50
 * Introduction：单例模式-饿汉式
 */
public class SingleHungry {

    // 可能会浪费空间
    private byte[] data1 = new byte[1024 * 1024];
    private byte[] data2 = new byte[1024 * 1024];
    private byte[] data3 = new byte[1024 * 1024];
    private byte[] data4 = new byte[1024 * 1024];

    private SingleHungry() {

    }

    private static SingleHungry instance = new SingleHungry();

    public static SingleHungry getInstance() {
        return instance;
    }
}