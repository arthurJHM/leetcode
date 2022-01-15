package com.arthur.leetcode;

import com.sun.org.apache.xml.internal.security.Init;

/**
 * @program: leetcode
 * @description: 构建乘积数组
 * @title: JZoffer66
 * @Author hengmingji
 * @Date: 2022/1/15 14:29
 * @Version 1.0
 */
public class JZoffer66 {
    public int[] constructArr(int[] a) {
        if(a.length == 0) {
            return new int[0];
        }
        int[] head = new int[a.length];
        head[0] = a[0];
        int[] tail = new int[a.length];
        tail[a.length - 1] = a[a.length - 1];
        int[] ans = new int[a.length];
        for (int i = 1; i < a.length; i++) {
            head[i] = head[i - 1] * a[i];
        }
        for (int i = a.length - 2; i >= 0; i--) {
            tail[i] = tail[i + 1] * a[i];
        }
        ans[0] = tail[1];
        ans[a.length - 1] = head[a.length - 2];
        for (int i = 1; i < a.length - 1; i++) {
            ans[i] = head[i - 1] * tail[i + 1];
        }
        return ans;
    }
}
