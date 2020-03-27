package leetcode.leetcode;

import java.util.HashMap;
import java.util.Map;
import structs.ListNode;

/**
 * 卡牌分组
 * https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/
 * @author masikkk.com
 * @create 2020-03-27 13:36
 */
public class _916_CardsGroup {
    private static class SolutionV2020 {
        public boolean hasGroupsSizeX(int[] deck) {
            if (null == deck || deck.length < 2) {
                return false;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : deck) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            // 所有value的最大公约数
            int gcd = map.get(deck[0]);
            for (Integer n : map.values()) {
                gcd = gcd(n, gcd);
            }
            return gcd > 1;
        }

        // 循环求最大公约数
        private int gcd(int x, int y) {
            while (y != 0) {
                int remain = x % y;
                x = y;
                y = remain;
            }
            return x;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.hasGroupsSizeX(ListNode.stringToIntegerArray("[1,2,3,4,4,3,2,1]")));
        System.out.println(solutionV2020.hasGroupsSizeX(ListNode.stringToIntegerArray("[1,1,1,2,2,2,3,3]")));
        System.out.println(solutionV2020.hasGroupsSizeX(ListNode.stringToIntegerArray("[1]")));
        System.out.println(solutionV2020.hasGroupsSizeX(ListNode.stringToIntegerArray("[1,1]")));
        System.out.println(solutionV2020.hasGroupsSizeX(ListNode.stringToIntegerArray("[1,1,2,2,2,2]")));
        // 易错用例，类似比如 6个1，9个2，则能分成x=3的小组
        System.out.println(solutionV2020.hasGroupsSizeX(ListNode.stringToIntegerArray("[1,1,1,1,2,2,2,2,2,2]")));
    }
}
