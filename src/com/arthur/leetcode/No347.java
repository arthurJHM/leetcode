package com.arthur.leetcode;

import java.util.*;

/**
 * @title: No347
 * @Author ArthurJi
 * @Date: 2021/2/19 23:19
 * @Version 1.0
 */
public class No347 {
    public static void main(String[] args) {
        int[] res = new No347().topKFrequent1(new int[]{1, 1, 1, 2, 2, 3}, 2);
        for (int re : res) {
            System.out.println(re);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        for (Integer key : map.keySet()) {
            heap.add(key);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        for (Integer key : map.keySet()) {
            heap.add(key);
        }
        //测试使用一下arraylist<Integer> 变成 int[]
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(heap.poll());
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
