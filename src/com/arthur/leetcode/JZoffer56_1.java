package com.arthur.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: leetcode
 * @description: I. 数组中数字出现的次数
 * @title: JZoffer65_1
 * @Author hengmingji
 * @Date: 2022/1/15 11:42
 * @Version 1.0
 */
public class JZoffer56_1 {
    public int[] singleNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int[] ans = Arrays.stream(set.toArray(new Integer[2])).mapToInt(Integer::intValue).toArray();
        return ans;
    }

    public int[] singleNumbers1(int[] nums) {
        int m = 1, n1 = 0, n2 = 0, total = 0;
        for (int num : nums) {
            total ^= num;
        }
        while ((total & m) == 0) {
            m <<= 1;
        }
        for (int num : nums) {
            if ((num & m) != 0) {
                n1 ^= num;
            } else {
                n2 ^= num;
            }
        }
        return new int[]{n1, n2};
    }
}
