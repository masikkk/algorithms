package leetcode.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _412_FizzBuzz {
    private static class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> output = new ArrayList<String>();
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    if (i % 5 == 0) {
                        output.add("FizzBuzz");
                    } else {
                        output.add("Fizz");
                    }
                } else if (i % 5 == 0) {
                    output.add("Buzz");
                } else {
                    output.add("" + i);
                }
            }
            return output;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> outputList = solution.fizzBuzz(15);
        System.out.println(outputList);
    }
}
