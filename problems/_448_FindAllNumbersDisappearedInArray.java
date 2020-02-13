package problems;

import java.util.ArrayList;
import java.util.List;
import structs.ListNode;

/**
 * 数组中消失的数
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * @author masikkk.com
 * @create 2020-02-13 12:40
 */
public class _448_FindAllNumbersDisappearedInArray {
    private static class SolutionV2020 {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                nums[Math.abs(nums[i]) - 1] = - Math.abs(nums[Math.abs(nums[i]) - 1]);
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    list.add(i + 1);
                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.findDisappearedNumbers(ListNode.stringToIntegerArray("[4,3,2,7,8,2,3,1]")));
    }
}
