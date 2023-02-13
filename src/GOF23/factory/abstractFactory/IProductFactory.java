package GOF23.factory.abstractFactory;

/**
 * Author : Ryans
 * Date : 2023/2/13
 * Introduction :
 */
public interface IProductFactory {

    Phone createPhone();

    Router createRouter();
}
