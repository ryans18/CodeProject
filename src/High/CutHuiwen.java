package High;

/**
 * Author：Ryans
 * Date：Created in 2022/10/15 18:04
 * Introduction：求最小分割字符串，形成都是回问字串的方法
 * 思路：从左到右尝试模型。i到j判断是否为回问，如果是的话递归调用剩余长度
 * 预处理：范围模型，判断i到j是否为回问。使得上面判断变为O(1)。从而使得时间复杂度由O(N³)变为O(N²)
 *
 */
public class CutHuiwen {

}