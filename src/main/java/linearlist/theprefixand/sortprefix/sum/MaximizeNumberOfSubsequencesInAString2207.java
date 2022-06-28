package linearlist.theprefixand.sortprefix.sum;

/**
 * @author luna
 * 2022/6/28
 */
public class MaximizeNumberOfSubsequencesInAString2207 {

    /**
     * 2207. 字符串中最多数目的子字符串
     * 给你一个下标从 0 开始的字符串 text 和另一个下标从 0 开始且长度为 2 的字符串 pattern ，两者都只包含小写英文字母。
     * <p>
     * 你可以在 text 中任意位置插入 一个 字符，这个插入的字符必须是 pattern[0] 或者 pattern[1] 。注意，这个字符可以插入在 text 开头或者结尾的位置。
     * <p>
     * 请你返回插入一个字符后，text 中最多包含多少个等于 pattern 的 子序列 。
     * <p>
     * 子序列 指的是将一个字符串删除若干个字符后（也可以不删除），剩余字符保持原本顺序得到的字符串。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：text = "abdcdbc", pattern = "ac"
     * 输出：4
     * 解释：
     * 如果我们在 text[1] 和 text[2] 之间添加 pattern[0] = 'a' ，那么我们得到 "abadcdbc" 。那么 "ac" 作为子序列出现 4 次。
     * 其他得到 4 个 "ac" 子序列的方案还有 "aabdcdbc" 和 "abdacdbc" 。
     * 但是，"abdcadbc" ，"abdccdbc" 和 "abdcdbcc" 这些字符串虽然是可行的插入方案，但是只出现了 3 次 "ac" 子序列，所以不是最优解。
     * 可以证明插入一个字符后，无法得到超过 4 个 "ac" 子序列。
     * 示例 2：
     * <p>
     * 输入：text = "aabb", pattern = "ab"
     * 输出：6
     * 解释：
     * 可以得到 6 个 "ab" 子序列的部分方案为 "aaabb" ，"aaabb" 和 "aabbb" 。
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * 若pattern="ac"，那么认为在text的开始添加'a'或者在text的结尾添加'c'这两种情况能得到最大值。
     * 遍历字符串，并记录初始子序列数量sum，以及'a'和'c'的数量。
     * <p>
     * 在开始处添加'a'，则子序列数量=初始子序列数量+'c'的数量。
     * 在结尾处添加'c'，则子序列数量=初始子序列数量+'a'的数量。
     * @param text
     * @param pattern
     * @return
     */
    public long maximumSubsequenceCount(String text, String pattern) {
        char front = pattern.charAt(0), back = pattern.charAt(1);
        long sum = 0;
        int fcnt = 0, bcnt = 0;
        // 从后向前遍历，统计pattern[0]和pattenr[1]的数量以及初始子序列数量。
        for (int i = text.length() - 1; i >= 0; i--) {
            char c = text.charAt(i);
            if (c == front) {
                sum += bcnt;
                fcnt++;
            }
            if (c == back) {
                bcnt++;
            }
        }
        // 返回初始子序列数量+新增的子序列数量
        return sum + Math.max(bcnt, fcnt);
    }


}
