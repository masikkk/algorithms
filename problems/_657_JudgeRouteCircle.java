public class _657_JudgeRouteCircle {
    private static class Solution {
        public boolean judgeCircle(String moves) {
            int Lnum = 0, Rnum = 0, Unum = 0, Dnum = 0;
            for (int i = 0; i < moves.length(); i++) {
                switch (moves.charAt(i)) {
                    case 'L':
                        Lnum++;
                        break;
                    case 'R':
                        Rnum++;
                        break;
                    case 'U':
                        Unum++;
                        break;
                    case 'D':
                        Dnum++;
                        break;
                    default:
                        break;
                }
            }
            if (Lnum == Rnum && Unum == Dnum) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.judgeCircle("UD"));
    }
}
