package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @program: leetcode
 * @description: 数组中出现次数超过一半的数字
 * @title: JZoffer39
 * @Author hengmingji
 * @Date: 2022/1/15 14:20
 * @Version 1.0
 */
public class JZoffer39 {
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            if (x == num) {
                votes++;
            } else {
                votes--;
            }
        }
        return x;
    }
}
