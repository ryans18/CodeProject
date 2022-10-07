package Middle.Class4;

/**
 * Author：Ryans
 * Date：Created in 2022/10/2 22:36
 * Introduction：给定一个数组arr长度为N，你可以把任意长度大于0且小于N的前缀作为左部分，剩下的作为右部分。但是每种划分都有做部分的最大值和右部分的最小值，请返回最大的。
 * 思路：整个数组的最大值一定在左部分或右部分。所以结果为Max- 右边一个的大数。 那么N-1位置一定每次切割都会包含在右边内。
 * 假设N-1位置的数就是最小的数。那么就是Max - arr(N-1)。如果N-1位置的数不是最小。那么右边的最大值一定是>= arr(N-1)的。
 *
 */
public class CutArray {

}