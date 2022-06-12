package linearlist.linearenum.other;

/**
 * @author luna
 * 2022/6/12
 */
public class SingleElementInASortedArray540 {

    /**
     * 540. 有序数组中的单一元素
     * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
     * <p>
     * 请你找出并返回只出现一次的那个数。
     * <p>
     * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,1,2,3,3,4,4,8,8]
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: nums =  [3,3,7,7,10,11,11]
     * 输出: 10
     * <p>
     * <p>
     * 提示:
     * <p>
     * 1 <= nums.length <= 105
     * 0 <= nums[i] <= 105
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        int i = new SingleElementInASortedArray540().singleNonDuplicate(nums);
        System.out.println(i);

        int number = (0 ^ 3) ^ 3 ^ 4 ^ 5 ^ 5;
        System.out.println(number);
    }

    /**
     * 复杂度分析
     * <p>
     * 时间复杂度：O(\log n)O(logn)，其中 nn 是数组 \textit{nums}nums 的长度。需要在全数组范围内二分查找，
     * 二分查找的时间复杂度是 O(\log n)O(logn)。
     * <p>
     * 空间复杂度：O(1)O(1)。
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int hight = nums.length - 1;
        while (low < hight) {
            int mid = low + (hight - low) / 2;
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                hight = mid;
            }
        }
        return nums[low];
    }

    public int singleNonDuplicate2(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            // 偶数 -0 奇数 -1
            mid -= mid & 1;
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

    public int singleNonDuplicate3(int[] nums) {
        int ans = 0;
        for (int x : nums) {
            ans = ans ^ x;
        }
        return ans;

    }
}
