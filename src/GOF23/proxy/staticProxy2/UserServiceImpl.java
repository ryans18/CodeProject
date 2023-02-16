package GOF23.proxy.staticProxy2;

/**
 * Author : Ryans
 * Date : 2023/2/16
 * Introduction :
 */
public class UserServiceImpl implements UserService{

    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void get() {
        System.out.println("get");
    }
}
