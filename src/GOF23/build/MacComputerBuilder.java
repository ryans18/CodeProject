package GOF23.build;

/**
 * Author : Ryans
 * Date : 2023/2/13
 * Introduction :
 */
public class MacComputerBuilder extends ComputerBuilder{

    private Computer computer;

    public MacComputerBuilder() {
        this.computer = new Computer();
        computer.setCpu("M2");
        computer.setRam(8);
        computer.setRom(256);
    }

    @Override
    public void setKeyBoard() {
        computer.setKeyboard("苹果鼠标");
    }

    @Override
    public void setUsbCount() {
        computer.setUsbCount(1);
    }

    @Override
    public void setDisplay() {
        computer.setDisplay("苹果显示器");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
