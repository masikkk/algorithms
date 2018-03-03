package _153_FindMinimumInRotatedSortedArray;

class Solution {
    public int findMin(int[] nums) {
    	int low = 0;
    	int high = nums.length-1;
        while(low<=high){
        	//先判断nums[low,...,high]是否升序，即无旋转
        	if(nums[low] <= nums[high])
        		return nums[low];
        	//nums[low,...,high]不是升序
        	int mid = (low+high)/2;
        	if(nums[mid]>=nums[low]){//左边升序，转折点在右边，最小值也在右边
        		low=mid+1;
        	}else{//右边升序，转折点在左边，最小值也在左边
        		high=mid;
        	}
        }
        return nums[low];
    }
}

public class FindMinimumInRotatedSortedArray {
	public static void main(String[] args){
		int[] input = {3,1,2};//易错用例：{2,1},{3,1,2},{2,3,1}
		Solution solution = new Solution();
		System.out.println(solution.findMin(input));
	}
}
