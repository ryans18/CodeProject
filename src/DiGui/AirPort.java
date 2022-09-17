package DiGui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author : Ryans
 * Date : 2022/9/14
 * Introduction : 输入机场的起点和终点，使其连成一块
 */
public class AirPort {

    public static void main(String[] args) {
        String[][] strs = new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};

//        String[][] strs = new String[][] {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        String from = "JFK";
        path.add(from);
        boolean[] used = new boolean[strs.length];
        backtracking(strs, from, used);
        System.out.println(result);
    }

    private static List<String> result = new ArrayList<>();
    private static LinkedList<String> path = new LinkedList<>();
    private static void backtracking(String[][] arr, String from, boolean[] used) {
        if (path.size() == arr.length + 1) {
            if (result.size() > 0) {
                String old = "";
                String newS = "";
                for (String s : result) {
                    old += s;
                }
                for (String s : path) {
                    newS += s;
                }
                if (old.compareTo(newS) > 0) {
                    result.clear();
                    result.addAll(new ArrayList<>(path));
                }
            } else {
                result.addAll(new ArrayList<>(path));
            }

            return;
        }
        for (int i = 0; i < arr.length; i++) {
            String[] strings = arr[i];
            String str1 = strings[0];
            String str2 = strings[1];
            if (str1.equals(from) && !used[i]) {
                path.add(str2);
                used[i] = true;
                backtracking(arr, str2, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
