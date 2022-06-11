package linearlist.linearenum.situalgorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author luna
 * 2022/6/10
 */

public class KeepMultiplyingFoundValuesByTwo2154 {

    /**
     * 2154. 将找到的值乘以 2
     * 给你一个整数数组 nums ，另给你一个整数 original ，这是需要在 nums 中搜索的第一个数字。
     * <p>
     * 接下来，你需要按下述步骤操作：
     * <p>
     * 如果在 nums 中找到 original ，将 original 乘以 2 ，得到新 original（即，令 original = 2 * original）。
     * 否则，停止这一过程。
     * 只要能在数组中找到新 original ，就对新 original 继续 重复 这一过程。
     * 返回 original 的 最终 值。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [5,3,6,1,12], original = 3
     * 输出：24
     * 解释：
     * - 3 能在 nums 中找到。3 * 2 = 6 。
     * - 6 能在 nums 中找到。6 * 2 = 12 。
     * - 12 能在 nums 中找到。12 * 2 = 24 。
     * - 24 不能在 nums 中找到。因此，返回 24 。
     * 示例 2：
     * <p>
     * 输入：nums = [2,7,9], original = 4
     * 输出：4
     * 解释：
     * - 4 不能在 nums 中找到。因此，返回 4 。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 1000
     * 1 <= nums[i], original <= 1000
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    public int findFinalValue2(int[] nums, int original) {
        Arrays.sort(nums);
        for (int num : nums) {
            if (num == original) {
                original *= 2;
            }
        }
        return original;
    }

    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        while (set.contains(original)) {
            original *= 2;
        }
        return original;
    }
}
