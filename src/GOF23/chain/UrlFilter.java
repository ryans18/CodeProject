package GOF23.chain;

/**
 * Author : Ryans
 * Date : 2023/6/9
 * Introduction :
 */
public class UrlFilter implements MyFilter{
    @Override
    public void doFilter(MyRequest request, MyResponse response, MyFilterChain chain) {
        System.out.println("request-UrlFilter");
        chain.doFilter(request, response);
        System.out.println("response-UrlFilter");
    }
}
