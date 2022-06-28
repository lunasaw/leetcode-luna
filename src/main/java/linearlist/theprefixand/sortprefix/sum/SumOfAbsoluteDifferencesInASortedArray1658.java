package linearlist.theprefixand.sortprefix.sum;

/**
 * @author luna
 * 2022/6/27
 */
public class SumOfAbsoluteDifferencesInASortedArray1658 {

    /**
     * 1685. 有序数组中差绝对值之和
     * 给你一个 非递减 有序整数数组 nums 。
     * <p>
     * 请你建立并返回一个整数数组 result，它跟 nums 长度相同，且result[i] 等于 nums[i] 与数组中所有其他元素差的绝对值之和。
     * <p>
     * 换句话说， result[i] 等于 sum(|nums[i]-nums[j]|) ，其中 0 <= j < nums.length 且 j != i （下标从 0 开始）。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,3,5]
     * 输出：[4,3,5]
     * 解释：假设数组下标从 0 开始，那么
     * result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4，
     * result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3，
     * result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5。
     * 示例 2：
     * <p>
     * 输入：nums = [1,4,6,8,10]
     * 输出：[24,15,13,15,21]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 2 <= nums.length <= 105
     * 1 <= nums[i] <= nums[i + 1] <= 104
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 6, 8, 10};

        new SumOfAbsoluteDifferencesInASortedArray1658().getSumAbsoluteDifferences2(nums);
    }

    /**
     * 穷举  会超时
     * @param nums
     * @return
     */
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    result[i] += Math.abs(nums[i] - nums[j]);
                }
            }
        }
        return result;
    }

    /**
     * 因为数组是有序的, 对数任意一个数nums[i],
     * 在数nums[i]左边的数比nums[i]小, 在nums[i]右边的数比nums[i]大,
     * 因此, 计算nums[i]和其他数的差绝对值之和可以分割为两部分来进行计算.
     * 首先计算前缀和数组prefixSum[], prefixSum[i]表示前i个数之和.
     * 对于nums[i]的左半部分, nums[i]与其他数的差绝对值之和可计算为:
     * <p>
     * sumOfLeftDifferences = (i+1)*nums[i]-prefixSum[i];
     * 对于nums[i]的右半部分, nums[i]与其他数的绝对值之和可计算为:
     * sumOfRightDifferences = prefixSum[nums.length-1]-prefixSum[i]-nums[i]*(nums.length-1-i);
     * 所以, 当前nums[i]与左右其他数的绝对值之和为:
     * sumOfDifferences = sumOfLeftDifferences+sumOfRightDifferences;
     * 代码
     * @param nums
     * @return
     */
    public int[] getSumAbsoluteDifferences2(int[] nums) {
        int sum = 0;
        int[] prefixSum = new int[nums.length];
        //计算前缀和
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
        //计算每个数的差绝对值之和
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // int sumOfLeftDifferences = (i+1)*nums[i]-prefixSum[i];
            // int sumOfRightDifferences = prefixSum[nums.length-1]-prefixSum[i]-nums[i]*(nums.length-1-i);
            // sumOfDifferences =  sumOfLeftDifferences+sumOfRightDifferences;
            output[i] = (i + 1) * nums[i] - prefixSum[i] + prefixSum[nums.length - 1] - prefixSum[i] - nums[i] * (nums.length - 1 - i);
        }
        return output;
    }


}
