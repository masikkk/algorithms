package _557_ReverseWordsInString3;

class Solution {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        int start=0; //要反转的子串的起始位置
        int length=0; //要反转的子串的长度
        for(int i=0; i<str.length; i++){
        	//当前字符非空格，继续往前扫描，同时记录子串长度
        	if(str[i] != ' '){
        		length++;
        	}
        	//当前字符为空格，或者是最后一个字符
        	if(str[i]==' ' || i==str.length-1){
        		if(length>1){//当子串长度大于1时
        			reverse(str, start, start+length-1);//反转子串
        		}
        		length=0;//长度归零
        		start=i+1;//起始位置后移
        	}
        }
        return new String(str);
    }
    
    //反转字符数组str中从start到end的内容
    public char[] reverse(char[] str, int start, int end){
    	int i=start, j=end;
    	while(i<j){
    		char temp=str[i];
    		str[i] = str[j];
    		str[j] = temp;
    		i++;
    		j--;
    	}
    	return str;
    }
}

public class ReverseWordsInString {
	public static void main(String[] args){
		Solution solution = new Solution();
		char[] str = {'m','a','d','a','i'};
		System.out.println(solution.reverse(str,0,str.length-1));
		
		System.out.println(solution.reverseWords("I love u"));
	}
}

