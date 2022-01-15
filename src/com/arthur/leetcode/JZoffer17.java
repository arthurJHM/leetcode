package com.arthur.leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 打印从1到最大的n位数
 * @title: JZoffer17
 * @Author hengmingji
 * @Date: 2022/1/15 23:33
 * @Version 1.0
 */
public class JZoffer17 {
    public int[] printNumbers(int n) {
        int count = (int) (Math.pow(10, n) - 1);
        int[] ans = new int[count];
        ans[0] = 1;
        for (int i = 1; i < count; i++) {
            ans[i] = ans[i - 1] + 1;
        }
        return ans;
    }
}
