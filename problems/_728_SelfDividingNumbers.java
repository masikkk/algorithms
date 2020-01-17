package problems;

import java.util.ArrayList;
import java.util.List;

public class _728_SelfDividingNumbers {
    private static class Solution {
        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> arrayList = new ArrayList<Integer>();
            for (int i = left; i <= right; i++) {
                //System.out.println(i);
                int remain = i;
                int mod = i % 10;
                if (mod == 0) {//直接跳过10的倍数
                    continue;
                }
                while (i % mod == 0) {
                    remain = remain / 10;
                    if (remain % 10 == 0) {//remain为0或10的倍数时停止
                        break;
                    } else {
                        mod = remain % 10;
                    }
                }
                if (remain == 0) {//所有位数都能整除i
                    arrayList.add(i);
                }
            }
            return arrayList;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = solution.selfDividingNumbers(100, 1000);
        System.out.println(list);
    }
}
