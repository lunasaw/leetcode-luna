package array;

/**
 * @author luna
 * 2022/6/10
 */

public class WordSearch79 {

    /**
     * 79. 单词搜索
     * 难度
     * 中等
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * <p>
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <img width="600" height="400" src="https://assets.leetcode.com/uploads/2020/11/04/word2.jpg" alt="">
     * <p>
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     * 示例 2：
     * <img width="600" height="400" src="https://assets.leetcode.com/uploads/2020/11/04/word-1.jpg" alt="">
     * <p>
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
     * 输出：true
     * 示例 3：
     * <img width="600" height="400" src="https://assets.leetcode.com/uploads/2020/10/15/word3.jpg" alt="">
     * <p>
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
     * 输出：false
     * <p>
     * <p>
     * 提示：
     * <p>
     * m == board.length
     * n = board[i].length
     * 1 <= m, n <= 6
     * 1 <= word.length <= 15
     * board 和 word 仅由大小写英文字母组成
     * <p>
     * <p>
     * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // 遍历当前网格，以每个位置为起点，往下找
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param board   棋盘
     * @param visited 是否已经被访问过的数组维护
     * @param i       表示判断以网格的 (i,j) 位置出发
     * @param j
     * @param s       被查找字符串
     * @param k       被查找位置
     * @return
     */
    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            // 当前位置与所需要查找的值不一致 直接返回flase
            return false;
        } else if (k == s.length() - 1) {
            // 当前查找长度等于字符串长度，查找完成
            return true;
        }
        // 当前位置值与查找字符串的位置一致，继续查找
        // 标识当前位置被访问
        visited[i][j] = true;
        // 查找方向
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // 返回当前查找结果
        boolean result = false;
        // 遍历方向
        for (int[] dir : directions) {
            // 新的i，j 等于当前位置加上方向
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                // 如果当前位置合法
                if (!visited[newi][newj]) {
                    // 并且没有被访问
                    // 接着往下找 k+1 号位置的字符
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        // 找到成功的，继续跳出循环，返回
                        break;
                    }
                }
            }
        }
        // 路径失败，重新查找
        visited[i][j] = false;
        return result;
    }
}
