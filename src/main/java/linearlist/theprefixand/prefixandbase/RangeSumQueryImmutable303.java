package linearlist.theprefixand.prefixandbase;

/**
 * @author luna
 * 2022/6/15
 */

public class RangeSumQueryImmutable303 {

    /**
     * 303. 区域和检索 - 数组不可变
     * 给定一个整数数组  nums，处理以下类型的多个查询:
     * <p>
     * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
     * 实现 NumArray 类：
     * <p>
     * NumArray(int[] nums) 使用数组 nums 初始化对象
     * int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * ["NumArray", "sumRange", "sumRange", "sumRange"]
     * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
     * 输出：
     * [null, 1, -1, -3]
     * <p>
     * 解释：
     * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
     * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
     * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
     * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 104
     * -105 <= nums[i] <= 105
     * 0 <= i <= j < nums.length
     * 最多调用 104 次 sumRange 方法
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    class NumArray {

        int[] sums;

        public NumArray(int[] nums) {
            int n = nums.length;
            sums = new int[n + 1];
            for (int i = 0; i < nums.length; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sums[right + 1] - sums[left];
        }
    }
}
