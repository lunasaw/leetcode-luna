package linearlist.theprefixand.prefixandbase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luna
 * 2022/6/14
 */

public class SumOfAllOddLengthSubarrays1588 {

    /**
     * 1588. 所有奇数长度子数组的和
     * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
     * <p>
     * 子数组 定义为原数组中的一个连续子序列。
     * <p>
     * 请你返回 arr 中 所有奇数长度子数组的和 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [1,4,2,5,3]
     * 输出：58
     * 解释：所有奇数长度子数组和它们的和为：
     * [1] = 1
     * [4] = 4
     * [2] = 2
     * [5] = 5
     * [3] = 3
     * [1,4,2] = 7
     * [4,2,5] = 11
     * [2,5,3] = 10
     * [1,4,2,5,3] = 15
     * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
     * 示例 2：
     * <p>
     * 输入：arr = [1,2]
     * 输出：3
     * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
     * 示例 3：
     * <p>
     * 输入：arr = [10,11,12]
     * 输出：66
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= arr.length <= 100
     * 1 <= arr[i] <= 1000
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * 方法一：暴力
     * 最简单的方法是遍历数组 {arr}arr 中的每个长度为奇数的子数组，计算这些子数组的和。由于只需要计算所有长度为奇数的子数组的和，
     * 不需要分别计算每个子数组的和，因此只需要维护一个变量 {sum}sum 存储总和即可。
     * <p>
     * 实现方面，令数组 {arr}arr 的长度为 nn，子数组的开始下标为 {start}start，长度为 {length}length，
     * 结束下标为 {end}end，则有 0 \le {start} \le {end} < n0≤start≤end<n，
     * {length} = {end} - {start} + 1length=end−start+1 为奇数。遍历符合上述条件的子数组，计算所有长度为奇数的子数组的和。
     *
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int length = 0; length + i < n; length += 2) {
                int end = length + i;
                for (int start = i; start <= end; start++) {
                    sum += arr[start];
                }
            }
        }
        return sum;
    }

    /**
     * 方法二：前缀和
     * 方法一中，对于每个子数组需要使用 O(n)O(n) 的时间计算子数组的和。如果能将计算每个子数组的和的时间复杂度从 O(n)O(n) 降低到 O(1)O(1)，则能将总时间复杂度从 O(n^3)O(n
     * 3
     * ) 降低到 O(n^2)O(n
     * 2
     * )。
     * <p>
     * 为了在 O(1)O(1) 的时间内得到每个子数组的和，可以使用前缀和。创建长度为 n + 1n+1 的前缀和数组 {prefixSums}prefixSums，
     * 其中 {prefixSums}[0] = 0prefixSums[0]=0，当 1 \le i \le n1≤i≤n 时，{prefixSums}[i]prefixSums[i] 表示数组 {arr}arr 从下标 00 到下标 i - 1i−1 的元素和。
     * <p>
     * 得到前缀和数组 {prefixSums}prefixSums 之后，对于 0 \le {start} \le {end} < n0≤start≤end<n，
     * 数组 {arr}arr 的下标范围 [{start}, {end}][start,end] 的子数组的
     * 和为 {prefixSums}[{end} + 1] - {prefixSums}[{start}]prefixSums[end+1]−prefixSums[start]，可以在 O(1)O(1) 的时间内得到每个子数组的和。
     *
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays2(int[] arr) {
        int n = arr.length;
        int[] prefixSums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + arr[i];
        }
        int sum = 0;
        for (int start = 0; start < n; start++) {
            for (int length = 1; start + length <= n; length += 2) {
                int end = start + length - 1;
                sum += prefixSums[end + 1] - prefixSums[start];
            }
        }
        return sum;
    }

}
