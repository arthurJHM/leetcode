package com.arthur.leetcode;

import javax.xml.stream.FactoryConfigurationError;

/**
 * @program: leetcode
 * @description: 矩阵中的路径
 * @title: JZoffer12
 * @Author hengmingji
 * @Date: 2021/12/30 17:42
 * @Version 1.0
 */
public class JZoffer12 {
    int height;
    int width;

    public boolean exist(char[][] board, String word) {
        height = board.length;
        width = board[0].length;
        char[] chars = word.toCharArray();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, chars, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] word, int k) {
        if (i < 0 || i >= height || j < 0 || j >= width || board[i][j] != word[k]){
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean ans = dfs(board, i + 1, j, word, k + 1) || dfs(board, i - 1, j, word, k + 1) || dfs(board, i, j + 1, word, k + 1) || dfs(board, i, j - 1, word, k + 1);
        board[i][j] = word[k];
        return ans;
    }
}
