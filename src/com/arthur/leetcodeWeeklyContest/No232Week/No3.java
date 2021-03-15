package com.arthur.leetcodeWeeklyContest.No232Week;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @title: No3
 * @Author ArthurJi
 * @Date: 2021/3/14 10:50
 * @Version 1.0
 */
public class No3 {
    private class pair {
        float first;
        float second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public float getFirst() {
            return first;
        }


        public float getSecond() {
            return second;
        }


        public void addFirst() {
            this.first++;
        }

        public void addSecond() {
            this.second++;
        }

        public double get() {
            return this.first / this.second;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = 0;
        PriorityQueue<pair> queue = new PriorityQueue<>(new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return ((o1.getFirst() + 1.0) / (o1.getSecond() + 1.0) - o1.getFirst() / o1.getSecond() - ((o2.getFirst() + 1) / (o2.getSecond() + 1) - o2.getFirst() / o2.getSecond())) < 0 ? 1 : -1;
            }
        });

        for (int i = 0; i < classes.length; i++) {
            queue.add(new pair(classes[i][0], classes[i][1]));
        }
        while (n < extraStudents) {
            pair poll = queue.poll();
            poll.addFirst();
            poll.addSecond();
            queue.offer(poll);
            n++;
        }
        double ans = 0.0;
        for (int i = 0; i < classes.length; i++) {
            ans += queue.poll().get();
        }
        return ans / classes.length;
    }
}
/*

5703. 最大平均通过率 显示英文描述
        通过的用户数90
        尝试过的用户数113
        用户总通过次数89
        用户总提交次数123
        题目难度Medium
        一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。给你一个二维数组 classes ，其中 classes[i] = [passi, totali] ，表示你提前知道了第 i 个班级总共有 totali 个学生，其中只有 passi 个学生可以通过考试。

        给你一个整数 extraStudents ，表示额外有 extraStudents 个聪明的学生，他们 一定 能通过任何班级的期末考。你需要给这 extraStudents 个学生每人都安排一个班级，使得 所有 班级的 平均 通过率 最大 。

        一个班级的 通过率 等于这个班级通过考试的学生人数除以这个班级的总人数。平均通过率 是所有班级的通过率之和除以班级数目。

        请你返回在安排这 extraStudents 个学生去对应班级后的 最大 平均通过率。与标准答案误差范围在 10-5 以内的结果都会视为正确结果。



        示例 1：

        输入：classes = [[1,2],[3,5],[2,2]], extraStudents = 2
        输出：0.78333
        解释：你可以将额外的两个学生都安排到第一个班级，平均通过率为 (3/4 + 3/5 + 2/2) / 3 = 0.78333 。
        示例 2：

        输入：classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
        输出：0.53485
*/
