package problems;
/**
 * @author masikkk.com
 * @create 2020-03-18 16:47
 */
public class _836_RectangleOverlap {
    private static class SolutionV2020 {
        // [x1, y1, x2, y2]
        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
            // x区间有重叠 且 y区间有重叠
            return overlap(rec1[0], rec1[2], rec2[0], rec2[2]) > 0 && overlap(rec1[1], rec1[3], rec2[1], rec2[3]) > 0;
        }

        // 计算区间 [left1, right1] [left2, right2] 之间的重叠长度，不重叠返回0
        private int overlap(int left1, int right1, int left2, int right2) {
            return Math.min(right1, right2) >= Math.max(left1, left2) ? Math.min(right1, right2) - Math.max(left1, left2) : 0;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.isRectangleOverlap(new int[] {0,0,2,2}, new int[] {1,1,3,3}));
        System.out.println(solutionV2020.isRectangleOverlap(new int[] {0,0,1,1}, new int[] {1,0,2,1}));
    }
}
