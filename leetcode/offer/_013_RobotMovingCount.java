package leetcode.offer;

import java.util.HashSet;
import java.util.Set;
import javafx.util.Pair;

/**
 * 《剑指offer》面试题13. 机器人的运动范围
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * @author si.ma
 * @create 2020-04-08 11:57
 */
public class _013_RobotMovingCount {
    private static class SolutiionV2020 {
        private int count;
        private int rows, columns;
        // 访问过的坐标
        private Set<Pair<Integer, Integer>> visited;

        public int movingCount(int m, int n, int k) {
            count = 0;
            rows = m;
            columns = n;
            visited = new HashSet<>();
            dfs(0, 0, k);
            return count;
        }

        private void dfs(int x, int y, int k) {
            if (x >= rows || y >= columns || (x/10 + x%10) + (y/10 + y%10) > k) {
                return;
            }
            Pair<Integer, Integer> pair = new Pair<>(x, y);
            if (visited.contains(pair)) {
                return;
            }
            count++;
            visited.add(pair);
            // 下
            dfs(x + 1, y, k);
            // 右下
            dfs(x + 1, y + 1, k);
            // 右 ️
            dfs(x, y + 1, k);
        }
    }

    public static void main(String[] args) {
        SolutiionV2020 solutiionV2020 = new SolutiionV2020();
        System.out.println(solutiionV2020.movingCount(2, 3, 1));
        System.out.println(solutiionV2020.movingCount(3, 1, 0));
        System.out.println(solutiionV2020.movingCount(3, 2, 17));
        System.out.println(solutiionV2020.movingCount(11, 8, 16));
        System.out.println(solutiionV2020.movingCount(36, 11, 15));
    }
}
