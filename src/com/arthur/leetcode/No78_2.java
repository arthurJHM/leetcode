package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: No78_2
 * @Author ArthurJi
 * @Date: 2021/3/2 17:21
 * @Version 1.0
 */
public class No78_2 {
    public static void main(String[] args) {

    }
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<Integer>());
        return res;
    }

    private void backtrack( int[] nums, int no, ArrayList<Integer> temp) {

        if(nums.length == no) {
            res.add(new ArrayList<>(temp));
            return;
        }

        backtrack(nums, no + 1, temp);
        temp.add(nums[no]);
        backtrack(nums, no + 1, temp);
        temp.remove(temp.size() - 1);
    }
}
