package _003_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
    	int max=0;
    	int len=0;
    	String maxSub="";
    	String sub="";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
    	for(int i=0; i<s.length();){
        	if(map.containsKey(s.charAt(i))){
        		max = len>max ? len : max;
        		maxSub = sub.length()>maxSub.length() ? sub : maxSub;
        		len = 0;
        		sub = "";
        		i = map.get(s.charAt(i)) + 1;
        		map.clear();
        	}else{
        		map.put(s.charAt(i), i);
        		sub+=s.charAt(i);
        		len++;
        		i++;
        	}
        }
    	max = len>max ? len : max;
    	maxSub = sub.length()>maxSub.length() ? sub : maxSub;
    	System.out.println(maxSub);
    	return max;
    }
}

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args){
		Solution solution = new Solution();
		System.out.println(solution.lengthOfLongestSubstring("a"));
	}
}
