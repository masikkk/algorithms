package leetcode.leetcode;

import utils.ArrayUtils;

/**
 * 车的可用捕获量
 * https://leetcode-cn.com/problems/available-captures-for-rook/
 * @author masikkk.com
 * @create 2020-03-26 15:38
 */
public class _999_AvailableCapturesForRook {
    private static class SolutionV2020 {
        public int numRookCaptures(char[][] board) {
            if (null == board || 0 == board.length) {
                return 0;
            }
            int pawns = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    // 找到车的坐标
                    if (board[i][j] == 'R') {
                        // 上
                        for (int ii = i; ii >= 0 && board[ii][j] != 'B'; ii--) {
                            if (board[ii][j] == 'p') {
                                pawns++;
                                break;
                            }
                        }
                        // 下
                        for (int ii = i; ii < board.length && board[ii][j] != 'B'; ii++) {
                            if (board[ii][j] == 'p') {
                                pawns++;
                                break;
                            }
                        }
                        // 右
                        for (int jj = j; jj < board[0].length && board[i][jj] != 'B'; jj++) {
                            if (board[i][jj] == 'p') {
                                pawns++;
                                break;
                            }
                        }
                        // 左
                        for (int jj = j; jj >= 0 && board[i][jj] != 'B'; jj--) {
                            if (board[i][jj] == 'p') {
                                pawns++;
                                break;
                            }
                        }
                    }
                }
            }
            return pawns;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        char[][] board1 = ArrayUtils.stringToChar2DArray("["
                + "[.,.,.,.,.,.,.,.],"
                + "[.,.,.,p,.,.,.,.],"
                + "[.,.,.,p,.,.,.,.],"
                + "[p,p,.,R,.,p,B,.],"
                + "[.,.,.,.,.,.,.,.],"
                + "[.,.,.,B,.,.,.,.],"
                + "[.,.,.,p,.,.,.,.],"
                + "[.,.,.,.,.,.,.,.]]");

        char[][] board2 = ArrayUtils.stringToChar2DArray("["
                + "[.,.,.,.,.,.,.,.],"
                + "[.,p,p,p,p,p,.,.],"
                + "[.,p,p,B,p,p,.,.],"
                + "[.,p,B,R,B,p,.,.],"
                + "[.,p,p,B,p,p,.,.],"
                + "[.,p,p,p,p,p,.,.],"
                + "[.,.,.,.,.,.,.,.],"
                + "[.,.,.,.,.,.,.,.]]");

        char[][] board3 = ArrayUtils.stringToChar2DArray("["
                + "[.,.,.,.,.,.,.,.],"
                + "[.,.,.,p,.,.,.,.],"
                + "[.,.,.,p,.,.,.,.],"
                + "[p,p,.,R,.,p,B,.],"
                + "[.,.,.,.,.,.,.,.],"
                + "[.,.,.,B,.,.,.,.],"
                + "[.,.,.,p,.,.,.,.],"
                + "[.,.,.,.,.,.,.,.]]");

        System.out.println(solutionV2020.numRookCaptures(board1));
        System.out.println(solutionV2020.numRookCaptures(board2));
        System.out.println(solutionV2020.numRookCaptures(board3));
    }
}
