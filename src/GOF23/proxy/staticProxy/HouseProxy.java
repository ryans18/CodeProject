package GOF23.proxy.staticProxy;

/**
 * Author : Ryans
 * Date : 2023/2/16
 * Introduction :
 */
public class HouseProxy implements Rent{

    private Rent houseOwner;

    public HouseProxy(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    @Override
    public void rent() {
        seeHouse();
        houseOwner.rent();
        charge();
    }

    private void seeHouse() {
        System.out.println("中介带看房子");
    }

    private void charge() {
        System.out.println("中介代为收费");
    }
}
