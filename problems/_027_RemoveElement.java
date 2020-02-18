package problems;

import java.util.Arrays;
import structs.ListNode;

public class _027_RemoveElement {
    private static class SolutionV2018 {
        public int removeElement(int[] nums, int val) {
            int i = 0, j = nums.length - 1;
            while (i <= j) {
                if (val == nums[j]) {
                    j--;
                }
                if (val != nums[i]) {
                    i++;
                }
                if (i < j && val == nums[i] && val != nums[j]) {
                    nums[i] ^= nums[j];
                    nums[j] ^= nums[i];
                    nums[i++] ^= nums[j--];
                }
            }
            return j + 1;
        }
    }

    private static class SolutionV2020 {
        public int removeElement(int[] nums, int val) {
            if (null == nums || 0 == nums.length) {
                return 0;
            }
            int low = 0, high = nums.length - 1;
            while (low < high) {
                while (nums[high] == val && low < high) {
                    high--;
                }
                while (nums[low] != val && low < high) {
                    low ++;
                }
                if (low < high) {
                    nums[low] = nums[high--];
                }
            }
            return nums[low] == val ? low : low + 1;
        }
    }

    public static void main(String[] args) {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println("SolutionV2018:");
        int[] nums = ListNode.stringToIntegerArray("[1]");
        System.out.println(solutionV2018.removeElement(nums, 3) + ": " + Arrays.toString(nums));

        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println("SolutionV2020:");
        int[] nums2 = ListNode.stringToIntegerArray("[1]");
        System.out.println(solutionV2020.removeElement(nums2, 3) + ": " + Arrays.toString(nums2));
        int[] nums3 = ListNode.stringToIntegerArray("[1]");
        System.out.println(solutionV2020.removeElement(nums3, 1) + ": " + Arrays.toString(nums3));
        int[] nums4 = ListNode.stringToIntegerArray("[1,1,1,1]");
        System.out.println(solutionV2020.removeElement(nums4, 1) + ": " + Arrays.toString(nums4));
        int[] nums5 = ListNode.stringToIntegerArray("[1,1,1,1]");
        System.out.println(solutionV2020.removeElement(nums5, 2) + ": " + Arrays.toString(nums5));
        int[] nums6 = ListNode.stringToIntegerArray("[3,2,2,3]");
        System.out.println(solutionV2020.removeElement(nums6, 3) + ": " + Arrays.toString(nums6));
        int[] nums7 = ListNode.stringToIntegerArray("[0,1,2,2,3,0,4,2]");
        System.out.println(solutionV2020.removeElement(nums7, 2) + ": " + Arrays.toString(nums7));
        int[] nums8 = ListNode.stringToIntegerArray("[4,5]");
        System.out.println(solutionV2020.removeElement(nums8, 4) + ": " + Arrays.toString(nums8));
    }
}
