package leetcode.leetcode;

/**
 * 甲板上的战舰
 * https://leetcode-cn.com/problems/battleships-in-a-board/
 */
public class _419_BattleshipsInBoard {
    private static class SolutionV2018 {
        public int countBattleships(char[][] board) {
            int count = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    // 新出现x
                    if (board[i][j] == 'X') {
                        count++; //先加1
                        // 如果左边是x，不能重复计数，减1
                        if (j >= 1 && board[i][j - 1] == 'X') {
                            count--;
                        }
                        // 如果上边是x，不能重复计数，减1
                        if (i >= 1 && board[i - 1][j] == 'X') {
                            count--;
                        }
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        char[][] board = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        System.out.println(solutionV2018.countBattleships(board));
    }
}
