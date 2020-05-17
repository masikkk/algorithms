package leetcode.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 课程表 II
 * https://leetcode-cn.com/problems/course-schedule-ii/
 * @author masikkk.com 2020-05-17 17:30
 */
public class _210_CourseSchedule2 {
    private static class SolutionV202005 {
        // 结果集，有序 Set
        Set<Integer> res;
        // 前置条件 map int -> List<Integer>
        Map<Integer, List<Integer>> map;
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            if (numCourses < 1) {
                return new int[] {0};
            }
            res = new LinkedHashSet<>();

            // 将前置条件放入 map
            map = new HashMap<>();
            for (int[] pair : prerequisites) {
                if (map.containsKey(pair[0])) {
                    map.get(pair[0]).add(pair[1]);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(pair[1]);
                    map.put(pair[0], list);
                }
            }

            // 遍历 0 ~ n-1，放入结果集
            for (int i = 0; i < numCourses; i++) {
                if (res.contains(i)) {
                    // 结果集中已存在，跳过
                    continue;
                }
                if (!map.containsKey(i)) {
                    // 无前置依赖项，直接加入结果集末尾
                    res.add(i);
                    continue;
                }
                // 有前置依赖项，开始一次 dfs，将前置项从前往后加入 res，并返回是否有环（即循环依赖）
                boolean hasCircle = dfs(i, new LinkedHashSet());
                if (hasCircle) {
                    // 若有循环依赖，返回空数组
                    return new int[] {};
                }
            }
            return res.stream().mapToInt(Integer::intValue).toArray();
        }

        // 从 i 开始一次 dfs，过程中将前置项从前往后加入 res，fathers 是父节点有序集合，有环时返回 true
        private boolean dfs(int i, LinkedHashSet<Integer> fathers) {
            if (fathers.contains(i)) {
                // i 在父节点集合中，说明有循环依赖
                return true;
            }
            if (res.contains(i)) {
                // i 已在结果集中，不作处理
                return false;
            }
            if (!map.containsKey(i)) {
                // 到达叶子节点，即 i 无前置依赖项，加入结果集
                res.add(i);
                return false;
            }
            boolean hasCircle = false;
            fathers.add(i);
            for (int pre : map.get(i)) {
                hasCircle = hasCircle | dfs(pre, fathers);
            }
            // 回溯，删除父节点
            fathers.remove(i);
            // i 的依赖项都加入结果集后，把 i 加入结果集
            res.add(i);
            return hasCircle;
        }
    }

    public static void main(String[] args) {
        SolutionV202005 solutionV202005 = new SolutionV202005();
        System.out.println(Arrays.toString(solutionV202005.findOrder(2, new int[][] {{1,0}})));
        System.out.println(Arrays.toString(solutionV202005.findOrder(4, new int[][] {{1,0}, {2,0}, {3,1}, {3,2}})));
        System.out.println(Arrays.toString(solutionV202005.findOrder(2, new int[][] {{1,0}, {0,1}})));
        System.out.println(Arrays.toString(solutionV202005.findOrder(2, new int[][] {{0,1}})));
        System.out.println(Arrays.toString(solutionV202005.findOrder(3, new int[][] {{0,1}, {0,2}, {1,2}})));
    }
}