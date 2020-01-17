import java.util.Stack;

public class _020_ValidParentheses {
    private static class Solution {
        public boolean isValid(String s) {
            Stack<String> stack = new Stack<String>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(' || ch == '[' || ch == '{') {
                    switch (ch) {
                        case '(':
                            stack.push(")"); break;
                        case '[':
                            stack.push("]"); break;
                        case '{':
                            stack.push("}"); break;
                        default:
                            break;
                    }
                } else {
                    if (stack.isEmpty()) {//��;ջΪ��˵����ƥ��
                        return false;
                    } else if (!stack.pop().equals(s.substring(i, i + 1))) {
                        return false;
                    }
                }
            }
            return stack.isEmpty() ? true : false;//���ջΪ�ղ�ƥ��
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("[(){}]]"));
    }
}
