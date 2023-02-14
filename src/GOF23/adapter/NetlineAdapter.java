package GOF23.adapter;


/**
 * Author : Ryans
 * Date : 2023/2/14
 * Introduction :
 */
public class NetlineAdapter implements Usb2Netline{

    private Netline netline;

    public NetlineAdapter(Netline netline) {
        this.netline = netline;
    }

    @Override
    public void requestConnect() {
        System.out.println("插上Usb网线适配器，");
        netline.connect();
    }
}
