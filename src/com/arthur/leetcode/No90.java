package com.arthur.leetcode;

import java.util.*;

/**
 * @title: No90
 * @Author ArthurJi
 * @Date: 2021/3/31 14:08
 * @Version 1.0
 */
public class No90 {


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        //注意如果有重复元素且又要做排列或者子集的话我们一般先排序，方便后面剪枝
        Arrays.sort(nums);
        backtrack(0,len,nums,res,new ArrayList<Integer>());
        return res;
    }

    public void backtrack(int index,int length,int [] nums,List<List<Integer>> res,List<Integer> temp) {
        //注意拷贝
        res.add(new ArrayList(temp));

        for(int i = index;i<length;i++){
            //剪枝 去重
            if(i>index && nums[i] == nums[i-1]){
                continue;
            }
            //选择节点
            temp.add(nums[i]);
            // 继续探索新的节点 i+1
            backtrack(i+1,length,nums,res,temp);
            //撤销选择
            temp.remove(temp.size()-1);
        }
    }


}
/*
90. 子集 II
        给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

        解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。



        示例 1：

        输入：nums = [1,2,2]
        输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
        示例 2：

        输入：nums = [0]
        输出：[[],[0]]


        提示：

        1 <= nums.length <= 10
        -10 <= nums[i] <= 10*/
