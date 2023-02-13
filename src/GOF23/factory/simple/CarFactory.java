package GOF23.factory.simple;

import GOF23.factory.Car;

/**
 * Author : Ryans
 * Date : 2023/2/13
 * Introduction : 抽象工厂模式
 */
public class CarFactory {

    public static Car getCar(String name) {
        switch (name) {
            case "BYD":
                return new BYDCar();
            case "Tesla":
                return new TeslaCar();
            default:
                return null;
        }
    }
}
