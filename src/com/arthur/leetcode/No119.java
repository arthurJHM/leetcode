package com.arthur.leetcode;

import sun.plugin2.message.GetAppletMessage;

import java.util.ArrayList;
import java.util.List;

//杨辉三角
//    1
//    1 1
//    1 2 1
//    1 3 3 1
//    1 4 6 4 1
//输入: 3
//输出: [1,3,3,1]

/**
 * @title: No119
 * @Author ArthurJi
 * @Date: 2021/2/12 22:42
 * @Version 1.0
 */
public class No119 {


    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for(int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i) {
                    row.add(1);
                }
                else {
                    row.add(ans.get(i - 1).get(j) + ans.get(i - 1).get(j - 1));
                }
            }
            ans.add(row);
        }
        return ans.get(rowIndex);
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
