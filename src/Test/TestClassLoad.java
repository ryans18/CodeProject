package Test;

/**
 * Author : Ryans
 * Date : 2023/2/6
 * Introduction :
 */
public class TestClassLoad {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.num);
    }
}

class A {

    static int num = 100;
    static {
        num = 300;
    }

    public A (){
        System.out.println("A类无参构造初始化");
//        num = 500;
    }
}
