package GOF23.factory.abstractFactory;

/**
 * Author : Ryans
 * Date : 2023/2/13
 * Introduction :
 */
public class HuaweiPhone extends Phone{
    @Override
    public void call() {
        System.out.println("华为手机打电话");
    }

    @Override
    public void sendMsg() {
        System.out.println("华为手机发短信");
    }
}
