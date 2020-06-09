package leetcode.leetcode;

/**
 * 等式方程的可满足性
 * https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 * @author masikkk.com 2020-06-08 18:40
 */
public class _990_SatisfiabilityOfEqualityEquations {
    private static class SolutionV202006 {
        public boolean equationsPossible(String[] equations) {
            // 并查集
            int[] parent = new int[26];
            for (int i = 0; i < 26; i++) {
                parent[i] = i;
            }

            // 合并相等的变量
            for (String equation : equations) {
                if (equation.charAt(1) == '=') {
                    union(parent, equation.charAt(0) - 'a', equation.charAt(3) - 'a');
                }
            }

            // 不等的变量，必须属于不同的子树（联通分量），否则无法满足
            for (String equation : equations) {
                if (equation.charAt(1) == '!') {
                    if (find(parent, equation.charAt(0) - 'a') == find(parent, equation.charAt(3) - 'a')) {
                        return false;
                    }
                }
            }
            return true;
        }

        // 并查集的合并操作，将 x 所在子树的根指向 y 所在子树的根
        private void union(int[] parent, int x, int y) {
            parent[find(parent, x)] = find(parent, y);
        }

        // 查找 x 的根
        private int find(int[] parent, int x) {
            while (parent[x] != x) {
                x = parent[x];
            }
            return x;
        }
    }

    public static void main(String[] args) {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(solutionV202006.equationsPossible(new String[] {"a==b","b!=a"}));
        System.out.println(solutionV202006.equationsPossible(new String[] {"b==a","a==b"}));
        System.out.println(solutionV202006.equationsPossible(new String[] {"a==b","b==c","a==c"}));
        System.out.println(solutionV202006.equationsPossible(new String[] {"a==b","b!=c","c==a"}));
        System.out.println(solutionV202006.equationsPossible(new String[] {"c==c","b==d","x!=z"}));
    }
}