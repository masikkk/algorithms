package others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
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
public class LieTou {
    public List<String> query(Map<String, List<Integer>> lt2jl){
        // 所有简历set
        LinkedHashMap<String, List<Integer>> inputMap = new LinkedHashMap<>();


        Set<Integer> set = new HashSet<>();
        for (List<Integer> list : lt2jl.values()) {
            set.addAll(list);
        }

        Set<Integer> set1 = new HashSet<>();

        lt2jl.forEach((k, list) -> {

        });

        Set<Integer> preSet = new HashSet<>();
        return new ArrayList<String>();

    }
}
