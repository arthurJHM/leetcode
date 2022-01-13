package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 格雷编码
 * @title: No89
 * @Author hengmingji
 * @Date: 2022/1/8 23:28
 * @Version 1.0
 */
public class No89 {
    public List<Integer> grayCode(int n) {
        int head = 1;
        ArrayList<Integer> list = new ArrayList<Integer>(){{add(0);}};
        for (int i = 0; i < n; i++) {
            int size = list.size();
            for (int j = size - 1; j >= 0; j--) {
                list.add(head + list.get(j));
            }
            head <<= 1;
        }
        return list;
    }
}
