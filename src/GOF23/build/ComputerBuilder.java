package GOF23.build;

/**
 * Author : Ryans
 * Date : 2023/2/13
 * Introduction :
 */
public abstract class ComputerBuilder {

    public abstract void setKeyBoard();
    public abstract void setUsbCount();
    public abstract void setDisplay();

    public abstract Computer getComputer();
}
