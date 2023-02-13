package GOF23.factory.simple;

/**
 * Author : Ryans
 * Date : 2023/2/13
 * Introduction :
 */
public class CarShop {

    public static void main(String[] args) {
        CarFactory.getCar("BYD").name();
        CarFactory.getCar("Tesla").name();
    }
}
