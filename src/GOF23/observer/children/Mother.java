package GOF23.observer.children;

/**
 * Author : Ryans
 * Date : 2023/6/8
 * Introduction :
 */
public class Mother implements CryObserver{

    @Override
    public void onCry() {
        System.out.println("mother 喂奶");
    }
}
