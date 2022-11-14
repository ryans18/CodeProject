package Middle.Class5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author : Ryans
 * Date : 2022/10/9
 * Introduction : 队列结构实现栈，栈结构实现队列
 */
public class StackQueue {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.push(2);
        queue.push(5);
        queue.push(9);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(7);
        System.out.println(queue.peek());
        System.out.println("------------------");
        MyStack<Integer> stack = new MyStack<>();
        System.out.println(stack.peek());
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        stack.push(3);
        System.out.println(stack.peek());

        /*stack.push(2);
        stack.push(5);
        stack.push(9);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(7);
        System.out.println(stack.pop());*/
    }

    /**
     * 一个push栈，一个pop栈，当pop栈没东西时，把push栈里所有东西放进pop栈里
     * @param <T>
     */
    private static class MyQueue<T> {

        private Stack<T> pushStack;
        private Stack<T> popStack;

        public MyQueue() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        private void push(T t) {
            pushStack.push(t);
        }

        private T pop() {
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.pop();
        }

        private T peek() {
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.peek();
        }
    }

    /**
     * 两个队列实现栈
     * 如果一个队列里有东西，把所有倒出到另一个，只剩一个返回。加入时加到有东西的那个里。
     * 时刻保持一个队列有东西，另一个为空。
     * @param <T>
     */
    private static class MyStack<T> {

        Queue<T> queue1;
        Queue<T> queue2;

        private MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        private void push(T t) {
            if (!queue2.isEmpty()) {
                queue2.add(t);
            } else {
                queue1.add(t);
            }
        }

        private T pop() {
            if (!queue2.isEmpty()) {
                while (queue2.size() > 1) {
                    queue1.add(queue2.poll());
                }
                return queue2.poll();
            } else {
                while (queue1.size() > 1) {
                    queue2.add(queue1.poll());
                }
                return queue1.poll();
            }
        }

        private T peek() {
            if (!queue2.isEmpty()) {
                while (queue2.size() > 1) {
                    queue1.add(queue2.poll());
                }
                T peek = queue2.peek();
                queue1.add(queue2.poll());
                return peek;
            } else {
                while (queue1.size() > 1) {
                    queue2.add(queue1.poll());
                }
                T peek = queue1.peek();
                queue2.add(queue1.poll());
                return peek;
            }
        }
    }

}
