package linearlist.theprefixand.sortprefix.sum;

/**
 * @author luna
 * 2022/6/29
 */
public class NumberOfWaysToSelectBuildings2222 {


    /**
     * 2222. 选择建筑的方案数
     * 给你一个下标从 0 开始的二进制字符串 s ，它表示一条街沿途的建筑类型，其中：
     * <p>
     * s[i] = '0' 表示第 i 栋建筑是一栋办公楼，
     * s[i] = '1' 表示第 i 栋建筑是一间餐厅。
     * 作为市政厅的官员，你需要随机 选择 3 栋建筑。然而，为了确保多样性，选出来的 3 栋建筑 相邻 的两栋不能是同一类型。
     * <p>
     * 比方说，给你 s = "001101" ，我们不能选择第 1 ，3 和 5 栋建筑，因为得到的子序列是 "011" ，有相邻两栋建筑是同一类型，所以 不合 题意。
     * 请你返回可以选择 3 栋建筑的 有效方案数 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "001101"
     * 输出：6
     * 解释：
     * 以下下标集合是合法的：
     * - [0,2,4] ，从 "001101" 得到 "010"
     * - [0,3,4] ，从 "001101" 得到 "010"
     * - [1,2,4] ，从 "001101" 得到 "010"
     * - [1,3,4] ，从 "001101" 得到 "010"
     * - [2,4,5] ，从 "001101" 得到 "101"
     * - [3,4,5] ，从 "001101" 得到 "101"
     * 没有别的合法选择，所以总共有 6 种方法。
     * 示例 2：
     * <p>
     * 输入：s = "11100"
     * 输出：0
     * 解释：没有任何符合题意的选择。
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * 统计每个元素前后的0和1的个数即可
     * @param s
     * @return
     */
    public long numberOfWays(String s) {
        int n = s.length();
        long ans = 0;
        char[] ss = s.toCharArray();
        int[] pz = new int[n];
        int[] po = new int[n];
        int z = 0, o = 0;
        for (int i = 1; i < n; i++) {
            if (ss[i - 1] == '0') {
                z++;
                pz[i] = z;
                po[i] = o;
            } else if (ss[i - 1] == '1') {
                o++;
                po[i] = o;
                pz[i] = z;
            }
        }
        z += ss[n - 1] - '0' > 0 ? 0 : 1;
        o += ss[n - 1] - '0' > 0 ? 1 : 0;

        for (int i = 1; i <= n - 2; i++) {
            if (ss[i] == '0') {
                ans += (long) po[i] * (o - po[i]);
            } else {
                ans += (long) pz[i] * (z - pz[i]);
            }
        }
        return ans;
    }
}
