package _283_MoveZeroes;

class Solution {
	//仿冒泡排序法，O(n^2)
    public void moveZeroes(int[] nums) {
    	boolean swaped=true;//上次循环是否有过交换
        for(int i=1; i<nums.length && swaped; i++){
        	swaped = false;
        	for(int j=0; j<nums.length-i; j++){
        		if(nums[j]==0 && nums[j+1]!=0){//交换
        			swaped=true;
        			nums[j] = nums[j] ^ nums[j+1];
        			nums[j+1] = nums[j] ^ nums[j+1];
        			nums[j] = nums[j] ^ nums[j+1];
        		}
        	}
        }
    }
    
    //双指针，O(n)
    public void moveZeroes2(int[] nums) {
        int leftMostZeroIndex = 0; // The index of the leftmost zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > leftMostZeroIndex) { // There are zero(s) on the left side of the current non-zero number, swap!
                    nums[leftMostZeroIndex] = nums[i];
                    nums[i] = 0;
                }
                leftMostZeroIndex++;
            }
        }
    }
       
}

public class MoveZeroes {
	public static void main(String[] args){
		Solution solution = new Solution();
		int[] nums={0, 1, 0, 3, 12};
		solution.moveZeroes(nums);
		for(int i:nums)
			System.out.print(i+",");
	}
}
