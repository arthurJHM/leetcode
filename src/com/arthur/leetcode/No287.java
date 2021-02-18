package com.arthur.leetcode;

import java.util.HashMap;

/**
 * @title: No287
 * @Author ArthurJi
 * @Date: 2021/2/18 22:32
 * @Version 1.0
 */
public class No287 {
    public static void main(String[] args) {
        System.out.println(new No287().findDuplicate1(new int[]{1, 3, 4, 2, 2}));
    }

    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> temp = new HashMap<>();
        for (int num : nums) {
            if(temp.getOrDefault(num, 0) == 0) {
                temp.put(num, 1);
            }
            else {
                return num;
            }
        }
        return 0;
    }

    public int findDuplicate1(int[] nums) {
        int left = 0;
        int right = nums.length;
        int n;
        while(right > left) {
            int mid = (left + right) >>> 1;
            n = 0;
            for (int num : nums) {
                if(num <= mid) {
                    n++;
                }
            }
            if(n > mid) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/*
287. 寻找重复数
        给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。

        假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。



        示例 1：

        输入：nums = [1,3,4,2,2]
        输出：2
        示例 2：

        输入：nums = [3,1,3,4,2]
        输出：3
        示例 3：

        输入：nums = [1,1]
        输出：1
        示例 4：

        输入：nums = [1,1,2]
        输出：1

*/
