package com.arthur.leetcode;

import javax.xml.stream.FactoryConfigurationError;

/**
 * @title: No79
 * @Author ArthurJi
 * @Date: 2021/3/5 10:41
 * @Version 1.0
 */
public class No79 {
    public static void main(String[] args) {

    }
    public boolean exist(char[][] board, String word) {
        int len = word.length();
        int[][] flag;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                flag = new int[board.length][board[0].length];
                if (dfs(board, word, 0, len, i, j, flag)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(char[][] board, String word, int deep, int len, int i, int j, int[][] flag) {
        if(deep == len) {
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if(flag[i][j] == 1) {
            return false;
        }
        if(board[i][j] == word.charAt(deep)) {
            flag[i][j] = 1;
            if(dfs(board, word, deep + 1, len, i + 1, j, flag) ||
            dfs(board, word, deep + 1, len, i, j + 1, flag) ||
            dfs(board, word, deep + 1, len, i - 1, j, flag) ||
            dfs(board, word, deep + 1, len, i, j - 1, flag)) {
                return true;
            } else {
                flag[i][j] = 0;
            }
        }
        return false;
    }
}

/*79. 单词搜索
        给定一个二维网格和一个单词，找出该单词是否存在于网格中。

        单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。



        示例:

        board =
        [
        ['A','B','C','E'],
        ['S','F','C','S'],
        ['A','D','E','E']
        ]

        给定 word = "ABCCED", 返回 true
        给定 word = "SEE", 返回 true
        给定 word = "ABCB", 返回 false*/
