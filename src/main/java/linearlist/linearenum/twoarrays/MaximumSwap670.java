package linearlist.linearenum.twoarrays;

/**
 * @author luna
 * 2022/6/14
 */

public class MaximumSwap670 {

    /**
     * 670. 最大交换
     * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
     *
     * 示例 1 :
     *
     * 输入: 2736
     * 输出: 7236
     * 解释: 交换数字2和数字7。
     * 示例 2 :
     *
     * 输入: 9973
     * 输出: 9973
     * 解释: 不需要交换。
     * 注意:
     *
     * 给定数字的范围是 [0, 108]
     * @param args
     */
    public static void main(String[] args) {
        int i = new MaximumSwap670().maximumSwap2(7243);
        System.out.println(i);
    }

    public int maximumSwap3(int num) {
        String numStr = String.valueOf(num);
        char[] chars = numStr.toCharArray();

        int[] index = new int[10];
        // [0, 0, 1, 3, 2, 0, 0, 0, 0, 0]
        for (int i = 0; i < chars.length; i++) {
            index[chars[i] - '0'] = i;
        }

        for (int i = 0; i < chars.length; i++) {
            for (int d = 9; d > chars[i] - '0'; d--) {
                if (index[d] > i){
                    swap(chars, i, index[d]);
                    // 只允许交换一次，因此直接返回
                    return Integer.parseInt(new String(chars));
                }
            }
        }
        return num;
    }


    /**
     * 暴力枚举
     * 复杂度分析
     *
     * 时间复杂度：O(N^3)O(N
     * 3
     *  )。其中 NN 是输入数字的总位数。对于每对数字，我们最多花费 O(N)O(N) 的时间来比较最后的序列。
     * 空间复杂度：O(N)O(N)，存储在 \text{A}A 中的信息。
     *
     * @param num
     * @return
     */
    public int maximumSwap(int num) {
        String numberStr = String.valueOf(num);
        char[] chars = numberStr.toCharArray();

        int max = num;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                swap(chars, i , j);
                max = Math.max(max, Integer.parseInt(new String(chars)));
                swap(chars, i , j);
            }
        }
        return max;
    }
    public int maximumSwap2(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        char[] charArray = s.toCharArray();

        // 记录每个数字出现的最后一次出现的下标
        int[] last = new int[10];
        for (int i = 0; i < len; i++) {
            last[charArray[i] - '0'] = i;
        }

        // 从左向右扫描，找到当前位置右边的最大的数字并交换
        for (int i = 0; i < len - 1; i++) {
            // 找最大，所以倒着找
            for (int d = 9; d > charArray[i] - '0'; d--) {
                if (last[d] > i) {
                    // 位置在后大数往前置换
                    swap(charArray, i, last[d]);
                    // 只允许交换一次，因此直接返回
                    return Integer.parseInt(new String(charArray));
                }
            }
        }

        return num;
    }


    public static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
