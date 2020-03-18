package leetcode.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _442_FindAllDuplicatesInArray {
    private static class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++) {
                //有的被标记过的值已经是负的，需要对其进行加nums.length还原
                int realindex = nums[i] >= 1 ? nums[i] : nums[i] + nums.length;
                if (nums[realindex - 1] >= 1) {//下标位nums[i]没有被标记过
                    //把下标位nums[i]的值减nums.length，以此来表示此下标位的值存在
                    nums[realindex - 1] -= nums.length;
                } else {//已被标记过的值肯定<=0
                    list.add(realindex);
                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(solution.findDuplicates(input));
    }
}
