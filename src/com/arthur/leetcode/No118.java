package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: No118
 * @Author ArthurJi
 * @Date: 2021/3/19 10:51
 * @Version 1.0
 */
public class No118 {
    public static void main(String[] args) {

    }

        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>();

            for (int i = 0; i < numRows; i++) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if(j == 0 || j == i) {
                        temp.add(1);
                    } else {
                        temp.add(ans.get(i - 1).get(j) + ans.get(i - 1).get(j - 1));
                    }
                }
                ans.add(temp);
            }
            return ans;
        }
}
/*
118. 杨辉三角
        给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。



        在杨辉三角中，每个数是它左上方和右上方的数的和。

        示例:

        输入: 5
        输出:
        [
        [1],
        [1,1],
        [1,2,1],
        [1,3,3,1],
        [1,4,6,4,1]
        ]
*/
