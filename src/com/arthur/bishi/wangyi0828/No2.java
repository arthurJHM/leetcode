package com.arthur.bishi.wangyi0828;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/28 15:24
 * @modifiedBy：
 * @version: 1.0
 */
public class No2 {
    static ArrayList<Integer>[] list;
    static ArrayList<Integer>[] listback;
    static int[] value;
    static int ans;
    static HashSet<Integer> map = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            value = new int[n + 1];
            list = new ArrayList[n + 1];
            listback = new ArrayList[n + 1];
            ans = Integer.MIN_VALUE;
            for (int j = 1; j < list.length; j++) {
                list[j] = new ArrayList<>();
            }
            for (int j = 1; j < listback.length; j++) {
                listback[j] = new ArrayList<>();
            }
            for (int j = 1; j < n + 1; j++) {
                value[j] = scanner.nextInt();
                int count = scanner.nextInt();
                for (int k = 1; k < count + 1; k++) {
                    list[j].add(scanner.nextInt());
                }
            }
            for (int j = 1; j < list.length; j++) {
                for (Integer pre : list[j]) {
                    if (pre != -1) {
                        listback[pre].add(j);
                    }
                }
            }
            for (int j = 1; j < list.length; j++) {
                int val = value[j];
                if (list[j].size() == 0) {
                    for (Integer integer : listback[j]) {
                        dfs(integer, val + value[integer]);
                    }
                }
            }
            System.out.println(ans);
        }
    }

    private static void dfs(Integer integer, int val) {
        if (listback[integer].size() == 0) {
            ans = Integer.max(ans, val);
            return;
        }
        if (map.contains(integer)) {
            return;
        }
        map.add(integer);
        for (int i = 0; i < listback[integer].size(); i++) {
            dfs(listback[integer].get(i), val + value[listback[integer].get(i)]);
        }
        map.remove(integer);
    }
}
/*
2
3
5 0
10 1 1
15 1 1
4
3 0
4 0
7 1 1
6 2 1 2

* */