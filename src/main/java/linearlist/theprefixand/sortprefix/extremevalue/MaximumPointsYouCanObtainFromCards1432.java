package linearlist.theprefixand.sortprefix.extremevalue;

import java.util.Arrays;

/**
 * @author luna
 * 2022/6/27
 */
public class MaximumPointsYouCanObtainFromCards1432 {

    //前缀和数组+滑动窗口
    int res = Integer.MIN_VALUE;

    /**
     * 1423. 可获得的最大点数
     * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
     * <p>
     * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
     * <p>
     * 你的点数就是你拿到手中的所有卡牌的点数之和。
     * <p>
     * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：cardPoints = [1,2,3,4,5,6,1], k = 3
     * 输出：12
     * 解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
     * 示例 2：
     * <p>
     * 输入：cardPoints = [2,2,2], k = 2
     * 输出：4
     * 解释：无论你拿起哪两张卡牌，可获得的点数总是 4 。
     * 示例 3：
     * <p>
     * 输入：cardPoints = [9,7,7,9,7,7,9], k = 7
     * 输出：55
     * 解释：你必须拿起所有卡牌，可以获得的点数为所有卡牌的点数之和。
     * 示例 4：
     * <p>
     * 输入：cardPoints = [1,1000,1], k = 1
     * 输出：1
     * 解释：你无法拿到中间那张卡牌，所以可以获得的最大点数为 1 。
     * 示例 5：
     * <p>
     * 输入：cardPoints = [1,79,80,1,1,1,200,1], k = 3
     * 输出：202
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * 找到最小窗口，向右滑动，求和减去最小窗口，就是最大值
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        // 滑动窗口大小为 n-k
        int windowSize = n - k;
        // 选前 n-k 个作为初始值
        int sum = 0;
        for (int i = 0; i < windowSize; ++i) {
            sum += cardPoints[i];
        }
        int minSum = sum;
        for (int i = windowSize; i < n; ++i) {
            // 滑动窗口每向右移动一格，增加从右侧进入窗口的元素值，并减少从左侧离开窗口的元素值
            sum += cardPoints[i] - cardPoints[i - windowSize];
            minSum = Math.min(minSum, sum);
        }
        return Arrays.stream(cardPoints).sum() - minSum;
    }

    public int maxScore2(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int[] preSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            preSum[i] = preSum[i - 1] + cardPoints[i - 1];
        }
        int windows = len - k;
        if (windows == 0) {
            return preSum[len];
        }
        for (int i = windows; i <= len; i++) {
            int val = preSum[i] - preSum[i - windows];
            int resVal = preSum[len] - val;
            res = Math.max(res, resVal);
        }
        return res;
    }
}
