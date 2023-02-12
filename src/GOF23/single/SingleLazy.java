package GOF23.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Author：Ryans
 * Date：Created in 2023/2/12 16:55
 * Introduction：懒汉式单例
 */
public class SingleLazy {

    private static boolean myFlag = false;
    private SingleLazy() {
        System.out.println(Thread.currentThread().getName() + " ok");
        synchronized (SingleLazy.class) {
            if (!myFlag) {
                myFlag = true;
            } else {
                throw new RuntimeException("不要试图用反射破坏单例");
            }

        }
    }

    private static SingleLazy instance;

    // 最基础的懒汉式
    public static SingleLazy getInstance2() {
        if (instance == null) {
            instance = new SingleLazy();
        }
        return instance;
    }

    // 双重检测锁的懒汉式，DCL懒汉式。添加volatile，就不会被指令重排，保证了原子性
    public static SingleLazy getInstance() {
        if (instance == null) {
            synchronized (SingleLazy.class) {   // Class对象只有一个
                if (instance == null) {
                    instance = new SingleLazy();  // 不是一个原子性操作。
                    /**原子性：多个操作要么一起成功，要么一起失败。比如一个事务就是原子性。要么都成功，要么回退
                     * 1. 分配内存空间
                     * 2. 执行构造方法
                     * 3. 把这个对象指向这个空间
                     * 如果是132，此时instance对象还没完成构造。此时为指令重排
                     */
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {
        // 1. 多线程可能破坏，生成了多个对象
       /* for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SingleLazy.getInstance();
            }).start();
        }*/
       // 2. 使用反射破坏,生成两个对象 ---解决：构造器synchronized(Singlelazy.class)  ----使用一个flag
//        SingleLazy instance = SingleLazy.getInstance();
        Constructor<SingleLazy> constructor = SingleLazy.class.getDeclaredConstructor(null);
        constructor.setAccessible(true); // 跳过安全检测
        SingleLazy singleLazy = constructor.newInstance(null);
//        System.out.println(instance);
        System.out.println(singleLazy);
        Field myFlag = SingleLazy.class.getDeclaredField("myFlag");
        myFlag.setAccessible(true);
        myFlag.set(singleLazy, false);
        SingleLazy singleLazy1 = constructor.newInstance(null);
        System.out.println(singleLazy1);
    }
}