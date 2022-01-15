package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description: 查找和最小的K对数字
 * @title: No373
 * @Author hengmingji
 * @Date: 2022/1/14 13:31
 * @Version 1.0
 */
public class No373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> ((nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]])));
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            queue.add(new int[]{i, 0});
        }
        for (int i = 0; i < k; i++) {
            if(queue.isEmpty()) {
                break;
            }
            int[] num = queue.poll();
            ans.add(new ArrayList<Integer>() {{
                add(nums1[num[0]]);
                add(nums2[num[1]]);
            }});
            if (num[1] + 1 < nums2.length) {
                queue.add(new int[]{num[0], num[1] + 1});
            }
        }
        return ans;
    }
}
