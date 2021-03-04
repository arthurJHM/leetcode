package com.arthur.leetcode;

/**
 * @title: No494_2
 * @Author ArthurJi
 * @Date: 2021/3/4 15:27
 * @Version 1.0
 */
public class No494_2 {
    public static void main(String[] args) {

    }

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if(S > sum || (sum + S) % 2 == 1) {
            return 0;
        }
        return subsets(nums, (sum + S) / 2);
    }

    private int subsets(int[] nums, int target) {
        int len = nums.length;
        int[][] dp = new int[len + 1][target + 1];
        for (int j = 0; j <= len; j++) {
            dp[j][0] = 1;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= target; j++) {
                if(j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                }
            }
        }
        return dp[len][target];

    }

}
/*
读完本文，你可以去力扣拿下如下题目：

        494.目标和

        我们前文经常说回溯算法和递归算法有点类似，有的问题如果实在想不出状态转移方程，尝试用回溯算法暴力解决也是一个聪明的策略，总比写不出来解法强。

        那么，回溯算法和动态规划到底是啥关系？它俩都涉及递归，算法模板看起来还挺像的，都涉及做「选择」，真的酷似父与子。

        那么，它俩具体有啥区别呢？回溯算法和动态规划之间，是否可能互相转化呢？

        今天就用力扣第 494 题「目标和」来详细对比一下回溯算法和动态规划，真可谓群魔乱舞：



        注意，给出的例子 nums 全是 1，但实际上可以是任意正整数哦。

        一、回溯思路
        其实我第一眼看到这个题目，花了两分钟就写出了一个回溯解法。

        任何算法的核心都是穷举，回溯算法就是一个暴力穷举算法


        def backtrack(路径, 选择列表):
        if 满足结束条件:
        result.add(路径)
        return

        for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
        关键就是搞清楚什么是「选择」，而对于这道题，「选择」不是明摆着的吗？对于每个数字 nums[i]，我们可以选择给一个正号 + 或者一个负号 -，然后利用回溯模板穷举出来所有可能的结果，数一数到底有几种组合能够凑出 target 不就行了嘛？

        伪码思路如下：


        def backtrack(nums, i):
        if i == len(nums):
        if 达到 target:
        result += 1
        return

        for op in { +1, -1 }:
        选择 op * nums[i]
        # 穷举 nums[i + 1] 的选择
        backtrack(nums, i + 1)
        撤销选择
        如果看过我们之前的几篇回溯算法文章，这个代码可以说是比较简单的了：


        int result = 0;

        *//* 主函数 *//*
        int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) return 0;
        backtrack(nums, 0, target);
        return result;
        }

        *//* 回溯算法模板 *//*
        void backtrack(int[] nums, int i, int rest) {
        // base case
        if (i == nums.length) {
        if (rest == 0) {
        // 说明恰好凑出 target
        result++;
        }
        return;
        }
        // 给 nums[i] 选择 - 号
        rest += nums[i];
        // 穷举 nums[i + 1]
        backtrack(nums, i + 1, rest);
        // 撤销选择
        rest -= nums[i];

        // 给 nums[i] 选择 + 号
        rest -= nums[i];
        // 穷举 nums[i + 1]
        backtrack(nums, i + 1, rest);
        // 撤销选择
        rest += nums[i];
        }
        有的读者可能问，选择 - 的时候，为什么是 rest += nums[i]，选择 + 的时候，为什么是 rest -= nums[i] 呢，是不是写反了？

        不是的，「如何凑出 target」和「如何把 target 减到 0」其实是一样的。我们这里选择后者，因为前者必须给 backtrack 函数多加一个参数，我觉得不美观：


        void backtrack(int[] nums, int i, int sum, int target) {
        // base case
        if (i == nums.length) {
        if (sum == target) {
        result++;
        }
        return;
        }
        // ...
        }
        因此，如果我们给 nums[i] 选择 + 号，就要让 rest - nums[i]，反之亦然。

        以上回溯算法可以解决这个问题，时间复杂度为 O(2^N)，N 为 nums 的大小。这个复杂度怎么算的？回忆学习数据结构和算法的框架思维，发现这个回溯算法就是个二叉树的遍历问题：


        void backtrack(int[] nums, int i, int rest) {
        if (i == nums.length) {
        return;
        }
        backtrack(nums, i + 1, rest - nums[i]);
        backtrack(nums, i + 1, rest + nums[i]);
        }
        树的高度就是 nums 的长度嘛，所以说时间复杂度就是这棵二叉树的节点数，为 O(2^N)，其实是非常低效的。

        那么，这个问题如何用动态规划思想进行优化呢？

        二、消除重叠子问题
        动态规划之所以比暴力算法快，是因为动态规划技巧消除了重叠子问题。

        如何发现重叠子问题？看是否可能出现重复的「状态」。对于递归函数来说，函数参数中会变的参数就是「状态」，对于 backtrack 函数来说，会变的参数为 i 和 rest。

        动态规划之编辑距离说了一种一眼看出重叠子问题的方法，先抽象出递归框架：


        void backtrack(int i, int rest) {
        backtrack(i + 1, rest - nums[i]);
        backtrack(i + 1, rest + nums[i]);
        }
        举个简单的例子，如果 nums[i] = 0，会发生什么？


        void backtrack(int i, int rest) {
        backtrack(i + 1, rest);
        backtrack(i + 1, rest);
        }
        你看，这样就出现了两个「状态」完全相同的递归函数，无疑这样的递归计算就是重复的。这就是重叠子问题，而且只要我们能够找到一个重叠子问题，那一定还存在很多的重叠子问题。

        因此，状态 (i, rest) 是可以用备忘录技巧进行优化的：


        int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) return 0;
        return dp(nums, 0, target);
        }

// 备忘录
        HashMap<String, Integer> memo = new HashMap<>();
        int dp(int[] nums, int i, int rest) {
        // base case
        if (i == nums.length) {
        if (rest == 0) return 1;
        return 0;
        }
        // 把它俩转成字符串才能作为哈希表的键
        String key = i + "," + rest;
        // 避免重复计算
        if (memo.containsKey(key)) {
        return memo.get(key);
        }
        // 还是穷举
        int result = dp(nums, i + 1, rest - nums[i]) + dp(nums, i + 1, rest + nums[i]);
        // 记入备忘录
        memo.put(key, result);
        return result;
        }
        以前我们都是用 Python 的元组配合哈希表 dict 来做备忘录的，其他语言没有元组，可以用把「状态」转化为字符串作为哈希表的键，这是一个常用的小技巧。

        这个解法通过备忘录消除了很多重叠子问题，效率有一定的提升，但是这就结束了吗？

        三、动态规划
        事情没有这么简单，先来算一算，消除重叠子问题之后，算法的时间复杂度是多少？其实最坏情况下依然是 O(2^N)。

        为什么呢？因为我们只不过恰好发现了重叠子问题，顺手用备忘录技巧给优化了，但是底层思路没有变，依然是暴力穷举的回溯算法，依然在遍历一棵二叉树。这只能叫对回溯算法进行了「剪枝」，提升了算法在某些情况下的效率，但算不上质的飞跃。

        其实，这个问题可以转化为一个子集划分问题，而子集划分问题又是一个典型的背包问题。动态规划总是这么玄学，让人摸不着头脑……

        首先，如果我们把 nums 划分成两个子集 A 和 B，分别代表分配 + 的数和分配 - 的数，那么他们和 target 存在如下关系：


        sum(A) - sum(B) = target
        sum(A) = target + sum(B)
        sum(A) + sum(A) = target + sum(B) + sum(A)
        2 * sum(A) = target + sum(nums)
        综上，可以推出 sum(A) = (target + sum(nums)) / 2，也就是把原问题转化成：nums 中存在几个子集 A，使得 A 中元素的和为 (target + sum(nums)) / 2？

        类似的子集划分问题，现在实现这么一个函数：


        *//* 计算 nums 中有几个子集的和为 sum *//*
        int subsets(int[] nums, int sum) {}
        然后，可以这样调用这个函数：


        int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) sum += n;
        // 这两种情况，不可能存在合法的子集划分
        if (sum < target || (sum + target) % 2 == 1) {
        return 0;
        }
        return subsets(nums, (sum + target) / 2);
        }
        好的，变成背包问题的标准形式：

        有一个背包，容量为 sum，现在给你 N 个物品，第 i 个物品的重量为 nums[i - 1]（注意 1 <= i <= N），每个物品只有一个，请问你有几种不同的方法能够恰好装满这个背包？

        现在，这就是一个正宗的动态规划问题了，下面按照我们一直强调的动态规划套路走流程：

        第一步要明确两点，「状态」和「选择」。

        对于背包问题，这个都是一样的，状态就是「背包的容量」和「可选择的物品」，选择就是「装进背包」或者「不装进背包」。

        第二步要明确 dp 数组的定义。

        按照背包问题的套路，可以给出如下定义：

        dp[i][j] = x 表示，若只在前 i 个物品中选择，若当前背包的容量为 j，则最多有 x 种方法可以恰好装满背包。

        翻译成我们探讨的子集问题就是，若只在 nums 的前 i 个元素中选择，若目标和为 j，则最多有 x 种方法划分子集。

        根据这个定义，显然 dp[0][..] = 0，因为没有物品的话，根本没办法装背包；dp[..][0] = 1，因为如果背包的最大载重为 0，「什么都不装」就是唯一的一种装法。

        我们所求的答案就是 dp[N][sum]，即使用所有 N 个物品，有几种方法可以装满容量为 sum 的背包。

        第三步，根据「选择」，思考状态转移的逻辑。

        回想刚才的 dp 数组含义，可以根据「选择」对 dp[i][j] 得到以下状态转移：

        如果不把 nums[i] 算入子集，或者说你不把这第 i 个物品装入背包，那么恰好装满背包的方法数就取决于上一个状态 dp[i-1][j]，继承之前的结果。

        如果把 nums[i] 算入子集，或者说你把这第 i 个物品装入了背包，那么只要看前 i - 1 个物品有几种方法可以装满 j - nums[i-1] 的重量就行了，所以取决于状态 dp[i-1][j-nums[i-1]]。

        PS：注意我们说的 i 是从 1 开始算的，而数组 nums 的索引时从 0 开始算的，所以 nums[i-1] 代表的是第 i 个物品的重量，j - nums[i-1] 就是背包装入物品 i 之后还剩下的容量。

        由于 dp[i][j] 为装满背包的总方法数，所以应该以上两种选择的结果求和，得到状态转移方程：


        dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
        然后，根据状态转移方程写出动态规划算法：


        *//* 计算 nums 中有几个子集的和为 sum *//*
        int subsets(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];
        // base case
        for (int i = 0; i <= n; i++) {
        dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
        for (int j = 0; j <= sum; j++) {
        if (j >= nums[i-1]) {
        // 两种选择的结果之和
        dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
        } else {
        // 背包的空间不足，只能选择不装物品 i
        dp[i][j] = dp[i-1][j];
        }
        }
        }
        return dp[n][sum];
        }
        然后，发现这个 dp[i][j] 只和前一行 dp[i-1][..] 有关，那么肯定可以优化成一维 dp：


        *//* 计算 nums 中有几个子集的和为 sum *//*
        int subsets(int[] nums, int sum) {
        int n = nums.length;
        int[] dp = new int[sum + 1];
        // base case
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
        // j 要从后往前遍历
        for (int j = sum; j >= 0; j--) {
        // 状态转移方程
        if (j >= nums[i-1]) {
        dp[j] = dp[j] + dp[j-nums[i-1]];
        } else {
        dp[j] = dp[j];
        }
        }
        }
        return dp[sum];
        }
        对照二维 dp，只要把 dp 数组的第一个维度全都去掉就行了，唯一的区别就是这里的 j 要从后往前遍历，原因如下：

        因为二维压缩到一维的根本原理是，dp[j] 和 dp[j-nums[i-1]] 还没被新结果覆盖的时候，相当于二维 dp 中的 dp[i-1][j] 和 dp[i-1][j-nums[i-1]]。

        那么，我们就要做到：在计算新的 dp[j] 的时候，dp[j] 和 dp[j-nums[i-1]] 还是上一轮外层 for 循环的结果。

        如果你从前往后遍历一维 dp 数组，dp[j] 显然是没问题的，但是 dp[j-nums[i-1]] 已经不是上一轮外层 for 循环的结果了，这里就会使用错误的状态，当然得不到正确的答案。

        作者：labuladong
        链接：https://leetcode-cn.com/problems/target-sum/solution/dong-tai-gui-hua-he-hui-su-suan-fa-dao-di-shui-shi/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
/*

弄懂题意
        第一步需要根据题意考虑输出的结构，在【416.分割等和子集】这道题中，要求的输出结果就是boolean值，因此我们定义的dp数组只需要记录T/F即可，但是这道题要求返回结果是方法数，那么我们dp数组需要记录的数据就是具体的方法数。

        定义状态
        搞清楚需要输出的结果后，就可以来想办法画一个表格，也就是定义dp数组的含义。根据背包问题的经验，可以将dp[ i ][ j ]定义为从数组nums中 0 - i 的元素进行加减可以得到 j 的方法数量。

        状态转移方程
        搞清楚状态以后，我们就可以根据状态去考虑如何根据子问题的转移从而得到整体的解。这道题的关键不是nums[i]的选与不选，而是nums[i]是加还是减，那么我们就可以将方程定义为：

        dp[ i ][ j ] = dp[ i - 1 ][ j - nums[ i ] ] + dp[ i - 1 ][ j + nums[ i ] ]
        可以理解为nums[i]这个元素我可以执行加，还可以执行减，那么我dp[i][j]的结果值就是加/减之后对应位置的和。

        dp数组的定义
        一般背包问题的定义都是dp[len][t+1]。而我一开始基于这个出发就进入了一个误区。下图是我刚开始在本子上画的表格，在计算到第二行的时候就发现不对了，在取值 i=1也就是第二行的时候，很明显[1,1]会有两种得到0的方法，但是我根据上面的方程来算的话，这个dp[1][0]应该等于1才对，百思不得其解，后来我去官方题解确认了下我状态转移方程的正确性，发现并没有问题，我只能接着画图，思考这个多出来的1应该在哪儿？


        打表格
        后来前前后后又读了几遍题目，发现我上面那个表格只画了每个元素执行加法的部分，而忽略了执行减法的部分，整个表格区域应该是分为三部分：-/0/+。那么对应的表格的每一行的长度t就可以表示为：t=(sum*2)+1，其中一个sum表示nums中执行全部执行加/减能达到的数，而加的1显然是中间的0.具体表格如下图所示：


        那么上面红色部分为什么得2也说的通了，因为忽略了负数部分的那个1，加上负数部分以后就可以得到正确的结果了。而绿色部分的表格值就是我们本题的解。dp表示为：dp[len - 1][sum + s]。

        初始化
        这道题有个坑的地方，就是nums[0]可能等于0，这样初始化dp数组第一行的时候很可能踩坑，因为如果nums[0]==0那么dp[0][sum]需要初始化为2，因为加减0都得0。具体代码如下：


public static int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        }
        // 绝对值范围超过了sum的绝对值范围则无法得到
        if (Math.abs(s) > Math.abs(sum)) return 0;

        int len = nums.length;
        // - 0 +
        int t = sum * 2 + 1;
        int[][] dp = new int[len][t];
        // 初始化
        if (nums[0] == 0) {
        dp[0][sum] = 2;
        } else {
        dp[0][sum + nums[0]] = 1;
        dp[0][sum - nums[0]] = 1;
        }

        for (int i = 1; i < len; i++) {
        for (int j = 0; j < t; j++) {
        // 边界
        int l = (j - nums[i]) >= 0 ? j - nums[i] : 0;
        int r = (j + nums[i]) < t ? j + nums[i] : 0;
        dp[i][j] = dp[i - 1][l] + dp[i - 1][r];
        }
        }
        return dp[len - 1][sum + s];
        }

        以上代码都是按照题解的思路一步一步写的，无论是空间还是时间都有很大的优化空间，不过我这里只打算提供一个思路，具体的优化就不写啦~感谢各位能看到这里，如果发现哪里有误多多包涵，欢迎指正。

        作者：keepal
        链接：https://leetcode-cn.com/problems/target-sum/solution/dong-tai-gui-hua-si-kao-quan-guo-cheng-by-keepal/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
