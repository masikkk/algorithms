package leetcode.leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import javafx.util.Pair;

/**
 * @author masikkk.com
 * @create 2020-03-21 16:36
 */
public class _365_WaterJugProblem {
    private static class SolutionV2020 {
        public boolean canMeasureWater(int x, int y, int z) {
            if (z > x + y || z < 0) {
                return false;
            }
            Deque<Pair<Integer, Integer>> stack = new LinkedList<>();
            stack.push(new Pair<>(0, 0));
            // 已经检查过的 remainX, remainY 集合
            Set<Pair<Integer, Integer>> found = new HashSet<>();
            while (!stack.isEmpty()) {
                Pair<Integer, Integer> pair = stack.pop();
                // 已经检查过的不再考虑
                if (found.contains(pair)) {
                    continue;
                }
                int remainX = pair.getKey(), remainY = pair.getValue();
                if (z == remainX || z == remainY || z == remainX + remainY) {
                    return true;
                }
                found.add(pair);
                // 装满x
                stack.push(new Pair<>(x, remainY));
                // 装满y
                stack.push(new Pair<>(remainX, y));
                // 倒空x
                stack.push(new Pair<>(0, remainY));
                // 倒空y
                stack.push(new Pair<>(remainX, y));
                // x倒入y，直到x为空或者y满
                stack.push(remainX + remainY < y ? new Pair<>(0, remainX + remainY) : new Pair<>(remainX + remainY - y, y));
                // y倒入x，直到y为空或者x满
                stack.push(remainX + remainY < x ? new Pair<>(remainX + remainY, 0) : new Pair<>(x, remainX + remainY - x));
            }
            return false;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.canMeasureWater(3,5,4));
        System.out.println(solutionV2020.canMeasureWater(2,6,5));
    }
}
