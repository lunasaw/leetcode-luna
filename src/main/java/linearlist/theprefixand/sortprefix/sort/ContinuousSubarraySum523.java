package linearlist.theprefixand.sortprefix.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luna
 * 2022/6/21
 */
public class ContinuousSubarraySum523 {

    /**
     * 523. 连续的子数组和
     * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
     * <p>
     * 子数组大小 至少为 2 ，且
     * 子数组元素总和为 k 的倍数。
     * 如果存在，返回 true ；否则，返回 false 。
     * <p>
     * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [23,2,4,6,7], k = 6
     * 输出：true
     * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
     * 示例 2：
     * <p>
     * 输入：nums = [23,2,6,4,7], k = 6
     * 输出：true
     * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
     * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
     * 示例 3：
     * <p>
     * 输入：nums = [23,2,6,4,7], k = 13
     * 输出：false
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 105
     * 0 <= nums[i] <= 109
     * 0 <= sum(nums[i]) <= 231 - 1
     * 1 <= k <= 231 - 1
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{23,2,4,6,7};
        new ContinuousSubarraySum523().checkSubarraySum(nums, 6);
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        //   余数       index
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 标志位
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                // 余数相同，则倍数存在
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }

    public boolean checkSubarraySum2(int[] nums, int k) {

        // s5-s2 = s3+s4+s5
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                int target = 0;
                if (j == nums.length) {
                    target = nums[j - 1];
                } else {
                    target = nums[j] - nums[i];
                }

                boolean val = findSuitableKVal(target, k);
                if (val && j - i > 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean findSuitableKVal(int target, int k) {
        if (k == 0) {
            return target == 0;
        }

        return target % k == 0;
    }
}
