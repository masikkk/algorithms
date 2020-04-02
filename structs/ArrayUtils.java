package structs;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * 二维数组工具类
 * @author masikkk.com
 * @create 2020-02-29 22:53
 */
public class ArrayUtils {
    // 字符串转int二维数组
    public static int[][] stringToInt2DArray(String input) {
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

    // 字符串转char二维数组
    public static char[][] stringToChar2DArray(String input) {
        input = input.trim().substring(1, input.length() - 1);
        String[] rows = input.split("],");
        char[][] res = new char[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String row = rows[i].trim();
            if (row.charAt(0) == '[') {
                row = row.substring(1);
            }
            if (row.charAt(row.length() -1 ) == ']') {
                row = row.substring(0, row.length() - 1);
            }
            String[] columns = row.split(",");
            char column[] = new char[columns.length];
            for (int j = 0; j < columns.length; j++) {
                column[j] = columns[j].charAt(0);
            }
            res[i] = column;
        }
        return res;
    }

    // 打印int二位数组
    public static void printInt2DArray(int[][] input) {
        for (int[] row : input) {
            System.out.println(Arrays.toString(row));
        }
    }

    // 打印char二位数组
    public static void printChar2DArray(char[][] input) {
        for (char[] row : input) {
            System.out.println(Arrays.toString(row));
        }
    }

    @Test
    public void testStringToInt2DArray() {
        System.out.println("-----------------grid------------------");
        int[][] grid = ArrayUtils.stringToInt2DArray("[[0,0,1,0,0,0,0,1,0,0,0,0,0],"
                + " [0,0,0,0,0,0,0,1,1,1,0,0,0],"
                + " [0,1,1,0,1,0,0,0,0,0,0,0,0],"
                + " [0,1,0,0,1,1,0,0,1,0,1,0,0],"
                + " [0,1,0,0,1,1,0,0,1,1,1,0,0],"
                + " [0,0,0,0,0,0,0,0,0,0,1,0,0],"
                + " [0,0,0,0,0,0,0,1,1,1,0,0,0],"
                + " [0,0,0,0,0,0,0,1,1,0,0,0,0]]");
        printInt2DArray(grid);

        System.out.println("\n-----------------grid2------------------");
        int[][] grid2 = ArrayUtils.stringToInt2DArray("[[0,0,0,0,0,0,0,0]]");
        printInt2DArray(grid2);

        System.out.println("\n-----------------grid3------------------");
        int[][] grid3 = ArrayUtils.stringToInt2DArray("[[0,2]]");
        printInt2DArray(grid3);
    }

    @Test
    public void testStringToChar2DArray() {
        System.out.println("\n-----------------charGrid1------------------");
        char[][] charGrid1 = ArrayUtils.stringToChar2DArray("["
                + "[.,.,.,.,.,.,.,.],"
                + "[.,.,.,p,.,.,.,.],"
                + "[.,.,.,p,.,.,.,.],"
                + "[p,p,.,R,.,p,B,.],"
                + "[.,.,.,.,.,.,.,.],"
                + "[.,.,.,B,.,.,.,.],"
                + "[.,.,.,p,.,.,.,.],"
                + "[.,.,.,.,.,.,.,.]]");
        printChar2DArray(charGrid1);
    }

    @Test
    public void testPrint2DArray() {
        printInt2DArray(new int[][] {{0, 1, 2}, {2, 1}, {1}});
    }
}
