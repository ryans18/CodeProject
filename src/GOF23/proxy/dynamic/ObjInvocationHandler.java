package GOF23.proxy.dynamic;

import GOF23.proxy.staticProxy2.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author : Ryans
 * Date : 2023/2/16
 * Introduction : 动态代理
 */
public class ObjInvocationHandler implements InvocationHandler {

    // 被代理的类
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start: " + method.getName());
        Object invoke = method.invoke(target, args);
        System.out.println("end: " + method.getName());
        return invoke;
    }
}
