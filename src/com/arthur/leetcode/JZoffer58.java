package com.arthur.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description: I. 翻转单词顺序
 * @title: JZoffer58
 * @Author hengmingji
 * @Date: 2021/12/29 10:33
 * @Version 1.0
 */
public class JZoffer58 {
    public String reverseWords(String s) {
//        List<String> collect = Arrays.stream(s.split("\\s+")).collect(Collectors.toList());
        List<String> collect = Arrays.stream(s.split(" ")).collect(Collectors.toList());
        Collections.reverse(collect);
        StringBuilder sb = new StringBuilder();
        collect.stream().filter(o -> !o.equals("")).forEach(o -> sb.append(o + " "));
        return sb.toString().trim();
    }
}
