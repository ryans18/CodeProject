package GOF23.proxy.staticProxy;

/**
 * Author : Ryans
 * Date : 2023/2/16
 * Introduction :
 */
public class Customer {

    public void rentHouse(Rent rent) {
        rent.rent();
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        HouseProxy houseProxy = new HouseProxy(new HouseOwner());
        customer.rentHouse(houseProxy);
    }
}
