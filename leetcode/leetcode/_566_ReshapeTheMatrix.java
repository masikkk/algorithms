package leetcode.leetcode;

public class _566_ReshapeTheMatrix {
    private static class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            int origin_row = nums.length;
            int origin_column = nums[0].length;
            if (origin_row * origin_column != r * c) {
                return nums;
            }
            int[][] output = new int[r][];
            output[0] = new int[c];
            int m = 0, n = 0;
            for (int i = 0; i < origin_row; i++) {
                for (int j = 0; j < origin_column; j++) {
                    if (n >= c) {//新矩阵换行
                        n = 0;
                        m++;
                        output[m] = new int[c];
                    }
                    output[m][n++] = nums[i][j];
                }
            }
            return output;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = {{1, 2}, {3, 4}};
        int[][] output = solution.matrixReshape(input, 4, 1);
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }
}
