package linearlist.theprefixand.prefixandbase;

/**
 * @author luna
 * 2022/6/15
 */

public class RunningSumOf1DArray1480 {

    /**
     * 1480. 一维数组的动态和
     * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
     * <p>
     * 请返回 nums 的动态和。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,6,10]
     * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
     * 示例 2：
     * <p>
     * 输入：nums = [1,1,1,1,1]
     * 输出：[1,2,3,4,5]
     * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
     * 示例 3：
     * <p>
     * 输入：nums = [3,1,2,10,1]
     * 输出：[3,4,6,16,17]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 1000
     * -10^6 <= nums[i] <= 10^6
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    public int[] runningSum(int[] nums) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = nums[i] + sums[i - 1];
        }
        return sums;
    }

    /**
     * 原地算法
     *
     * @param nums
     * @return
     */
    public int[] runningSum2(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

}
