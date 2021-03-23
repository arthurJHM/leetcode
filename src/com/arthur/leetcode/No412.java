package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: No412
 * @Author ArthurJi
 * @Date: 2021/3/23 10:09
 * @Version 1.0
 */
public class No412 {
    String s1 = "Fizz";
    String s2 = "Buzz";
    String s3 = "FizzBuzz";

    public List<String> fizzBuzz(int n) {
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 ==0) {
//                System.out.println(s3);
                ans.add(s3);
            } else if(i % 3 == 0) {
//                System.out.println(s1);
                ans.add(s1);
            } else if(i % 5 == 0) {
//                System.out.println(s2);
                ans.add(s2);
            } else {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }
}
/*
412. Fizz Buzz
        写一个程序，输出从 1 到 n 数字的字符串表示。

        1. 如果 n 是3的倍数，输出“Fizz”；

        2. 如果 n 是5的倍数，输出“Buzz”；

        3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。

        示例：

        n = 15,

        返回:
        [
        "1",
        "2",
        "Fizz",
        "4",
        "Buzz",
        "Fizz",
        "7",
        "8",
        "Fizz",
        "Buzz",
        "11",
        "Fizz",
        "13",
        "14",
        "FizzBuzz"
        ]*/
