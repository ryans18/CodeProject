package Middle.Class3;

/**
 * Author：Ryans
 * Date：Created in 2022/10/1 15:04
 * Introduction：冰箱问题，给一个数组代表冰箱和冰箱里的衣服，问把冰箱里的衣服平均到所有冰箱需要多少步。一次只能放一件给左或右
 *
 * 1. left 为负， right为负。 则至少需要 left + right
 * 2. left 为正，right为正。则至少需要 max(left, right)
 * 3. left为正，right为负。则至少需要max(left, right)。 i既可以接收，又可以外放。
 * 依次求每个位置的次数，最大的就是需要的步数
 */
public class PackingMachine {

    private static int getMinOps(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int sum = 0;
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }
        if (sum % size != 0) {
            return -1;
        }
        int avg = sum / size;
        int res = 0;
        int leftSum = 0;  // 左边已经有的衣服数量
        for (int i = 0; i < size; i++) {
            int leftRest = leftSum - i * avg;
            int rightRest = (sum - leftSum - arr[i]) - (size - i - 1) * avg;
            if (leftRest < 0 && rightRest < 0) {
                res = Math.max(res, Math.abs(leftRest) + Math.abs(rightRest));
            } else {
                res = Math.max(res, Math.max(Math.abs(leftRest), Math.abs(rightRest)));
            }
            leftSum += arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {100, 0, 0, 0};
        System.out.println(getMinOps(arr));
    }
}