package GOF23.factory.abstractFactory;

/**
 * Author : Ryans
 * Date : 2023/2/13
 * Introduction :
 */
public class XiaomiRouter extends Router{
    @Override
    public void openWifi() {
        System.out.println("小米路由器打开wifi");
    }

    @Override
    public void connect() {
        System.out.println("小米路由器连接网络");
    }
}
