package com.arthur.bishi.xiecheng0415;

import java.util.Scanner;

/**
 * @title: No1
 * @Author ArthurJi
 * @Date: 2021/4/15 18:57
 * @Version 1.0
 */
public class No1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;
        String _n;
        try {
            _n = in.nextLine();
        } catch (Exception e) {
            _n = null;
        }

        res = buildingHouse(_n);
        System.out.println(res);
    }
    private static String buildingHouse(String n) {
        StringBuilder sb = new StringBuilder();
        int k;
        try {
            k = Integer.valueOf(n);
            if(k > 12 || k <= 0) {
                return "O";
            }
            dfs(sb, k, "R");
            return sb.toString();
        } catch (Exception e) {
            return "N";
        }

    }
    private static void dfs(StringBuilder sb, int n, String ch) {
        if (n == 0) {
            return;
        }
        dfs(sb, n - 1, "G");
        sb.append(ch);
        dfs(sb, n - 1, "R");
    }
}
