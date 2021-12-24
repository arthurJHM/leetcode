package com.arthur.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description: 吃苹果的最大数目
 * @title: No1705
 * @Author hengmingji
 * @Date: 2021/12/24 13:29
 * @Version 1.0
 */
public class No1705 {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        int time = 0;
        int ans = 0;

        while (!queue.isEmpty() || time < apples.length) {
            if (time < apples.length) {
                queue.add(new int[]{days[time] + time - 1, apples[time]});
            }
            while (!queue.isEmpty()) {
                int[] apple = queue.remove();
                if (apple[0] >= time && apple[1] > 0) {
                    ans++;
                    if (--apple[1] > 0) {
                        queue.add(apple);
                    }
                    break;
                }
            }
            time++;
        }
        return ans;
    }
}
