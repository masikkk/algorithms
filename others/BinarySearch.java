package others;
/**
 * 二分搜素（快看漫画二面）
 * @author masikkk.com
 * @create 2020-03-18 15:58
 */
public class BinarySearch {
    public static int binarySearch(int[] nums, int target) {
        if (null == nums || 0 == nums.length) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,6,6,7,9,9,12};
        System.out.println(binarySearch(nums, 3));
        System.out.println(binarySearch(nums, 1));
        System.out.println(binarySearch(nums, 9));
        System.out.println(binarySearch(nums, 5));
        System.out.println(binarySearch(nums, 22));

        int[] nums2 = {1};
        System.out.println(binarySearch(nums2, 1));
        System.out.println(binarySearch(nums2, 0));
        System.out.println(binarySearch(nums2, 12));
    }
}
