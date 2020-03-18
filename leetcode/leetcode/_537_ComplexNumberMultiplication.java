package leetcode.leetcode;

public class _537_ComplexNumberMultiplication {
    private static class Solution {
        //a=a1+a2i, b=b1+b2i，结果c=c1+c2i
        public String complexNumberMultiply(String a, String b) {
            int a1 = Integer.parseInt(a.substring(0, a.indexOf("+")));
            int a2 = Integer.parseInt(a.substring(a.indexOf("+") + 1, a.length() - 1));
            int b1 = Integer.parseInt(b.substring(0, b.indexOf("+")));
            int b2 = Integer.parseInt(b.substring(b.indexOf("+") + 1, b.length() - 1));
            int c1 = a1 * b1 - a2 * b2;
            int c2 = a1 * b2 + b1 * a2;
            return new String(c1 + "+" + c2 + "i");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.complexNumberMultiply("1+1i", "1+1i"));
        System.out.println(solution.complexNumberMultiply("1+-1i", "1+-1i"));
    }
}
