package com.arthur.leetcode;

import java.util.ArrayDeque;

/**
 * @title: No85
 * @Author ArthurJi
 * @Date: 2021/4/3 20:31
 * @Version 1.0
 */
public class No85 {
    public static void main(String[] args) {
        new No85().maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
    }

    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if(row == 0) {
            return 0;
        }
        int col = matrix[0].length;

        int[] heights = new int[col + 2];

        int max = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    heights[j + 1]++;
                } else {
                    heights[j + 1] = 0;
                }
            }
            max = Math.max(max, maxRow(heights));
        }
        return max;
    }

    private int maxRow(int[] heights) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.add(0);
        int ans = 0;
        for (int i = 1; i < heights.length; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                Integer cur = stack.pollLast();
                ans = Math.max(ans, (i - stack.peekLast() - 1) * heights[cur]);
            }
            stack.addLast(i);
        }
        return ans;
    }
}
/*
85. 最大矩形
        给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。



        示例 1：


        输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
        输出：6
        解释：最大矩形如上图所示。
        示例 2：

        输入：matrix = []
        输出：0
        示例 3：

        输入：matrix = [["0"]]
        输出：0
        示例 4：

        输入：matrix = [["1"]]
        输出：1
        示例 5：

        输入：matrix = [["0","0"]]
        输出：0


        提示：

        rows == matrix.length
        cols == matrix[0].length
        0 <= row, cols <= 200
        matrix[i][j] 为 '0' 或 '1'*/
/*
【最大矩形】单调栈入门课后练习，将题目难度降为 84
        Ikaruga
        发布于 2020-12-26
        4.2k
        思路
        如果只有一行，把每个格子中的数据看成是高度，那么就是 [84. 柱状图中最大的矩形]
        如果只有两行，我想得到第二行中所有数据的高度
        第二行中数据是 1 ，如果上面第一行也是 1 ，高度就是 2 ，否则是 1
        第二行中数据是 0 ，那么不管第一行是什么，高度都是 0
        因此，遍历每一行时，都能够得到以这一行为底的带高度的数组
        将其代入 【柱状图中最大的矩形】单调栈入门，使用单调栈快速寻找边界 的代码中进行计算，手动狗头
        记录最大值得到答案
        答题

class Solution {
    public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        if (matrix.empty()) return 0;
        int ans = 0;
        vector<int> line(matrix[0].size() + 2, 0);
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix[0].size(); j++) {
                line[j + 1] = (matrix[i][j] == '0') ? 0 : line[j + 1] + 1;
            }
            ans = max(ans, largestRectangleArea(line));
        }
        return ans;
    }

    int largestRectangleArea(vector<int>& heights) {
        int ans = 0;
        vector<int> st;
        // heights.insert(heights.begin(), 0);
        // heights.push_back(0);
        for (int i = 0; i < heights.size(); i++) {
            while (!st.empty() && heights[st.back()] > heights[i]) {
                int cur = st.back();
                st.pop_back();
                int left = st.back() + 1;
                int right = i - 1;
                ans = max(ans, (right - left + 1) * heights[cur]);
            }
            st.push_back(i);
        }
        return ans;
    }
};
致谢
        感谢您的观看，希望对您有帮助，欢迎热烈的交流！

        如果感觉还不错就点个赞吧~

        在 我的力扣个人主页 中有我使用的做题助手项目链接，帮助我收集整理题目，可以方便的 visual studio 调试，欢迎关注，star*/
