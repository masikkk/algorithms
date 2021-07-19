package leetcode.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import javafx.util.Pair;
import utils.ArrayUtils;

/**
 * 01 矩阵
 * https://leetcode-cn.com/problems/01-matrix/
 * @author masikkk.com 2020-04-15 12:04
 */
public class _542_01Matrix {
    private static class SolutionV2020 {
        int[] dx = {-1, 0, 1,  0};
        int[] dy = { 0, 1, 0, -1};
        int nrows, ncolumns;
        public int[][] updateMatrix(int[][] matrix) {
            if (null == matrix) {
                return null;
            }
            this.nrows = matrix.length;
            this.ncolumns = matrix[0].length;
            int[][] res = new int[nrows][ncolumns];

            for (int i = 0; i < nrows; i++) {
                for (int j = 0; j < ncolumns; j++) {
                    if (matrix[i][j] == 1) {
                        res[i][j] = bfs(matrix, i, j);
                    }
                }
            }
            return res;
        }

        // 从 i,j 开始一次bfs，返回首次遇到0时的层数
        private int bfs(int[][] matrix, int i, int j) {
            // 已访问结点集合
            Set<Pair<Integer, Integer>> visited = new HashSet<>();
            Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
            queue.offer(new Pair<>(i, j));
            int level = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                // 遍历当前层的所有结点
                for (int l = 0; l < size; l++) {
                    Pair<Integer, Integer> pair = queue.poll();
                    visited.add(pair);
                    // 遇到0直接结束
                    if (matrix[pair.getKey()][pair.getValue()] == 0) {
                        return level;
                    }
                    // 上下左右的结点
                    for (int k = 0; k < 4; k++) {
                        int ii = pair.getKey() + dx[k];
                        int jj = pair.getValue() + dy[k];
                        if (ii >= 0 && ii < nrows && jj >= 0 && jj < ncolumns && !visited.contains(new Pair<>(ii, jj))) {
                            queue.offer(new Pair<>(ii, jj));
                        }
                    }
                }
                level++;
            }
            return level;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 =  new SolutionV2020();
        ArrayUtils.printInt2DArray(solutionV2020.updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}}));
        ArrayUtils.printInt2DArray(solutionV2020.updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}}));
    }
}