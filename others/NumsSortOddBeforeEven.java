package others;

import java.util.Arrays;

/**
 * 58 同城二面
 * 给定无序数组，把奇数放偶数前面
 * @author masikkk.com 2020-06-10 19:26
 */
public class NumsSortOddBeforeEven {
    public static int [] sort(int[] nums) {
        if (null == nums || nums.length < 2) {
            return nums;
        }
        int left = 0, right = nums.length - 1;
        int sentinal = nums[0];
        while (left < right) {
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            nums[left++] = nums[right];
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            nums[right--] = nums[left];
        }
        nums[left] = sentinal;
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[] {1,2,3})));
        System.out.println(Arrays.toString(sort(new int[] {1,2,3,4,5,6,7,8})));
    }
}