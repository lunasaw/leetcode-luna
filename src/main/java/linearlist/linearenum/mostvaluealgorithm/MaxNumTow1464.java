package linearlist.linearenum.mostvaluealgorithm;

/**
 * @author luna
 * 2022/6/3
 */
public class MaxNumTow1464 {

    /**
     * 一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
     */

    public static void main(String[] args) {

    }

    public static int maxProduct(int[] nums) {
        int max = 0;
        int maxNext = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                maxNext = max;
                max = nums[i];
            } else if (nums[i] > maxNext) {
                maxNext = nums[i];
            }
        }
        return (max - 1) * (maxNext - 1);
    }


}
