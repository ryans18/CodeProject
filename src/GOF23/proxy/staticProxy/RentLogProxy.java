package GOF23.proxy.staticProxy;

/**
 * Author : Ryans
 * Date : 2023/6/7
 * Introduction :
 */
public class RentLogProxy implements Rent{

    Rent rent;

    public RentLogProxy(Rent rent) {
        this.rent = rent;
    }

    @Override
    public void rent() {
        rent.rent();
        System.out.println("rent log");
    }
}
