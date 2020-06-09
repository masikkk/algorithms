package others;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * 并查集
 * 有路径压缩，但没实现按秩合并
 * @author masikkk.com 2020-06-09 11:57
 */
public class UnionFindTest {
    public class UnionFind {
        int length = 0;
        int[] parent;

        // 初始化一个长度为 length 的并查集
        public UnionFind(int length) {
            this.length = length;
            this.parent = new int[length];
            // 初始时，每个元素都是自己的根
            for (int i = 0; i < length; i++) {
                parent[i] = i;
            }
        }

        // 合并 x 和 y，即将 x 的根节点指向 y
        public void union(int x, int y) {
            int xParent = find(x);
            int yParent = find(y);
            if (xParent != yParent) {
                parent[xParent] = y;
            }
        }

        // 在并查集中查找 x 的根 - 递归并带有路径压缩
        public int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        // 在并查集中查找 x 的根 - 迭代
        public int findIterative(int x) {
            while (parent[x] != x) {
                x = parent[x];
            }
            return x;
        }

        // 打印并查集
        public void print() {
            Set<Integer> valueSet = new HashSet<>();
            for (int i = 0; i < length; i++) {
                if (parent[i] != i) {
                    valueSet.add(parent[i]);
                }
            }
            for (int i = 0; i < length; i++) {
                // 只遍历有父节点的叶子节点，即 i 指向其他结点 且 i 不被其他结点指向
                if (parent[i] != i && !valueSet.contains(i)) {
                    int j = i;
                    while (j != parent[j]) {
                        System.out.print(j + " -> ");
                        j = parent[j];
                    }
                    System.out.println(j);
                }
            }
        }
    }

    // 构造出来就是路径压缩后的并查集
    @Test
    public void testUnionFind1() {
        UnionFind unionFind = new UnionFind(100);
        // 0 - 10 中的奇数构成一个连通分量，根是 1。偶数构成一个联通分量，根是 0，这样构造出来就是路径压缩后的并查集
        for (int i = 2; i <= 10; i++) {
            if (i % 2 == 0) {
                unionFind.union(i, 0);
            } else {
                unionFind.union(i, 1);
            }
        }
        unionFind.print();
        System.out.println(unionFind.find(3));
        System.out.println(unionFind.find(6));
        System.out.println(unionFind.find(10));
    }

    // 查找中进行路径压缩
    @Test
    public void testUnionFind2() {
        UnionFind unionFind = new UnionFind(100);
        // 0 - 10 中的奇数构成一个连通分量，偶数构成一个联通分量。
        int lastOdd = 1, lastEven = 0;
        for (int i = 2; i <= 10; i++) {
            if (i % 2 == 0) {
                // 偶数指向上一个偶数
                unionFind.union(i, lastEven);
                lastEven = i;
            } else {
                // 奇数指向上一个奇数
                unionFind.union(i, lastOdd);
                lastOdd = i;
            }
        }
        unionFind.print();
        System.out.println(unionFind.find(9));
        System.out.println(unionFind.find(10));
        unionFind.print();
    }
}
