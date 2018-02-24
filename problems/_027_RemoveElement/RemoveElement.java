package _027_RemoveElement;

class Solution {
    public int removeElement(int[] nums, int val) {
    	int i=0,j=nums.length-1;
        while(i<=j){
        	if(val == nums[j])
        		j--;
        	if(val != nums[i])
        		i++;
        	if(i<j && val == nums[i] && val != nums[j]){
        		nums[i] ^= nums[j];
        		nums[j] ^= nums[i];
        		nums[i++] ^= nums[j--];
        	}
        }
        return j+1;
    }
}

public class RemoveElement {
	public static void main(String[] args){
		int[] input = {};
		Solution solution = new Solution();
		System.out.println(solution.removeElement(input, 3));
		for(int a:input)
			System.out.print(a);
	}
}

