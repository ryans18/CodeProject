package GOF23.build;

/**
 * Author : Ryans
 * Date : 2023/2/13
 * Introduction :
 */
public class LenovoComputerBuilder extends ComputerBuilder{

    private Computer computer;

    public LenovoComputerBuilder() {
        this.computer = new Computer();
        computer.setCpu("英特尔");
        computer.setRam(16);
        computer.setRom(512);
    }

    @Override
    public void setKeyBoard() {
        computer.setKeyboard("罗技");
    }

    @Override
    public void setUsbCount() {
        computer.setUsbCount(3);
    }

    @Override
    public void setDisplay() {
        computer.setDisplay("三星显示器");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
