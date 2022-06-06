package linearlist.linearenum;

/**
 * @author luna
 * 2022/6/6
 */

public class RemovingMinimumAndMaximumFromArray2091 {


    /**
     * 给你一个下标从 0 开始的数组 nums ，数组由若干 互不相同 的整数组成。
     * <p>
     * nums 中有一个值最小的元素和一个值最大的元素。分别称为 最小值 和 最大值 。你的目标是从数组中移除这两个元素。
     * <p>
     * 一次 删除 操作定义为从数组的 前面 移除一个元素或从数组的 后面 移除一个元素。
     * <p>
     * 返回将数组中最小值和最大值 都 移除需要的最小删除次数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,10,7,5,4,1,8,6]
     * 输出：5
     * 解释：
     * 数组中的最小元素是 nums[5] ，值为 1 。
     * 数组中的最大元素是 nums[1] ，值为 10 。
     * 将最大值和最小值都移除需要从数组前面移除 2 个元素，从数组后面移除 3 个元素。
     * 结果是 2 + 3 = 5 ，这是所有可能情况中的最小删除次数。
     * 示例 2：
     * <p>
     * 输入：nums = [0,-4,19,1,8,-2,-3,5]
     * 输出：3
     * 解释：
     * 数组中的最小元素是 nums[1] ，值为 -4 。
     * 数组中的最大元素是 nums[2] ，值为 19 。
     * 将最大值和最小值都移除需要从数组前面移除 3 个元素。
     * 结果是 3 ，这是所有可能情况中的最小删除次数。
     * 示例 3：
     * <p>
     * 输入：nums = [101]
     * 输出：1
     * 解释：
     * 数组中只有这一个元素，那么它既是数组中的最小值又是数组中的最大值。
     * 移除它只需要 1 次删除操作。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 105
     * -105 <= nums[i] <= 105
     * nums 中的整数 互不相同
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/removing-minimum-and-maximum-from-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */

    public static void main(String[] args) {

    }

    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int maxi = 0, mini = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num > max) {
                max = num;
                maxi = i;
            }
            if (num < min) {
                min = num;
                mini = i;
            }
        }
        int l = Math.min(maxi, mini);
        int r = Math.max(maxi, mini);
        // 从左往右删 从右往左删 两头删
        return Math.min(Math.min(r + 1, len - l), l + 1 + len - r);
    }



    public int minimumDeletions2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxi = 0;
        int mini = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxi = i;
            }
            if (nums[i] < min) {
                min = nums[i];
                mini = i;
            }
        }
        int l = Math.min(maxi, mini);
        int r = Math.max(maxi, mini);
        return Math.min(Math.min(r + 1, nums.length - l), l + 1 + nums.length - r);
    }
}
