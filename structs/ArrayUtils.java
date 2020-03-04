package structs;

import java.util.Arrays;

/**
 * @author masikkk.com
 * @create 2020-02-29 22:53
 */
public class ArrayUtils {
    // 字符串转二维数组
    public static int[][] stringToInteger2DArray(String input) {
        input = input.trim().substring(1, input.length() - 1);
        String[] rows = input.split("],");
        int[][] res = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String row = rows[i].trim();
            if (row.charAt(0) == '[') {
                row = row.substring(1);
            }
            if (row.charAt(row.length() -1 ) == ']') {
                row = row.substring(0, row.length() - 1);
            }
            String[] columns = row.split(",");
            int column[] = new int[columns.length];
            for (int j = 0; j < columns.length; j++) {
                column[j] = Integer.parseInt(columns[j]);
            }
            res[i] = column;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = ArrayUtils.stringToInteger2DArray("[[0,0,1,0,0,0,0,1,0,0,0,0,0],"
                + " [0,0,0,0,0,0,0,1,1,1,0,0,0],"
                + " [0,1,1,0,1,0,0,0,0,0,0,0,0],"
                + " [0,1,0,0,1,1,0,0,1,0,1,0,0],"
                + " [0,1,0,0,1,1,0,0,1,1,1,0,0],"
                + " [0,0,0,0,0,0,0,0,0,0,1,0,0],"
                + " [0,0,0,0,0,0,0,1,1,1,0,0,0],"
                + " [0,0,0,0,0,0,0,1,1,0,0,0,0]]");
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }

        int[][] grid2 = ArrayUtils.stringToInteger2DArray("[[0,0,0,0,0,0,0,0]]");
        for (int[] row : grid2) {
            System.out.println(Arrays.toString(row));
        }

        int[][] grid3 = ArrayUtils.stringToInteger2DArray("[[0,2]]");
        for (int[] row : grid3) {
            System.out.println(Arrays.toString(row));
        }
    }
}
