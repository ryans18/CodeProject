package GOF23.chain;

/**
 * Author : Ryans
 * Date : 2023/6/9
 * Introduction :
 */
public interface MyFilter {

    void doFilter(MyRequest request, MyResponse response, MyFilterChain chain);
}
