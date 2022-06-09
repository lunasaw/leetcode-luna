package array;

/**
 * @author luna
 * 2022/6/8
 */

public class SearchA2dMatrix74 {

    /**
     * 74. 搜索二维矩阵
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     * <p>
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * <p>
     * 示例 1：
     *
     * <img width="600" height="400" src="https://assets.leetcode.com/uploads/2020/10/05/mat.jpg" alt="">
     * <p>
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
     * 输出：true
     * 示例 2：
     *
     * <img width="600" height="400" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/11/25/mat2.jpg" alt="">
     * <p>
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
     * 输出：false
     * <p>
     * <p>
     * 提示：
     * <p>
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 100
     * -104 <= matrix[i][j], target <= 104
     *
     * @param args
     */

    public static void main(String[] args) {

        // [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
        //3

        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60},
        };
        boolean b = new SearchA2dMatrix74().searchMatrix(matrix, 3);
        System.out.println(b);
    }


    /**
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean flag = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j >= 1 && matrix[i][j] < matrix[i][j - 1]) {
                    return false;
                }
                if (matrix[i][j] == target && !flag) {
                    flag = true;
                }
                if (i >= 1 && matrix[i - 1][matrix[i - 1].length - 1] > matrix[i][0]) {
                    return false;
                }
            }
        }
        return flag;
    }

    /**
     * 由于每行的第一个元素大于前一行的最后一个元素，且每行元素是升序的，所以每行的第一个元素大于前一行的第一个元素，因此矩阵第一列的元素是升序的。
     * <p>
     * 我们可以对矩阵的第一列的元素二分查找，找到最后一个不大于目标值的元素，然后在该元素所在行中二分查找目标值是否存在。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        // 先首列二分 再行二分
        int i = binarySearchFirstColumn(matrix, target);
        if (i < 0){
            return false;
        }
        return binarySearchRow(matrix[i], target);
    }

    public int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = -1, high = matrix.length - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean binarySearchRow(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = low + (high - low + 1) / 2;
            if (target > row[mid]) {
                low = mid + 1;
            } else if (target < mid) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix3(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            // 将二维数组看作一维数组
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
