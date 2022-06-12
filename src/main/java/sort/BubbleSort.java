package sort;

import java.util.Arrays;

/**
 * @author luna
 * 2022/6/12
 */
public class BubbleSort {


    /**
     * 冒泡排序
     * 算法描述
     * 对于要排序的数组，从第一位开始从前往后比较相邻两个数字，若前者大，则交换两数字位置，然后比较位向右移动一位。也就是比较arr[0]和arr[1]，若arr[0] > arr[1]，交换arr[0]和arr[1]。接着比较位移动一位，比较arr[1]和arr[2]，直到比较到arr[n - 2]和arr[n - 1] (n = arr.length)。第1轮从前到后的比较将使得最大的数字 冒泡 到最后，此时可以说一个数字已经被排序。每一轮的比较将使得当前未排序数字中的最大者被排序，未排序数字总数减1。第arr.length - 1轮结束后排序完成。
     * <p>
     * 如下动图展示了{4,6,2,1,7,9,5,8,3}的冒泡排序过程（未应用优化）。
     * <p>
     * <p>
     * <img src="https://pic.leetcode-cn.com/1652691998-pJaTQD-bubble.gif">冒泡排序</img>
     * <p>
     * 稳定性：稳定。
     * <p>
     * 排序 稳定性 指的是相等元素在原输入数组中的相对位置，在排序后不变，否则排序不稳定。稳定性对于纯数字数组来说意义不大，但对于包含多个属性的类数组来说，用于比较的属性之外其他属性不同时，保持排序的稳定性就很重要了。
     * <p>
     * 冒泡排序始终只交换相邻元素，比较对象大小相等时不交换，相对位置不变，故稳定。
     * <p>
     * 优化
     * 提前结束优化
     * <p>
     * 当某一轮比较均未发生交换，说明排序已完成，可设置一个布尔值记录一轮排序是否有发生交换，若无则提前退出循环结束程序。
     * <p>
     * 冒泡界优化
     * <p>
     * 记录前一轮交换的最终位置，说明该位置之后的元素为已排序状态，下一轮的交换只需执行到该处。
     * <p>
     * 复杂度分析
     * 时间复杂度：两层for循环，第1轮比较 n - 1 次(n = arr.length)，最后一轮比较1次。总比较次数为 n*(n - 1) / 2n∗(n−1)/2 次，时间复杂度为 O(n^2)O(n
     * 2
     * )。当输入数组为已排序状态时，在应用提前结束优化的情况下，只需一轮比较，此时为最佳时间复杂度 O(n)O(n)。
     * <p>
     * 空间复杂度：算法中只有常数项变量，O(1)O(1)。
     * <p>
     * 代码
     * 无优化的基本冒泡排序代码此处不列出。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 2, 9, 3, 4, 4, 8, 8};

        bubbleSortBetter(nums);

        System.out.println(Arrays.toString(nums));
    }

    public static int[] bubbleSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        // n - 1轮次执行，当前 n - 1 个元素排好后，最后一个元素无需执行，故i < arr.length - 1
        for (int i = 0; i < arr.length - 1; i++) {
            // 本轮执行是否有交换的标志，若无则false，若有则true
            boolean swapped = false;
            // 每轮循环，通过依次向右比较两个数，将本轮循环中最大的数放到最右
            for (int j = 1; j < arr.length - i; j++) {
                // 若左大于右则交换，并将swapped置为true
                if (arr[j - 1] > arr[j]) {
                    SwapFunction.swap(arr, j - 1, j);
                    swapped = true;
                }
            }
            // 若无交换，表示当前数组已完全排序，退出大循环
            if (!swapped) {
                break;
            }
        }
        return arr;
    }

    public static int[] bubbleSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 1; j < arr.length - 1; j++) {
                if (arr[j - 1] > arr[j]) {
                    SwapFunction.swap(arr, j, j - 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return arr;
    }

    public static int[] bubbleSortBetter(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        boolean swapped = true;
        int lastSwappedIdx = arr.length - 1;
        int swappedIdx = -1;
        // lastSwappedIdx表示前一轮交换的最终位置，即下标为lastSwappedIdx是未排序部分中的最后一个数的下标，
        // 因此for中的界是i < lastSwappedIdx而不需要写成i <= lastSwappedIdx
        while (swapped) {
            // 当swapped = false时，排序完成
            // 本轮执行是否有交换的标志，若无则true，若有则false
            swapped = false;
            // 每轮循环，通过依次向右比较两个数，将本轮循环中最大的数放到最右
            for (int i = 0; i < lastSwappedIdx; i++) {
                // 若左大于右则交换，并将swapped置为true
                if (arr[i] > arr[i + 1]) {
                    SwapFunction.swap(arr, i, i + 1);
                    swapped = true;
                    swappedIdx = i;
                }
            }
            lastSwappedIdx = swappedIdx;
        }
        return arr;
    }

    public static int[] bubbleSortBetter2(int[] arr) {
        int maxLength = arr.length - 1;
        int lastSwapped = -1;
        boolean swapped = true;
        while (swapped) {
            for (int i = 0; i < maxLength; i++) {
                if (arr[i] > arr[i++]) {
                    SwapFunction.swap(arr, i, i++);
                    swapped = false;
                    lastSwapped = i;
                }
            }
            maxLength = lastSwapped;
        }
        return arr;
    }
}
