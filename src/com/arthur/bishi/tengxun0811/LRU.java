package com.arthur.bishi.tengxun0811;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/11 20:33
 * @modifiedBy：
 * @version: 1.0
 */
public class LRU {
    private LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>(4);

    public Integer get(Character key) {
        return map.getOrDefault(key, -1);
    }

    public void put(Character key, Integer value) {
        map.put(key, value);
    }
}
