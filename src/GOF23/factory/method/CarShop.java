package GOF23.factory.method;

/**
 * Author : Ryans
 * Date : 2023/2/13
 * Introduction : 工厂方法模式
 */
public class CarShop {

    public static void main(String[] args) {
        new TeslaFactory().getCar().name();
        new BYDFactory().getCar().name();
    }
}
