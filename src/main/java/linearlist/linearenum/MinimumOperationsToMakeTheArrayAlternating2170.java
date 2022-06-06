package linearlist.linearenum;

import java.util.HashMap;

/**
 * @author luna
 * 2022/6/6
 */

public class MinimumOperationsToMakeTheArrayAlternating2170 {

    /**
     * 2170. 使数组变成交替数组的最少操作数
     * 给你一个下标从 0 开始的数组 nums ，该数组由 n 个正整数组成。
     * <p>
     * 如果满足下述条件，则数组 nums 是一个 交替数组 ：
     * <p>
     * nums[i - 2] == nums[i] ，其中 2 <= i <= n - 1 。
     * nums[i - 1] != nums[i] ，其中 1 <= i <= n - 1 。
     * 在一步 操作 中，你可以选择下标 i 并将 nums[i] 更改 为 任一 正整数。
     * <p>
     * 返回使数组变成交替数组的 最少操作数 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3,1,3,2,4,3]
     * 输出：3
     * 解释：
     * 使数组变成交替数组的方法之一是将该数组转换为 [3,1,3,1,3,1] 。
     * 在这种情况下，操作数为 3 。
     * 可以证明，操作数少于 3 的情况下，无法使数组变成交替数组。
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,2,2,2]
     * 输出：2
     * 解释：
     * 使数组变成交替数组的方法之一是将该数组转换为 [1,2,1,2,1].
     * 在这种情况下，操作数为 2 。
     * 注意，数组不能转换成 [2,2,2,2,2] 。因为在这种情况下，nums[0] == nums[1]，不满足交替数组的条件。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 105
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/minimum-operations-to-make-the-array-alternating
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */

    public static void main(String[] args) {

    }

    public int minimumOperations(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> even = new HashMap<>();
        HashMap<Integer, Integer> odd = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                //记录偶数位上的每个数字个数
                even.put(nums[i], even.getOrDefault(nums[i], 0) + 1);
            } else {
                //记录奇数位上的每个数字个数
                odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
            }
        }
        //找出两个map中最多和次多的两个数字的key和val
        int[][] evenMaxAndSubMax = check(even);
        int[][] oddMaxAndSubMax = check(odd);
        //如果当前两个最多数量的key不相同 也就是 1 != 2 的情况下说明 当前长度 分别减去他们出现的频率 就是剩下的需要改变的正整数个数
        if (evenMaxAndSubMax[0][0] != oddMaxAndSubMax[0][0]) {
            n -= evenMaxAndSubMax[0][1];
            n -= oddMaxAndSubMax[0][1];
        } else { // 反之如果出现了两个数量最多的数字相同时 需要获得最小操作数 就要是比较当最大数和次大数的加和最大才能使得次数最小
            n -= Math.max(evenMaxAndSubMax[0][1] + oddMaxAndSubMax[1][1], oddMaxAndSubMax[0][1] + evenMaxAndSubMax[1][1]);
        }
        return n;
    }

    int[][] check(HashMap<Integer, Integer> map) {
        int[][] maxAndSubMax = new int[2][2];
        //对于每个数字
        for (Integer key : map.keySet()) {
            //获取当前数字key的val
            int val = map.get(key);
            //找到个数数量前两个的数字进行数组存储 保存他们的 key 与 val || res[0][0] 是最多数量数字的key res[0][0] 是最多数量数字的val
            if (val > maxAndSubMax[0][1]) {

                // 改次多
                maxAndSubMax[1][0] = maxAndSubMax[0][0];
                maxAndSubMax[1][1] = maxAndSubMax[0][1];

                // 改最多
                maxAndSubMax[0][0] = key;
                maxAndSubMax[0][1] = val;

            } else if (val > maxAndSubMax[1][1]) {
                //数量次多的key 与 val
                maxAndSubMax[1][0] = key;
                maxAndSubMax[1][1] = val;
            }
        }
        return maxAndSubMax;
    }

}
