package com.arthur.leetcode;

import java.util.List;

/**
 * @program: leetcode
 * @description: 三角形最小路径和
 * @title: No120
 * @Author hengmingji
 * @Date: 2021/12/31 22:11
 * @Version 1.0
 */
public class No120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    triangle.get(i).set(0, triangle.get(i - 1).get(0) + triangle.get(i).get(0));
                } else if (j == triangle.get(i).size() - 1) {
                    triangle.get(i).set(triangle.get(i).size() - 1, triangle.get(i - 1).get(triangle.get(i - 1).size() - 1) + triangle.get(i).get(triangle.get(i).size() - 1));
                } else {
                    triangle.get(i).set(j, Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)) + triangle.get(i).get(j));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (Integer a : triangle.get(triangle.size() - 1)) {
            min = Math.min(min, a);
        }
        return min;
    }
}
