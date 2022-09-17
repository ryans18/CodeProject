package DiGui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author : Ryans
 * Date : 2022/9/13
 * Introduction : 组合问题
 */
public class ZuHe {

    public static void main(String[] args) {
        int[] arr = new int[] {3,6,8,4,0};
        backtracking(arr, 2, 0);
        System.out.println(result);
    }

    private static List<List<Integer>> result = new ArrayList<>();
    private static LinkedList<Integer> path = new LinkedList<>();
    private static void backtracking(int[] arr, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        // length:5, startIndex:2, k:4,  -> i < 2.  5-4 + 1
        // i < arr.length + 1 - k
        for (int i = startIndex; i < arr.length - (k - path.size()) + 1 ; i++) {
            path.add(arr[i]);
            backtracking(arr, k, i + 1);
            path.removeLast();
        }
    }
}
