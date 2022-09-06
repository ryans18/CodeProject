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
        prim(graph);
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
        dijkstra2(new ArrayList<Node>(graph.nodes.values()).get(0));
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
    // 为什么又把node压回栈中————node可能还有其它next，但刚才break掉了
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
                    System.out.println(next.value);
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
     * 把所有的边从小到大排序，依次选择最小的边(可能并不在一起)，然后把所有的边合并在一起。如果已经是一个集合就不再加了
     * (初始，设置每个节点都自成一个集合)
     */
    private static Set<Edge> kruskal2(Graph graph) {
        List<Edge> edges = new ArrayList<>(graph.edges);
        edges.sort(Comparator.comparingInt(e -> e.weight));
        UnionFind unionFind = new UnionFind();
//        unionFind.makeSets(graph.nodes.values());
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

    /**
     * 最小生成树-prim算法
     * 随机找一个点，标记所有的边并选择最小的边，然后边所指向的to节点，把to节点所有的边标记，然后选择所有标记的最小的边
     * 通过set判断已经加过的节点时，就不再加这条边
     * @return
     */
    private static Set<Edge> prim(Graph graph) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(new EdgeComparator());
        Set<Node> set = new HashSet<>();
        List<Node> values = new ArrayList<>(graph.nodes.values());
        Node node = values.get(0);
        Set<Edge> result = new HashSet<>();
        if (!set.contains(node)) {
            set.add(node);
            queue.addAll(node.edges);
            while (!queue.isEmpty()) {
                Edge edge = queue.poll();
                Node to = edge.to;
                if (!set.contains(to)) {
                    queue.addAll(to.edges);
                    set.add(to);
                    result.add(edge);
                }
            }
        }
        return result;
    }

    private static class EdgeComparator implements Comparator<Edge>{

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
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

    /**
     * 并查集，解决两个不同的集合合并问题以及判断是否为同一集合
     * 初始化，所有Node自己为一个集合，
     */
    private static class UnionFind {
        private HashMap<Node, Node> fatherMap;
        public UnionFind() {
            fatherMap = new HashMap<>();
        }

        private Node findFather(Node node) {
            while (fatherMap.containsKey(node)) {
                node = fatherMap.get(node);
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
                fatherMap.put(head2, head1);
            }
        }
    }

    // 工具-数字转为字母
    private static String value2String (int value) {
        return String.valueOf((char)(value + 'A' - 1));
    }

    /******************************************************************************************************************/

    /**
     * 迪克特斯拉算法-最短路径(从一个点出发)
     * 先初始化head到head距离为0，到其它节点为空。然后从head出发，修改to节点的距离。找到一条最短距离，继续to出发，修改它周围节点的距离（d+weight即为head到该节点的距离）
     * @param head
     */
    private static void dijkstra(Node head) {
        Set<Node> selectSet = new HashSet<>();
        Map<Node, Integer> distanceMap = new HashMap<>(); // 节点到head的距离
        distanceMap.put(head, 0);
        Node minNode = getMinDistanceNotInSet(distanceMap, selectSet);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node to = edge.to;
               if (!selectSet.contains(to)) {
                   if (distanceMap.containsKey(to)) {
                       distanceMap.put(to, Math.min(distanceMap.get(to), distance + edge.weight));
                   } else {
                       distanceMap.put(to, distance + edge.weight);
                   }
               }
            }
            selectSet.add(minNode);
            minNode = getMinDistanceNotInSet(distanceMap, selectSet);
        }
        System.out.println(distanceMap);
    }

    private static Node getMinDistanceNotInSet(Map<Node, Integer> map, Set<Node> set) {
        int distance = Integer.MAX_VALUE;
        Node minNode = null;
        for (Node node : map.keySet()) {
            if (!set.contains(node) && map.get(node) < distance) {
                distance = map.get(node);
                minNode = node;
            }
        }
//        for (Edge edge : head.edges) {
//            if (!set.contains(edge.to) && edge.weight <= distance) {
//                distance = edge.weight;
//                minNode = edge.to;
//            }
//        }
        return minNode;
    }

    /******************************************************************************************************************/

    /**
     * 迪克特斯拉算法2，使用自定义小根堆，优化。
     */
    private static void dijkstra2(Node head) {
        int size = getGraphSize(head);
        NodeHeap nodeHeap = new NodeHeap(size);
        Map<Node, Integer> result = new HashMap<>();
        nodeHeap.addOrUpdateOrIgnore(head, 0);
        while (!nodeHeap.isEmpty()) {
            NodeResult nodeResult = nodeHeap.pop();
            int distance = nodeResult.distance;
            Node node = nodeResult.node;
            for (Edge edge : node.edges) {
                Node to = edge.to;
                nodeHeap.addOrUpdateOrIgnore(to, distance + edge.weight);
            }
            result.put(node, distance);
        }
        System.out.println(result);
    }

    private static int getGraphSize(Node head) {
        Set<Node> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        set.add(head);
        queue.add(head);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (Node next : poll.nexts) {
                if (!set.contains(next)) {
                    queue.add(next);
                    set.add(next);
                }
            }
        }
        return set.size();
    }
}