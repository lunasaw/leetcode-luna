package linearlist.theprefixand.prefixandbase;

/**
 * @author luna
 * 2022/6/14
 */

public class MinimumValueToGetPositiveStepByStepSum1413 {

    /**
     * 1413. 逐步求和得到正数的最小值
     * 给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
     * <p>
     * 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
     * <p>
     * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-3,2,-3,4,2]
     * 输出：5
     * 解释：如果你选择 startValue = 4，在第三次累加时，和小于 1 。
     * 累加求和
     * startValue = 4 | startValue = 5 | nums
     * (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
     * (1 +2 ) = 3  | (2 +2 ) = 4    |   2
     * (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
     * (0 +4 ) = 4  | (1 +4 ) = 5    |   4
     * (4 +2 ) = 6  | (5 +2 ) = 7    |   2
     * 示例 2：
     * <p>
     * 输入：nums = [1,2]
     * 输出：1
     * 解释：最小的 startValue 需要是正数。
     * 示例 3：
     * <p>
     * 输入：nums = [1,-2,-3]
     * 输出：5
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{-3, 2, -3, 4, 2};

        int i = new MinimumValueToGetPositiveStepByStepSum1413().minStartValue(nums);

        System.out.println(i);
    }


    /**
     * 取和为负数时1-sum 的最大值即可
     *
     * @param nums
     * @return
     */
    public int minStartValue(int[] nums) {
        int start = 1;
        int sum = 0;
        for (int i : nums) {
            sum += i;
            if (sum < 0) {
                start = Math.max(start, 1 - sum);
            }
        }
        return start;
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int minStartValue2(int[] nums) {
        int dp = 1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // dp 存和
            if (dp + nums[i] > 0) {
                // 和大于0
                dp = dp + nums[i];
            } else {
                // 和小于0， 基数 = 1 - 和
                count += 1 - (dp + nums[i]);
                // 重置dp
                dp = 1;
            }
        }
        return count + 1;
    }

}
