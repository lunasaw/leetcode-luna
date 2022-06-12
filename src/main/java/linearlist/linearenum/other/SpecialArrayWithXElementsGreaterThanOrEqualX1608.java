package linearlist.linearenum.other;

import java.util.Arrays;

/**
 * @author luna
 * 2022/6/12
 */
public class SpecialArrayWithXElementsGreaterThanOrEqualX1608 {

    /**
     * 1608. 特殊数组的特征值
     * 给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
     * <p>
     * 注意： x 不必 是 nums 的中的元素。
     * <p>
     * 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3,5]
     * 输出：2
     * 解释：有 2 个元素（3 和 5）大于或等于 2 。
     * 示例 2：
     * <p>
     * 输入：nums = [0,0]
     * 输出：-1
     * 解释：没有满足题目要求的特殊数组，故而也不存在特征值 x 。
     * 如果 x = 0，应该有 0 个元素 >= x，但实际有 2 个。
     * 如果 x = 1，应该有 1 个元素 >= x，但实际有 0 个。
     * 如果 x = 2，应该有 2 个元素 >= x，但实际有 0 个。
     * x 不能取更大的值，因为 nums 中只有两个元素。
     * 示例 3：
     * <p>
     * 输入：nums = [0,4,3,0,4]
     * 输出：3
     * 解释：有 3 个元素大于或等于 3 。
     * 示例 4：
     * <p>
     * 输入：nums = [3,6,7,7,0]
     * 输出：-1
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 1000
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{0, 4, 3, 0, 4};
        int i = new SpecialArrayWithXElementsGreaterThanOrEqualX1608().specialArray(nums);
        System.out.println(i);
    }

    private static int binarySearch(int[] nums, int x) {
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            int mid = (left + right) >> 1;
            mid = left + (right - left) / 2;
            if (nums[mid] >= x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = n;
        while (l <= r) {
            int x = (l + r) >> 1;
            int idx = binarySearch(nums, x);
            // nums中第一个大于等于x的元素位置
            if (x == n - idx) {
                return x;
            } else if (x < n - idx) {
                // 大于等于x的元素太多了，所以下一轮搜索要增大x的取值范围
                l = x + 1;
            } else {
                // 反之，减少x的取值范围
                r = x - 1;
            }
        }
        return -1;
    }
}
