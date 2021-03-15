package com.arthur.leetcodeWeeklyContest.No232Week;

/**
 * @title: No2
 * @Author ArthurJi
 * @Date: 2021/3/14 10:45
 * @Version 1.0
 */
public class No2 {
    public int findCenter(int[][] edges) {
        if(edges[0][1] == edges[1][1]) {
            return edges[0][1];
        }
        if(edges[0][0] == edges[1][0]) {
            return edges[0][0];
        }
        if(edges[0][1] == edges[1][0]) {
            return edges[0][1];
        }
        if(edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }
        return 0;
    }
}
/*5702. 找出星型图的中心节点 显示英文描述
        通过的用户数1335
        尝试过的用户数1376
        用户总通过次数1338
        用户总提交次数1502
        题目难度Medium
        有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。

        给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回 edges 所表示星型图的中心节点。



        示例 1：


        输入：edges = [[1,2],[2,3],[4,2]]
        输出：2
        解释：如上图所示，节点 2 与其他每个节点都相连，所以节点 2 是中心节点。
        示例 2：

        输入：edges = [[1,2],[5,1],[1,3],[1,4]]
        输出：1*/
