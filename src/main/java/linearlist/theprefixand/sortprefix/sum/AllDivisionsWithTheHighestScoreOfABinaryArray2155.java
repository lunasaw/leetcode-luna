package linearlist.theprefixand.sortprefix.sum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luna
 * 2022/6/29
 */
public class AllDivisionsWithTheHighestScoreOfABinaryArray2155 {

    /**
     * 给你一个下标从 0 开始的二进制数组 nums ，数组长度为 n 。nums 可以按下标 i（ 0 <= i <= n ）拆分成两个数组（可能为空）：numsleft 和 numsright 。
     * <p>
     * numsleft 包含 nums 中从下标 0 到 i - 1 的所有元素（包括 0 和 i - 1 ），而 numsright 包含 nums 中从下标 i 到 n - 1 的所有元素（包括 i 和 n - 1 ）。
     * 如果 i == 0 ，numsleft 为 空 ，而 numsright 将包含 nums 中的所有元素。
     * 如果 i == n ，numsleft 将包含 nums 中的所有元素，而 numsright 为 空 。
     * 下标 i 的 分组得分 为 numsleft 中 0 的个数和 numsright 中 1 的个数之 和 。
     * <p>
     * 返回 分组得分 最高 的 所有不同下标 。你可以按 任意顺序 返回答案。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [0,0,1,0]
     * 输出：[2,4]
     * 解释：按下标分组
     * - 0 ：numsleft 为 [] 。numsright 为 [0,0,1,0] 。得分为 0 + 1 = 1 。
     * - 1 ：numsleft 为 [0] 。numsright 为 [0,1,0] 。得分为 1 + 1 = 2 。
     * - 2 ：numsleft 为 [0,0] 。numsright 为 [1,0] 。得分为 2 + 1 = 3 。
     * - 3 ：numsleft 为 [0,0,1] 。numsright 为 [0] 。得分为 2 + 0 = 2 。
     * - 4 ：numsleft 为 [0,0,1,0] 。numsright 为 [] 。得分为 3 + 0 = 3 。
     * 下标 2 和 4 都可以得到最高的分组得分 3 。
     * 注意，答案 [4,2] 也被视为正确答案。
     * 示例 2：
     * <p>
     * 输入：nums = [0,0,0]
     * 输出：[3]
     * 解释：按下标分组
     * - 0 ：numsleft 为 [] 。numsright 为 [0,0,0] 。得分为 0 + 0 = 0 。
     * - 1 ：numsleft 为 [0] 。numsright 为 [0,0] 。得分为 1 + 0 = 1 。
     * - 2 ：numsleft 为 [0,0] 。numsright 为 [0] 。得分为 2 + 0 = 2 。
     * - 3 ：numsleft 为 [0,0,0] 。numsright 为 [] 。得分为 3 + 0 = 3 。
     * 只有下标 3 可以得到最高的分组得分 3 。
     * 示例 3：
     * <p>
     * 输入：nums = [1,1]
     * 输出：[0]
     * 解释：按下标分组
     * - 0 ：numsleft 为 [] 。numsright 为 [1,1] 。得分为 0 + 2 = 2 。
     * - 1 ：numsleft 为 [1] 。numsright 为 [1] 。得分为 0 + 1 = 1 。
     * - 2 ：numsleft 为 [1,1] 。numsright 为 [] 。得分为 0 + 0 = 0 。
     * 只有下标 0 可以得到最高的分组得分 2 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/all-divisions-with-the-highest-score-of-a-binary-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {

    }

    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        int max = 0, preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                preSum++;
                if (preSum > max) {
                    ans = new ArrayList<>();
                    ans.add(i + 1);
                    max = preSum;
                } else if (preSum == max) {
                    ans.add(i + 1);
                }
            } else {
                preSum--;
            }
        }
        return ans;
    }

    /**
     * 常规做法吧，三次遍历，一次计算前缀和，一次寻找最大的分，一次查找符合要求的下标
     * @param nums
     * @return
     */
    public List<Integer> maxScoreIndices2(int[] nums) {
        int count[] = new int[nums.length];
        //前缀和，记录1的个数
        count[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            count[i] = count[i - 1] + nums[i];
        }
        int max = count[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, count[nums.length - 1] - 2 * count[i] + i + 1);
        }
        List<Integer> ans = new ArrayList<>();
        if (max == count[nums.length - 1]) {
            ans.add(0);
        }
        for (int i = 0; i < nums.length; i++) {
            if (max == count[nums.length - 1] - 2 * count[i] + i + 1) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}

