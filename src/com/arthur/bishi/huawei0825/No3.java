package com.arthur.bishi.huawei0825;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/25 19:32
 * @modifiedBy：
 * @version: 1.0
 */
public class No3 {
    static ArrayList<Integer>[] list;
    static  ArrayList<Integer>[] listback;
    static int[] value;
    static int ans;
    static HashSet<Integer> map = new HashSet<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        value = new int[n];
        list = new ArrayList[n];
        listback = new ArrayList[n];
        ans = Integer.MIN_VALUE;
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < listback.length; i++) {
            listback[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            String[] nums = s.split(" ");
            List<Integer> fore = Arrays.stream(nums[0].split(",")).map(Integer::valueOf).collect(Collectors.toList());
            value[i] = Integer.valueOf(nums[1]);
            list[i].addAll(fore);
        }
        for (int i = 0; i < list.length; i++) {
            for (Integer pre : list[i]) {
                if (pre != -1) {
                    listback[pre].add(i);
                }
            }
        }
        for (int i = 0; i < list.length; i++) {
            int val = value[i];
            if (list[i].size() == 1 && list[i].get(0) == -1) {
                for (Integer integer : listback[i]) {
                    dfs(integer, val + value[integer]);
                }
            }
        }
        System.out.println(ans);
    }

    private static void dfs(Integer integer, int val) {
        if(listback[integer].size() == 0) {
            ans = Integer.max(ans, val);
            return;
        }
        if(map.contains(integer)) {
            return;
        }
        map.add(integer);
        for (int i = 0; i < listback[integer].size(); i++) {
            dfs(listback[integer].get(i), val + value[listback[integer].get(i)]);
        }
        map.remove(integer);
    }
}
