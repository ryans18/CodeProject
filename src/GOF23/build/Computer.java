package GOF23.build;

/**
 * Author : Ryans
 * Date : 2023/2/13
 * Introduction :
 */
public class Computer {

    private String cpu; // 必选
    private int ram;    // 必选
    private int rom;    // 必选
    private String keyboard = "罗技";  // 可选
    private int usbCount = 2;   // 可选
    private String display = "三星";  // 可选

    public Computer() {

    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public int getUsbCount() {
        return usbCount;
    }

    public void setUsbCount(int usbCount) {
        this.usbCount = usbCount;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram=" + ram +
                ", rom=" + rom +
                ", keyboard='" + keyboard + '\'' +
                ", usbCount=" + usbCount +
                ", display='" + display + '\'' +
                '}';
    }
}
