package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @title: No17
 * @Author ArthurJi
 * @Date: 2021/2/20 15:06
 * @Version 1.0
 */
public class No17 {
    public static void main(String[] args) {
        List<String> strings = new No17().letterCombinations("23");
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }

    String[] letter = {" ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
        };

    ArrayList<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) {
            return res;
        }

        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String s) {
        if(index == digits.length()) {
            res.add(s);
            return;
        }

        int num = digits.charAt(index) - '0';
        for (int i = 0; i < letter[num].length(); i++) {
            findCombination(digits, index + 1, s + letter[num].charAt(i));
        }
    }
}
