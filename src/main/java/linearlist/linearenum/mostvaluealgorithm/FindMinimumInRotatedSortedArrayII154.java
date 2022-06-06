package linearlist.linearenum.mostvaluealgorithm;

/**
 * @author luna
 * 2022/6/4
 */
public class FindMinimumInRotatedSortedArrayII154 {


    /**
     * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
     * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
     * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     * <p>
     * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
     * <p>
     * 你必须尽可能减少整个过程的操作步骤。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,3,5]
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：nums = [2,2,2,0,1]
     * 输出：0
     *  
     * <p>
     * 提示：
     * <p>
     * n == nums.length
     * 1 <= n <= 5000
     * -5000 <= nums[i] <= 5000
     * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
     *  
     * <p>
     * 进阶：这道题与 寻找旋转排序数组中的最小值 类似，但 nums 可能包含重复元素。允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {


    }

    public static int findMinBinary(int[] nums) {
        int low = 0;
        int hight = nums.length - 1;
        if (nums[low] < nums[hight]) {
            return nums[low];
        }

        while (low < hight) {
            int pivot = low + (hight - low) / 2;
            if (nums[pivot] < nums[hight]) {
                hight = pivot;
            } else if (nums[pivot] > nums[hight]) {
                low = pivot + 1;
            } else {
                hight--;
            }
        }

        return nums[low];
    }


    public static int findMin(int[] nums) {
        int min = 5000;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
