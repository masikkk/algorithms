package _007_ReverseInteger;

class Solution {
	//使用long型
    public int reverse(int x) {
    	//反转后有可能超过Integer.MAX_VALUE，例如1534236469，所以必须用long存放
        long result=0;
        //Math.abs(-2147483648)结果还是-2147483648，所以必须将参数强转为long型再求绝对值，而且用long存放结果
        long abs = Math.abs((long)x);
        while(abs!=0){
        	result = result*10 + abs%10;
        	abs = abs/10;
        }
        result = x>0 ? result : -result;
        if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE)//反转后越界，设为0
        	result = 0;
        return (int)result;
    }
    
    //不适用long型
    public int reverse2(int x) {
        int res = 0;
        while(x != 0){
            //Math.abs(res) >= 214748365，无论原值第一位是什么都会越界
        	//必须在更新res值之前判断，否则当最终res*10大于Integer.MAX_VALUE时出错
            if(Math.abs(res) > Integer.MAX_VALUE / 10)
            	return 0;
        	res = res*10 + x % 10;
            x /= 10;
        }
        return res;
    }    
}

public class ReverseInteger {
	public static void main(String[] args){
		Solution solution = new Solution();
		System.out.println(" "+Integer.MAX_VALUE+":  "+Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println((Integer.MAX_VALUE+1)+": "+Integer.toBinaryString(Integer.MAX_VALUE+1));
		System.out.println(Integer.MIN_VALUE+": "+Integer.toBinaryString(Integer.MIN_VALUE));
		System.out.println("Math.abs(Integer.MIN_VALUE): "+Math.abs(Integer.MIN_VALUE));
		System.out.println("Math.abs((long)Integer.MIN_VALUE): "+Math.abs((long)Integer.MIN_VALUE));
		
		System.out.println(solution.reverse2(1463847412));
		System.out.println(solution.reverse2(-2147483412));
		System.out.println(solution.reverse2(1563847412));
		System.out.println(solution.reverse(-2147483648));
	}
}
