package com.arthur.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @title: No1438
 * @Author ArthurJi
 * @Date: 2021/2/21 12:14
 * @Version 1.0
 */
public class No1438 {
    public static void main(String[] args) {
        System.out.println(new No1438().longestSubarray1(new int[]{10,1,2,4,7,2}, 5));
    }
    public int longestSubarray(int[] nums, int limit) {
        int len = nums.length;
        int right = 0;
        PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> min = new PriorityQueue<>();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            min.add(nums[i]);
            max.add(nums[i]);
            int big = max.peek() - min.peek();
            while (big > limit) {
                max.remove(nums[right]);
                min.remove(nums[right]);
                right++;
                big = max.peek() - min.peek();
            }
            ans = Math.max(ans, i - right + 1);
        }
        return ans;
    }

    public int longestSubarray1(int[] nums, int limit) {
        int len = nums.length;
        int left = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while(map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
