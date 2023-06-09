package GOF23.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Ryans
 * Date : 2023/6/9
 * Introduction :
 */
public class MyFilterChain{

    private List<MyFilter> filters = new ArrayList<>();

    private int cur = 0;

    public MyFilterChain() {
    }

    public MyFilterChain add(MyFilter filter) {
        filters.add(filter);
        return this;
    }

    public void doFilter(MyRequest request, MyResponse response) {
        if (cur == filters.size()) return;
        MyFilter filter = filters.get(cur);
        cur++;
        filter.doFilter(request, response, this);
    }
}
