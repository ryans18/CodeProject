package GOF23.proxy.dynamic;

import GOF23.proxy.staticProxy.Customer;
import GOF23.proxy.staticProxy.HouseOwner;
import GOF23.proxy.staticProxy.Rent;
import GOF23.proxy.staticProxy2.UserService;
import GOF23.proxy.staticProxy2.UserServiceImpl;

/**
 * Author : Ryans
 * Date : 2023/2/16
 * Introduction : 动态代理Test
 */
public class Client {

    public static void main(String[] args) {

//        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", true);
        // jdk1.8 显示代理类
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        HouseOwner houseOwner = new HouseOwner();  // 房东
        ObjInvocationHandler invocationHandler = new ObjInvocationHandler();
        invocationHandler.setTarget(houseOwner);   // 代理房东
        Rent proxy = (Rent)invocationHandler.getProxy();
        Customer customer = new Customer();
        customer.rentHouse(proxy);
        System.out.println("===========UserService============");
        UserService userService = new UserServiceImpl();
        ObjInvocationHandler userInvocationHandler = new ObjInvocationHandler();
        userInvocationHandler.setTarget(userService);
        // target.getClass().getInterfaces() 可替换成classes Class[] classes = new Class[]{UserService.class};
        UserService service = (UserService)userInvocationHandler.getProxy();
        service.add();
        service.get();
    }
}
