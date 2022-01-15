package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: II. 和为s的连续正数序列
 * @title: JZoffer57_2
 * @Author hengmingji
 * @Date: 2022/1/15 14:47
 * @Version 1.0
 */
public class JZoffer57_2 {
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> lists = new ArrayList<>();
        int i = 0, j = 0;
        int sum = 0;
        while (i < target && j < target) {
            if(sum < target) {
                sum+=j;
                j++;
            } else if(sum > target){
                sum-=i;
                i++;
            } else if(sum == target && j - i >= 2) {
                int[] temp = new int[j - i];
                int l = 0;
                for (int k = i; k < j; k++) {
                    temp[l++] = k;
                }
                lists.add(temp);
                sum-=i;
                i++;
            }
        }
        return lists.toArray(new int[lists.size()][]);
    }
}
