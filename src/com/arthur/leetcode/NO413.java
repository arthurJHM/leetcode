package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountedCompleter;

/**
 * @program: leetcode
 * @description: 等差数列划分
 * @title: NO413
 * @Author hengmingji
 * @Date: 2021/12/28 13:43
 * @Version 1.0
 */
public class NO413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        int[] diff = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            diff[i] = nums[i + 1] - nums[i];
        }
        ArrayList<Integer> list = new ArrayList<>();
        int n = 1;
        for (int i = 0; i < diff.length - 1; i++) {
            if (diff[i + 1] == diff[i]) {
                n++;
            } else if(n >= 2){
                list.add(n);
                n = 1;
            }
            if(n >= 2 && i == diff.length - 2) {
                list.add(n);
            }
        }
        int ans = 0;
        for (Integer i : list) {
            ans += (i - 1) * (i - 2) / 2;
        }
        return ans;
    }
}
