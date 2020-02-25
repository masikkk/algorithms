package problems;

import structs.ListNode;

/**
 * 数组中第三大的数
 * https://leetcode-cn.com/problems/third-maximum-number/
 * @author masikkk.com
 * @create 2020-02-25 13:27
 */
public class _414_ThirdMaximumNumber {
    private static class SolutionV2020 {
        public int thirdMax(int[] nums) {
            Integer max = null, secondMax = null, thirdMax = null;
            for (int n : nums) {
                if (null == max || n > max) {
                    thirdMax = secondMax;
                    secondMax = max;
                    max = n;
                } else if (n < max && (null == secondMax || n > secondMax)) {
                    thirdMax = secondMax;
                    secondMax = n;
                } else if ((secondMax != null && n < secondMax) && (thirdMax == null || n > thirdMax)) {
                    thirdMax = n;
                }
            }
            return thirdMax != null ? thirdMax : max;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.thirdMax(ListNode.stringToIntegerArray("[3,2,1]")));
        System.out.println(solutionV2020.thirdMax(ListNode.stringToIntegerArray("[1,2]")));
        System.out.println(solutionV2020.thirdMax(ListNode.stringToIntegerArray("[2,2,3,1]")));
    }
}
