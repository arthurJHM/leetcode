package com.arthur.bishi.zoom0828;

import java.util.ArrayDeque;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/28 16:45
 * @modifiedBy：
 * @version: 1.0
 */
public class No2 {
    public int find132Pattern (int[] nums) {
        // write code here
        int n = nums.length;
        ArrayDeque<Integer> d = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;
        int ans = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(nums[i] < k) ans++;
            while (!d.isEmpty() && d.peekLast() < nums[i]) {
                k = Math.max(k, d.pollLast());
            }
            d.addLast(nums[i]);
        }
        return ans;
    }
}
