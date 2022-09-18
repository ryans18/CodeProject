package graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Author：Ryans
 * Date：Created in 2022/9/17 15:28
 * Introduction：并查集, 判断两个集合是否为同一集合，时间复杂度接近于O(1)
 */
public class UnionFind<V> {

    private Map<V, Element<V>> elementMap;
    private Map<Element<V>, Element<V>> fatherMap;
    private Map<Element<V>, Integer> sizeMap;

    public UnionFind(List<V> list) {
        elementMap = new HashMap<>();
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for (V v : list) {
            Element<V> element = new Element<>();
            elementMap.put(v, element);
            fatherMap.put(element, element);
            sizeMap.put(element, 1);
        }
    }

    private Element<V> findFather(Element<V> element) {
        Stack<Element<V>> stack = new Stack<>();
        while (fatherMap.containsKey(element) && element != elementMap.get(element)) {
            stack.push(element);
            element = fatherMap.get(element);
        }
        // 把子节点放到父节点下面
        while (!stack.isEmpty()) {
            fatherMap.put(stack.pop(), element);
        }
        return element;
    }

    private boolean isSameSet(V v1, V v2) {
        if (elementMap.containsKey(v1) && elementMap.containsKey(v2)) {
            return findFather(elementMap.get(v1)) == findFather(elementMap.get(v2));
        }
        return false;
    }

    private void union(V v1, V v2) {
        if (elementMap.containsKey(v1) && elementMap.containsKey(v2)) {
            Element<V> father1 = findFather(elementMap.get(v1));
            Element<V> father2 = findFather(elementMap.get(v2));
            if (father1 != father2) {
                Element<V> big = sizeMap.get(father1) >= sizeMap.get(father2) ? father1 : father2;
                Element<V> small = big == father1 ? father2 : father1;
                fatherMap.put(small, big);
                sizeMap.put(big, sizeMap.get(big) + sizeMap.get(small));
                sizeMap.remove(small);
            }
        }
    }

    private class Element<V> {
        V value;
    }
}