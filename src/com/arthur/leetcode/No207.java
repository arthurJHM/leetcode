package com.arthur.leetcode;

import java.util.*;

/**
 * @title: No207
 * @Author ArthurJi
 * @Date: 2021/2/22 14:46
 * @Version 1.0
 */
public class No207 {
    public static void main(String[] args) {
        System.out.println(new No207().canFinish(2, new int[][]{{0, 1}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> temp = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            List<Integer> list = new ArrayList<>();
            temp.add(list);
        }
        for (int[] prerequisite : prerequisites) {
            temp.get(prerequisite[1]).add(prerequisite[0]);
            indegrees[prerequisite[0]]++;
        }
        for (int i = 0; i < indegrees.length; i++) {
            if(indegrees[i] == 0) {
                deque.addLast(i);
            }
        }
        while (!deque.isEmpty()) {
            Integer pre = deque.poll();
            numCourses--;
            for (Integer in : temp.get(pre)) {
                if(--indegrees[in] == 0) {
                    deque.addLast(in);
                }
            }
        }
        return numCourses == 0;
    }
}

/*

方法一：入度表（广度优先遍历）
        算法流程：
        统计课程安排图中每个节点的入度，生成 入度表 indegrees。
        借助一个队列 queue，将所有入度为 00 的节点入队。
        当 queue 非空时，依次将队首节点出队，在课程安排图中删除此节点 pre：
        并不是真正从邻接表中删除此节点 pre，而是将此节点对应所有邻接节点 cur 的入度 -1−1，即 indegrees[cur] -= 1。
        当入度 -1−1后邻接节点 cur 的入度为 00，说明 cur 所有的前驱节点已经被 “删除”，此时将 cur 入队。
        在每次 pre 出队时，执行 numCourses--；
        若整个课程安排图是有向无环图（即可以安排），则所有节点一定都入队并出队过，即完成拓扑排序。换个角度说，若课程安排图中存在环，一定有节点的入度始终不为 00。
        因此，拓扑排序出队次数等于课程个数，返回 numCourses == 0 判断课程是否可以成功安排。
        复杂度分析：
        时间复杂度 O(N + M)O(N+M)： 遍历一个图需要访问所有节点和所有临边，NN 和 MM 分别为节点数量和临边数量；
        空间复杂度 O(N + M)O(N+M)： 为建立邻接表所需额外空间，adjacency 长度为 NN ，并存储 MM 条临边的数据。

        1 / 6

        代码：
        pythonjava

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        // Get the indegree and adjacency of every course.
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        // Get all the courses with the indegree of 0.
        for(int i = 0; i < numCourses; i++)
            if(indegrees[i] == 0) queue.add(i);
        // BFS TopSort.
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for(int cur : adjacency.get(pre))
                if(--indegrees[cur] == 0) queue.add(cur);
        }
        return numCourses == 0;
    }
}
方法二：深度优先遍历
        原理是通过 DFS 判断图中是否有环。

        算法流程：
        借助一个标志列表 flags，用于判断每个节点 i （课程）的状态：
        未被 DFS 访问：i == 0；
        已被其他节点启动的 DFS 访问：i == -1；
        已被当前节点启动的 DFS 访问：i == 1。
        对 numCourses 个节点依次执行 DFS，判断每个节点起步 DFS 是否存在环，若存在环直接返回 FalseFalse。DFS 流程；
        终止条件：
        当 flag[i] == -1，说明当前访问节点已被其他节点启动的 DFS 访问，无需再重复搜索，直接返回 TrueTrue。
        当 flag[i] == 1，说明在本轮 DFS 搜索中节点 i 被第 22 次访问，即 课程安排图有环 ，直接返回 FalseFalse。
        将当前访问节点 i 对应 flag[i] 置 11，即标记其被本轮 DFS 访问过；
        递归访问当前节点 i 的所有邻接节点 j，当发现环直接返回 FalseFalse；
        当前节点所有邻接节点已被遍历，并没有发现环，则将当前节点 flag 置为 -1−1 并返回 TrueTrue。
        若整个图 DFS 结束并未发现环，返回 TrueTrue。
        复杂度分析：
        时间复杂度 O(N + M)O(N+M)： 遍历一个图需要访问所有节点和所有临边，NN 和 MM 分别为节点数量和临边数量；
        空间复杂度 O(N + M)O(N+M)： 为建立邻接表所需额外空间，adjacency 长度为 NN ，并存储 MM 条临边的数据。

        1 / 10

        代码：
        pythonjava

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        int[] flags = new int[numCourses];
        for(int[] cp : prerequisites)
            adjacency.get(cp[1]).add(cp[0]);
        for(int i = 0; i < numCourses; i++)
            if(!dfs(adjacency, flags, i)) return false;
        return true;
    }
    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if(flags[i] == 1) return false;
        if(flags[i] == -1) return true;
        flags[i] = 1;
        for(Integer j : adjacency.get(i))
            if(!dfs(adjacency, flags, j)) return false;
        flags[i] = -1;
        return true;
    }
}

作者：jyd
        链接：https://leetcode-cn.com/problems/course-schedule/solution/course-schedule-tuo-bu-pai-xu-bfsdfsliang-chong-fa/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
