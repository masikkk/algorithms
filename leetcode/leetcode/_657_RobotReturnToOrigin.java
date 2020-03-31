package leetcode.leetcode;

/**
 * 机器人能否返回原点
 * https://leetcode-cn.com/problems/robot-return-to-origin/
 */
public class _657_RobotReturnToOrigin {
    private static class SolutionV2018 {
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
        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println(solutionV2018.judgeCircle("UD"));
    }
}
