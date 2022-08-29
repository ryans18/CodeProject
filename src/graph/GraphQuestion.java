package graph;

import com.sun.applet2.AppletParameters;

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
        kruskal2(graph);
        Set<Integer> set = new HashSet<>();
        set.add(0);
        set.add(1);
        set.add(34);
        set.add(39);
        set.add(55);
        set.add(108);
        if (set.contains(34) && set.contains(55)) {
            System.out.println("same");
        }
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
    /******************************************************************************************************************/
    /**
     * 最小生成树-k算法
     */
    private static Set<Edge> kruskal(Graph graph) {
        List<Edge> edges = new ArrayList<>(graph.edges);
        edges.sort(Comparator.comparingInt(e -> e.weight));
        Set<Node> set = new HashSet<>();
        MySets mySets = new MySets(new ArrayList<Node>(graph.nodes.values()));
        Set<Edge> result = new HashSet<>();
        for (Edge edge : edges) {
            Node from = edge.from;
            Node to = edge.to;
            if (!mySets.isSameSet(from, to)) {
                mySets.union(from, to);
                result.add(edge);
            }
        }
        return result;
    }
    /**
     * 最小生成树-k算法2
     */
    private static Set<Edge> kruskal2(Graph graph) {
        List<Edge> edges = new ArrayList<>(graph.edges);
        edges.sort(Comparator.comparingInt(e -> e.weight));
        UnionFind unionFind = new UnionFind();
        unionFind.makeSets(graph.nodes.values());
        Set<Edge> result = new HashSet<>();
        for (Edge edge : edges) {
            Node from = edge.from;
            Node to = edge.to;
            if (!unionFind.isSameSet(from, to)) {
                unionFind.union(from, to);
                result.add(edge);
            }
        }
        return result;
    }


    private static class MySets {
        HashMap<Node, List<Node>> setMap = new HashMap<>(); // 存放节点及所在的集合
        public MySets(List<Node> nodes) {
            for (Node node : nodes) {
                List<Node> set = new ArrayList<>();
                set.add(node);
                setMap.put(node, set);
            }
        }

        public boolean isSameSet(Node n1, Node n2) {
            List<Node> nodes1 = setMap.get(n1);
            List<Node> nodes2 = setMap.get(n2);
            return nodes1 == nodes2;
        }

        public void union(Node node1, Node node2) {
            List<Node> nodes1 = setMap.get(node1);
            List<Node> nodes2 = setMap.get(node2);
            for (Node node : nodes2) {
                nodes1.add(node);
                setMap.put(node, nodes1);
            }
        }
    }

    // 并查集
    private static class UnionFind {
        private HashMap<Node, Node> fatherMap;
        private HashMap<Node, Integer> sizeMap;
        public UnionFind() {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }
        public void makeSets(Collection<Node> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        private Node findFather(Node node) {
            Stack<Node> stack = new Stack<>();
            while (node != fatherMap.get(node)) {
                stack.add(node);
                node = fatherMap.get(node);
            }
            while (!stack.isEmpty()) {
                fatherMap.put(stack.pop(), node);
            }
            return node;
        }

        private boolean isSameSet(Node node1, Node node2) {
            return findFather(node1) == findFather(node2);
        }

        private void union(Node node1, Node node2) {
            if (node1 == null || node2 == null) {
                return;
            }
            Node head1 = findFather(node1);
            Node head2 = findFather(node2);
            if (head1 != head2) {
                int size1 = sizeMap.get(head1);
                int size2 = sizeMap.get(head2);
                if (size1 >= size2) {
                    fatherMap.put(head2, head1);
                    sizeMap.put(head1, size1 + size2);
                    sizeMap.remove(head2);
                } else {
                    fatherMap.put(head1, head2);
                    sizeMap.put(head2, size1 + size2);
                    sizeMap.remove(head1);
                }
            }
        }
    }

    // 工具-数字转为字母
    private static String value2String (int value) {
        return String.valueOf((char)(value + 'A' - 1));
    }

    /******************************************************************************************************************/
}