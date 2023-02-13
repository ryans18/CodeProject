package GOF23.factory.abstractFactory;

/**
 * Author : Ryans
 * Date : 2023/2/13
 * Introduction : 抽象工厂模式，超级工厂接口定义可以生成的产品。然后由实际品牌的工厂生产
 *
 *
 */
public class Shop {

    public static void main(String[] args) {
        System.out.println("===================华为产品==============");
        IProductFactory hwFactory = new HuaweiFactory();
        Phone hwPhone = hwFactory.createPhone();
        hwPhone.call();
        hwPhone.sendMsg();
        Router hwRouter = hwFactory.createRouter();
        hwRouter.openWifi();
        hwRouter.connect();
        System.out.println("===================小米产品==============");
        IProductFactory xmFactory = new XiaomiFactory();
        Phone xmPhone = xmFactory.createPhone();
        xmPhone.call();
        xmPhone.sendMsg();
        Router xmRouter = xmFactory.createRouter();
        xmRouter.openWifi();
        xmRouter.connect();
    }
}
