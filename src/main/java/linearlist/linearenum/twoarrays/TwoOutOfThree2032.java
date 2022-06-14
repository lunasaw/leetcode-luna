package linearlist.linearenum.twoarrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author luna
 * 2022/6/14
 */

public class TwoOutOfThree2032 {

    /**
     * 2032. 至少在两个数组中出现的值
     * 给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 元素各不相同的 数组，且由 至少 在 两个 数组中出现的所有值组成。数组中的元素可以按 任意 顺序排列。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
     * 输出：[3,2]
     * 解释：至少在两个数组中出现的所有值为：
     * - 3 ，在全部三个数组中都出现过。
     * - 2 ，在数组 nums1 和 nums2 中出现过。
     * 示例 2：
     * <p>
     * 输入：nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
     * 输出：[2,3,1]
     * 解释：至少在两个数组中出现的所有值为：
     * - 2 ，在数组 nums2 和 nums3 中出现过。
     * - 3 ，在数组 nums1 和 nums2 中出现过。
     * - 1 ，在数组 nums1 和 nums3 中出现过。
     * 示例 3：
     * <p>
     * 输入：nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
     * 输出：[]
     * 解释：不存在至少在两个数组中出现的值。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums1.length, nums2.length, nums3.length <= 100
     * 1 <= nums1[i], nums2[j], nums3[k] <= 100
     *
     * @param args
     */
    public static void main(String[] args) {

        /**
         * [1,1,3,2]
         * [2,3]
         * [3]
         */

        int[] nums1 = new int[]{1, 1, 3, 2};
        int[] nums2 = new int[]{2, 3};
        int[] nums3 = new int[]{3};

        List<Integer> integers = new TwoOutOfThree2032().twoOutOfThree2(nums1, nums2, nums3);
        System.out.println(integers);
    }

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                for (int k = 0; k < nums3.length; k++) {
                    if (nums1[i] == nums2[j]) {
                        ans.add(nums1[i]);
                    } else if (nums3[k] == nums2[j] || nums3[k] == nums1[i]) {
                        ans.add(nums3[k]);
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }

    /**
     * 用100个int记录每个可能出现的数字的状态，每个数字的状态按如下编码：
     * <p>
     * 0：不出现
     * 1：在nums1中出现
     * 2：在nums2中出现
     * 3：在nums3中出现
     * 4：在nums1、2中出现
     * 5：在nums1、3中出现
     * 6：在nums2、3中出现
     * 大于7：在nums1、2、3中出现
     * 遍历nums1
     * 此时数组中均为状态0,对int x:nums ，cache[x]的值由0->1
     * <p>
     * 遍历nums2
     * 此时数组中状态为0,1。开始遍历，按照
     * <p>
     * 0->2
     * 1->4
     * 进行值的更新，对于nums2重复出现的数字，之前已经进行过状态更新，所以当遇到状态为2,4，说明已经更新过该数字的状态，跳过：if (cache[x] <= 1)。若更新后状态为4，符合题意，加入res。
     * <p>
     * 遍历nums3
     * 对于状态0->3，不满足题意，忽略。状态4已经在遍历nums2中加入到结果中，忽略。对于其他所有状态，按照下列规则更新后，均符合题意。
     * <p>
     * 1->5
     * 2->6
     *
     * @param nums1
     * @param nums2
     * @param nums3
     * @return
     */
    public List<Integer> twoOutOfThree2(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> res = new ArrayList<>();
        int[] cache = new int[101];
        for (int x : nums1) {
            cache[x] = 1;
        }
        for (int x : nums2) {
            if (cache[x] <= 1) {
                cache[x] += 1;
                cache[x] <<= 1;
                if (cache[x] == 4) {
                    res.add(x);
                }
            }

        }
        for (int x : nums3) {
            if (cache[x] == 1 || cache[x] == 2) {
                cache[x] += 4;
                res.add(x);
            }
        }
        return res;
    }

    public List<Integer> twoOutOfThree3(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> s1 = new HashSet<Integer>();
        Set<Integer> s2 = new HashSet<Integer>();
        Set<Integer> s3 = new HashSet<Integer>();
        for (Integer i : nums1) {
            s1.add(i);
        }
        for (Integer i : nums2) {
            s2.add(i);
        }
        for (Integer i : nums3) {
            s3.add(i);
        }
        Set<Integer> total = new HashSet<Integer>();
        total.addAll(s1);
        total.addAll(s2);
        total.addAll(s3);
        List<Integer> ret = new ArrayList<>();
        for (Integer i : total) {
            int v1 = s1.contains(i) ? 1 : 0;
            int v2 = s2.contains(i) ? 1 : 0;
            int v3 = s3.contains(i) ? 1 : 0;
            if (v1 + v2 + v3 > 1) {
                ret.add(i);
            }
        }

        return ret;
    }

}
