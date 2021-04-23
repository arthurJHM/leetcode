package com.arthur.leetcode;

import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @title: No368
 * @Author ArthurJi
 * @Date: 2021/4/23 10:25
 * @Version 1.0
 */
public class No368 {
    public static void main(String[] args) {
//        new No368().largestDivisibleSubset(new int[]{1, 2, 3});
        new No368().largestDivisibleSubset(new int[]{3,4,16,8});
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] dp = new int[len];
        int[] pre = new int[len];
        for (int i = 0; i < len; i++) {
            pre[i] = i;
            dp[i] = 1;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                    }
                }
            }
        }
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (ans.size() != max) {
            ans.add(nums[index]);
            index = pre[index];
        }
        return ans;
    }
}

/*368. 最大整除子集
        给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
        answer[i] % answer[j] == 0 ，或
        answer[j] % answer[i] == 0
        如果存在多个有效解子集，返回其中任何一个均可。



        示例 1：

        输入：nums = [1,2,3]
        输出：[1,2]
        解释：[1,3] 也会被视为正确答案。
        示例 2：

        输入：nums = [1,2,4,8]
        输出：[1,2,4,8]*/
/*
动态规划
        基于上述分析，我们不难发现这其实是一个序列 DP 问题：某个状态的转移依赖于与前一个状态的关系。即 nums[i] 能否接在 nums[j] 后面，取决于是否满足 nums[i] % nums[j] == 0 条件。

        可看做是「最长上升子序列」问题的变形题。

        定义 f[i]f[i] 为考虑前 i 个数字，且以第 i 个数为结尾的最长「整除子集」长度。

        我们不失一般性的考虑任意位置 i，存在两种情况：

        如果在 i 之前找不到符合条件 nums[i] % nums[j] == 0 的位置 j，那么 nums[i] 不能接在位置 i 之前的任何数的后面，只能自己独立作为「整除子集」的第一个数，此时状态转移方程为 f[i] = 1f[i]=1；
        如果在 i 之前能够找到符合条件的位置 j，则取所有符合条件的 f[j] 的最大值，代表如果希望找到以 nums[i] 为结尾的最长「整除子集」，需要将 nums[i] 接到符合条件的最长的 nums[j] 后面，此时状态转移方程为 f[i] = f[j] + 1f[i]=f[j]+1。
        同时由于我们需要输出具体方案，需要额外使用 g[] 数组来记录每个状态是由哪个状态转移而来。

        定义 g[i]g[i] 为记录 f[i]f[i] 是由哪个下标的状态转移而来，如果 f[i] = f[j] + 1f[i]=f[j]+1, 则有 g[i] = jg[i]=j。

        对于求方案数的题目，多开一个数组来记录状态从何转移而来是最常见的手段。

        当我们求得所有的状态值之后，可以对 f[] 数组进行遍历，取得具体的最长「整除子集」长度和对应下标，然后使用 g[] 数组进行回溯，取得答案。

        代码（感谢 @Benhao 同学提供的 Python3 版本）：

        JavaC++Python3

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        for (int i = 0; i < n; i++) {
            // 至少包含自身一个数，因此起始长度为 1，由自身转移而来
            int len = 1, prev = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    // 如果能接在更长的序列后面，则更新「最大长度」&「从何转移而来」
                    if (f[j] + 1 > len) {
                        len = f[j] + 1;
                        prev = j;
                    }
                }
            }
            // 记录「最终长度」&「从何转移而来」
            f[i] = len;
            g[i] = prev;
        }

        // 遍历所有的 f[i]，取得「最大长度」和「对应下标」
        int max = -1, idx = -1;
        for (int i = 0; i < n; i++) {
            if (f[i] > max) {
                idx = i;
                max = f[i];
            }
        }

        // 使用 g[] 数组回溯出具体方案
        List<Integer> ans = new ArrayList<>();
        while (ans.size() != max) {
            ans.add(nums[idx]);
            idx = g[idx];
        }
        return ans;
    }
}
时间复杂度：O(n^2)O(n
        2
        )
        空间复杂度：O(n)O(n)
        证明
        之所以上述解法能够成立，问题能够转化为「最长上升子序列（LIS）」问题进行求解，本质是利用了「全序关系」中的「可传递性」。

        在 LIS 问题中，我们是利用了「关系运算符 \geqslant⩾ 」的传递性，因此当我们某个数 a 能够接在 b 后面，只需要确保 a \geqslant ba⩾b 成立，即可确保 a 大于等于 b 之前的所有值。

        那么同理，如果我们想要上述解法成立，我们还需要证明如下内容：

        「倍数/约数关系」具有传递性
        由于我们将 nums[i] 往某个数字后面接时（假设为 nums[j]），只检查了其与 nums[j] 的关系，并没有去检查 nums[i] 与 nums[j] 之前的数值是否具有「倍数/约数关系」。

        换句话说，我们只确保了最终答案 [a1, a2, a3, ..., an] 相邻两数值之间具有「倍数/约数关系」，并不明确任意两值之间具有「倍数/约数关系」。

        因此需要证得由 a | ba∣b 和 b | cb∣c，可推导出 a | ca∣c 的传递性：

        由 a | ba∣b 可得 b = x * ab=x∗a
        由 b | cb∣c 可得 c = y * bc=y∗b

        最终有 c = y * b = y * x * ac=y∗b=y∗x∗a，由于 xx 和 yy 都是整数，因此可得 a | ca∣c。

        得证「倍数/约数关系」具有传递性。

        作者：AC_OIer
        链接：https://leetcode-cn.com/problems/largest-divisible-subset/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-0a3jc/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
