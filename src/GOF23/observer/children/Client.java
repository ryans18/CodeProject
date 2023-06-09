package GOF23.observer.children;

/**
 * Author : Ryans
 * Date : 2023/6/8
 * Introduction : 观察者模式 Observe
 */
public class Client {

    public static void main(String[] args) {
        Child child = new Child();
        child.addObserver(new Father());
        child.addObserver(new Mother());
        child.addObserver(new Dog());
        child.sleep();
    }
}
