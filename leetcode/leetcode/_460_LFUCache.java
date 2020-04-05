package leetcode.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;

/**
 * @author si.ma
 * @create 2020-04-05 19:05
 */
public class _460_LFUCache {
    private static class LFUCache {
        // LFUCache 的固定容量
        private int capacity;
        // 全局的计数器，代表时间，用于对访问次数相同的key再按时间排序
        private int time;
        // 按 (LFUNode.frequent 升序, LFUNode.time 升序) 排序的有序集合，红黑树实现， get 和 add 是 O(logn) 复杂度
        private TreeSet<LFUNode> frequentSet;
        // 存储数据的 map
        private Map<Integer, LFUNode> dataMap;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.time = 1;
            // 如果 自定义类 LFUNode 没有实现 Comparable 接口的 compareTo 方法，就必须在创建 TreeSet 时指定排序方法
            frequentSet = new TreeSet<>((k1, k2) -> k1.frequent == k2.frequent ? k1.time - k2.time : k1.frequent - k2.frequent);
            dataMap = new HashMap<>();
        }

        public int get(int key) {
            LFUNode existedNode = dataMap.get(key);
            if (null == existedNode) {
                return -1;
            }
            frequentSet.remove(existedNode);
            existedNode.frequent++; // 访问次数加1
            existedNode.time = time++; // 更新全局时间
            frequentSet.add(existedNode);
            System.out.println("after get: " + frequentSet);
            return existedNode.value;
        }

        public void put(int key, int value) {
            // 测试用例中有 capacity 为0的特例
            if (capacity == 0) {
                return;
            }
            LFUNode existedNode = dataMap.get(key);
            if (existedNode != null) {
                // 注意一定要先删除
                frequentSet.remove(existedNode);
                // 已存在key，更新value
                existedNode.value = value; // 更新value
                existedNode.frequent++; // 访问次数加1
                existedNode.time = time++; // 更新全局时间
                dataMap.put(key, existedNode);
                frequentSet.add(existedNode);
            } else {
                // 新key，先看空间够不够
                if (dataMap.size() == capacity) {
                    // 空间不够时删除访问次数最小的，若有多个删除time最小的，也就是有序集合 TreeSet 的第一个元素
                    LFUNode lfuNode = frequentSet.first();
                    frequentSet.remove(lfuNode);
                    dataMap.remove(lfuNode.key);
                    System.out.println("after remove lfu in put: " + frequentSet);
                }
                LFUNode newNode = new LFUNode(key, value, 1, time++);
                dataMap.put(key, newNode);
                frequentSet.add(newNode);
            }
            System.out.println("after put: " + frequentSet);
        }

        // LFUCache 的结点
        class LFUNode {
            int key;
            int value;
            int frequent;
            int time;

            LFUNode(int key, int value, int frequent, int time) {
                this.key = key;
                this.value = value;
                this.frequent = frequent;
                this.time = time;
            }

            @Override
            public String toString() {
                return "{" + key + "=" + value + ", f:" + frequent + ", t:" + time + "}";
            }
        }
    }

    @Test
    public void testDefaultCase() {
        LFUCache cache = new LFUCache( 2 /* capacity */ );
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.get(3);       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

    @Test
    public void testZeroCapacityCase() {
        LFUCache cache = new LFUCache( 0 /* capacity */ );
        cache.put(0, 0);
        System.out.println(cache.get(0));
    }

    @Test
    public void testErrorCase() {
        LFUCache cache = new LFUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
