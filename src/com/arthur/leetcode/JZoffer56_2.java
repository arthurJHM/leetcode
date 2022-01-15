package com.arthur.leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 数组中数字出现的次数 II
 * @title: JZoffer56_2
 * @Author hengmingji
 * @Date: 2022/1/15 13:50
 * @Version 1.0
 */
public class JZoffer56_2 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.getOrDefault(num, 0) == 2) {
                map.remove(num);
            } else if (map.getOrDefault(num, 0) < 2) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return Arrays.stream(map.keySet().toArray(new Integer[1])).mapToInt(Integer::intValue).toArray()[0];
    }

}
