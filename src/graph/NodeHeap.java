package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Author : Ryans
 * Date : 2022/9/6
 * Introduction : 自定义Heap，适应于迪力特斯拉算法计算最短路径
 * 自定义原因：系统的堆@PriorityQueue,无法做到修改后重新形成大根堆
 */
public class NodeHeap {

    private Node[] nodes;
    private Map<Node, Integer> nodeIndexMap; // 存放node的位置信息 。 -1表示已经锁定
    private Map<Node, Integer> distanceMap;  // 存放node到head的距离信息
    private int size;

    public NodeHeap(int size) {
        nodes = new Node[size];
        nodeIndexMap = new HashMap<>();
        distanceMap = new HashMap<>();
        this.size = 0;
    }

    // 没有就添加。有了看是否比之前的小。小的话更新，否则忽略
    public void addOrUpdateOrIgnore(Node node, int distance) {
        if (isInHeap(node)) { // update, distance变小，往上更新
            distanceMap.put(node, Math.min(distance, distanceMap.get(node)));
            insertHeapify(nodeIndexMap.get(node)); // 从中间往上怼
        } else if (!isEntered(node)) { // 在堆尾添加
            nodes[size] = node;
            distanceMap.put(node, distance);
            nodeIndexMap.put(node, size);
            insertHeapify(size);
            this.size++;
        }
    }

    public NodeResult pop() {
        Node head = nodes[0];
        NodeResult nodeResult = new NodeResult(head, distanceMap.get(head));
        swap(0, size - 1);
        distanceMap.remove(head);
        nodeIndexMap.put(head, -1);
        nodes[size - 1] = null;
        this.size--;
        heapify(0);
        return nodeResult;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    // 从下面往上怼
    private void insertHeapify(int index) {
        while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])){
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 删除一个，下面往上怼
    private void heapify(int index) {
        int left = index * 2 + 1;
        while (left < size) {
            int minerIndex = left + 1 < size &&
                    distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left])? left + 1: left;
            minerIndex = distanceMap.get(nodes[index]) < distanceMap.get(nodes[minerIndex])? index : minerIndex;
            if (minerIndex == index) {
                break;
            }
            swap(minerIndex, index);
            index = minerIndex;
            left = index * 2 + 1;
        }
    }

    // 是否进来过，并且没有锁定
    private boolean isInHeap(Node node) {
        return isEntered(node) && nodeIndexMap.get(node) != -1;
    }

    // 是否进来过
    private boolean isEntered(Node node) {
        return nodeIndexMap.containsKey(node);
    }

    // 真正的堆数组交换，heapIndexMap也交换
    private void swap(int i, int j) {
        nodeIndexMap.put(nodes[i], j);
        nodeIndexMap.put(nodes[j], i);
        Node temp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = temp;
    }
}
