package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @title: No448
 * @Author ArthurJi
 * @Date: 2021/2/13 11:32
 * @Version 1.0
 */
public class No448 {

    public static void main(String[] args) {
        int[] nums = new int[] {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
//        System.out.println(findDisappearedNumbers2(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int x = (nums[i] - 1) % n;
            nums[x] += n;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(nums[i] <= n) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> ans = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ans.put(nums[i], ans.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<Integer> res = new ArrayList<>();
        System.out.println(ans);
        for (int i = 1; i <= n; i++) {
            if(ans.getOrDefault(i, 0) == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
