package linearlist.theprefixand.sortprefix.sort;

import java.util.Arrays;

/**
 * @author luna
 * 2022/6/23
 */
public class RangeSumOfSortedSubarraySums1508 {

    /**
     * 1508. 子数组和排序后的区间和
     * 给你一个数组 nums ，它包含 n 个正整数。你需要计算所有非空连续子数组的和，并将它们按升序排序，得到一个新的包含 n * (n + 1) / 2 个数字的数组。
     * <p>
     * 请你返回在新数组中下标为 left 到 right （下标从 1 开始）的所有数字和（包括左右端点）。由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3,4], n = 4, left = 1, right = 5
     * 输出：13
     * 解释：所有的子数组和为 1, 3, 6, 10, 2, 5, 9, 3, 7, 4 。将它们升序排序后，我们得到新的数组 [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] 。下标从 le = 1 到 ri = 5 的和为 1 + 2 + 3 + 3 + 4 = 13 。
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3,4], n = 4, left = 3, right = 4
     * 输出：6
     * 解释：给定数组与示例 1 一样，所以新数组为 [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] 。下标从 le = 3 到 ri = 4 的和为 3 + 3 = 6 。
     * 示例 3：
     * <p>
     * 输入：nums = [1,2,3,4], n = 4, left = 1, right = 10
     * 输出：50
     * @param args
     */
    public static void main(String[] args) {

    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        final int MODULO = 1000000007;
        // 对于长度为 nn 的数组，其中的非空连续子数组一共有 [nx(n+1)]/2 个，对应的子数组的和也一共有[nx(n+1)]/2个。
        // 创建一个长度为 [nx(n+1)]/2 的数组 sums 存储所有的子数组的和
        int sumsLength = n * (n + 1) / 2;
        int[] sums = new int[sumsLength];
        int index = 0;
        // 计算子数组的和时，将 i 从 0 到 n-1 依次遍历，对于每个 i，将 i 作为子数组最左侧的下标，
        for (int i = 0; i < n; i++) {
            // 分别计算每个子数组的和，将子数组的和存入数组 sums 中。
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                sums[index++] = sum;
            }
        }
        Arrays.sort(sums);
        int ans = 0;
        for (int i = left - 1; i < right; i++) {
            ans = (ans + sums[i]) % MODULO;
        }
        return ans;
    }


}
