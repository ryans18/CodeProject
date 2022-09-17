package DiGui;

import java.util.*;

/**
 * Author : Ryans
 * Date : 2022/9/13
 * Introduction : 全排列， 包含重复的元素
 */
public class Pailie2 {

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3};
        Arrays.sort(arr);
        boolean[] used = new boolean[arr.length];
        backtracking(arr, used);
        System.out.println(result);
    }

    private static List<List<Integer>> result = new ArrayList<>();
    private static LinkedList<Integer> path = new LinkedList<>();
    private static void backtracking(int[] arr, boolean[] used) {
        if (path.size() >= arr.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1] && used[i -1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                path.add(arr[i]);
                backtracking(arr, used);
                path.removeLast();
                used[i] = false;
//                set.remove(arr[i]);
            }
        }
    }
}
