package com.arthur.leetcode;

/**
 * @title: No289
 * @Author ArthurJi
 * @Date: 2021/4/5 12:20
 * @Version 1.0
 */
public class No289 {
    public static void main(String[] args) {

    }

    public void gameOfLife(int[][] board) {
        int[] dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};

        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int num = 0;
                for (int k = 0; k < 8; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx >= 0 && nx < row && ny >= 0 && ny < col) {
                        if((board[nx][ny] & 1) == 1) {
                            num++;
                        }
                    }
                }
                if((board[i][j] & 1) == 1) {
                    if(num == 2 || num == 3) {
                        board[i][j] |= 2;
                    }
                } else if(num == 3) {
                    board[i][j] |= 2;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}
/*
一个 int 有 32 bit，输入数据只用了一个 bit，所以我们可以利用其他空闲的bit位进行“原地修改”。
        具体的位运算操作可以查看代码注释。


class Solution {
    public:
    void gameOfLife(vector<vector<int>>& board) {
        int dx[] = {-1,  0,  1, -1, 1, -1, 0, 1};
        int dy[] = {-1, -1, -1,  0, 0,  1, 1, 1};

        for(int i = 0; i < board.size(); i++) {
            for(int j = 0 ; j < board[0].size(); j++) {
                int sum = 0;
                for(int k = 0; k < 8; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx >= 0 && nx < board.size() && ny >= 0 && ny < board[0].size()) {
                        sum += (board[nx][ny]&1); // 只累加最低位
                    }
                }
                if(board[i][j] == 1) {
                    if(sum == 2 || sum == 3) {
                        board[i][j] |= 2;  // 使用第二个bit标记是否存活
                    }
                } else {
                    if(sum == 3) {
                        board[i][j] |= 2; // 使用第二个bit标记是否存活
                    }
                }
            }
        }
        for(int i = 0; i < board.size(); i++) {
            for(int j = 0; j < board[i].size(); j++) {
                board[i][j] >>= 1; //右移一位，用第二bit覆盖第一个bit。
            }
        }
    }
};


如果感觉有点意思，加个反手一个赞吧~

        作者：Time-Limit
        链接：https://leetcode-cn.com/problems/game-of-life/solution/c-wei-yun-suan-yuan-di-cao-zuo-ji-bai-shuang-bai-b/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
