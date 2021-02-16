package com.arthur.leetcode;

/**
 * @title: No765
 * @Author ArthurJi
 * @Date: 2021/2/14 21:45
 * @Version 1.0
 */
public class No765 {
    int[] p;
    public static void main(String[] args) {
        System.out.println(new No765().minSwapsCouples(new int[]{0, 2, 1, 3}));
    }

    public  int minSwapsCouples(int[] row) {
        int n = row.length;
        int m = n / 2;
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        for (int i = 0; i < n; i+=2) {
            union(row[i] / 2, row[i + 1] / 2);
        }

        int num = 0;
        for (int i = 0; i < m; i++) {
            if(find(i) == i) {
                num++;
            }
        }

        return m - num;
    }

    private void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }

    private int find(int a) {
        if(p[a] != a) {
            p[a] = find(p[a]);
        }
        return p[a];
    }
}

