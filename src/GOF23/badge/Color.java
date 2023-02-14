package GOF23.badge;

/**
 * Author : Ryans
 * Date : 2023/2/14
 * Introduction :
 */
public abstract class Color {

    public abstract void paint(String shape);
}

class While extends Color {

    @Override
    public void paint(String shape) {
        System.out.println("白色的" + shape);
    }
}

class Black extends Color{

    @Override
    public void paint(String shape) {
        System.out.println("黑色的" + shape);
    }
}

class Red extends Color {

    @Override
    public void paint(String shape) {
        System.out.println("红色的" + shape);
    }
}
