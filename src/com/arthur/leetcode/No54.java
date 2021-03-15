package com.arthur.leetcode;

import com.sun.javafx.font.directwrite.DWFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: No54
 * @Author ArthurJi
 * @Date: 2021/3/15 9:21
 * @Version 1.0
 */
public class No54 {
    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = col - 1;
        int top = 0;
        int down = row - 1;
        ArrayList<Integer> ans = new ArrayList<>();
        while (true) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            if(top++ == down) break;

            for (int i = top; i <= down; i++) {
                ans.add(matrix[i][right]);
            }
            if(right-- == left) break;

            for (int i = right; i >= left; i--) {
                ans.add(matrix[down][i]);
            }
            if(down-- == top) break;

            for (int i = down; i >= top; i--) {
                ans.add(matrix[i][left]);
            }
            if(left++ == right) break;
        }
        return ans;
    }
}

/*
54. 螺旋矩阵
        给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。



        示例 1：


        输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        输出：[1,2,3,6,9,8,7,4,5]
        示例 2：


        输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        输出：[1,2,3,4,8,12,11,10,9,5,6,7]

*/
/*
这里的方法不需要记录已经走过的路径，所以执行用时和内存消耗都相对较小

        首先设定上下左右边界
        其次向右移动到最右，此时第一行因为已经使用过了，可以将其从图中删去，体现在代码中就是重新定义上边界
        判断若重新定义后，上下边界交错，表明螺旋矩阵遍历结束，跳出循环，返回答案
        若上下边界不交错，则遍历还未结束，接着向下向左向上移动，操作过程与第一，二步同理
        不断循环以上步骤，直到某两条边界交错，跳出循环，返回答案
        C++

class Solution {
    public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector <int> ans;
        if(matrix.empty()) return ans; //若数组为空，直接返回答案
        int u = 0; //赋值上下左右边界
        int d = matrix.size() - 1;
        int l = 0;
        int r = matrix[0].size() - 1;
        while(true)
        {
            for(int i = l; i <= r; ++i) ans.push_back(matrix[u][i]); //向右移动直到最右
            if(++ u > d) break; //重新设定上边界，若上边界大于下边界，则遍历遍历完成，下同
            for(int i = u; i <= d; ++i) ans.push_back(matrix[i][r]); //向下
            if(-- r < l) break; //重新设定有边界
            for(int i = r; i >= l; --i) ans.push_back(matrix[d][i]); //向左
            if(-- d < u) break; //重新设定下边界
            for(int i = d; i >= u; --i) ans.push_back(matrix[i][l]); //向上
            if(++ l > r) break; //重新设定左边界
        }
        return ans;
    }
};

作者：youlookdeliciousc
        链接：https://leetcode-cn.com/problems/spiral-matrix/solution/cxiang-xi-ti-jie-by-youlookdeliciousc-3/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
