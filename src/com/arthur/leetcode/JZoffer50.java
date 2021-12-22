package com.arthur.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description:
 * @title: JZoffer50
 * @Author hengmingji
 * @Date: 2021/12/21 14:50
 * @Version 1.0
 */
public class JZoffer50 {
    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, !map.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if(entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
