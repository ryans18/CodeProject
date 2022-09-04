package tanxin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Author：Ryans
 * Date：Created in 2022/9/4 15:35
 * Introduction：花费与收益问题。
 * 准备一个小根堆，根据花费排序。准备一个大根堆根据利润排序
 */
public class Earning {

    public static void main(String[] args) {

        Earn[] earns  = new Earn[] {
          new Earn(1, 1),
          new Earn(1, 4),
          new Earn(2, 3),
          new Earn(2, 7),
          new Earn(3, 2),
          new Earn(4, 10),
        };
        int income = getMaxEarn(earns, 4, 1);
        System.out.println(income);

    }

    /**
     *
     * @param earnings
     * @param k  几个项目
     * @param money 初始资金
     * @return  最终资金
     */
    private static int getMaxEarn(Earn[] earnings, int k, int money) {
        PriorityQueue<Earn> minCostQueue = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Earn> maxIncomeQueue = new PriorityQueue<>(new MaxIncomeComparator());
        minCostQueue.addAll(Arrays.asList(earnings));
        for (int i = 0; i < k; i++) {
            while (!minCostQueue.isEmpty() && minCostQueue.peek().cost <= money) {
                maxIncomeQueue.add(minCostQueue.poll());
            }
            if (maxIncomeQueue.isEmpty()) {
                return money;
            }
            money += maxIncomeQueue.poll().income;
        }
        return money;
    }


    private static class MinCostComparator implements Comparator<Earn> {

        @Override
        public int compare(Earn o1, Earn o2) {
            return o1.cost - o2.cost;
        }
    }

    private static class MaxIncomeComparator implements Comparator<Earn> {

        @Override
        public int compare(Earn o1, Earn o2) {
            return o2.income - o1.income;
        }
    }

    private static class Earn {
        int cost;
        int income;

        public Earn(int cost, int income) {
            this.cost = cost;
            this.income = income;
        }
    }

}