package DiGui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author : Ryans
 * Date : 2022/9/13
 * Introduction : 子集问题, 不重复
 */
public class SonStr {

    public static void main(String[] args) {
        int[] arr = new int[] {2,6,8,3,5};
        backtracking(arr, 0);
        System.out.println(result);
    }

    private static List<List<Integer>> result = new ArrayList<>();
    private static LinkedList<Integer> path = new LinkedList<>();
    private static void backtracking(int[] arr, int startIndex) {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < arr.length; i++) {
            path.add(arr[i]);
            backtracking(arr, i + 1);
            path.removeLast();
        }
    }
}
