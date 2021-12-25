package com.arthur.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description: 相对名次
 * @title: No506
 * @Author hengmingji
 * @Date: 2021/12/25 15:40
 * @Version 1.0
 */
public class No506 {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }
        Integer[] temp = Arrays.stream(Arrays.copyOfRange(score, 0, score.length)).boxed().toArray(Integer[]::new);
        Arrays.sort(temp, Collections.reverseOrder());
        String[] ans = new String[score.length];
        for (int i = 0; i < temp.length; i++) {
            System.out.println(map.get(temp[i]));
            if(i == 0) {
                ans[map.get(temp[i])] = "Gold Medall";
            } else if(i == 1) {
                ans[map.get(temp[i])] = "Silver Medal";
            } else if(i == 2) {
                ans[map.get(temp[i])] = "Bronze Medal";
            } else {
                ans[map.get(temp[i])] = String.valueOf(i + 1);
            }
        }
        return ans;
    }
}
