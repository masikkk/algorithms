package leetcode.leetcode;

public class _419_BattleshipsInBoard {
    private static class Solution {
        public int countBattleships(char[][] board) {
            int count = 0;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j] == 'X') { //新出现x
						count++; //先加1
						if (j >= 1 && board[i][j - 1] == 'X')//如果左边是x，不能重复计数，减1
						{
							count--;
						}
						if (i >= 1 && board[i - 1][j] == 'X')//如果上边是x，不能重复计数，减1
						{
							count--;
						}
					}
				}
			}
            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        System.out.println(solution.countBattleships(board));
    }
}
