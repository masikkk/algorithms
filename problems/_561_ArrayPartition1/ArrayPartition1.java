package _561_ArrayPartition1;

import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);//正序排序
        int sum=0;
        for(int i=0; i<nums.length; ){
        	sum+=nums[i];
        	i=i+2;
        }
        return sum;
    }
}

public class ArrayPartition1 {
	public static void main(String[] args){
		Solution solution = new Solution();
		int[] nums={1,4,3,2};
		System.out.println(solution.arrayPairSum(nums));
	}
}
