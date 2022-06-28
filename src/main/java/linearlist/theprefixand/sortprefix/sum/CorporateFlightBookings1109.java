package linearlist.theprefixand.sortprefix.sum;

/**
 * @author luna
 * 2022/6/28
 */
public class CorporateFlightBookings1109 {

    /**
     * 1109. 航班预订统计
     * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
     * <p>
     * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi]
     * 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
     * <p>
     * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
     * 输出：[10,55,45,25,25]
     * 解释：
     * 航班编号        1   2   3   4   5
     * 预订记录 1 ：   10  10
     * 预订记录 2 ：       20  20
     * 预订记录 3 ：       25  25  25  25
     * 总座位数：      10  55  45  25  25
     * 因此，answer = [10,55,45,25,25]
     * 示例 2：
     * <p>
     * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
     * 输出：[10,25]
     * 解释：
     * 航班编号        1   2
     * 预订记录 1 ：   10  10
     * 预订记录 2 ：       15
     * 总座位数：      10  25
     * 因此，answer = [10,25]
     * @param args
     */
    public static void main(String[] args) {
        int[][] bookings = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};

        new CorporateFlightBookings1109().corpFlightBookings(bookings, 5);
    }

        /**
         * 差分
         * 差分数组求前缀和即可得到原数组
         */
        public int[] corpFlightBookings ( int[][] bookings, int n){
            // 差分数组
            int[] nums = new int[n];
            for (int[] booking : bookings) {
                // booking[0] 表示航班号； booking[0] - 1 ；前置航班号 nums[前置航班号] 前置航班号的座位数； booking[2]  表示座位数
                nums[booking[0] - 1] += booking[2];
                if (booking[1] < n) {
                    nums[booking[1]] -= booking[2];
                }
            }
            for (int i = 1; i < n; i++) {
                nums[i] += nums[i - 1];
            }
            return nums;
        }

    }
