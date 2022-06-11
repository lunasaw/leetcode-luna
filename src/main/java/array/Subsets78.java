package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luna
 * 2022/6/9
 */

public class Subsets78 {

    /**
     * 78. 子集
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * <p>
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     * <p>
     * 输入：nums = [0]
     * 输出：[[],[0]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * nums 中的所有元素 互不相同
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] matrix = new int[]{1, 2, 3};
        new Subsets78().subsets3(matrix);
        System.out.println(ans);
    }

    /**
     * 数组的每一位对应 0，1 表示是否在集合內，穷举所有二进制移位操作 即可得到所有的子集
     * (mask & (1 << i)) ?= 0 表示当前子集（1 << i）是否包含 mask
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> t = new ArrayList<Integer>();
        int n = nums.length;
        int max = 1 << n;
        for (int mask = 0; mask < max; ++mask) {
            t.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            list.add(new ArrayList<Integer>(t));
        }
        return list;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubSets = new ArrayList<>();
            for (List<Integer> oldSubSet : result) {
                List<Integer> newSubSet = new ArrayList<>(oldSubSet);
                newSubSet.add(num);
                newSubSets.add(newSubSet);
            }
            result.addAll(newSubSets);
        }

        return result;
    }

    static List<Integer> t = new ArrayList<Integer>();
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets3(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }
}
