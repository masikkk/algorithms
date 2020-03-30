package leetcode.offer;

import java.util.ArrayList;

/**
 * 《剑指offer》面试题62 圆圈中最后剩下的数字/约瑟夫环
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * @author masikkk.com
 * @create 2020-03-30 10:54
 */
public class _062_JosephusProblem {
    private static class SolutionV2020 {
        public int lastRemaining(int n, int m) {
            ArrayList<Integer> arrayList = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                arrayList.add(i);
            }
            int idx = 0;
            while (arrayList.size() > 1) {
                idx = (idx + m - 1) % arrayList.size();
                arrayList.remove(idx);
            }
            return arrayList.get(0);
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.lastRemaining(5, 3));
        System.out.println(solutionV2020.lastRemaining(10, 17));
    }
}
