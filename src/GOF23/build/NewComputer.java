package GOF23.build;

/**
 * Author : Ryans
 * Date : 2023/2/13
 * Introduction : 建造者模式-使用内部类构成
 */
public class NewComputer {

    private String cpu; // 必选
    private int ram;    // 必选
    private int rom;    // 必选
    private String keyboard; // 可选
    private int usbCount;   // 可选
    private String display;  // 可选

    private NewComputer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.rom = builder.rom;
        this.keyboard = builder.keyboard;
        this.usbCount = builder.usbCount;
        this.display = builder.display;
    }

    @Override
    public String toString() {
        return "NewComputer{" +
                "cpu='" + cpu + '\'' +
                ", ram=" + ram +
                ", rom=" + rom +
                ", keyboard='" + keyboard + '\'' +
                ", usbCount=" + usbCount +
                ", display='" + display + '\'' +
                '}';
    }

    public static class Builder {
        private String cpu; // 必选
        private int ram;    // 必选
        private int rom;    // 必选
        private String keyboard; // 可选
        private int usbCount;   // 可选
        private String display;  // 可选
        public Builder(String cpu, int rom, int ram) {
            this.cpu = cpu;
            this.rom = rom;
            this.ram = ram;
        }

        public Builder setKeyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }

        public Builder setUsbCount(int count) {
            this.usbCount = count;
            return this;
        }

        public Builder setDisplay(String display) {
            this.display = display;
            return this;
        }

        public NewComputer build() {
            return new NewComputer(this);
        }
    }
}
