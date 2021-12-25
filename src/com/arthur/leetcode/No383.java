package com.arthur.leetcode;

import com.sun.corba.se.spi.transport.ReadTimeouts;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 赎金信
 * @title: No383
 * @Author hengmingji
 * @Date: 2021/12/25 16:34
 * @Version 1.0
 */
public class No383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            map1.put(ransomNote.charAt(i), map1.getOrDefault(ransomNote.charAt(i), 0) +1);
        }
        for (int i = 0; i < magazine.length(); i++) {
            map2.put(magazine.charAt(i), map2.getOrDefault(magazine.charAt(i), 0) +1);
        }
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if(map2.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
