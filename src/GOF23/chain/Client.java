package GOF23.chain;

/**
 * Author : Ryans
 * Date : 2023/6/9
 * Introduction : 责任链模式
 * request执行1,2,3。response执行3,2,1。 运用了递归手法
 */
public class Client {
    public static void main(String[] args) {
        MyRequest request = new MyRequest("Hello, 99, my ");
        MyResponse response = new MyResponse("aferuom");
        MyFilterChain filterChain = new MyFilterChain();
        filterChain.add(new NumFilter()).add(new UrlFilter()).add(new HttpFilter());
        filterChain.doFilter(request, response);
    }
}
