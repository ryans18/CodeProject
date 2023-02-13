package GOF23.factory.simple;

import GOF23.factory.Car;

/**
 * Author : Ryans
 * Date : 2023/2/13
 * Introduction :
 */
public class TeslaCar extends Car {
    @Override
    public void name() {
        System.out.println("特斯拉汽车");
    }
}
