package linearlist.linearenum.situalgorithm;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author luna
 * 2022/6/10
 */

public class ContainsDuplicate217 {

    /**
     * 217. 存在重复元素
     * <a href="https://leetcode.cn/problems/contains-duplicate/">https://leetcode.cn/problems/contains-duplicate/</a>
     * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3,1]
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3,4]
     * 输出：false
     * 示例 3：
     * <p>
     * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
     * 输出：true
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * 在对数字从小到大排序之后，数组的重复元素一定出现在相邻位置中。
     * 因此，我们可以扫描已排序的数组，每次判断相邻的两个元素是否相等，如果相等则说明存在重复的元素。
     *
     * @param nums
     * @return 复杂度分析
     * <p>
     * 时间复杂度：O(N\log N)O(NlogN)，其中 NN 为数组的长度。需要对数组进行排序。
     * <p>
     * 空间复杂度：O(\log N)O(logN)，其中 NN 为数组的长度。注意我们在这里应当考虑递归调用栈的深度。
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() != nums.length;

    }

    public boolean containsDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;


    }
}
