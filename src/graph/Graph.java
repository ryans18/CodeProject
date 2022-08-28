package graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Author：Ryans
 * Date：Created in 2022/8/28 16:37
 * Introduction：图，由节点和边构成
 */
public class Graph {

    HashMap<Integer, Node> nodes; // Node.value, Node
    HashSet<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }

    public Graph(HashMap<Integer, Node> nodes, HashSet<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public static Graph createGraph(int[][] arr) {
        Graph graph = new Graph();
        for (int i = 0; i < arr.length; i++) {
            int from = arr[i][0];
            int to = arr[i][0];
            int weight = arr[i][0];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge edge = new Edge(weight, fromNode, toNode);
            fromNode.out++;
            fromNode.edges.add(edge);
            fromNode.nexts.add(toNode);
            toNode.in++;
            graph.edges.add(edge);
        }
        return graph;
    }
}