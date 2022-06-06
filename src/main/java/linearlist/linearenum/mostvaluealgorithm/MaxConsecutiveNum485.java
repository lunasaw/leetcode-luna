package linearlist.linearenum.mostvaluealgorithm;

/**
 * @author luna
 * 2022/6/3
 */
public class MaxConsecutiveNum485 {
    /**
     * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
     *
     * 
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,0,1,1,1]
     * 输出：3
     * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
     * 示例 2:
     *
     * 输入：nums = [1,0,1,1,0,1]
     * 输出：2
     * 
     *
     * 提示：
     *
     * 1 <= nums.length <= 105
     * nums[i]不是0就是1.
     *
     */

    public static void main(String[] args) {

    }

    /**
     * (1) 当前数字为0，则以当前数字结尾的长度为 0；
     * ( 2 ) (2)(2) 当前数字为1，则 s u m = s u m + 1 sum = sum + 1sum=sum+1，即 当前数字结尾的长度 为 上一个为止的长度加一；
     * ( 3 ) (3)(3) 随时记录最大值；
     *
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int sum = 0 ;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                sum = 0;
            } else {
                sum++;
                if (sum > max){
                    max = sum;
                }
            }
        }
        return max;
    }
}
