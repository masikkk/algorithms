package leetcode.offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 《剑指offer》面试题46. 把数字翻译成字符串
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * @author masikkk.com 2020-06-09 18:07
 */
public class _046_TranslateNumToString {
    private static class SolutionV202006BackTracking {
        Set<String> res;
        public int translateNum(int num) {
            res = new HashSet<>();
            backtrack(String.valueOf(num), new LinkedList<>());
            System.out.println(res);
            return res.size();
        }

        // 回溯法
        private void backtrack(String num, LinkedList<Integer> choice) {
            // 去掉前导0
            while (!num.equals("") && num.charAt(0) == '0') {
                num = num.substring(1);
            }
            // 到达叶子节点，放入结果集
            if (num.equals("")) {
                StringBuilder sb = new StringBuilder();
                for (int i : choice) {
                    sb.append((char)(i + 'a'));
                }
                res.add(sb.toString());
                return;
            }
            // 选1位数
            choice.offerLast(num.charAt(0) - '0');
            backtrack(num.substring(1), choice);
            choice.pollLast(); // 回溯，撤销选择
            // 选2位数
            if (num.length() >= 2 && (num.charAt(0) < '2' || (num.charAt(0) == '2' && num.charAt(1) < '6'))) {
                choice.offerLast((num.charAt(0) - '0') * 10 + num.charAt(1) - '0');
                backtrack(num.substring(2), choice);
                choice.pollLast(); // 回溯，撤销选择
            }
        }
    }

    public static void main(String[] args) {
        SolutionV202006BackTracking solutionV202006BackTracking = new SolutionV202006BackTracking();
        System.out.println(solutionV202006BackTracking.translateNum(12258));
        System.out.println(solutionV202006BackTracking.translateNum(25));
        // 易错用例，中间的0要忽略
        System.out.println(solutionV202006BackTracking.translateNum(100006));
        System.out.println(solutionV202006BackTracking.translateNum(0));
        System.out.println(solutionV202006BackTracking.translateNum(01));
        System.out.println(solutionV202006BackTracking.translateNum(100001));
    }
}