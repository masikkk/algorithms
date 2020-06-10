package others;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 俄罗斯农民乘法
 * @author masikkk.com 2020-06-08 11:05
 */
public class RussianFarmerMultiple {
    // 俄罗斯农民乘法
    public long russianFarmerMultiple(long a, long b) {
        // a 不断乘 2， b 不断除以 2，b 是奇数时结果加上 a
        long res = 0;
        while (b >= 1) {
            if (b % 2 == 1) {
                res += a;
            }
            a <<= 1; // a 左移 1 位，即 a 乘 2
            b >>= 1; // b 右移 1 位，即 b 除以 2
        }
        return res;
    }

    @Test
    public void testRussianFarmerMultiple() {
        Assertions.assertEquals( 5 * 6, russianFarmerMultiple(5, 6));
        Assertions.assertEquals( 6 * 5, russianFarmerMultiple(6, 5));
        Assertions.assertEquals( 231233253L * 34454354L, russianFarmerMultiple(231233253, 34454354));
    }

    // 快速乘法计算 m*n mod k 避免中间结果溢出
    public long multipleMod(long a, long b, long k) {
        long res = 0;
        while (b >= 1) {
            if (b % 2 == 1) {
                res = (res + a) % k; // 根据求余运算的加法分配律，可对中间结果先求余
            }
            a = (a << 1) % k; // 根据求余运算的乘法结合律，可以对被乘数先求余
            b >>= 1;
        }
        return res;
    }

    @Test
    public void testMultipleMod() {
        Assertions.assertEquals((123 * 456) % 23, multipleMod(123, 456, 23));
        Assertions.assertEquals((3759375 * 23574756437L) % 123, multipleMod(3759375, 23574756437L, 123));
    }
}