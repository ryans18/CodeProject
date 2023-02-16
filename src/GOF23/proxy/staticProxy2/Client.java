package GOF23.proxy.staticProxy2;

/**
 * Author : Ryans
 * Date : 2023/2/16
 * Introduction :
 */
public class Client {

    public static void main(String[] args) {
        UserServiceProxy userService = new UserServiceProxy();
        userService.setUserService(new UserServiceImpl());
        userService.add();
        System.out.println("========================");
        userService.delete();
        System.out.println("========================");
        userService.update();
        System.out.println("========================");
        userService.get();
    }
}
