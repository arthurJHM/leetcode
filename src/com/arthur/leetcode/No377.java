package com.arthur.leetcode;

/**
 * @title: No377
 * @Author ArthurJi
 * @Date: 2021/4/24 13:21
 * @Version 1.0
 */
public class No377 {
    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int[] dp = new int[target + 1];
        dp[0]  = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < len; j++) {
                if(i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
/*377. 组合总和 Ⅳ
        给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。

        题目数据保证答案符合 32 位整数范围。



        示例 1：

        输入：nums = [1,2,3], target = 4
        输出：7
        解释：
        所有可能的组合为：
        (1, 1, 1, 1)
        (1, 1, 2)
        (1, 2, 1)
        (1, 3)
        (2, 1, 1)
        (2, 2)
        (3, 1)
        请注意，顺序不同的序列被视作不同的组合。
        示例 2：

        输入：nums = [9], target = 3
        输出：0*/
/*
爬楼梯问题 楼梯的阶数一共为target，一次可以走的步数为nums[i]。 一共有多少种走法？问题搞定。

public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++){
        for(int j = 0; j < nums.length; j++){
        if(i >= nums[j]){
        dp[i] += dp[i - nums[j]];
        }
        }
        }
        return dp[target];
        }*/
/*
解题思路
        常见的背包问题有1、组合问题。2、True、False问题。3、最大最小问题。
        以下题目整理来自大神CyC，github地址：
        github
        我在大神整理的基础上，又做了细分的整理。分为三类。
        1、组合问题：
        377. 组合总和 Ⅳ
        494. 目标和
        518. 零钱兑换 II
        2、True、False问题：
        139. 单词拆分
        416. 分割等和子集
        3、最大最小问题：
        474. 一和零
        322. 零钱兑换

        组合问题公式


        dp[i] += dp[i-num]
        True、False问题公式


        dp[i] = dp[i] or dp[i-num]
        最大最小问题公式


        dp[i] = min(dp[i], dp[i-num]+1)或者dp[i] = max(dp[i], dp[i-num]+1)
        以上三组公式是解决对应问题的核心公式。

        当然拿到问题后，需要做到以下几个步骤：
        1.分析是否为背包问题。
        2.是以上三种背包问题中的哪一种。
        3.是0-1背包问题还是完全背包问题。也就是题目给的nums数组中的元素是否可以重复使用。
        4.如果是组合问题，是否需要考虑元素之间的顺序。需要考虑顺序有顺序的解法，不需要考虑顺序又有对应的解法。

        接下来讲一下背包问题的判定
        背包问题具备的特征：给定一个target，target可以是数字也可以是字符串，再给定一个数组nums，nums中装的可能是数字，也可能是字符串，问：能否使用nums中的元素做各种排列组合得到target。

        背包问题技巧：
        1.如果是0-1背包，即数组中的元素不可重复使用，nums放在外循环，target在内循环，且内循环倒序；


        for num in nums:
        for i in range(target, nums-1, -1):
        2.如果是完全背包，即数组中的元素可重复使用，nums放在外循环，target在内循环。且内循环正序。


        for num in nums:
        for i in range(nums, target+1):
        3.如果组合问题需考虑元素之间的顺序，需将target放在外循环，将nums放在内循环。


        for i in range(1, target+1):
        for num in nums:
        代码

class Solution:
        def combinationSum4(self, nums: List[int], target: int) -> int:
        if not nums:
        return 0
        dp = [0] * (target+1)
        dp[0] = 1
        for i in range(1,target+1):
        for num in nums:
        if i >= num:
        dp[i] += dp[i-num]
        return dp[target]
        以上是我对背包问题的总结，希望对你有帮助。要是觉得不错，点个赞吧。

        欢迎关注我的公众号：

        作者：Jackie1995
        链接：https://leetcode-cn.com/problems/combination-sum-iv/solution/xi-wang-yong-yi-chong-gui-lu-gao-ding-bei-bao-wen-/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
/*
【宫水三叶】本题与「完全背包」问题的主要区别
        宫水三叶
        发布于 6 小时前
        2.4k
        动态规划
        本题与「完全背包求方案数」问题的差别在于：选择方案中的不同的物品顺序代表不同方案。

        举个 🌰，在「完全背包」问题中，凑成总价值为 6 的方案 [1,2,3] 算是 11 种方案，但在本题算是 3 * 2 * 1 = 63∗2∗1=6 种方案（[1,2,3],[2,1,3],[3,1,2] ... ）。

        因此我们不能直接代入「完全背包」的思路（状态定义）来求解。

        这时候可以从「构成答案的组合」入手：利用 1 <= nums[i] <= 1000 和 1 <= target <= 1000 条件可以确定，组合长度必然在 [1, 1000][1,1000]。

        定义 f[i][j]f[i][j] 为组合长度为 ii，凑成总和为 jj 的方案数是多少。

        由于对组合方案的长度没有限制，因此我们最终答案为所有的 f[x][target]f[x][target] 的总和。

        同时有显而易见的初始条件（有效值）：f[0][0] = 1f[0][0]=1。

        那么对任意的 f[len][target]f[len][target] 而言，组合中的最后一个数字可以选择 nums 中的任意数值，因此 f[len][target]f[len][target] 应该为以下所有方案总和：

        最后一个数选择 nums[0]，方案数为 f[len - 1][target - nums[0]]f[len−1][target−nums[0]]
        最后一个数选择 nums[1]，方案数为 f[len - 1][target - nums[1]]f[len−1][target−nums[1]]
        最后一个数选择 nums[2]，方案数为 f[len - 1][target - nums[2]]f[len−1][target−nums[2]]
        ...
        即转移方程为：

        f[len][target] = \sum_{i = 0}^{n -1} f[len - 1][target - nums[i]], target \geqslant nums[i]
        f[len][target]=
        i=0
        ∑
        n−1
        ​
        f[len−1][target−nums[i]],target⩾nums[i]

        代码（感谢 @🍭可乐可乐吗QAQ 同学提供的其他语言版本 ）：


class Solution {
    public int combinationSum4(int[] nums, int t) {
        // 因为 nums[i] 最小值为 1，因此构成答案的最大长度为 target
        int len = t;
        int[][] f = new int[len + 1][t + 1];
        f[0][0] = 1;
        int ans = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= t; j++) {
                for (int u : nums) {
                    if (j >= u) f[i][j] += f[i - 1][j - u];
                }
            }
            ans += f[i][t];
        }
        return ans;
    }
}
时间复杂度：O(t^2 * n)O(t
        2
        ∗n)
        空间复杂度：O(t^2)O(t
        2
        )
        动态规划（降维优化）
        我们知道「完全背包」可以通过取消物品维度来实现降维优化。

        本题也可以使用相同手段：定义 f[i]f[i] 为凑成总和为 ii 的方案数是多少。

        由于 nums 的数都是正整数，因此我们有显然的初始化条件 f[0] = 1f[0]=1（代表什么都不选，凑成总和为 0 的方案数为 1），同时最终答案为 f[target]f[target]。

        不失一般性的考虑 f[i]f[i] 该如何转移，由于每个数值可以被选择无限次，因此在计算任意总和时，我们保证 nums 中的每一位都会被考虑到即可（即确保对组合总和 target 的遍历在外，对数组 nums 的遍历在内）。

        即转移方程为：

        f[j] = \sum_{i = 0}^{n -1} f[target - nums[i]], target \geqslant nums[i]
        f[j]=
        i=0
        ∑
        n−1
        ​
        f[target−nums[i]],target⩾nums[i]

        代码（感谢 @🍭可乐可乐吗QAQ 同学提供的其他语言版本 ）：


class Solution {
    public int combinationSum4(int[] nums, int t) {
        int[] f = new int[t + 1];
        f[0] = 1;
        for (int j = 1; j <= t; j++) {
            for (int u : nums) {
                if (j >= u) f[j] += f[j - u];
            }
        }
        return f[t];
    }
}
时间复杂度：O(t * n)O(t∗n)
        空间复杂度：O(t)O(t)
        进阶
        如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？
        如果存在负权值，答案可能会有无穷个。因为本身数值能够被选无限次，一旦存在负权，我们可以构造多个总和为 0 的方案，然后在此方案上构造出 targettarget。

        举个 🌰，考虑如下数据：nums = [-1,1,2] , target = 2，我们构造出无数个总和为 0 的方案：

        [-1,1]
        [-1,1,-1,1]
        [-1,1,-1,1,-1,1]
        ...
        然后在这些方案的基础上，构造出 targettarget 。

        因此，如果允许出现负权，需要增加选择数量的限制。

        可以考虑在二维解决方案的基础上去做，因为本质是一个「图论的有限步数到达具体节点」的问题，当我们期望从状态 f[0][0]f[0][0] 到达 f[m][n]f[m][n]，但是中间存在总权值为 0 的环，那么我们可以通过进入无数次这样的环，来构成无限种方案。因此直接限制进环次数，或者增加总步数限制，就能从无限集合中解脱出来。

        关于溢出说明
        首先 Java 不需要考虑溢出，CPP 需要考虑溢出，绝不是因为测试数据不同，而是两者对于「溢出」处理不同导致。

        由于题目最终答案是 int，因此 Java 不需要用额外操作。

        当 Java 发生溢出时，会直接当成最小负数来处理。这就导致了只要答案最终是 int，所有的溢出会被补偿回来：


        {
        System.out.println(Integer.MIN_VALUE); // -2147483648

        int a = Integer.MAX_VALUE;
        System.out.println(a); // 2147483647
        a += 1;
        System.out.println(a); // -2147483648
        a -= 1;
        System.out.println(a); //2147483647
        }
        这意味着，如果我们在运算过程中如果只涉及「纯加减运算」，而不涉及「乘除」、「取最大值/最小值」和「数值大小判断」的话，Java 是不需要使用 Long 来确保正确性的，因为最终溢出会被转化回来。

        按道理，CPP 本身对于 int 溢出的转化处理也是一样的。

        但在 LC 上的 CPP 发生溢出时，不会直接当做最小负数来处理，而是直接抛出异常。因此同样的代码在 LC 上是无法被正常执行的：


        {
        cout << INT_MIN << endl; //-2147483648

        int a = INT_MAX;
        cout << a << endl; // 2147483647
        a += 1; // 溢出报错
        cout << a << endl;
        a -= 1;
        cout << a << endl;
        }
        这是一般性的，对于 LC 上的同一道题，Java 不需要处理溢出，CPP 需要处理的原因。

        但本题还有另外一个原因：由于状态值是被累加的，最终答案又是 int，所以其实那些溢出值是不会被用到的（不会与我们的目标状态值相关），CPP 使用 ULL 其实只是单纯为了解决溢出报错罢了。*/
