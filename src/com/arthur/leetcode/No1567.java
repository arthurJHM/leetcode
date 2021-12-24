package com.arthur.leetcode;

import com.sun.xml.internal.org.jvnet.mimepull.MIMEConfig;

/**
 * @program: leetcode
 * @description: 乘积为正数的最长子数组长度
 * @title: No1567
 * @Author hengmingji
 * @Date: 2021/12/24 14:17
 * @Version 1.0
 */
public class No1567 {
    public int getMaxLen(int[] nums) {
        int pos = 0;
        int neg = 0;
        int first = -1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                pos = 0;
                neg = 0;
                first = -1;
            } else if (nums[i] > 0) {
                pos++;
            } else {
                neg++;
                if (first == -1) {
                    first = i;
                }
            }
            if (neg % 2 == 0) {
                ans = Math.max(ans, pos + neg);
            } else {
                ans = Math.max(ans, i - first);
            }
        }
        return ans;
    }
}
