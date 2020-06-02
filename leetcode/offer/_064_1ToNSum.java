package leetcode.offer;

/**
 * 《剑指offer》面试题64. 求1+2+…+n
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 * @author masikkk.com 2020-06-02 18:56
 */
public class _064_1ToNSum {
    private static class SolutionV202006 {
        public int sumNums(int n) {
            boolean temp = (n == 0 || (n += sumNums(n - 1)) >= 0);
            return n;
        }
    }

    public static void main(String[] args) {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(solutionV202006.sumNums(3));
    }
}