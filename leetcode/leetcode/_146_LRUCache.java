package leetcode.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 实现LRU缓存
 * https://leetcode-cn.com/problems/lru-cache/
 * @author masikkk.com
 * @create 2020-03-25 11:18
 */
public class _146_LRUCache {
    private static class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.get(key) != null ? super.get(key) : -1;
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        // 重写 removeEldestEntry 当元素个数大于初始容量 capacity 时删除最长时间没访问的Entry
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));       // returns 1
        lruCache.put(3, 3);    // evicts key 2
        System.out.println(lruCache.get(2));       // returns -1 (not found)
        lruCache.put(4, 4);    // evicts key 1
        System.out.println(lruCache.get(1));       // returns -1 (not found)
        System.out.println(lruCache.get(3));       // returns 3
        System.out.println(lruCache.get(4));       // returns 4
    }
}
