package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 猎头简历问题（跟谁学一面）
 * 已知猎头跟简历的对应关系，猎头手中的简历可能重叠，找到能获取全部简历的最少的猎头
 * eg:
 * A -> 1 2 3 4
 * B -> 2 3 5
 * C -> 4 5 6
 * D -> 5 6 7 8
 * E -> 1 4 6
 * result: [A, D]
 *
 * @author masikkk.com
 * @create 2020-03-12 17:06
 */
public class HeadHunterAndResume {
    public List<String> getLeastHeaderHunter(Map<String, List<Integer>> lt2jl) {
        if (null == lt2jl || lt2jl.size() == 0) {
            return Collections.emptyList();
        }
        // 所有简历全集
        Set<Integer> allResumeSet = new HashSet<>();
        lt2jl.forEach((k, list) -> allResumeSet.addAll(list));

        // 已覆盖的简历集合
        Set<Integer> coveredResumeSet = new HashSet<>();

        // 已找到的猎头集合
        Set<String> headHunterSet = new HashSet<>();
        // 剩余猎头集合
        Set<String> remainingHeadHunterSet = new HashSet<>(lt2jl.keySet());

        // 已覆盖集合为全集时结束
        while (coveredResumeSet.size() < allResumeSet.size()) {
            // 遍历剩余猎头集合 remainingHeadHunterSet, 每次找和已覆盖简历集合 coveredResumeSet 差集最大的猎头，将其加入已找到猎头集合 headHunterSet ，其简历加入 coveredResumeSet，将其从 remainingHeadHunterSet 删除
            int maxDiff = 0;
            String maxDiffHeaderHunter = "";
            for (String headHunter : remainingHeadHunterSet) {
                Set<Integer> resumeSet = new HashSet<>(lt2jl.get(headHunter));
                // resumeSet - coveredResumeSet 的差集
                Set<Integer> diffSet = difference(resumeSet, coveredResumeSet);
                if (diffSet.size() > maxDiff) {
                    maxDiff = diffSet.size();
                    maxDiffHeaderHunter = headHunter;
                }
            }
            remainingHeadHunterSet.remove(maxDiffHeaderHunter);
            headHunterSet.add(maxDiffHeaderHunter);
            coveredResumeSet.addAll(lt2jl.get(maxDiffHeaderHunter));
        }

        return new ArrayList<>(headHunterSet);
    }

    // 求 set1 - set2 的差集
    private <T> Set<T> difference(Set<T> set1, Set<T> set2) {
        if (null == set2 || set2.size() == 0) {
            return set1;
        }
        Set<T> resultSet = new HashSet<>(set1);
        for (T ele : set2) {
            resultSet.remove(ele);
        }
        return resultSet;
    }

    public static void main(String[] args) {
        HeadHunterAndResume headHunterAndResume = new HeadHunterAndResume();
        HashMap<String, List<Integer>> lt2jl = new HashMap<>();
        lt2jl.put("A", Arrays.asList(1,2,3,4));
        lt2jl.put("B", Arrays.asList(2,3,5));
        lt2jl.put("C", Arrays.asList(4,5,6));
        lt2jl.put("D", Arrays.asList(5,6,7,8));
        lt2jl.put("E", Arrays.asList(1,4,6));
        System.out.println(headHunterAndResume.getLeastHeaderHunter(lt2jl));
    }
}
