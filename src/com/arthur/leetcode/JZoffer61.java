package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 扑克牌中的顺子
 * @title: JZoffer61
 * @Author hengmingji
 * @Date: 2022/1/1 18:32
 * @Version 1.0
 */
public class JZoffer61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int n = 0;
        while (nums[i] == 0) {
            i++;
            n++;
        }
        while (i < nums.length - 1) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            } else if (nums[i] + 1 != nums[i + 1]) {
                if (n >= nums[i + 1] - nums[i] - 1) {
                    n -= (nums[i + 1] - nums[i] - 1);
                } else {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        new JZoffer61().isStraight(new int[]{11,8,12,8,10});
    }
}
