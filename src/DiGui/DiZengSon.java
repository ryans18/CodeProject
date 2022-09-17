package DiGui;

import java.util.*;

/**
 * Author : Ryans
 * Date : 2022/9/13
 * Introduction : 找出一个数组的递增子序列
 */
public class DiZengSon {
    public static void main(String[] args) {
        int[] arr = new int[] {4, 6, 7, 7};
        backtracking(arr, 0);
        System.out.println(result);
    }

    private static List<List<Integer>> result = new ArrayList<>();
    private static LinkedList<Integer> path = new LinkedList<>();
    private static void backtracking(int[] arr, int startIndex) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }
        Set<Integer> set = new HashSet<>(); // 标识本层元素是否重复
        for (int i = startIndex; i < arr.length; i++) {
            if (path.size() == 0) {
                path.add(arr[i]);
            } else if (arr[i] >= path.getLast() && !set.contains(arr[i])) {
                set.add(arr[i]);
                path.add(arr[i]);
            } else {
                continue;
            }
            backtracking(arr, i + 1);
            path.removeLast();
        }
    }
}
