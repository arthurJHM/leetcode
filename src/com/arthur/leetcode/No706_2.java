package com.arthur.leetcode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @title: No706_2
 * @Author ArthurJi
 * @Date: 2021/3/14 9:31
 * @Version 1.0
 */
public class No706_2 {
    private class pair {
        private int key;
        private int val;

        public pair(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    private static final int BASE = 769;
    private LinkedList[] map = new LinkedList[BASE];

    /**
     * Initialize your data structure here.
     */
    public No706_2() {
        for (int i = 0; i < BASE; i++) {
            map[i] = new LinkedList<pair>();
        }

    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int h = myhash(key);
        Iterator<pair> iterator = map[h].iterator();
        while (iterator.hasNext()) {
            pair next = iterator.next();
            if(next.getKey() == key) {
                next.setVal(value);
                return;
            }
        }
        map[h].add(new pair(key,value));
    }

    private int myhash(int key) {
        return key % BASE;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int h = myhash(key);
        Iterator<pair> iterator = map[h].iterator();
        while (iterator.hasNext()) {
            pair next = iterator.next();
            if(next.getKey() == key) {
                return next.getVal();
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int h = myhash(key);
        Iterator<pair> iterator = map[h].iterator();
        while (iterator.hasNext()) {
            pair next = iterator.next();
            if(next.getKey() == key) {
                map[h].remove(next);
                return;
            }
        }
    }
}
