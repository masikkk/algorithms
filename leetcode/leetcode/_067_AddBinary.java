package leetcode.leetcode;

/**
 * 二进制求和
 * https://leetcode-cn.com/problems/add-binary/
 * @author masikkk.com 2020-06-23 19:47
 */
public class _067_AddBinary {
    private static class SolutionV202006 {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int i = a.length() - 1, j = b.length() - 1;
            byte carry = 0; // 进位
            while (i >= 0 || j >= 0 || carry != 0) {
                carry += i >= 0 ? a.charAt(i--) - '0' : 0;
                carry += j >= 0 ? b.charAt(j--) - '0' : 0;
                sb.insert(0, String.valueOf(carry & 1));
                carry >>= 1;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(solutionV202006.addBinary("11", "1"));
        System.out.println(solutionV202006.addBinary("1010", "1011"));
    }
}