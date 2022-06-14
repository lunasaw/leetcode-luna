package linearlist.linearenum.twoarrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author luna
 * 2022/6/13
 */

public class IntersectionOfTwoArrays349 {

    /**
     * 349. 两个数组的交集
     * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2]
     * 示例 2：
     * <p>
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[9,4]
     * 解释：[4,9] 也是可通过的
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums1.length, nums2.length <= 1000
     * 0 <= nums1[i], nums2[i] <= 1000
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};

        int[] nums2 = new int[]{2, 2};
        int[] intersection = new IntersectionOfTwoArrays349().intersection(nums1, nums2);

        System.out.println(intersection);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> sets = new HashSet<>();
        int tag = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    sets.add(nums2[j]);
                }
            }
        }

        return sets.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 方法二：排序 + 双指针
     * 如果两个数组是有序的，则可以使用双指针的方法得到两个数组的交集。
     *
     * 首先对两个数组进行排序，然后使用两个指针遍历两个数组。可以预见的是加入答案的数组的元素一定是递增的，为了保证加入元素的唯一性，
     * 我们需要额外记录变量 {pre}pre 表示上一次加入答案数组的元素。
     *
     * 初始时，两个指针分别指向两个数组的头部。每次比较两个指针指向的两个数组中的数字，如果两个数字不相等，则将指向较小数字的指针右移一位，
     * 如果两个数字相等，且该数字不等于 {pre}pre ，将该数字添加到答案并更新 {pre}pre 变量，同时将两个指针都右移一位。当至少有一个指针超出数组范围时，遍历结束。

     *
     * 复杂度分析
     *
     * 时间复杂度：O(m \log m+n \log n)O(mlogm+nlogn)，其中 mm 和 nn 分别是两个数组的长度。对两个数组排序的时间复杂度
     * 分别是 O(m \log m)O(mlogm) 和 O(n \log n)O(nlogn)，双指针寻找交集元素的时间复杂度是 O(m+n)O(m+n)，因此总时间复杂度是 O(m \log m+n \log n)O(mlogm+nlogn)。
     *
     * 空间复杂度：O(\log m+\log n)O(logm+logn)，其中 mm 和 nn 分别是两个数组的长度。空间复杂度主要取决于排序使用的额外空间。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[length1 + length2];
        int index = 0, index1 = 0, index2 = 0;

        while (index1 < length1 && index2 < length2){
            int num1 = nums1[index1];
            int num2 =  nums2[index2];
            if (num1 == num2){
                if (index == 0 || intersection[index-1] != num1){
                    intersection[index++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 < num2){
                index1 ++;
            } else {
                index2 ++;
            }
        }

        return Arrays.copyOfRange(intersection, 0, index);

    }
}
