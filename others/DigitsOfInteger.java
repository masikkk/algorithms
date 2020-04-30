package others;

import org.junit.jupiter.api.Test;

/**
 * 整数的位数
 * @author masikkk.com 2020-04-30 11:57
 */
public class DigitsOfInteger {
    int getDigitsOfInt(Integer n) {
        return String.valueOf(n).length();
    }

    int getDigitsOfIntLog(Integer n) {
        return (int)(Math.log10(n)) + 1;
    }

    @Test
    public void test() {
        System.out.println(getDigitsOfInt(8) + "," + getDigitsOfIntLog(8));
        System.out.println(getDigitsOfInt(100) + "," + getDigitsOfIntLog(100));
        System.out.println(getDigitsOfInt(33) + "," + getDigitsOfIntLog(33));
        System.out.println(getDigitsOfInt(Integer.MAX_VALUE) + "," + getDigitsOfIntLog(Integer.MAX_VALUE));
        System.out.println(getDigitsOfInt(Integer.MIN_VALUE) + "," + getDigitsOfIntLog(Integer.MIN_VALUE));
        System.out.println(getDigitsOfInt(99999) + "," + getDigitsOfIntLog(99999));
    }
}