package com.arthur.bishi.meituan0903;

import java.util.HashMap;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/9/3 23:58
 * @modifiedBy：
 * @version: 1.0
 */
public class No1 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(1, "2");
        System.out.println(map.get(1));
    }
}
