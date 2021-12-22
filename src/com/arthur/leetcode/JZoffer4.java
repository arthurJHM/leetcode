package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 二维数组中的查找
 * @title: JZoffer4
 * @Author hengmingji
 * @Date: 2021/12/21 13:44
 * @Version 1.0
 */
public class JZoffer4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int h = matrix.length;
        if(h == 0){
            return false;
        }
        int w = matrix[0].length;
        int i = 0;
        int j = w - 1;
        while (i < h && j >= 0) {
            if(matrix[i][j] < target) {
                i++;
            } else if(matrix[i][j] > target) {
                j--;
            } else if(matrix[i][j] == target) {
                return true;
            }
        }
        return false;
    }
}
