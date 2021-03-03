package com.arthur.leetcode;

import com.sun.glass.ui.View;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @title: No146
 * @Author ArthurJi
 * @Date: 2021/3/3 14:40
 * @Version 1.0
 */
public class No146 extends LinkedHashMap<Integer, Integer> {
    private int capacity;
    public No146(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

//这是直接继承LinkedHashMap进行使用