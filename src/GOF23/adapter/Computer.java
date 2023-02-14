package GOF23.adapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author : Ryans
 * Date : 2023/2/14
 * Introduction : 适配器模式
 */
public class Computer {

    private void internet(NetlineAdapter adapter) {
        adapter.requestConnect();
    }

    public static void main(String[] args) {
        NetlineAdapter adapter = new NetlineAdapter(new Netline());
        new Computer().internet(adapter);
    }
}
