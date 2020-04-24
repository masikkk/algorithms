package sort;

import java.util.Arrays;

/**
 * 冒泡排序，O(n^2)，稳定
 * @author masikkk.com
 * @create 2020-02-24 11:48
 */
public class BubbleSort {
    public static void sort(int [] nums) {
        if (null == nums || 0 == nums.length) {
           return;
        }
        // 上次循环是否交换过，若无交换说明排序已完成
        boolean changed = true;
        for (int i = 1; i <  nums.length; i++) {
            if (changed) {
                changed = false;
                for (int j = 0; j < nums.length - i; j++) {
                    if (nums[j] > nums[j+1]) {
                        changed = true;
                        int temp = nums[j+1];
                        nums[j+1] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,10,2,9,5,6,2,7};
        BubbleSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
