package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @program: leetcode
 * @description: 连接词
 * @title: No472
 * @Author hengmingji
 * @Date: 2021/12/28 10:55
 * @Version 1.0
 */
public class No472 {
    HashSet<Long> set = new HashSet<>();
    int P = 131;
    int OFFSET = 128;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            long hash = 0;
            for (char c : words[i].toCharArray()) {
                hash = hash * P + (c - 'a') + OFFSET;
            }
            set.add(hash);
        }

        for (int i = 0; i < words.length; i++) {
            if (check(words[i])) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    private boolean check(String word) {
        int len = word.length();
        int[] f = new int[len + 1];
        Arrays.fill(f, -1);
        f[0] = 0;
        for (int i = 0; i <= len; i++) {
            if (f[i] == -1) {
                continue;
            }
            long hash = 0;
            for (int j = i + 1; j <= len; j++) {
                hash = hash * P + (word.charAt(j - 1) - 'a') + OFFSET;
                if (set.contains(hash)) {
                    f[j]++;
                }
            }
        }
        return f[len] > 1;
    }
}
