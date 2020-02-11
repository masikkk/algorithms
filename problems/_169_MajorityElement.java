package problems;

import structs.ListNode;

/**
 * 数组的众数
 * https://leetcode-cn.com/problems/majority-element/
 * @author masikkk.com
 * @create 2020-02-09 19:04
 */
public class _169_MajorityElement {
    private static class SolutionV2020 {
        public int majorityElement(int[] nums) {
            int mid = (nums.length) / 2;
            int partition = partition(nums, 0, nums.length - 1);
            while (partition != mid) {
                if (partition < mid) {
                    partition = partition(nums, partition + 1, nums.length - 1);
                } else {
                    partition = partition(nums, 0, partition -1);
                }
            }
            int major = nums[partition];
            return major;
        }

        private int partition(int[] nums, int low, int high) {
            int pivot = nums[low];
            while (low < high) {
                for(; nums[high] >= pivot && low < high; high--) {
                }
                nums[low] = nums[high];
                for(; nums[low] <= pivot && low < high; low++) {
                }
                nums[high] = nums[low];
            }
            // 枢轴归位
            nums[low] = pivot;
            return low;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.majorityElement(ListNode.stringToIntegerArray("[2,2,1,1,1,2,2]")));
        System.out.println(solutionV2020.majorityElement(ListNode.stringToIntegerArray("[3,2,3]")));
    }
}
