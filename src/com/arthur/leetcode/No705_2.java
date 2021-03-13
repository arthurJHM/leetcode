package com.arthur.leetcode;

import sun.util.resources.cldr.xh.CurrencyNames_xh;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @title: No705
 * @Author ArthurJi
 * @Date: 2021/3/13 9:12
 * @Version 1.0
 */
public class No705_2 {

    LinkedList[] hash;

    /**
     * Initialize your data structure here.
     */
    public No705_2() {
        hash = new LinkedList[857];
        for (int i = 0; i < 857; i++) {
            hash[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int h = myhash(key);
        Iterator<Integer> iterator = hash[h].iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == key) {
                return;
            }
        }
        hash[h].add(key);
    }

    public void remove(int key) {
        int h = myhash(key);
        hash[h].remove(Integer.valueOf(key));
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int h = myhash(key);
        return hash[h].contains(key);
    }

    private int myhash(int key) {
        return key % 857;
    }
}
/*
705. 设计哈希集合
        不使用任何内建的哈希表库设计一个哈希集合（HashSet）。

        实现 MyHashSet 类：

        void add(key) 向哈希集合中插入值 key 。
        bool contains(key) 返回哈希集合中是否存在这个值 key 。
        void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。

        示例：

        输入：
        ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
        [[], [1], [2], [1], [3], [2], [2], [2], [2]]
        输出：
        [null, null, null, true, false, null, true, null, false]

        解释：
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // 返回 True
        myHashSet.contains(3); // 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // 返回 True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // 返回 False ，（已移除）*/
