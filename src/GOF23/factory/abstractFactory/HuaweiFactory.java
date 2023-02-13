package GOF23.factory.abstractFactory;

/**
 * Author : Ryans
 * Date : 2023/2/13
 * Introduction :
 */
public class HuaweiFactory implements IProductFactory{
    @Override
    public Phone createPhone() {
        return new HuaweiPhone();
    }

    @Override
    public Router createRouter() {
        return new HuaweiRouter();
    }
}
