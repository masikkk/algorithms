public class _033_SearchInRotatedSortedArray {
    private static class Solution {
        public int search(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
				if (nums[mid] == target) {
					return mid;
				}
                if (nums[mid] >= nums[low]) {//左边有序，转折点在右边
                    if (target >= nums[low] && target < nums[mid]) {//target在左边
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else {//右边有序，转折点在左边
                    if (target > nums[mid] && target <= nums[high]) {//target在右边
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] input = {3, 1};
        Solution solution = new Solution();
        System.out.println(solution.search(input, 1));
    }
}
