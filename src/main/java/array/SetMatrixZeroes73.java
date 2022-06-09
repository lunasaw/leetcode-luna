package array;

import java.util.Arrays;

/**
 * @author luna
 * 2022/6/8
 */

public class SetMatrixZeroes73 {

    /**
     * <a href="https://leetcode.cn/problems/set-matrix-zeroes/">73. 矩阵置零   </a>
     * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     *
     * <img width="600" height="400" src="https://assets.leetcode.com/uploads/2020/08/17/mat1.jpg" alt="">
     * <p>
     * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]] matrix[1][1]
     * 输出：[[1,0,1],[0,0,0],[1,0,1]]
     * 示例 2：
     * <img width="600" height="400" src="https://assets.leetcode.com/uploads/2020/08/17/mat2.jpg" alt="">
     * <p>
     * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
     * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
     * <p>
     * <p>
     * 提示：<br/>
     * <p>
     * m == matrix.length
     * n == matrix[0].length
     * 1 <= m, n <= 200
     * -231 <= matrix[i][j] <= 231 - 1
     * <p>
     * <p>
     * 进阶：
     * <p>
     * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
     * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
     * 你能想出一个仅使用常量空间的解决方案吗？
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        /**   int[][] matrix = new int[][]{
         {1,0,1},
         {0,0,0},
         {1,0,1},
         {1,0,1}
         };
         */
        new SetMatrixZeroes73().setZeroes2(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void setZeroes(int[][] matrix) {
        // 行数
        boolean[] row = new boolean[matrix.length];
        // 列数
        boolean[] col = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public void setZeroes2(int[][] matrix) {
        // 行 [i][0]
        int m = matrix.length,
                // 列数 [0][j]
                n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                // 遍历第0列 也就是每一行第0个 为0，则第0列需要为0
                flagCol0 = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                // 遍历第0行 也就是第0行的第j个 为0，则第0行需要为0
                flagRow0 = true;
            }
        }
        // 行
        for (int i = 1; i < m; i++) {
            // 列
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    /**
     * 我们可以对方法二进一步优化，只使用一个标记变量记录第一列是否原本存在 00。这样，第一列的第一个元素即可以标记第一行是否出现 00。
     * 但为了防止每一列的第一个元素被提前更新，我们需要从最后一行开始，倒序地处理矩阵元素。
     *
     * @param matrix
     */
    public void setZeroes3(int[][] matrix) {
        // 行 [i][0]
        int m = matrix.length,
                // 列数 [0][j]
                n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }

    }
}
