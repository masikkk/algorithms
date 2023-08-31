package others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

/**
 * 滴滴国际 一面
 * 给定数组 [a, b, c] 求出其所有子集，不包含空集
 * @author masikkk.com 2020-06-11 19:51
 */
public class SubSet {
    private static class SolutionV2020 {
        Set<String> resSet;

        public List<String> getSet(char[] chars) {
            resSet = new HashSet<>();
            backtrack("", chars, 0);
            return new ArrayList<>(resSet);
        }

        private void backtrack(String choice, char[] chars, int i) {
            if (i >= chars.length && !choice.equals("")) {
                resSet.add(choice);
            }
            if (i < chars.length) {
                // 不选 i
                backtrack(choice, chars, i+1);
                // 选 i
                backtrack(choice + chars[i], chars, i+1);
            }
        }
    }

    private static class SolutionV2023 {
        private static List<String> subsetList = new ArrayList<>();

        public static List<String> subset(char[] set) {
            backtrace(set, "", 0);
            return subsetList;
        }

        private static void backtrace(char[] set, String curStr, int start) {
            if (start == set.length) {
                if (StringUtils.isNotBlank(curStr)) {
                    subsetList.add(curStr);
                }
                return;
            }
            backtrace(set, curStr + set[start], start + 1);
            backtrace(set, curStr, start + 1);
        }
    }

    @Test
    public void testSolutionV2020() {
        SolutionV2020 numSet = new SolutionV2020();
        System.out.println(numSet.getSet(new char[] {'a', 'b', 'c'}));
        System.out.println(numSet.getSet(new char[] {'a', 'b', 'c', 'd'}));
    }

    @Test
    public void testSolutionV2023() {
        System.out.println(SolutionV2023.subset(new char[] {'a', 'b', 'c'}));
        System.out.println(SolutionV2023.subset(new char[] {'a', 'b', 'c', 'd'}));
    }
}