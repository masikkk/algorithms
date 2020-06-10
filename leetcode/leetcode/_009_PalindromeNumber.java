package leetcode.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 判断整数是否回文数
 * https://leetcode-cn.com/problems/palindrome-number/
 * @author masikkk.com 2020-06-10 11:05
 */
public class _009_PalindromeNumber {
    private static class SolutionV2018 {
        //Integer.MAX_VALUE范围内最大的回文数是2147447412，其逆置不会溢出
        //如果x的逆置溢出，reverse会变成负的，肯定和x不相等，所以即使不考虑溢出此方法也能AC
        public boolean isPalindrome1(int x) {
            if (x < 0) {
                return false;
            }
            int a = x;
            int reverse = 0;
            while (a != 0) {
                reverse = reverse * 10 + a % 10;
                a = a / 10;
            }
            return reverse == x ? true : false;
        }

        //只逆置x的后半段，和前半段比较
        public boolean isPalindrome(int x) {
            //10的倍数(除了0)肯定不是回文数，因为逆置后第一位的0会被舍去
            //必须单独处理10的倍数，否则遇到122100这种除0外是回文的会出错
            if (x < 0 || (x % 10 == 0 && x != 0)) {
                return false;
            }
            int reverse = 0;
            while (reverse <= x) { //当x<reverse时，表明已处理了x的后半段
                reverse = reverse * 10 + x % 10;
                //在x除以10前后都和reverse比较一下是为了能同时应对偶数位回文(1221)和奇数位回文(121)
                if (reverse == x) {
                    return true;
                }
                x = x / 10;
                if (reverse == x) {
                    return true;
                }
            }
            return false;
        }
    }

    @Test
    public void testSolutionV2018() {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println(solutionV2018.isPalindrome(1221000));//-2147483648,2147447412,2147483647
    }

    private static class SolutionV202006 {
        public boolean isPalindrome(int x) {
            if (x < 0 || (x % 10) == 0) {
                return x == 0 ? true : false;
            }
            // x 的逆序数
            int reverse = 0;
            while (reverse < x) {
                reverse = reverse * 10 + x % 10;
                if (reverse == x || reverse == (x / 10)) {
                    return true;
                }
                x /= 10;
            }
            return false;
        }
    }

    @Test
    public void testSolutionV202006() {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(solutionV202006.isPalindrome(11));
        System.out.println(solutionV202006.isPalindrome(121));
        System.out.println(solutionV202006.isPalindrome(-121));
        System.out.println(solutionV202006.isPalindrome(10));
        System.out.println(solutionV202006.isPalindrome(100));
        System.out.println(solutionV202006.isPalindrome(101));
        System.out.println(solutionV202006.isPalindrome(0));
    }
}
