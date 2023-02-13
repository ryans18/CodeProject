package GOF23.build;

/**
 * Author : Ryans
 * Date : 2023/2/13
 * Introduction :
 */
public class ComputerShop {

    public static void main(String[] args) {
        Director director = new Director();
        MacComputerBuilder macBuilder = new MacComputerBuilder();
        director.makeComputer(macBuilder);
        Computer macComputer = macBuilder.getComputer();
        System.out.println("Mac: " + macComputer);
        System.out.println("=============================");
        LenovoComputerBuilder lenovoBuilder = new LenovoComputerBuilder();
        director.makeComputer(lenovoBuilder);
        Computer lenovoComputer = lenovoBuilder.getComputer();
        System.out.println("lenovo: " + lenovoComputer.toString());
        System.out.println("=============华为  内部类的建造者模式================");
        NewComputer huaweiComputer = new NewComputer.Builder("AMD", 1000, 16)
                .setDisplay("华为")
                .setUsbCount(4)
                .setKeyboard("华为")
                .build();
        System.out.println("华为： " + huaweiComputer);

    }
}
