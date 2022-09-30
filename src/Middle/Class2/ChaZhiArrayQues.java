package Middle.Class2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Author : Ryans
 * Date : 2022/9/30
 * Introduction : 给定一个arr，求差值为k的去重数字对
 * 差值为k： k=2； 0,2|3,5
 * 去重： 0,2与2,0是一样
 */
public class ChaZhiArrayQues {

    private static List<List<Integer>> getKNumsArray(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hashSet.add(arr[i]);
        };
        for (Integer integer : hashSet) {
            if (hashSet.contains(integer + k)) {
                result.add(Arrays.asList(integer, integer+k));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3,6,8,3,5,2,4,8,3,5,7,8,6};
        System.out.println(getKNumsArray(arr, 3));
    }
}
