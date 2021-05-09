package com.arthur.bishi.zijie0509;

import java.util.Scanner;

/**
 * @title: No3
 * @Author ArthurJi
 * @Date: 2021/5/9 20:03
 * @Version 1.0
 */
public class No3 {
    private static class UnionFind {
        private int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        // 使用了路径压缩
        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        // 0 位置不使用，因此需要 + 1
        UnionFind unionFind = new UnionFind(N + 1);
        for (int i = 0; i < K; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            unionFind.union(a, b);
        }
        // 将候选数组映射成代表元，统计代表元出现的次数，找出最大者
        int[] cnt = new int[N + 1];
        int res = 0;
        for (int i = 1; i <= N; i++) {
            int root = unionFind.find(i);
            cnt[root]++;
            res = Math.max(res, cnt[root]);
        }
        System.out.println(res);;
    }
}