package others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 滴滴国际 一面
 * 给定数组 [a, b, c] 求出其所有子集，不包含空集
 * @author masikkk.com 2020-06-11 19:51
 */
public class SubSet {
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

    public static void main(String[] args) {
        SubSet numSet = new SubSet();
        System.out.println(numSet.getSet(new char[] {'a', 'b', 'c'}));
        System.out.println(numSet.getSet(new char[] {'a', 'b', 'c', 'd'}));
    }
}