package leetcode.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author si.ma
 * @create 2020-04-10 10:25
 */
public class _151_ReverseWordsInString {
    private static class SolutionV2020 {
        public String reverseWords(String s) {
            if (null == s) {
                return null;
            }
            List<String> wordsList = Arrays.asList(s.trim().split(" "));
            Collections.reverse(wordsList);
            return wordsList.stream().filter(word -> !word.isEmpty()).collect(Collectors.joining(" "));
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.reverseWords("the sky is blue"));
        System.out.println(solutionV2020.reverseWords("  hello world!  "));
        System.out.println(solutionV2020.reverseWords("a good   example"));
        System.out.println(solutionV2020.reverseWords("   "));
        System.out.println(solutionV2020.reverseWords(""));
        System.out.println(solutionV2020.reverseWords(null));
    }
}
