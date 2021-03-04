package com.arthur.leetcode;

import javax.swing.*;
import java.util.List;

/**
 * @title: No1773
 * @Author ArthurJi
 * @Date: 2021/3/4 19:00
 * @Version 1.0
 */
public class No1773 {
    public static void main(String[] args) {

    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int i;
        if(ruleKey.equals("type")) {
            i = 0;
        } else  if(ruleKey.equals("color")) {
            i = 1;
        } else {
            i = 2;
        }
        int ans = 0;
        for (List<String> item : items) {
            if(item.get(i).equals(ruleValue))
                ans++;
        }
        return ans;
    }
}
