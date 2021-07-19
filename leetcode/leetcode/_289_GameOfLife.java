package leetcode.leetcode;

import utils.ArrayUtils;

/**
 * 生命游戏
 * https://leetcode-cn.com/problems/game-of-life/
 * @author masikkk.com
 * @create 2020-04-02 10:22
 */
public class _289_GameOfLife {
    private static class SolutionV2020 {
        private int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}, dy = {0, 1, 1, 1, 0, -1, -1, -1};
        public void gameOfLife(int[][] board) {
            if (null == board || board.length == 0) {
                return;
            }
            int nx = board.length, ny = board[0].length;
            for (int i = 0; i < nx; i++) {
                for (int j = 0; j < ny; j++) {
                    int lives = countAroundLives(board, i, j);
                    if (1 == board[i][j] && (lives < 2 || lives > 3)) {
                        board[i][j] = -1; // 1变0设为-1
                    } else if (0 == board[i][j] && lives == 3){
                        board[i][j] = 2; // 0变1设为2
                    }
                }
            }
            // 复位 -1 -> 0, 2 -> 1
            for (int i = 0; i < nx; i++) {
                for (int j = 0; j < ny; j++) {
                    if (board[i][j] == -1) {
                        board[i][j] = 0;
                    } else if (board[i][j] == 2) {
                        board[i][j] = 1;
                    }
                }
            }
        }

        // 统计 i,j 周围 1 的个数
        private int countAroundLives(int[][] board, int i, int j) {
            int nx = board.length, ny = board[0].length;
            int count = 0;
            for (int k = 0; k < 8; k++) {
                int ii = i + dx[k], jj = j + dy[k];
                if (ii >= 0 && ii < nx && jj >= 0 && jj < ny && 1 == Math.abs(board[ii][jj])) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        int[][] board = ArrayUtils.stringToInt2DArray("["
                + "  [0,1,0],"
                + "  [0,0,1],"
                + "  [1,1,1],"
                + "  [0,0,0]]");
        solutionV2020.gameOfLife(board);
        ArrayUtils.printInt2DArray(board);
    }
}
