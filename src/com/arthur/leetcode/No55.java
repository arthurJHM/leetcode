package com.arthur.leetcode;

/**
 * @title: No55
 * @Author ArthurJi
 * @Date: 2021/3/5 10:17
 * @Version 1.0
 */
public class No55 {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) { //贪心比较简单
        int len = nums.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if(max < i) {
                return false;
            }
            max = Math.max(max, nums[i] + i);
            if(max >= len - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean canJump_2(int[] nums) {//dp 复杂度较高
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(i - j + 1 <= nums[j] && dp[j] == true) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len - 1];
    }
}
/*55. 跳跃游戏
        给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。

        数组中的每个元素代表你在该位置可以跳跃的最大长度。

        判断你是否能够到达最后一个下标。



        示例 1：

        输入：nums = [2,3,1,1,4]
        输出：true
        解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
        示例 2：

        输入：nums = [3,2,1,0,4]
        输出：false
        解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。*/
