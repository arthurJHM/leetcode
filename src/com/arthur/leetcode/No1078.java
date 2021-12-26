package com.arthur.leetcode;

import java.util.ArrayList;

/**
 * @program: leetcode
 * @description: Bigram 分词
 * @title: No1078
 * @Author hengmingji
 * @Date: 2021/12/26 12:32
 * @Version 1.0
 */
public class No1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] s = text.split(" ");
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i < s.length - 1; i++) {
            if(s[i - 1].equals(first) && s[i].equals(second)) {
                ans.add(s[i + 1]);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
