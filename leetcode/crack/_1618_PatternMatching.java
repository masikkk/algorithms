package leetcode.crack;

/**
 * 《程序员面试金典（第 6 版）》面试题 16.18. 模式匹配
 * https://leetcode-cn.com/problems/pattern-matching-lcci/
 * @author masikkk.com 2020-06-22 14:56
 */
public class _1618_PatternMatching {
    private static class SolutionV202006 {
        public boolean patternMatching(String pattern, String value) {
            if (pattern.length() == 0 || value.length() == 0) {
                if (pattern.equals(value)) { // 两个都是空串
                    return true;
                }
                if (pattern.length() == 0) { // 模式是空串，value 不是空串
                    return false;
                }
                // value 是空串，模式不是空串时，只有当 pattern 是单字符时才能匹配
                return pattern.length() == 1;
            }
            // 字符 a,b 在模式中的出现次数
            int countA = 0, countB = 0;
            for (char c : pattern.toCharArray()) {
                if (c == 'a') {
                    countA++;
                } else {
                    countB++;
                }
            }
            int lengthV = value.length();
            // a 或 b 的个数是 0 时，只需一次匹配，但当 value 长度无法整除非零个数时直接返回 false
            if (countA == 0) {
                return lengthV % countB == 0 && match(pattern, value, 0, lengthV / countB);
            } else if (countB == 0) {
                return lengthV % countA == 0 && match(pattern, value, lengthV / countA, 0);
            }
            // lengthA 模式 a 在 value 中代表的子串长度， lengthB 模式 b 在 value 中代表的子串长度
            int lengthA = 0, lengthB = 0;
            // 根据方程 countA * lengthA + countB * lengthB = lengthV 枚举 lengthA 的值，lengthA 确定后 lengthB 也就确定了
            for (int i = 0; i <= lengthV / countA; i++) {
                if ((lengthV - countA * i) % countB == 0) {
                    lengthA = i;
                    lengthB = (lengthV - countA * i) / countB;
                    // 进行一次匹配，能匹配上则直接返回 true
                    if (match(pattern, value, lengthA, lengthB)) {
                        return true;
                    }
                }
            }
            return false;
        }

        // 进行一次匹配
        private boolean match(String pattern, String value, int lengthA, int lengthB) {
            int j = 0;
            String aStr = null, bStr = null;
            for (int i = 0; i < pattern.length(); i++) {
                if (pattern.charAt(i) == 'a') {
                    if (null == aStr) {
                        // 第一次先构造 a 代表的子串 aStr
                        aStr = value.substring(j, j + lengthA);
                    } else {
                        if (!aStr.equals(value.substring(j, j + lengthA))) {
                            return false;
                        }
                    }
                    j += lengthA;
                } else {
                    if (null == bStr) {
                        // 第一次先构造 b 代表的子串 bStr
                        bStr = value.substring(j, j + lengthB);
                    } else {
                        if (!bStr.equals(value.substring(j, j + lengthB))) {
                            return false;
                        }
                    }
                    j += lengthB;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(solutionV202006.patternMatching("abba", "dogcatcatdog"));
        System.out.println(solutionV202006.patternMatching("abba", "dogcatcatfish"));
        System.out.println(solutionV202006.patternMatching("aaaa", "dogcatcatdog"));
        System.out.println(solutionV202006.patternMatching("abba", "dogdogdogdog"));
        // 易错用例
        System.out.println(solutionV202006.patternMatching("", ""));
        System.out.println(solutionV202006.patternMatching("ab", ""));
        System.out.println(solutionV202006.patternMatching("a", ""));
        System.out.println(solutionV202006.patternMatching("", "dd"));
        System.out.println(solutionV202006.patternMatching("bbbbbbbbbbbbb", "p"));
    }
}