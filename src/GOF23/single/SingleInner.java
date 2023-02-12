package GOF23.single;

/**
 * Author：Ryans
 * Date：Created in 2023/2/12 17:26
 * Introduction：内部类的单例模式
 */
public class SingleInner {
    
    private SingleInner() {
        
    }

    public static SingleInner getInstance() {
        return InnerClass.SINGLE_INNER;
    }
    
    private static class InnerClass {
        private static final SingleInner SINGLE_INNER = new SingleInner();
    }

}