package leetcode.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 最大正方形
 * https://leetcode-cn.com/problems/maximal-square/
 * @author masikkk.com 2020-05-08 14:52
 */
public class _221_MaximalSquare {
    private static class SolutionV2020 {
        int[] dx = { 1, 1, 0};
        int[] dy = { 0, 1, 1};
        int rows, columns;
        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }
            rows = matrix.length;
            columns = matrix[0].length;

            int maxEdge = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (matrix[i][j] == '1') {
                        int edge = bfs(matrix, i, j);
                        maxEdge = Math.max(maxEdge, edge);
                    }
                }
            }
            return maxEdge * maxEdge;
        }

        // 从 (x,y) 开始一次BFS，并返回全为1的最大正方形边长
        private int bfs(char[][] matrix, int x, int y) {
            int edge = 1;
            Set<int[]> visited = new HashSet<>();
            Queue<int[]> queue = new LinkedList<>();
            visited.add(new int[] {x, y});
            queue.offer(new int[] {x, y});
            while (!queue.isEmpty()) {
                int levelCount = queue.size();
                // 只有下一层结点全部在矩阵范围内，且值全是1时，边长 edge 才加1
                for (int i = 0; i < levelCount; i++) {
                    int[] cur = queue.poll();
                    for (int k = 0; k < 3; k++) {
                        int xx = cur[0] + dx[k], yy = cur[1] + dy[k];
                        if (xx < rows && yy < columns && matrix[xx][yy] == '1') {
                            visited.add(new int[] {xx, yy});
                            queue.offer(new int[] {xx, yy});
                        } else {
                            return edge;
                        }
                    }
                }
                edge++;
            }
            return edge;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.maximalSquare(new char[][] {}));
        System.out.println(solutionV2020.maximalSquare(new char[][] {{}}));
        System.out.println(solutionV2020.maximalSquare(new char[][] {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
    }
}