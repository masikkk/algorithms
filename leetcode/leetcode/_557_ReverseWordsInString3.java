package leetcode.leetcode;

public class _557_ReverseWordsInString3 {
    private static class SolutionV2018 {
        //手动处理版
        public String reverseWords1(String s) {
            char[] str = s.toCharArray();
            int start = 0; //要反转的子串的起始位置
            int length = 0; //要反转的子串的长度
            for (int i = 0; i < str.length; i++) {
                //当前字符非空格，继续往前扫描，同时记录子串长度
                if (str[i] != ' ') {
                    length++;
                }
                //当前字符为空格，或者是最后一个字符
                if (str[i] == ' ' || i == str.length - 1) {
                    if (length > 1) {//当子串长度大于1时
                        reverse(str, start, start + length - 1);//反转子串
                    }
                    length = 0;//长度归零
                    start = i + 1;//起始位置后移
                }
            }
            return new String(str);
        }

        //反转字符数组str中从start到end的内容
        public char[] reverse(char[] str, int start, int end) {
            int i = start, j = end;
            while (i < j) {
                char temp = str[i];
                str[i] = str[j];
                str[j] = temp;
                i++;
                j--;
            }
            return str;
        }

        //java方法版
        public String reverseWords(String s) {
            String split[] = s.split(" ", -1);//空格分割字符串，-1会保留空字符串
            for (int i = 0; i < split.length; i++) {
                StringBuffer stringBuffer = new StringBuffer(split[i]);
                split[i] = stringBuffer.reverse().toString();
            }
            return String.join(" ", split);//空格连接split集合成字符串
        }
    }

    public static void main(String[] args) {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        char[] str = {'m', 'a', 'd', 'a', 'i'};
        System.out.println(solutionV2018.reverse(str, 0, str.length - 1));

        System.out.println(solutionV2018.reverseWords("  123     1"));//I love u
    }
}

