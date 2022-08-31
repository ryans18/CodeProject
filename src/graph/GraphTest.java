package graph;

import java.util.*;

/**
 * Author : Ryans
 * Date : 2022/8/30
 * Introduction :
 */
public class GraphTest {

    public static void main(String[] args) {
        Graph graph = createGraph(new int[][] {
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
        kCode(graph);
        pCode(graph);
        diketesila(new ArrayList<Node>(graph.nodes.values()).get(0));
    }

    private static Graph createGraph(int[][] arr) {
        Graph graph = new Graph();
        for (int i = 0; i < arr.length; i++) {
            int fromValue = arr[i][0];
            int toValue = arr[i][1];
            int weight = arr[i][2];
            if (!graph.nodes.containsKey(fromValue)) {
                graph.nodes.put(fromValue, new Node(fromValue));
            }
            if (!graph.nodes.containsKey(toValue)) {
                graph.nodes.put(toValue, new Node(toValue));
            }
            Node from = graph.nodes.get(fromValue);
            Node to = graph.nodes.get(toValue);
            Edge edge = new Edge(weight, from, to);
            from.out++;
            from.edges.add(edge);
            from.nexts.add(to);
            to.in++;
            graph.edges.add(edge);
        }
        return graph;
    }

    private static void widthOrder(Node head) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.add(head);
        set.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.println(head.value);
            for (Node next : head.nexts) {
                if (!set.contains(next)) {
                    queue.add(next);
                }
            }
        }
    }

    private static void deepOrder(Node head) {
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();
        stack.push(head);
        set.add(head);
        System.out.println(head.value);
        while (!stack.isEmpty()) {
            head = stack.pop();
            for (Node next : head.nexts) {
                if (!set.contains(next)) {
                    stack.push(head);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

    private static void tuopuOrder(Graph graph) {
        Queue<Node> zeroQueue = new LinkedList<>();
        Map<Node, Integer> inMap = new HashMap<>();
        for (Node value : graph.nodes.values()) {
            inMap.put(value, value.in);
            if (value.in == 0) {
                zeroQueue.add(value);
            }
        }
        while (!zeroQueue.isEmpty()) {
            Node poll = zeroQueue.poll();
            for (Node next : poll.nexts) {
                inMap.put(next, next.in - 1);
                if (inMap.get(next) == 0) {
                    zeroQueue.add(next);
                }
            }
        }
    }

    private static void kCode(Graph graph) {
        PriorityQueue<Edge> edges = new PriorityQueue<>(new EdgeComparator());
        edges.addAll(graph.edges);
        UnionFind unionFind = new UnionFind();
        Set<Edge> result = new HashSet<>();
        while (!edges.isEmpty()) {
            Edge poll = edges.poll();
            Node from = poll.from;
            Node to = poll.to;
            if (!unionFind.isSameSet(from, to)) {
                unionFind.union(from, to);
                result.add(poll);
            }
        }
        System.out.println(result);
    }

    private static class EdgeComparator implements Comparator<Edge>{

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }


    private static class UnionFind {
        Map<Node, Node> fatherMap = new HashMap<>();
        public UnionFind() {
        }

        public Node findFather(Node node) {
            while (fatherMap.containsKey(node)) {
                node = fatherMap.get(node);
            }
            return node;
        }

        public boolean isSameSet(Node node1, Node node2) {
            return findFather(node1) == findFather(node2);
        }

        public void union(Node node1, Node node2) {
            if (node1 == null || node2 == null) {
                return;
            }
            Node head1 = findFather(node1);
            Node head2 = findFather(node2);
            fatherMap.put(head2, head1);
        }

    }

    private static void pCode(Graph graph) {
        PriorityQueue<Edge> edges = new PriorityQueue<>(new EdgeComparator());
        Set<Node> set = new HashSet<>();
        Node head = new ArrayList<Node>(graph.nodes.values()).get(0);
        edges.addAll(head.edges);
        Set<Edge> result = new HashSet<>();
        while (!edges.isEmpty()) {
            Edge poll = edges.poll();
            Node to = poll.to;
            if (!set.contains(to)) {
                set.add(to);
                result.add(poll);
                edges.addAll(to.edges);
            }
        }
        System.out.println(result);
    }

    private static void diketesila(Node head) {
        Map<Node, Integer> distanceMap = new HashMap<>();
        Set<Node> selectSet = new HashSet<>();
        distanceMap.put(head, 0);
        Node minNode = getMinUnSelectedNode(distanceMap, selectSet);
        while (minNode!= null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node to = edge.to;
                if (!selectSet.contains(to)) {
                    if (distanceMap.containsKey(to)) {
                        distanceMap.put(to, Math.min(distanceMap.get(to), distance + edge.weight));
                    } else {
                        distanceMap.put(to,  distance + edge.weight);
                    }
                }
            }
            selectSet.add(minNode);
            minNode = getMinUnSelectedNode(distanceMap, selectSet);
        }
        System.out.println(distanceMap);
    }

    private static Node getMinUnSelectedNode(Map<Node, Integer> distanceMap, Set<Node> selectSet) {
        int distance = Integer.MAX_VALUE;
        Node minNode = null;
        for (Node node : distanceMap.keySet()) {
            if (distanceMap.get(node) < distance && !selectSet.contains(node)) {
                distance = distanceMap.get(node);
                minNode = node;
            }
        }
        return minNode;
    }


}
