package problems;

public class _026_RemoveDuplicatesFromSortedArray {
    private static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int slow = 0, fast = 0;
            for (; fast < nums.length - 1; ) {
                if (nums[fast] != nums[fast + 1]) {
                    nums[slow++] = nums[fast++];
                } else {
                    fast++;
                }
            }
            nums[slow++] = nums[fast];
            return slow;
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 1, 1, 2, 33, 44, 44};
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(input));
        for (int a : input) {
            System.out.print(a + " ");
        }
    }
}
