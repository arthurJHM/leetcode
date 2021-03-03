package com.arthur.leetcode;

/**
 * @title: No494
 * @Author ArthurJi
 * @Date: 2021/3/3 20:50
 * @Version 1.0
 */
public class No494 {
    public static void main(String[] args) {
        System.out.println(new No494().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
    int ans = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, nums.length, S, 0);
        return ans;
    }

    private void dfs(int[] nums, int k, int len, int target, int temp) {
        if(k == len ) {
            if(target == temp) {
                ans++;
            }
            return;
        }
        dfs(nums, k + 1, len, target, temp + nums[k]);
        dfs(nums, k + 1, len, target, temp - nums[k]);
    }

}
/*494. 目标和
        给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

        返回可以使最终数组和为目标数 S 的所有添加符号的方法数。



        示例：

        输入：nums: [1, 1, 1, 1, 1], S: 3
        输出：5
        解释：

        -1+1+1+1+1 = 3
        +1-1+1+1+1 = 3
        +1+1-1+1+1 = 3
        +1+1+1-1+1 = 3
        +1+1+1+1-1 = 3

        一共有5种方法让最终目标和为3。*/
