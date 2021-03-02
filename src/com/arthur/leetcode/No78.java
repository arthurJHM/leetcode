package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: No78
 * @Author ArthurJi
 * @Date: 2021/3/2 16:40
 * @Version 1.0
 */
public class No78 {
    public static void main(String[] args) {

    }
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<Integer>());
        return res;
    }

    private void backtrack( int[] nums, int no, ArrayList<Integer> temp) {

        res.add(new ArrayList<>(temp));

        for (int j = no; j < nums.length; j++) {
            temp.add(nums[j]);
            backtrack(nums, j + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

}
/*
    给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

        解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。*/
/*
假设nums=[1,2,3,4]，二进制的0可以写成0000，代表一个数也不取，1=0001表示去第一个数也就是[1]，2=0010
，表示取第二个数[2]，3=0011表示取1和2位[1,2]，4=0100表示[3]....15=1111表示[1,2,3,4]
class Solution {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        for(int i = 0; i < (1 << length); i++) { // i=3 011
            list.clear();
            for(int j = 0; j < length; j++) {
                if(((1 << j) & i) != 0) {
                    list.add(nums[j]);
                }
            }
            ans.add(new ArrayList<Integer>(list));
        }
        return ans;
    }
}*/
