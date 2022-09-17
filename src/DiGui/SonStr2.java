package DiGui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Author : Ryans
 * Date : 2022/9/13
 * Introduction : 子集问题-可重复
 */
public class SonStr2 {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,2};
        backtracking(arr, 0);
        System.out.println(result);
    }

    private static List<List<Integer>> result = new ArrayList<>();
    private static LinkedList<Integer> path = new LinkedList<>();
    private static void backtracking(int[] arr, int startIndex) {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < arr.length; i++) {
            if (i > startIndex && arr[i - 1] == arr[i]) {
                continue;
            }
            path.add(arr[i]);
            backtracking(arr, i + 1);
            path.removeLast();
        }

    }
}
