package com.arthur.leetcode;

import com.sun.prism.j2d.J2DPipeline;

import javax.print.attribute.standard.JobSheets;

/**
 * @title: No1723
 * @Author ArthurJi
 * @Date: 2021/5/8 9:13
 * @Version 1.0
 */
public class No1723 {
    public static void main(String[] args) {

    }

    private int k_;
    int[] jobs_;
    private int ans = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        int u = 0;
        int used = 0;
        k_ = k;
        jobs_ = jobs;
        int[] sum = new int[jobs.length];
        int max = 0;
        dfs(u, used, sum, max);
        return ans;
    }

    /*
     * @Date: 2021/5/8 9:27
     * Step   /**
     * u     : 当前处理到那个 job
     * used  : 当前分配给了多少个工人了
     * sum   : 工人的分配情况          例如：sum[0] = x 代表 0 号工人工作量为 x
     * max   : 当前的「最大工作时间
     */
    void dfs(int u, int used, int[] sum, int max) {
        if(max >= ans) {
            return;
        }
        if(u == sum.length) {
            ans = max;
            return;
        }
        if(used < k_) {
            sum[used] = jobs_[u];
            dfs(u + 1, used + 1, sum, Math.max(sum[used], max));
            sum[used] = 0;
        }
        for (int i = 0; i < used; i++) {
            sum[i] += jobs_[u];
            dfs(u + 1, used, sum, Math.max(max, sum[i]));
            sum[i] -= jobs_[u];
        }
    }
}



/*1723. 完成所有工作的最短时间
        给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。

        请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。

        返回分配方案中尽可能 最小 的 最大工作时间 。



        示例 1：

        输入：jobs = [3,2,3], k = 3
        输出：3
        解释：给每位工人分配一项工作，最大工作时间是 3 。
        示例 2：

        输入：jobs = [1,2,4,7,8], k = 2
        输出：11
        解释：按下述方式分配工作：
        1 号工人：1、2、8（工作时间 = 1 + 2 + 8 = 11）
        2 号工人：4、7（工作时间 = 4 + 7 = 11）
        最大工作时间是 11 。*/
/*
优先分配「空闲工人」的 DFS
        那么 DFS 就没法过了吗？

        除了 max >= ans 以外，我们还要做些别的剪枝吗？

        我们可以重新审视一下这道题。

        题目其实是让我们将 nn 个数分为 kk 份，并且尽可能让 kk 份平均。这样的「最大工作时间」才是最小的。

        但在朴素的 DFS 中，我们是将每个任务依次分给每个工人，并递归此过程。

        对应的递归树其实是一颗高度为 nn 的 kk 阶树。

        所以其实我们第一次更新的 ans 其实是「最差」的答案（所有的任务都会分配给 00 号工人），最差的 ans 为所有的 job 的总和（带编号的方块代表工人）:



        因此我们朴素版的 DFS 其实是弱化了 max >= ans 剪枝效果的。

        那么想要最大化剪枝效果，并且尽量让 kk 份平均的话，我们应当调整我们对于「递归树」的搜索方向：将任务优先分配给「空闲工人」（带编号的方块代表工人）：



        树还是那颗树，但是搜索调整分配优先级后，我们可以在首次取得一个「较好」的答案，来增强我们的 max >= ans 剪枝效益。

        事实上，当做完这个调整，我们能实现从 TLE 到 99% 的提升 🤣 🤣



        代码：

        Java

class Solution {
    int[] jobs;
    int n, k;
    int ans = 0x3f3f3f3f;
    public int minimumTimeRequired(int[] _jobs, int _k) {
        jobs = _jobs;
        n = jobs.length;
        k = _k;
        int[] sum = new int[k];
        dfs(0, 0, sum, 0);
        return ans;
    }
    */
/**
     * u     : 当前处理到那个 job
     * used  : 当前分配给了多少个工人了
     * sum   : 工人的分配情况          例如：sum[0] = x 代表 0 号工人工作量为 x
     * max   : 当前的「最大工作时间」
     *//*

    void dfs(int u, int used, int[] sum, int max) {
        if (max >= ans) return;
        if (u == n) {
            ans = max;
            return;
        }
        // 优先分配给「空闲工人」
        if (used < k) {
            sum[used] = jobs[u];
            dfs(u + 1, used + 1, sum, Math.max(sum[used], max));
            sum[used] = 0;
        }
        for (int i = 0; i < used; i++) {
            sum[i] += jobs[u];
            dfs(u + 1, used, sum, Math.max(sum[i], max));
            sum[i] -= jobs[u];
        }
    }
}
时间复杂度：O(k^n)O(k
        n
        )
        空间复杂度：O(k)O(k)

        作者：AC_OIer
        链接：https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs/solution/gong-shui-san-xie-yi-ti-shuang-jie-jian-4epdd/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
