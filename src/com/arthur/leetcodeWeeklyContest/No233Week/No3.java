package com.arthur.leetcodeWeeklyContest.No233Week;

/**
 * @title: No3
 * @Author ArthurJi
 * @Date: 2021/3/21 13:39
 * @Version 1.0
 */
public class No3 {

    public static void main(String[] args) {

        new No3().maxValue(4, 2, 6);
    }

    public int maxValue(int n, int index, int maxSum) {
        //这题不应该做不出来的
        int left = index;
        int right = index;
        int res = maxSum - n;
        int ans = 1;
        while (right < n - 1 || left > 0) {
            if(res >= (right - left + 1)) {
                res -= (right - left + 1);
                ans++;
                right = Math.min(n - 1, right + 1);
                left = Math.max(left - 1, 0);
            } else {
                break;
            }

        }
        ans += res / n;
        return ans;
    }
}

/*
5711. 有界数组中指定下标处的最大值
        给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：

        nums.length == n
        nums[i] 是 正整数 ，其中 0 <= i < n
abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
        nums 中所有元素之和不超过 maxSum
        nums[index] 的值被 最大化
        返回你所构造的数组中的 nums[index] 。

        注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。



        示例 1：

        输入：n = 4, index = 2,  maxSum = 6
        输出：2
        解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
        示例 2：

        输入：n = 6, index = 1,  maxSum = 10
        输出：3
*/
/*
数学过程模拟（最清晰的Java实现）
        liberg
        发布于 24 分钟前
        40
        解题思路
        过程模拟，从index开始往两边扩充：维护一个[l,r]范围，每次往范围内每个位置+1，通过这种方式维护一个向上生长的“三角形”。

        时间复杂度O(logM)，其中M为maxSum-n。
        空间复杂度O(1)。
        参考代码

public int maxValue(int n, int index, int maxSum) {
        int l = index, r = index;
        int ans = 1;
        // 整个数组一开始全部填充为1，
        // rest记录先全部填充1后，剩下1的个数
        int rest = maxSum - n;
        while (l > 0 || r < n - 1) {
        int len = r - l + 1;
        if (rest >= len) {
        // 当前[l,r]范围全部+1
        rest -= len;
        ans++;
        // 往左右两边扩
        l = Math.max(0, l - 1);
        r = Math.min(n - 1, r + 1);
        } else {
        break;
        }
        }
        // 扩大到整个数组之后，剩余的值“雨露均沾”一下
        ans += rest / n;
        return ans;
        }*/
