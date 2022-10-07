package Middle.Class9;

import java.util.HashSet;

/**
 * Author：Ryans
 * Date：Created in 2022/10/5 16:04
 * Introduction：土豪送礼给主播帮助其涨人气。主播初始人气为start，要求刚好达到end
 * 点赞人气+2，送礼人气翻倍，私聊人气-2.
 */
public class SendGiftCost {

    public static void main(String[] args) {
        System.out.println(minCost(3, 100, 1, 2, 6));
        System.out.println(minCost(3, 100, 1, 2, 6) == 6);
    }

    /**
     *
     * @param x 点赞花费
     * @param y 送礼物cost
     * @param z 私聊cost
     * @param start 初始人气
     * @param end end 人气
     * @return
     */
    private static int  minCost(int x, int y, int z, int start, int end) {
        return process(x, y, z, end, (end - start) / 2 * x, start, 0);
    }

    private static int process(int x, int y, int z, int end, int limitCost, int cur, int curCost) {
        if (cur <= 0) {
            return Integer.MAX_VALUE;
        }
        if (curCost > limitCost) {
            return Integer.MAX_VALUE;
        }
        if (cur == end) {
            return curCost;
        }
        if (cur > end) { // 已经大于了，只允许-
            return process(x, y, z, end,  limitCost,cur - 2, curCost + z);
        }
        int p1 = process(x, y, z, end, limitCost, cur + 2, curCost + x); //
        int p2 = process(x, y, z, end,  limitCost,cur * 2, curCost + y);
        int p3 = process(x, y, z, end, limitCost,cur - 2, curCost + z);
        return Math.min(Math.min(p1, p2), p3);
    }
}