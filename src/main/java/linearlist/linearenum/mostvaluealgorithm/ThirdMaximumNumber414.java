package linearlist.linearenum.mostvaluealgorithm;

import java.util.TreeSet;

/**
 * @author luna
 * 2022/6/6
 */
public class ThirdMaximumNumber414 {

    /**
     * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[3, 2, 1]
     * 输出：1
     * 解释：第三大的数是 1 。
     * 示例 2：
     * <p>
     * 输入：[1, 2]
     * 输出：2
     * 解释：第三大的数不存在, 所以返回最大的数 2 。
     * 示例 3：
     * <p>
     * 输入：[2, 2, 3, 1]
     * 输出：1
     * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
     * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 104
     * -231 <= nums[i] <= 231 - 1
     *  
     * <p>
     * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/third-maximum-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)O(n)，其中 nn 是数组 {nums}nums 的长度。由于有序集合的大小至多为 33，插入和删除的时间复杂度可以视作是 O(1)O(1) 的，因此时间复杂度为 O(n)O(n)。
     *
     * 空间复杂度：O(1)O(1)。
     *
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        TreeSet<Integer> s = new TreeSet<Integer>();
        for (int num : nums) {
            s.add(num);
            if (s.size() > 3) {
                s.remove(s.first());
            }
        }
        return s.size() == 3 ? s.first() : s.last();
    }


    public int thirdMax2(int[] nums) {
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (long num : nums) {
            if (num > a) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && num > b) {
                c = b;
                b = num;
            } else if (b > num && num > c) {
                c = num;
            }
        }
        return c == Long.MIN_VALUE ? (int) a : (int) c;
    }

}
