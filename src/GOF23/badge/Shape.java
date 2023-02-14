package GOF23.badge;

/**
 * Author : Ryans
 * Date : 2023/2/14
 * Introduction :
 */
public abstract class Shape {

    Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw();
}

class Circle extends Shape {

    @Override
    public void draw() {
        color.paint("圆形");
    }
}

class Rectangle extends Shape {
    @Override
    public void draw() {
        color.paint("长方形");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        color.paint("正方形");
    }
}
