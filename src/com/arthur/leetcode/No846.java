package com.arthur.leetcode;

import java.util.*;

/**
 * @program: leetcode
 * @description: 一手顺子
 * @title: No846
 * @Author hengmingji
 * @Date: 2021/12/30 11:47
 * @Version 1.0
 */
public class No846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
            set.add(hand[i]);
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (map.getOrDefault(list.get(i), 0) > 0) {
                for (int j = 1; j < groupSize; j++) {
                    if (map.getOrDefault(list.get(i) + j, 0) == 0 || map.get(list.get(i) + j) < map.get(list.get(i))) {
                        return false;
                    } else {
                        map.put(list.get(i) + j, map.get(list.get(i) + j) - map.get(list.get(i)));
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new No846().isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4);
    }
}
