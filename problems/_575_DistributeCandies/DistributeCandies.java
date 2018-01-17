package _575_DistributeCandies;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int distributeCandies(int[] candies) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i=0; i<candies.length; i++){
        	map.put(candies[i], i);
        }
    	if(map.size() >= candies.length/2){
    		return candies.length/2;
    	}else {
    		return map.size();
    	}
    }
}

public class DistributeCandies {
	public static void main(String[] args){
		Solution solution = new Solution();
		int[] candies = {1,1,1,1,2,2,2,3,3,3};
		System.out.println(solution.distributeCandies(candies));
	}
}
