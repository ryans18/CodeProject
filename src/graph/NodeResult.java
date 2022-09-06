package graph;

/**
 * Author : Ryans
 * Date : 2022/9/6
 * Introduction : {@link NodeHeap}
 */
public class NodeResult {

    Node node;
    int distance;

    public NodeResult(Node node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
