package GOF23.proxy.staticProxy2;

/**
 * Author : Ryans
 * Date : 2023/2/16
 * Introduction :
 */
public class UserServiceProxy implements UserService{

    // 真是对象
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        logBefore("add");
        userService.add();
        logAfter("add");
    }

    @Override
    public void delete() {
        logBefore("delete");
        userService.delete();
        logAfter("delete");
    }

    @Override
    public void update() {
        logBefore("update");
        userService.update();
        logAfter("update");
    }

    @Override
    public void get() {
        logBefore("get");
        userService.get();
        logAfter("get");
    }

    private void logBefore(String method) {
        System.out.println("start: " + method);
    }

    private void logAfter(String method) {
        System.out.println("end: " + method);
    }
}
