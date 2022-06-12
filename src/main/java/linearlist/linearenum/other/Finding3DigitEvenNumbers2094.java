package linearlist.linearenum.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author luna
 * 2022/6/12
 */
public class Finding3DigitEvenNumbers2094 {

    /**
     * 2094. 找出 3 位偶数
     * 给你一个整数数组 digits ，其中每个元素是一个数字（0 - 9）。数组中可能存在重复元素。
     * <p>
     * 你需要找出 所有 满足下述条件且 互不相同 的整数：
     * <p>
     * 该整数由 digits 中的三个元素按 任意 顺序 依次连接 组成。
     * 该整数不含 前导零
     * 该整数是一个 偶数
     * 例如，给定的 digits 是 [1, 2, 3] ，整数 132 和 312 满足上面列出的全部条件。
     * <p>
     * 将找出的所有互不相同的整数按 递增顺序 排列，并以数组形式返回。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：digits = [2,1,3,0]
     * 输出：[102,120,130,132,210,230,302,310,312,320]
     * 解释：
     * 所有满足题目条件的整数都在输出数组中列出。
     * 注意，答案数组中不含有 奇数 或带 前导零 的整数。
     * 示例 2：
     * <p>
     * 输入：digits = [2,2,8,8,2]
     * 输出：[222,228,282,288,822,828,882]
     * 解释：
     * 同样的数字（0 - 9）在构造整数时可以重复多次，重复次数最多与其在 digits 中出现的次数一样。
     * 在这个例子中，数字 8 在构造 288、828 和 882 时都重复了两次。
     * 示例 3：
     * <p>
     * 输入：digits = [3,7,5]
     * 输出：[]
     * 解释：
     * 使用给定的 digits 无法构造偶数。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 3 <= digits.length <= 100
     * 0 <= digits[i] <= 9
     * 通过次数8,409提交次数15,156
     * @param args
     */
    public static void main(String[] args) {
        int[] digits = new int[]{2, 2, 8, 8, 2};
        int[] evenNumbers = new Finding3DigitEvenNumbers2094().findEvenNumbers2(digits);
        System.out.println(Arrays.toString(evenNumbers));
    }

    /**
     * 我们可以从数组中枚举目标整数的三个整数位，判断组成的整数是否满足以下条件：
     * <p>
     * 整数为偶数；
     * <p>
     * 整数不包含前导零（即整数不小于 100100）；
     * <p>
     * 三个整数位对应的数组下标不能重复。
     * @param digits
     * @return
     */
    public int[] findEvenNumbers(int[] digits) {
        Arrays.sort(digits);
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    // 判断是否满足目标偶数的条件
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    int number = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (number >= 100 && number % 2 == 0) {
                        hashSet.add(number);
                    }
                }
            }
        }
        int[] a = hashSet.stream().sorted().mapToInt(Integer::intValue).toArray();
        return a;
    }

    /**
     * 我们也可以从小到大遍历所有 33 位偶数（即 [100, 999][100,999] 闭区间内的所有偶数），并判断对应的三个整数位是否为 \textit{digits}digits 数组中三个不同元素。如果是，则该偶数为目标偶数；反之亦然。
     * <p>
     * 具体地，我们首先用哈希表 \textit{freq}freq 维护 \textit{digits}digits 数组中每个数出现的次数。在遍历偶数时，我们同样用哈希表 \textit{freq}_1freq
     * 1
     * ​
     * 维护每个偶数中每个数位出现的次数。此时，该偶数能够被数组中不重复元素表示的充要条件即为：
     * <p>
     * \textit{freq}_1freq
     * 1
     * ​
     * 中每个元素的出现次数都不大于它在 \textit{freq}freq 中的出现次数。
     * <p>
     * 我们按照上述条件判断每个偶数是否为目标偶数，并按顺序统计这些偶数。最终，我们返回目标偶数的数组作为答案。
     * @param digits
     * @return
     */
    public int[] findEvenNumbers2(int[] digits) {
        List<Integer> ans = new ArrayList<>();

        int n = digits.length;
        int result = 0;
        // 使用数组
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (digits[i] != 0) {
                result = result * 10 + digits[i];
                used[i] = true;
                for (int j = 0; j < n; j++) {
                    if (used[j] == true) {
                        continue;
                    }
                    used[j] = true;
                    result = result * 10 + digits[j];
                    for (int z = 0; z < n; z++) {
                        if (used[z] == true) {
                            continue;
                        }
                        if (digits[z] % 2 == 0) {
                            used[z] = true;
                            result = result * 10 + digits[z];
                            ans.add(result);
                            result /= 10;
                            used[z] = false;
                        }
                    }
                    result /= 10;
                    used[j] = false;

                }
                result /= 10;
                used[i] = false;
            }
        }
        HashSet<Integer> set = new HashSet<>();
        set.addAll(ans);
        ans.clear();
        ans.addAll(set);

        int[] ret = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ret[i] = ans.get(i);
        }
        Arrays.sort(ret);
        return ret;
    }

    public int[] findEvenNumbers3(int[] digits) {
        int[] cur = new int[10];
        for (int i = 0; i < digits.length; i++) {
            cur[digits[i]]++;
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 100; i <= 998; i += 2) {
            int a = i / 100;
            int b = i / 10 % 10;
            int c = i % 10;
            cur[a]--;
            cur[b]--;
            cur[c]--;
            if (cur[a] < 0 || cur[b] < 0 || cur[c] < 0) {

            } else {
                res.add(i);
            }
            cur[a]++;
            cur[b]++;
            cur[c]++;
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
