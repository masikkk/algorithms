package _136_SingleNumber;

class Solution {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i=1; i<nums.length; i++){
        	result = result ^ nums[i];//异或
        }
        return result;
    }
}

public class _136_SingleNumber {
	public static void main(String[] args){
		int[] input = {1,2,3,4,5,4,3,2,1};
		Solution solution = new Solution();
		System.out.println(solution.singleNumber(input));
	}
}
