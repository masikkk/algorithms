package leetcode.leetcode;

public class _371_SumOfTwoIntegers {
    private static class Solution {
        public int getSum(int a, int b) {
            int sum = a ^ b;//不考虑进位的和
            int carry = (a & b) << 1;//进位
            while (carry != 0) {//直到进位为0，结束
                int newsum = sum ^ carry;
                carry = (sum & carry) << 1;
                sum = newsum;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getSum(3, 1));
    }
}
