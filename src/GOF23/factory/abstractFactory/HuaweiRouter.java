package GOF23.factory.abstractFactory;

/**
 * Author : Ryans
 * Date : 2023/2/13
 * Introduction :
 */
public class HuaweiRouter extends Router{
    @Override
    public void openWifi() {
        System.out.println("华为路由器打开wifi");
    }

    @Override
    public void connect() {
        System.out.println("华为路由器连接网络");
    }
}
