package leetcode.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 58. 最后一个单词的长度
 * https://leetcode.cn/problems/length-of-last-word/
 *
 * @author masi
 * @date 2023-11-12 19:27
 */
public class _058_LastWordLength {
    private static class SolutionV2023 {
        public int lengthOfLastWord(String s) {
            int currentWordLength = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != ' ') {
                    if (i - 1 >= 0 && chars[i-1] == ' ') {
                        currentWordLength = 0;
                    }
                    currentWordLength++;
                }
            }
            return currentWordLength;
        }
    }

    @Test
    public void testSolutionV2023() {
        SolutionV2023 solutionV2023 = new SolutionV2023();
        System.out.println(solutionV2023.lengthOfLastWord("Hello World"));
        System.out.println(solutionV2023.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(solutionV2023.lengthOfLastWord("luffy is still joyboy"));
        System.out.println(solutionV2023.lengthOfLastWord("a"));
        System.out.println(solutionV2023.lengthOfLastWord(" "));
        System.out.println(solutionV2023.lengthOfLastWord(" a "));
        System.out.println(solutionV2023.lengthOfLastWord("a a"));
    }
}
