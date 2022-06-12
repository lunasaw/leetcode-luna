package linearlist.linearenum.other;

/**
 * @author luna
 * 2022/6/12
 */
public class CountNumberOfTeams1395 {

    /**
     * 1395. 统计作战单位数
     * n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
     * <p>
     * 每 3 个士兵可以组成一个作战单位，分组规则如下：
     * <p>
     * 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
     * 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
     * 请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：rating = [2,5,3,4,1]
     * 输出：3
     * 解释：我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
     * 示例 2：
     * <p>
     * 输入：rating = [2,1,3]
     * 输出：0
     * 解释：根据题目条件，我们无法组建作战单位。
     * 示例 3：
     * <p>
     * 输入：rating = [1,2,3,4]
     * 输出：4
     * <p>
     * <p>
     * 提示：
     * <p>
     * n == rating.length
     * 3 <= n <= 1000
     * 1 <= rating[i] <= 10^5
     * rating 中的元素都是唯一的
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 3, 4, 1};
        int i = new CountNumberOfTeams1395().numTeams(nums);
        System.out.println(i);
    }

    public int numTeams(int[] rating) {
        int n = rating.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    if ((rating[i] < rating[j] && rating[j] < rating[k]) || (rating[i] > rating[j] && rating[j] > rating[k])) {
                        ++ans;
                    }
                }
            }
        }
        return ans;
    }

    public int numTeams2(int[] rating) {
        int n = rating.length;
        int ans = 0;
        // 枚举三元组中的 j
        for (int j = 1; j < n - 1; ++j) {
            int iless = 0, imore = 0;
            int kless = 0, kmore = 0;
            for (int i = 0; i < j; ++i) {
                if (rating[i] < rating[j]) {
                    ++iless;
                }
                // 注意这里不能直接写成 else
                // 因为可能有评分相同的情况
                else if (rating[i] > rating[j]) {
                    ++imore;
                }
            }
            for (int k = j + 1; k < n; ++k) {
                if (rating[k] < rating[j]) {
                    ++kless;
                } else if (rating[k] > rating[j]) {
                    ++kmore;
                }
            }
            ans += iless * kmore + imore * kless;
        }
        return ans;

    }
}
