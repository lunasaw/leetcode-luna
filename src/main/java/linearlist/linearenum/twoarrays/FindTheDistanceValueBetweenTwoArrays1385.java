package linearlist.linearenum.twoarrays;

import java.util.Arrays;

/**
 * @author luna
 * 2022/6/13
 */

public class FindTheDistanceValueBetweenTwoArrays1385 {

    /**
     * 1385. 两个数组间的距离值
     * <a href="https://leetcode.cn/problems/find-the-distance-value-between-two-arrays/">https://leetcode.cn/problems/find-the-distance-value-between-two-arrays/</a>
     * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
     * <p>
     * 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
     * 输出：2
     * 解释：
     * 对于 arr1[0]=4 我们有：
     * |4-10|=6 > d=2
     * |4-9|=5 > d=2
     * |4-1|=3 > d=2
     * |4-8|=4 > d=2
     * 所以 arr1[0]=4 符合距离要求
     * <p>
     * 对于 arr1[1]=5 我们有：
     * |5-10|=5 > d=2
     * |5-9|=4 > d=2
     * |5-1|=4 > d=2
     * |5-8|=3 > d=2
     * 所以 arr1[1]=5 也符合距离要求
     * <p>
     * 对于 arr1[2]=8 我们有：
     * |8-10|=2 <= d=2
     * |8-9|=1 <= d=2
     * |8-1|=7 > d=2
     * |8-8|=0 <= d=2
     * 存在距离小于等于 2 的情况，不符合距离要求
     * <p>
     * 故而只有 arr1[0]=4 和 arr1[1]=5 两个符合距离要求，距离值为 2
     * 示例 2：
     * <p>
     * 输入：arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3
     * 输出：2
     * 示例 3：
     * <p>
     * 输入：arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6
     * 输出：1
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= arr1.length, arr2.length <= 500
     * -10^3 <= arr1[i], arr2[j] <= 10^3
     * 0 <= d <= 100
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 5, 9};

        int[] nums2 = new int[]{10, 9, 1, 8};

        int theDistanceValue3 = new FindTheDistanceValueBetweenTwoArrays1385().findTheDistanceValue3(nums1, nums2, 2);

        System.out.println(theDistanceValue3);
    }

    /**
     * 方法一 模拟
     * 假设 arr1 中元素个数为 nn，arr2 中元素个数为 mm。
     * <p>
     * 时间复杂度：从代码可以看出这里的渐进时间复杂度是 O(n \times m)O(n×m)。
     * <p>
     * 空间复杂度：这里没有使用任何的辅助空间，故渐进空间复杂度为 O(1)O(1)。
     *
     * @param arr1
     * @param arr2
     * @param d
     * @return
     */
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int num = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    flag = false;
                }
            }
            if (flag) {
                num++;
            }
        }
        return num;
    }

    public int findTheDistanceValue2(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int num : arr1) {
            int low = num - d;
            int high = num + d;
            boolean b = binarySearch(arr2, low, high);
            if (!b){
                count ++;
            }

        }
        return count;
    }

    public static boolean binarySearch(int[] arr, int low ,int high){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (right + left) >> 1;
            if (arr[mid]>=low && arr[mid] <= high){
                return true;
            } else if (arr[mid] > high ){
                // 在左边
                right = mid - 1;
            } else if (arr[mid] < low){
                // 在右边
                left = mid + 1;
            }
        }

        return false;
    }


    public int findTheDistanceValue3(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;
        for (int i1 : arr1) {
            int low = i1 - d;
            int high = i1 + d;
            // num - d <= y <= num + d
            // 1到2的距离的绝对值
            int index1 = binarySearch(arr2, low);
            int index2 = binarySearch(arr2, high);
            if (index1 < 0 && index1 == index2) {
                ans++;
            }
        }
        return ans;
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];

            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }
}
