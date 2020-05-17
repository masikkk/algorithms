package others;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 华为机试题2
 * 在字符串中找出连续最长的数字串
 * 数字串包括 0-9 . 和 +- 号，其中， . 必须前后必须有数字， +- 号必须出现在开头且后面必须跟数字，有多个长度相同的连续数字串则以后最后出现的为准
 * 例如：
 * 1234567890abcd9.+12345.678.9ed -> +12345.678
 * +12345 -> +12345
 * +001 -> +001
 * 23+33 -> +33
 * 12345+ -> 12345
 * 123+++ -> 123
 * @author masikkk.com 2020-05-17 21:37
 */
public class HuaWei2 {
    // 只通过 80% 测试用例
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String res = "";
        char[] chars = input.toCharArray();

        StringBuilder sb = new StringBuilder();
        Set<Character> digitSet = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (isDigit(chars[i])) {
                sb.append(chars[i]);
                digitSet.add(chars[i]);
            } else if (chars[i] == '.' && i - 1 >= 0 && isDigit(chars[i - 1])
                    && i + 1 < chars.length && isDigit(chars[i + 1]) && !digitSet.contains('.')) {
                sb.append(chars[i]);
                digitSet.add(chars[i]);
            } else if ((chars[i] == '+' || chars[i] == '-') && sb.toString().length() == 0
                    && i + 1 < chars.length && isDigit(chars[i + 1])
                    && !digitSet.contains('+') && !digitSet.contains('-')) {
                sb.append(chars[i]);
                digitSet.add(chars[i]);
            } else {
                // 数字串结束，看长度是否需要更新 res
                digitSet.remove('+');
                digitSet.remove('-');
                if (sb.toString().length() >= res.length() && !digitSet.isEmpty()) {
                    res = sb.toString();
                }
                sb = new StringBuilder();
                digitSet = new HashSet<>();
                if (chars[i] == '+' || chars[i] == '-') {
                    sb.append(chars[i]);
                    digitSet.add(chars[i]);
                }
            }
        }
        digitSet.remove('+');
        digitSet.remove('-');
        if (sb.toString().length() >= res.length() && !digitSet.isEmpty()) {
            res = sb.toString();
        }
        System.out.println(res);
    }

    public static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}