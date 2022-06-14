package linearlist.linearenum.twoarrays;

import array.Subsets78;
import com.google.common.collect.Lists;

import java.util.*;

/**
 * @author luna
 * 2022/6/14
 */

public class SumOfSubarrayRanges2104 {


    /**
     * 2104. 子数组范围和
     * 给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。
     * <p>
     * 返回 nums 中 所有 子数组范围的 和 。
     * <p>
     * 子数组是数组中一个连续 非空 的元素序列。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：4
     * 解释：nums 的 6 个子数组如下所示：
     * [1]，范围 = 最大 - 最小 = 1 - 1 = 0
     * [2]，范围 = 2 - 2 = 0
     * [3]，范围 = 3 - 3 = 0
     * [1,2]，范围 = 2 - 1 = 1
     * [2,3]，范围 = 3 - 2 = 1
     * [1,2,3]，范围 = 3 - 1 = 2
     * 所有范围的和是 0 + 0 + 0 + 1 + 1 + 2 = 4
     * 示例 2：
     * <p>
     * 输入：nums = [1,3,3]
     * 输出：4
     * 解释：nums 的 6 个子数组如下所示：
     * [1]，范围 = 最大 - 最小 = 1 - 1 = 0
     * [3]，范围 = 3 - 3 = 0
     * [3]，范围 = 3 - 3 = 0
     * [1,3]，范围 = 3 - 1 = 2
     * [3,3]，范围 = 3 - 3 = 0
     * [1,3,3]，范围 = 3 - 1 = 2
     * 所有范围的和是 0 + 0 + 0 + 2 + 0 + 2 = 4
     * 示例 3：
     * <p>
     * 输入：nums = [4,-2,-3,4,1]
     * 输出：59
     * 解释：nums 中所有子数组范围的和是 59
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 1000
     * -109 <= nums[i] <= 109
     * <p>
     * <p>
     * 进阶：你可以设计一种时间复杂度为 O(n) 的解决方案吗？
     *
     * @param args
     */
    public static void main(String[] args) {
        // 加在前 扩展外边框，加在后 扩展数组元素
        int[][][][] f = new int[2][3][3][2];

        System.out.println(Arrays.deepToString(f));

        int[] arr = new int[]{1,2,3};

        long l = new SumOfSubarrayRanges2104().subArrayRanges3(arr);
        System.out.println(l);
    }

    /**
     * 区间 DP（预处理）
     * 数据范围为 10^310
     * 3
     * ，最为朴素的三层循环为：枚举区间（左右端点）+ 扫描区间统计最值，并累加到答案中。该做法复杂度为 O(n^3)O(n
     * 3
     * )，会 TLE。
     * <p>
     * 考虑在此基础上优化，枚举所有区间的操作不好避免，考虑通过「预处理」手段来优化「扫描区间统计最值」操作，通常会将其优化为 O(1)O(1) 查表。
     * <p>
     * 定义 f[l][r][k]f[l][r][k] 为区间 [l, r][l,r] 范围内的最值情况，其中 kk 非 00 即 11：f[l][r][0]f[l][r][0] 代表区间 [l, r][l,r] 内的最小值，f[l][r][1]f[l][r][1] 代表区间 [l, r][l,r] 内的最大值。
     * <p>
     * 不失一般性考虑 f[l][r][0]f[l][r][0] 和 f[l][r][1]f[l][r][1] 该如何计算：[l, r][l,r] 区间的最值可由 [l, r - 1][l,r−1] 与 nums[r]nums[r] 更新而来：
     * <p>
     * f[l][r][0] = \min(f[l][r - 1][0], nums[r])
     * f[l][r][0]=min(f[l][r−1][0],nums[r])
     * <p>
     * f[l][r][1] = \max(f[l][r - 1][1], nums[r])
     * f[l][r][1]=max(f[l][r−1][1],nums[r])
     * <p>
     * 最后再枚举所有区间统计答案即可。
     *
     * @param nums
     * @return
     */
    public long subArrayRanges2(int[] nums) {
        int n = nums.length;
        int[][][] f = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            f[i][i][0] = f[i][i][1] = nums[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                f[l][r][0] = Math.min(nums[r], f[l][r - 1][0]);
                f[l][r][1] = Math.max(nums[r], f[l][r - 1][1]);
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans += f[i][j][1] - f[i][j][0];
            }
        }
        return ans;
    }


    /**
     * 复杂度分析
     * <p>
     * 时间复杂度：O(n^2)O(n
     * 2
     * )，其中 nn 为数组的大小。两层循环需要 O(n^2)O(n
     * 2
     * )。
     * <p>
     * 空间复杂度：O(1)O(1)。
     *
     * @param nums
     * @return
     */
    public long subArrayRanges(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                // 迭代获取 max 和 min
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                ret += max - min;
            }
        }
        return ret;
    }


    /**
     * 方法二、单调栈
     * 进阶部分让我们使用 O(n)O(n) 的时间复杂度来实现，所以，我们需要进一步优化。
     * <p>
     * 以最大值为例，我们可以求出每个元素为最大值时的区间范围，比如，假设给定数组为 [1,1,2,1,3] ，那么，元素 2 作为最大值时的范围为多少呢？显然下标范围为 [0, 3]，
     * 那么，以 2 为最大值的子数组有多少个呢？答案是 6 个，为 2 左边的元素个数 乘以 2 右边元素的个数，两边都要包含 2，即为 3 * 2 = 6，这个也很好理解，
     * 我们需要在两边各取一个下标才能形成一个包含 2 的子数组，左边有三种取法，右边有两种取法，所以，是 6 种方式。
     * <p>
     * <img width="600" height="400" src="https://pic.leetcode-cn.com/1646409404-EcxYLZ-%E5%9B%BE%E7%89%87.png" alt="">
     * <p>
     * <p>
     * 那么，现在我们的问题就来到了，如何求出每个元素作为最大值时的范围，具体地，是左范围的元素个数和右范围的元素个数。
     * <p>
     * 这里，我们可以使用单调栈来求解。
     * <p>
     * 还是以最大值为例，我们使用一个单调递减栈，遇到比栈顶元素小的，直接入栈，遇到比栈顶元素大的，就要开始计算，
     * 具体的计算过程，栈顶元素下面一个元素到栈顶元素的范围就是左范围，栈顶元素到当前元素的范围就是右范围，
     * 所以，我们的栈里面需要存储下标，这样我们就可以很方便地计算出来左范围元素的个数及右范围元素的个数。
     * <p>
     * 这里为了方便，我们可以先在栈中存一个 -1 的下标。
     * <p>
     * 以下图为例，当遍历到下标为 4 的元素时，会先计算下标为 3 的元素，再计算下标为 2 的元素，具体的计算过程如上所述。
     * <p>
     * <img width="600" height="400" src="https://pic.leetcode-cn.com/1646409424-wwuSzw-%E5%9B%BE%E7%89%87.png" alt="">
     * 注：栈里存储的是下标，所以，肯定是递增的，但是，下标对应的元素值是递减的，所以，我们叫单调递减栈。
     * <p>
     * <p>
     * <p>
     * 最小值的求解过程正好是反过来的，你可以自己理一下。
     * <p>
     * 我们只要求出了 最大值和 及 最小值和，两者相减就题目的结果。
     *
     * @param nums
     * @return
     */
    public long subArrayRanges3(int[] nums) {
        return maxSum(nums) - minSum(nums);
    }

    private long maxSum(int[] nums) {
        long sum = 0;
        // 存储下标，这里没有放-1
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= nums.length; i++) {
            while (!stack.isEmpty() && (i == nums.length || nums[stack.peek()] < nums[i])) {
                int last = stack.pop();
                int lastlast = stack.isEmpty() ? -1 : stack.peek();
                sum += (long) nums[last] * (i - last) * (last - lastlast);
            }
            stack.push(i);
        }
        return sum;
    }

    private long minSum(int[] nums) {
        long sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= nums.length; i++) {
            while (!stack.isEmpty() && (i == nums.length || nums[stack.peek()] > nums[i])) {
                int last = stack.pop();
                int lastlast = stack.isEmpty() ? -1 : stack.peek();
                sum += (long) nums[last] * (i - last) * (last - lastlast);
            }
            stack.push(i);
        }
        return sum;
    }


}
