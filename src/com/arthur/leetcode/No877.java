package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 石子游戏
 * @title: No877
 * @Author hengmingji
 * @Date: 2021/6/16 21:56
 * @Version 1.0
 */
public class No877 {
    public boolean stoneGame(int[] ps) {
        int n = ps.length;
        int[][] f = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) { // 枚举区间长度
            for (int l = 1; l + len - 1 <= n; l++) { // 枚举左端点
                int r = l + len - 1; // 计算右端点
                int a = ps[l - 1] - f[l + 1][r];
                int b = ps[r - 1] - f[l][r - 1];
                f[l][r] = Math.max(a, b);
            }
        }
        return f[1][n] > 0;
    }
}
/*
【宫水三叶の相信科学系列】经典区间 DP & 经典博弈游戏
        宫水三叶
        发布于 11 小时前
        5.7k
        动态规划
        定义 f[l][r]f[l][r] 为考虑区间 [l,r][l,r]，在双方都做最好选择的情况下，先手与后手的最大得分差值为多少。

        那么 f[1][n]f[1][n] 为考虑所有石子，先手与后手的得分差值：

        f[1][n] > 0f[1][n]>0，则先手必胜，返回 True
        f[1][n] < 0f[1][n]<0，则先手必败，返回 False
        不失一般性的考虑 f[l][r]f[l][r] 如何转移。根据题意，只能从两端取石子（令 pilespiles 下标从 11 开始），共两种情况：

        从左端取石子，价值为 piles[l - 1]piles[l−1]；取完石子后，原来的后手变为先手，从 [l + 1, r][l+1,r] 区间做最优决策，所得价值为 f[l + 1][r]f[l+1][r]。因此本次先手从左端点取石子的话，双方差值为：
        piles[l - 1] - f[l + 1][r]
        piles[l−1]−f[l+1][r]

        从右端取石子，价值为 piles[r - 1]piles[r−1]；取完石子后，原来的后手变为先手，从 [l, r - 1][l,r−1] 区间做最优决策，所得价值为 f[l][r - 1]f[l][r−1]。因此本次先手从右端点取石子的话，双方差值为：
        piles[r - 1] - f[l][r - 1]
        piles[r−1]−f[l][r−1]

        双方都想赢，都会做最优决策（即使自己与对方分差最大）。因此 f[l][r]f[l][r] 为上述两种情况中的最大值。

        根据状态转移方程，我们发现大区间的状态值依赖于小区间的状态值，典型的区间 DP 问题。

        按照从小到大「枚举区间长度」和「区间左端点」的常规做法进行求解即可。

        代码：


class Solution {
    public boolean stoneGame(int[] ps) {
        int n = ps.length;
        int[][] f = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) { // 枚举区间长度
            for (int l = 1; l + len - 1 <= n; l++) { // 枚举左端点
                int r = l + len - 1; // 计算右端点
                int a = ps[l - 1] - f[l + 1][r];
                int b = ps[r - 1] - f[l][r - 1];
                f[l][r] = Math.max(a, b);
            }
        }
        return f[1][n] > 0;
    }
}
时间复杂度：O(n^2)O(n
        2
        )
        空间复杂度：O(n^2)O(n
        2
        )*/
