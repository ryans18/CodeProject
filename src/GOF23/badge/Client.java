package GOF23.badge;

/**
 * Author : Ryans
 * Date : 2023/2/14
 * Introduction : 两个不同的维度通过桥接组合出不同的对象。
 */
public class Client {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setColor(new Red());
        rectangle.draw();

        Circle circle = new Circle();
        circle.setColor(new Black());
        circle.draw();
    }
}
