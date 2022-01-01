package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 把数组排成最小的数
 * @title: JZoffer45
 * @Author hengmingji
 * @Date: 2022/1/1 18:53
 * @Version 1.0
 */
public class JZoffer45 {
    public String minNumber(int[] nums) {
        Integer[] ans = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(ans, (o1, o2) -> {
            return ("" + o1 + o2).compareTo("" + o2 + o1);
        });
        StringBuilder s = new StringBuilder();
        for (Integer str : ans) {
           s.append(str);
        }
        return s.toString();
    }
}
