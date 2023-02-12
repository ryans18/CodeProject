package GOF23.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Author：Ryans
 * Date：Created in 2023/2/12 17:52
 * Introduction：枚举：本身也是一个类
 */
public enum SingleEnum {

    INSTANCE;
    public static SingleEnum getInstance() {
        return INSTANCE;
    }
}

class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        SingleEnum instance1 = SingleEnum.getInstance();
        SingleEnum instance2 = SingleEnum.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
        // 测试枚举的构造方法,在class下可以看到enum的idea的源码
        Constructor<SingleEnum> constructor = SingleEnum.class.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        SingleEnum singleEnum = constructor.newInstance("", 1);
        System.out.println(singleEnum);

    }
}