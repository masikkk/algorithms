package leetcode.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

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
        // 按 LFUNode.frequent 升序 LFUNode.time 升序 排序的有序集合，红黑树实现， get add O(logn) 复杂度
        private TreeSet<LFUNode> frequentSet;
        // 存储数据的 map
        private Map<Integer, LFUNode> dataMap;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.time = 1;
            frequentSet = new TreeSet<>((k1, k2) -> k1.frequent - k2.frequent);
            dataMap = new HashMap<>();
        }

        public int get(int key) {
            LFUNode existedNode = dataMap.get(key);
            if (null == existedNode) {
                return -1;
            }
            frequentSet.remove(existedNode);
            existedNode.frequent++;
            frequentSet.add(existedNode);
            System.out.println("after get: " + frequentSet);
            return existedNode.value;
        }

        public void put(int key, int value) {
            if (dataMap.size() == capacity) {
                LFUNode lfuNode = frequentSet.first();
                frequentSet.remove(lfuNode);
                dataMap.remove(lfuNode.key);
                System.out.println("after remove lfu in put: " + frequentSet);
            }
            LFUNode existedNode = dataMap.get(key);
            if (existedNode == null) {
                LFUNode newNode = new LFUNode(key, value);
                dataMap.put(key, newNode);
                frequentSet.add(newNode);
            } else {
                existedNode.frequent++;
                dataMap.put(key, existedNode);
                frequentSet.remove(existedNode);
                frequentSet.add(existedNode);
            }
            System.out.println("after put: " + frequentSet);
        }

        // LFUCache 的结点
        class LFUNode {
            int key;
            int value;
            int frequent;

            LFUNode(int key, int value) {
                this.key = key;
                this.value = value;
                this.frequent = 1;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof LFUNode) {
                    return this.key == ((LFUNode) obj).key;
                }
                return false;
            }

            @Override
            public int hashCode() {
                return Integer.hashCode(key);
            }

            @Override
            public String toString() {
                return key + "=" + value + ":" + frequent;
            }
        }
    }

    public static void main(String[] args) {
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
}
