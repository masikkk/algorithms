package others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 华为机试题1
 * 字符串解压缩
 * 输入是一个字符串，每个子串后面有一个数字表示子串出现的次数，解压后输出。按出现的次数从小到大输出，有出现次数相同的按字典序排序输出
 * 例如
 * a2b3 -> aabbb
 * a4b1c2 -> bccaaaa
 * c2b2a4 -> bbccaaaa
 * @author masikkk.com 2020-05-17 21:08
 */
public class HuaWei1 {
    // 全部测试用例通过
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        TreeMap<Integer, List<String>> treeMap = new TreeMap<>();

        StringBuilder sb = new StringBuilder();
        int times = 0;
        char[] chars = input.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                times = times * 10 + chars[i] - '0';
                // 当前单词结束
                if (i + 1 == chars.length || (i + 1 < chars.length && !(chars[i+1] >= '0' && chars[i+1] <= '9'))) {
                    // 放入 treemap
                    if (!treeMap.containsKey(times)) {
                        List<String> list = new ArrayList<>();
                        list.add(sb.toString());
                        treeMap.put(times, list);
                    } else {
                        treeMap.get(times).add(sb.toString());
                    }
                    sb = new StringBuilder();
                    times = 0;
                }
            } else {
                sb.append(chars[i]);
            }
        }
//        System.out.println(treeMap);
        StringBuilder res = new StringBuilder();
        treeMap.forEach((k,v) -> {
            Collections.sort(v);
            v.forEach(str -> {
                for (int i = 0; i < k; i++) {
                    res.append(str);
                }
            });
        });
        System.out.println(res);
    }
}