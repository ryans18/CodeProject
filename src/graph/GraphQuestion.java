package graph;

import java.util.*;

/**
 * Author：Ryans
 * Date：Created in 2022/8/28 16:48
 * Introduction：
 */
public class GraphQuestion {

    public static void main(String[] args) {
        Graph graph = Graph.createGraph(new int[][] {
                {1, 2, 7},
                {2, 1, 7},
                {1, 3, 2},
                {3, 1, 2},
                {3, 4, 4},
                {4, 3, 4},
                {1, 4, 100},
                {4, 1, 100},
                {2, 4, 1000},
                {4, 2, 1000},
                {2, 5, 100000},
                {5, 2, 100000}
        });
        kruskal(graph);
    }

    // 宽度优先遍历，利用一个queue和一个set
    private static void widthOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.println(node.value);
            for (Node next : node.nexts) {
                if (!set.contains(node)) {
                    queue.add(next);
                }
            }
        }
    }


    // 深度优先遍历，先走一条没走过的路走到底，然后再走其他路
    private static void deepOrder(Node node) {
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            node = stack.pop();
            for (Node next : node.nexts) {
                if (!set.contains(next)) {
                    stack.push(node);
                    stack.push(next);
                    set.add(next);
                    System.out.println(node.value);
                    break;
                }
            }
        }
    }

    // 拓扑排序，依次擦掉入度为0的点，剩下的入度重新计算，继续擦除入度为0的点
    // 适应于build时的依赖问题
    private static List<Node> tuopuSort(Graph graph) {
        // Node剩余入度
        Map<Node, Integer> inMap = new HashMap<>();
        // 入度为0
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }

        // 将
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node node = zeroInQueue.poll(); // 擦除node为0的点，刚开始为头节点
            result.add(node);
            for (Node next : node.nexts) {
                next.in--;
                inMap.put(next, next.in);//后续in - 1
                if (next.in == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }

    /**
     * 最小生成树-k算法
     */
    private static void kruskal(Graph graph) {
        List<Edge> edges = new ArrayList<>(graph.edges);
        edges.sort(Comparator.comparingInt(e -> e.weight));
        Set<Node> set = new HashSet<>();
        for (Edge edge : edges) {
            Node from = edge.from;
            Node to = edge.to;
            if (!set.contains(from) || !set.contains(to)) {
                set.add(from);
                set.add(to);
                System.out.print(from.value + "\t");
                System.out.print(to.value + "\t");
            }
        }
    }
}