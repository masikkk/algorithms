package others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * 快手一面
 * 集合的子集
 * 请编写一个方法，返回某集合的所有非空子集。
 * 给定一个int数组A和数组的大小int n，请返回A的所有非空子集。保证A的元素个数小于等于20，且元素互异。各子集内部从大到小排序,子集之间字典逆序排序，见样例。
 * 测试样例：
 * [123,456,789]
 * 返回：{[789,456,123],[789,456],[789,123],[789],[456 123],[456],[123]}
 * @author masikkk.com
 * @create 2020-03-27 15:48
 */
public class SubSetSort {
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
        if (null == A || A.length == 0 || n == 0) {
            return null;
        }
        res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList();
        traceback(A, 0, list);
        Collections.sort(res, (list1, list2) -> {
            String str1 = list1.stream().map(String::valueOf).collect(Collectors.joining(""));
            String str2 = list2.stream().map(String::valueOf).collect(Collectors.joining(""));
            return str2.compareTo(str1);
        });
        return res;
    }

    private void traceback(int[] A, int start, ArrayList<Integer> list) {
        if (start >= A.length) { // 结束
            if (!list.isEmpty()) {
                Collections.sort(list, (a, b) -> b - a);
                res.add(new ArrayList<>(list));
            }
            return;
        }
        // 不选start
        traceback(A, start + 1, list);
        // 选start
        list.add(A[start]);
        traceback(A, start + 1, list);
        list.remove((Integer) A[start]);
    }

    public static void main(String[] args) {
        SubSetSort subSet = new SubSetSort();
        subSet.getSubsets(new int[]{123,456,789}, 3).forEach(System.out::println);
    }
}
