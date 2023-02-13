package GOF23.factory.abstractFactory;

/**
 * Author : Ryans
 * Date : 2023/2/13
 * Introduction :
 */
public class XiaomiFactory implements IProductFactory{
    @Override
    public Phone createPhone() {
        return new XiaomiPhone();
    }

    @Override
    public Router createRouter() {
        return new XiaomiRouter();
    }
}
