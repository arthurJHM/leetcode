package com.arthur.leetcode;

import java.util.Arrays;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @title: No213
 * @Author ArthurJi
 * @Date: 2021/4/15 12:15
 * @Version 1.0
 */
public class No213 {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) {
            return 0;
        }
        if(len == 1) {
            return nums[0];
        }
        int a = rob1(Arrays.copyOfRange(nums, 0, len - 1));
        int b = rob1(Arrays.copyOfRange(nums, 1, len));
        return Math.max(a, b);

    }

    private int rob1(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }
}

/*213. 打家劫舍 II
        你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

        给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。



        示例 1：

        输入：nums = [2,3,2]
        输出：3
        解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
        示例 2：

        输入：nums = [1,2,3,1]
        输出：4
        解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
        偷窃到的最高金额 = 1 + 3 = 4 。
        示例 3：

        输入：nums = [0]
        输出：0*/
/*
各位题友大家好！ 今天是 @负雪明烛 坚持日更的第 81 天。今天力扣上的每日一题是「213. 打家劫舍 II」。

        解题思路
        「打家劫舍 II」 是说两个相邻的房间不能同时偷，并且首尾两个房间是相邻的（不能同时偷首尾房间）。
        明显是基于「打家劫舍 I」做的升级，「打家劫舍 I」也是说两个相邻的房间不能同时偷，但是首尾房间不是相邻的（可以同时偷首尾房间）。
        所以，我们先从「打家劫舍 I」开始说起。

        打家劫舍 I
        题目：两个相邻的房间不能同时偷，首尾房间不相邻，求小偷能获取的最大金额。

        对于「求数组中按照某种方法进行选择，求最值，而不用知道具体选择方案」的问题，可以考虑动态规划。动态规划最基本的是「状态的定义」，然后比较难的是「状态转移方程」。

        「状态的定义」即 dp[i]，一般可以根据题意，题目要求什么我们就定义什么。比如本题，我们定义 dp[i]为数组的前 i 个元素中按照「两个相邻的房间不能同时偷」的方法，能够获取到的最大值。（经验：定义dp[i]为数组的前 i 个元素的结果）

        考虑「状态转移方程」时，一定要想办法让 dp[i] 能够基于 dp[0~i-1]生成。本题要求不能同时偷相邻的房间。所以，dp[i] 有两种抉择：nums[i] 选或者不选。这确实是个问题。

        如果 nums[i]选，那么由于不能选择相邻的房间，所以不可以选择 nums[i -1]，所以选择 nums[i]的情况下，数组的前 i 个元素构成的最大值dp[i] = dp[i - 2] + nums[i]；
        如果 nums[i]不选，那么就可以选择 nums[i - 1]，所以数组的前 i 个元素构成的最大值 等于 数组前 i - 1 个元素构成的最大值，即 dp[i] = dp[i - 1]。
        所以，最终的 dp[i]是上面两种情况的最大值。
        「初始条件」比较简单：

        dp[0] = nums[0]
        dp[1] = max(dp[0], nums[1]) = max(nums[0], nums[1])
        「返回结果」，可以根据我们的 dp[i]知道，最终要求的是在整个数组上能够取得的最大值。所以返回 dp[N - 1]。

        举个栗子🌰，当输入 nums = [2,3,2] 时，动态规划的初始化和转移方程的过程如下面两个图所示。

        初始化：


        状态转移：


        代码如下。

        Python

class Solution(object):
        def rob(self, nums):
        N = len(nums)
        if not nums:
        return 0
        if N == 1:
        return nums[0]
        # max amount [0, i]
        dp = [0] * N
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, N):
        dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
        return dp[-1]
        时间复杂度：O(N)O(N)
        空间复杂度：O(N)O(N)
        打家劫舍 II
        在多了数组的开头和结尾是相邻的情况下，也就是说，数组的开头和结尾元素不能同时选。由于状态转移方程中，是没有标记我们到底选了哪些元素的。所以如果想通过状态转移方程，来实现首尾元素不能同时选，是很难的。

        这里就用了技巧，分为两种情况去考虑：分别在nums[0:N-1] 和 nums[1:N]上计算能获取到的最大值，这两种情况取最大。这肯定能保证在物理上隔离了首尾两个元素，肯定不会同时选到。

        对应的代码如下，只需要基于「打家劫舍 I」稍微改造一下。

        Python

class Solution(object):
        def rob(self, nums):
        N = len(nums)
        if not nums:
        return 0
        if N == 1:
        return nums[0]
        return max(self.rob1(nums[0:N - 1]), self.rob1(nums[1:N]))

        def rob1(self, nums):
        N = len(nums)
        if not nums:
        return 0
        if N == 1:
        return nums[0]
        dp = [0] * N
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, N):
        dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
        return dp[-1]
        时间复杂度：O(N)O(N)
        空间复杂度：O(N)O(N)
        刷题心得
        打家劫舍是个系列题目，也是动态规划的最经典题目，务必掌握，并且理解动态规划的思想。

        参考资料：无。

        OK，以上就是 @负雪明烛 写的今天题解的全部内容了，如果你觉得有帮助的话，求赞、求关注、求收藏。如果有疑问的话，请在下面评论，我会及时解答。

        关注我，你将不会错过我的精彩动画题解、面试题分享、组队刷题活动，进入主页 @负雪明烛 右侧有刷题组织，从此刷题不再孤单。

        祝大家 AC 多多，Offer 多多！我们明天再见！

        作者：fuxuemingzhu
        链接：https://leetcode-cn.com/problems/house-robber-ii/solution/fu-xue-ming-zhu-da-jia-jie-she-i-yu-ii-b-yv0s/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
