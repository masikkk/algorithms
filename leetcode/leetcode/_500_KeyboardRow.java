package leetcode.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _500_KeyboardRow {
    private static class Solution {
        String firstRow = "QWERTYUIOPqwertyuiop";
        String secondRow = "ASDFGHJKLasdfghjkl";
        String thirdRow = "ZXCVBNMzxcvbnm";

        public String[] findWords(String[] words) {
            List<String> resultList = new ArrayList<String>();
            for (String word : words) {
                int firstLetterRow = whichRow(word.charAt(0));//第一个字符所在的行号
                int i = 1;
                for (; i < word.length(); i++) {
                    if (whichRow(word.charAt(i)) != firstLetterRow) {
                        break;
                    }
                }
                if (i == word.length()) {
                    resultList.add(word);
                }
            }
            return resultList.toArray(new String[0]);
        }

        //求ch所在的行号
        private int whichRow(char ch) {
            if (firstRow.indexOf(ch) >= 0) {
                return 1;
            } else if (secondRow.indexOf(ch) >= 0) {
                return 2;
            } else {
                return 3;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] input = {"Hello", "Alaska", "Dad", "Peace"};
        String[] output = solution.findWords(input);
        for (String word : output) {
            System.out.print(word + " ");
        }
    }
}
