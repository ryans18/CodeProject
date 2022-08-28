package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：Ryans
 * Date：Created in 2022/8/28 16:37
 * Introduction：图-节点
 */
public class Node {

    public int value;
    public int in;
    public int out;
    public List<Node> nexts;
    public List<Edge> edges;

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}