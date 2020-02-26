package problems;

import java.util.Deque;
import java.util.LinkedList;
import javafx.util.Pair;

/**
 * 岛屿个数
 * https://leetcode-cn.com/problems/number-of-islands/
 * @author masikkk.com
 * @create 2020-02-26 15:14
 */
public class _200_NumberOfIslands {
    private static class SolutionV2020 {
        public int numIslands(char[][] grid) {
            if (null == grid || grid.length == 0) {
                return 0;
            }
            int islandsCount = 0;
            int rows = grid.length, columns = grid[0].length;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (grid[i][j] == '1') {
                        // 开始一次dfs， 每次dfs可遍历一座岛，dfs的次数就是岛的个数
                        dfs(grid, i, j);
                        islandsCount++;
                    }
                }
            }
            return islandsCount;
        }

        // 从位置[row][column]开始深度优先搜索访问二维数组grid，将访问过的1设为0
        private void dfs(char[][] grid, int row, int column) {
            Deque<Pair<Integer, Integer>> stack = new LinkedList<>();
            grid[row][column] = '0';
            stack.push(new Pair(row, column));
            while (!stack.isEmpty()) {
                Pair<Integer, Integer> pair = stack.element();
                int i = pair.getKey(), j = pair.getValue();
                if (i - 1 >= 0 && grid[i-1][j] == '1') { // 往上
                    grid[i-1][j] = '0';
                    stack.push(new Pair(i-1, j));
                } else if (j - 1 >= 0 && grid[i][j-1] == '1') { // 往左
                    grid[i][j-1] = '0';
                    stack.push(new Pair(i, j-1));
                } else if (i + 1 < grid.length && grid[i + 1][j] == '1') { // 往下
                    grid[i + 1][j] = '0';
                    stack.push(new Pair(i + 1, j));
                } else if (j + 1 < grid[0].length && grid[i][j+1] == '1') { // 往右
                    grid[i][j+1] = '0';
                    stack.push(new Pair(i, j+1));
                } else {
                    stack.pop();
                }
            }
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        char[][] grid = {
                {'1', '1', '1', '1', '0' },
                {'1', '1', '0', '1', '0' },
                {'1', '1', '0', '0', '0' },
                {'0', '0', '0', '0', '0' }};
        char[][] grid2 = {
                {'1', '1', '0', '0', '0' },
                {'1', '1', '0', '0', '0' },
                {'0', '0', '1', '0', '0' },
                {'0', '0', '0', '1', '1' }};
        // 易错用例，dfs还要往左搜
        char[][] grid3 = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}};
        // 易错用例，dfs还要往上搜，就是前后左右4个方向都要搜
        char[][] grid4 = {
                {'1', '0', '1', '1', '1' },
                {'1', '0', '1', '0', '1' },
                {'1', '1', '1', '0', '1' }};
//        System.out.println(solutionV2020.numIslands(grid));
//        System.out.println(solutionV2020.numIslands(grid2));
        System.out.println(solutionV2020.numIslands(grid3));
        System.out.println(solutionV2020.numIslands(grid4));
    }
}
