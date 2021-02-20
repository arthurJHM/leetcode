package com.arthur.leetcode;

/**
 * @title: No279
 * @Author ArthurJi
 * @Date: 2021/2/20 18:52
 * @Version 1.0
 */
public class No279 {
    public static void main(String[] args) {
        System.out.println(new No279().numSquares(12));
    }
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}

/*
279. 完全平方数
思路：
        标签：动态规划
        首先初始化长度为 n+1 的数组 dp，每个位置都为 0
        如果 n 为 0，则结果为 0
        对数组进行遍历，下标为 i，每次都将当前数字先更新为最大的结果，即 dp[i]=i，比如 i=4，最坏结果为 4=1+1+1+1 即为 4 个数字
        动态转移方程为：dp[i] = MIN(dp[i], dp[i - j * j] + 1)，i 表示当前数字，j*j 表示平方数
        时间复杂度：O(n*sqrt(n))O(n∗sqrt(n))，sqrt 为平方根


        JavaJavaScript

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
        }
        return dp[n];
    }
}

作者：guanpengchn
        链接：https://leetcode-cn.com/problems/perfect-squares/solution/hua-jie-suan-fa-279-wan-quan-ping-fang-shu-by-guan/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
