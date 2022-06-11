package linearlist.linearenum.situalgorithm;

import java.util.Arrays;

/**
 * @author luna
 * 2022/6/11
 */
public class RearrangeArrayElementsBySign2149 {

    /**
     * 2149. 按符号重排数组
     * 给你一个下标从 0 开始的整数数组 nums ，数组长度为 偶数 ，由数目相等的正整数和负整数组成。
     * <p>
     * 你需要 重排 nums 中的元素，使修改后的数组满足下述条件：
     * <p>
     * 任意 连续 的两个整数 符号相反
     * 对于符号相同的所有整数，保留 它们在 nums 中的 顺序 。
     * 重排后数组以正整数开头。
     * 重排元素满足上述条件后，返回修改后的数组。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3,1,-2,-5,2,-4]
     * 输出：[3,-2,1,-5,2,-4]
     * 解释：
     * nums 中的正整数是 [3,1,2] ，负整数是 [-2,-5,-4] 。
     * 重排的唯一可行方案是 [3,-2,1,-5,2,-4]，能满足所有条件。
     * 像 [1,-2,2,-5,3,-4]、[3,1,2,-2,-5,-4]、[-2,3,-5,1,-4,2] 这样的其他方案是不正确的，因为不满足一个或者多个条件。
     * 示例 2：
     * <p>
     * 输入：nums = [-1,1]
     * 输出：[1,-1]
     * 解释：
     * 1 是 nums 中唯一一个正整数，-1 是 nums 中唯一一个负整数。
     * 所以 nums 重排为 [1,-1] 。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 2 <= nums.length <= 2 * 105
     * nums.length 是 偶数
     * 1 <= |nums[i]| <= 105
     * nums 由 相等 数量的正整数和负整数组成
     * @param args
     */
    public static void main(String[] args) {

        int[] nums = new int[]{3, 1, -2, -5, 2, -4};
        int[] ints = new RearrangeArrayElementsBySign2149().rearrangeArray(nums);
        System.out.println(Arrays.toString(ints));
    }

    public int[] rearrangeArray2(int[] nums) {
        int pos = 0;
        int neg = 1;
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[pos] = nums[i];
                pos += 2;
            } else {
                ans[neg] = nums[i];
                neg += 2;
            }
        }

        return ans;
    }

    public int[] rearrangeArray(int[] nums) {
        int[] positive = new int[nums.length];
        int[] negative = new int[nums.length];
        int tagPositive = 0;
        int tagNegative = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                positive[tagPositive] = nums[i];
                tagPositive++;
            }
            if (nums[i] < 0) {
                negative[tagNegative] = nums[i];
                tagNegative++;
            }
        }
        tagPositive = 0;
        tagNegative = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = positive[tagPositive];
                tagPositive++;
            } else {
                nums[i] = negative[tagNegative];
                tagNegative++;
            }
        }

        return nums;
    }
}
