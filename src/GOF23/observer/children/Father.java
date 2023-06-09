package GOF23.observer.children;

/**
 * Author : Ryans
 * Date : 2023/6/8
 * Introduction :
 */
public class Father implements CryObserver{

    @Override
    public void onCry() {
        System.out.println("Father拍了拍背");
    }
}
