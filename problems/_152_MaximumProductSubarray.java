package problems;

import structs.ListNode;

/**
 * 最大连续子序列积
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * @author masikkk.com
 * @create 2020-02-04 11:31
 */
public class _152_MaximumProductSubarray {
    private static class SolutiionV2020 {
        public int maxProduct(int[] nums) {
            int max = nums[0];
            // nums[0,...,i] 中以nums[i]为结尾的连续子序列的乘积最大值
            int maxi = nums[0];
            // nums[0,...,i] 中以nums[i]为结尾的连续子序列的乘积最小值
            int mini = nums[0];

            for (int i = 1; i < nums.length; i++) {
                // 保存原值，更新mini用
                int oldMaxi = maxi;
                maxi = Math.max(mini * nums[i], Math.max(maxi * nums[i], nums[i]));
                mini = Math.min(oldMaxi * nums[i], Math.min(mini * nums[i], nums[i]));
                max = Math.max(max, maxi);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        SolutiionV2020 solutiionV2020 = new SolutiionV2020();
        System.out.println(solutiionV2020.maxProduct(ListNode.stringToIntegerArray("[2,3,-2,4]")));
        System.out.println(solutiionV2020.maxProduct(ListNode.stringToIntegerArray("[-2,0,-1]")));
        System.out.println(solutiionV2020.maxProduct(ListNode.stringToIntegerArray("[-2]")));
        // 易错用例
        System.out.println(solutiionV2020.maxProduct(ListNode.stringToIntegerArray("[-2,3,-4]")));
        // 易错用例
        System.out.println(solutiionV2020.maxProduct(ListNode.stringToIntegerArray("[-1,-2,-9,-6]")));
    }
}
