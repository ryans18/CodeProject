package GOF23.build;

/**
 * Author : Ryans
 * Date : 2023/2/13
 * Introduction :
 */
public class Director {

    public void makeComputer(ComputerBuilder builder) {
        builder.setUsbCount();
        builder.setKeyBoard();
        builder.setDisplay();
    }
}
