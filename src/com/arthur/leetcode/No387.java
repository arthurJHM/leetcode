package com.arthur.leetcode;

import java.util.HashMap;

/**
 * @title: No387
 * @Author ArthurJi
 * @Date: 2021/4/1 14:36
 * @Version 1.0
 */
public class No387 {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.getOrDefault(s.charAt(i), 0) == 1) {
                return i;
            }
        }
        return -1;
    }
}

/*387. 字符串中的第一个唯一字符
        给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。



        示例：

        s = "leetcode"
        返回 0

        s = "loveleetcode"
        返回 2


        提示：你可以假定该字符串只包含小写字母。*/
