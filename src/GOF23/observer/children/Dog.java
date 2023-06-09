package GOF23.observer.children;

/**
 * Author : Ryans
 * Date : 2023/6/8
 * Introduction :
 */
public class Dog implements CryObserver{

    @Override
    public void onCry() {
        System.out.println("dog wang wang wang ");
    }
}
