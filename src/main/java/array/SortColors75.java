package array;

import java.util.Arrays;

/**
 * @author luna
 * 2022/6/9
 */

public class SortColors75 {

    /**
     * 75. 颜色分类
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * <p>
     * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * <p>
     * 必须在不使用库的sort函数的情况下解决这个问题。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     * 示例 2：
     * <p>
     * 输入：nums = [2,0,1]
     * 输出：[0,1,2]
     * <p>
     * <p>
     * 提示：
     * <p>
     * n == nums.length
     * 1 <= n <= 300
     * nums[i] 为 0、1 或 2
     * <p>
     * <p>
     * 进阶：
     * <p>
     * 你可以不使用代码库中的排序函数来解决这道题吗？
     * 你能想出一个仅使用常数空间的一趟扫描算法吗？
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] matrix = new int[]{2, 1, 2};
        new SortColors75().sortColors2(matrix);
        System.out.println(Arrays.toString(matrix));
    }

    /**
     * 我们可以考虑对数组进行两次遍历。在第一次遍历中，我们将数组中所有的 00 交换到数组的头部。在第二次遍历中，
     * 我们将数组中所有的 11 交换到头部的 00 之后。此时，所有的 22 都出现在数组的尾部，这样我们就完成了排序。
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(n)O(n)，其中 nn 是数组 \textit{nums}nums 的长度。
     * <p>
     * 空间复杂度：O(1)O(1)。
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int ptr = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }

        for (int i = ptr; i < nums.length; i++) {
            if (nums[i] == 1) {
                temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }
    }

    /**
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 是数组 \textit{nums}nums 的长度。
     *
     * 空间复杂度：O(1)O(1)。
     * 双指针
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > p2){
                return;
            }
            while (i <= p2 && nums[i] == 2) {
                temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if (nums[i] == 0) {
                temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }
}
