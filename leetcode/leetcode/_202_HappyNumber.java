package leetcode.leetcode;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * 快乐数
 * https://leetcode-cn.com/problems/happy-number/
 * @author masikkk.com 2020-04-30 10:41
 */
public class _202_HappyNumber {
    private static class SolutionV2020Hash {
        public boolean isHappy(int n) {
            // 是否已访问过，遇到已访问过的数说明存在循环，可直接返回false
            Set<Integer> visited = new HashSet<>();
            while (!visited.contains(n)) {
                if (n == 1) {
                    return true;
                }
                visited.add(n);
                int sum = 0;
                while (n != 0) {
                    sum += (n % 10) * (n % 10);
                    n /= 10;
                }
                n = sum;
            }
            return false;
        }
    }

    @Test
    public void testSolutionV2020Hash() {
        SolutionV2020Hash solutionV2020Hash = new SolutionV2020Hash();
        System.out.println(solutionV2020Hash.isHappy(19));
        System.out.println(solutionV2020Hash.isHappy(2));
    }

    // 循环 10000 次，可通过
    private static class SolutionV2020Brutal {
        public boolean isHappy(int n) {
            int loops = 0;
            while (loops < 10000) {
                if (n == 1) {
                    return true;
                }
                int sum = 0;
                while (n != 0) {
                    sum += (n % 10) * (n % 10);
                    n /= 10;
                }
                n = sum;
                loops++;
            }
            return false;
        }
    }

    @Test
    public void testSolutionV2020Brutal() {
        SolutionV2020Brutal solutionV2020Brutal = new SolutionV2020Brutal();
        System.out.println(solutionV2020Brutal.isHappy(19));
        System.out.println(solutionV2020Brutal.isHappy(2));
    }
}