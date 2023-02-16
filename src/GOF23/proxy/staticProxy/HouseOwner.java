package GOF23.proxy.staticProxy;

/**
 * Author : Ryans
 * Date : 2023/2/16
 * Introduction : 房东
 */
public class HouseOwner implements Rent{

    @Override
    public void rent() {
        System.out.println("房东出租房子");
    }
}
