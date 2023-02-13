package GOF23.factory.simple;

import GOF23.factory.Car;

/**
 * Author : Ryans
 * Date : 2023/2/13
 * Introduction :
 */
public class BYDCar extends Car {

    @Override
    public void name() {
        System.out.println("比亚迪汽车");
    }
}
