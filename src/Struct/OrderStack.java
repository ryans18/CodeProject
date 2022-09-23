package Struct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Author : Ryans
 * Date : 2022/9/19
 * Introduction : 单调栈
 * 求一个数组中每一个数，得到左边最近的比它大的和右边最近的比它大的数
 * 时间复杂度为O(N),单个接近O(1)
 * 一个栈，栈中的数从大到小排列，遍历数组时与栈顶比较，如果比栈顶大，那么栈顶数的右边比它大即为当前数，栈顶下一个即为左边比它大的数。弹出栈顶的数，再把当前数放入。
 * 最后剩下的数则是数组中最大的数，从大到小排列，又因为for循环已经退出，没有找到更大的当前数，所以没有右边大的数，左边为栈顶的下一个
 */
public class OrderStack {

    private Stack<LinkedList<Integer>> stack;  // 相同的数放在LinkedList里，解决数字重复问题

    public OrderStack() {
        stack = new Stack<>();   // 从大到小排列, Stack中存index
    }

    public static int[][] getNearBigNumNoRepeat(int[] arr) {
        int[][] result = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            // 如果还有比栈里的数大的话，栈里的数是从大到小排列的，所以可能会有多个数比当前数小
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) { // stack 是单调递减的，所以可能左边多个数的最大值都是当前值。
                int popIndex = stack.pop();
                int left = stack.isEmpty() ? -999 : arr[stack.peek()];
                result[popIndex][0] = left;
                result[popIndex][1] = arr[i];
            }
            stack.push(i);
        }
        // 为什么还有几个数，for循环没有找到比stack里任何一个大的数
        // 剩下的是最大的几个数
        // 最后剩下的数位左，右两边都没有比它大的数，即整个数组最大的数。
        while (!stack.isEmpty()) {
            int popIndex = stack.pop();
            result[popIndex][0] = stack.isEmpty() ? -999 :arr[stack.peek()];
            result[popIndex][1] = -999;
        }
        return result;
    }

    // 可重复,
    public static int[][] getNearBigNum(int[] arr) {
        int[][] result = new int[arr.length][2];
        Stack<LinkedList<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek().peekLast()]) {
                LinkedList<Integer> pop = stack.pop();
                int left = stack.isEmpty() ? -999 : arr[stack.peek().peekLast()];
                for (Integer index : pop) {
                    result[index][0] = left;
                    result[index][1] = arr[i];
                }
            }
            // 添加当前数
            // stack 是按照从大到小的所以，如果遇到相等的数，一定是在一起，之前的小的数已经被pop
            if (!stack.isEmpty() && arr[stack.peek().peekLast()] == arr[i]) {
                stack.peek().add(i);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                stack.push(list);
            }
        }
        // 处理最后比较大的数
        while (!stack.isEmpty()) {
            LinkedList<Integer> pop = stack.pop();
            int left = stack.isEmpty() ? -999 : arr[stack.peek().peekLast()];
            for (Integer index : pop) {
                result[index][0] = left;
                result[index][1] = -999;
            }
        }
        return result;
    }


    public static void main(String[] args) {
//        int[] arr = new int[] {3,7,9,4,5,2,6,13, 8, 5, 3};
//        int[] arr = new int[] {20, 18, 15, 10, 5, 1, 7, 11, 17};
        int[] arr = new int[] {20, 18, 20, 15, 10, 5, 10, 5, 1, 7, 11, 17};
        int[][] bigNums = getNearBigNum(arr);
        System.out.println(bigNums);
    }
}
