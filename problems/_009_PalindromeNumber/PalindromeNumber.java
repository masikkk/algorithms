package _009_PalindromeNumber;

class Solution {
    public boolean isPalindrome(int x) {
    	if(x<0)
    		return false;
    	long a=x;
        long reverse=0;
        while(a!=0){
        	reverse = reverse*10 + a%10;
        	a = a/10;
        }
        return reverse==x ? true : false;
    }
}

public class PalindromeNumber {
	public static void main(String[] args){
		Solution solution = new Solution();
		System.out.println(solution.isPalindrome(-2147447412));//2147447412,2147483647
	}
}
