package com.arthur.leetcode;

import java.util.HashMap;

/**
 * @title: No705
 * @Author ArthurJi
 * @Date: 2021/3/13 9:12
 * @Version 1.0
 */
public class No705 {

    int[] hash;
    /** Initialize your data structure here. */
    public No705() {
        hash = new int[1000001];
    }

    public void add(int key) {
        hash[key] = 1;
    }

    public void remove(int key) {
        hash[key] = 0;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return hash[key] == 1;
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
