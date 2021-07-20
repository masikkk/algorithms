package temp;

/**
 * 《剑指offer》11. 旋转数组的最小数字
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * @author masikkk.com
 * @create: 2020-07-22 22:54
 */
public class _011_FindMinimumInRotatedSortedArray {
    private static class SolutionV202007 {
        public int minArray(int[] numbers) {
            if (numbers.length < 2) {
                return numbers[0];
            }
            int left = 0, right = numbers.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                // 左边是有序的
                if (mid > 0 && numbers[mid] > numbers[mid - 1]) {
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {

    }
}
