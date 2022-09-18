package Digui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author：Ryans
 * Date：Created in 2022/9/12 22:09
 * Introduction: 求一个字符串的所有子集(字符串中不包含重复元素)
 */
public class SonArrs {
    public static void main(String[] args) {
        int[] arr = new int[] {2,6,7,3,9};
        backtracking(arr, 0);
        System.out.println(result);
    }

    private static List<List<Integer>> result = new ArrayList<>();
    private static LinkedList<Integer> path = new LinkedList<>();

    private static void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}