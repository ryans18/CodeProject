package GOF23.factory.method;

import GOF23.factory.Car;

/**
 * Author : Ryans
 * Date : 2023/2/13
 * Introduction :
 */
public class TeslaFactory implements CarFactory{

    @Override
    public Car getCar() {
        return new TeslaCar();
    }
}
