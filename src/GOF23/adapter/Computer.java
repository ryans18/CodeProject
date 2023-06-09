package GOF23.adapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author : Ryans
 * Date : 2023/2/14
 * Introduction : 适配器模式
 * 电脑只能插usb接口，没有网线接口。我们通过网线转Usb的适配器成功上网
 */
public class Computer {

    // 上网冲浪
    private void internet(Usb adapter) {
        adapter.connectUSB();
    }

    public static void main(String[] args) {
        Usb usb = new Usb2NetLineAdapter(new Netline());
        new Computer().internet(usb);

//        InputStream is = new FileInputStream("fdaaf");
//        InputStreamReader isr = new InputStreamReader(is);
//        BufferedReader bf = new BufferedReader(isr);
    }
}
