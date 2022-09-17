package DiGui;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Author : Ryans
 * Date : 2022/9/13
 * Introduction : 全排列
 */
public class Pailie {

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3};
        backtracking(arr);
        System.out.println(result);
    }

    private static List<List<Integer>> result = new ArrayList<>();
    private static LinkedList<Integer> path = new LinkedList<>();
    private static HashSet<Integer> set = new HashSet<>(); // 标记所有元素是否被使用
    private static void backtracking(int[] arr) {
        if (path.size() >= arr.length) {
            result.add(new ArrayList<>(path));
            return;
        }
//        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
                path.add(arr[i]);
            } else {
                continue;
            }
            backtracking(arr);
            path.removeLast();
            set.remove(arr[i]);
        }
    }
}
