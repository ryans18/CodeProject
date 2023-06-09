package GOF23.adapter;


/**
 * Author : Ryans
 * Date : 2023/2/14
 * Introduction :
 */
public class Usb2NetLineAdapter extends Usb{

    private Netline netline;

    public Usb2NetLineAdapter(Netline netline) {
        this.netline = netline;
    }

    @Override
    public void connectUSB() {
        System.out.println("插上Usb网线适配器，");
        netline.connectNet();
    }
}
