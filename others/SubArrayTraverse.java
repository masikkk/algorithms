package others;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * 遍历子数组的 3 种方式
 * @author masikkk.com 2020-06-17 20:51
 */
public class SubArrayTraverse {
    @Test
    public void testSubArrayTraverse() {
        List<Integer> list = Arrays.stream(new int[]{1, 2, 3}).boxed().collect(Collectors.toList());

        System.out.println("固定起始下标");
        fixedStartIndex(list);

        System.out.println("固定结束下标");
        fixedEndIndex(list);

        System.out.println("固定子数组长度");
        fixedLength(list);
    }

    // 固定起始下标
    public void fixedStartIndex(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                System.out.println(list.subList(i, j + 1));
            }
        }
    }

    // 固定结束下标
    public void fixedEndIndex(List<Integer> list) {
        for (int j = 0; j < list.size(); j++) {
            for (int i = 0; i <= j; i++) {
                System.out.println(list.subList(i, j + 1));
            }
        }
    }

    // 固定子数组长度
    public void fixedLength(List<Integer> list) {
        for (int length = 1; length <= list.size(); length++) {
            for (int i = 0; i + length <= list.size(); i++) {
                System.out.println(list.subList(i, i + length));
            }
        }
    }
}