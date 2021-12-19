package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 甲板上的战舰
 * @title: No419
 * @Author hengmingji
 * @Date: 2021/12/18 15:06
 * @Version 1.0
 */
public class No419 {
    int n = 0;
    static int direction[][] = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public int countBattleships(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    n++;
                    dfs(board, i, j);
                }
            }
        }
        return n;
    }

    private void dfs(char[][] board, int i, int j) {
        if ( i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] == '.') {
            return;
        }
        board[i][j] = '.';
        for (int[] dir : direction) {
            dfs(board, i + dir[0], j + dir[1]);
        }
    }
}
