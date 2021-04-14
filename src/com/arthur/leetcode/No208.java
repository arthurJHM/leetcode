package com.arthur.leetcode;

import java.util.Locale;
import java.util.TreeMap;

/**
 * @title: No208
 * @Author ArthurJi
 * @Date: 2021/4/14 11:50
 * @Version 1.0
 */
public class No208 {
    public static void main(String[] args) {
        No208 tree = new No208();
        tree.insert("apple");
        tree.search("apple");

    }

    TreeNode root;

    class TreeNode {
        boolean isEnd;
        TreeNode[] nums;

        public TreeNode() {
            this.isEnd = false;
            this.nums = new TreeNode[26];
        }
    }


    /**
     * Initialize your data structure here.
     */
    public No208() {
        root = new TreeNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TreeNode node = root;
        for (int i = 0; i < chars.length; i++) {
            if (node.nums[chars[i] - 'a'] == null) {
                TreeNode temp = new TreeNode();
                node.nums[chars[i] - 'a'] = temp;
            }
            node = node.nums[chars[i] - 'a'];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TreeNode node = root;
        for (int i = 0; i < chars.length; i++) {
            if (node.nums[chars[i] - 'a'] != null) {
                node = node.nums[chars[i] - 'a'];
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TreeNode node = root;
        for (int i = 0; i < chars.length; i++) {
            if (node.nums[chars[i] - 'a'] != null) {
                node = node.nums[chars[i] - 'a'];
            } else {
                return false;
            }
        }
        return node != null;
    }
}
/*
208. 实现 Trie (前缀树)
        Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

        请你实现 Trie 类：

        Trie() 初始化前缀树对象。
        void insert(String word) 向前缀树中插入字符串 word 。
        boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
        boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。


        示例：

        输入
        ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
        [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
        输出
        [null, null, true, false, true, null, true]

        解释
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 True
        trie.search("app");     // 返回 False
        trie.startsWith("app"); // 返回 True
        trie.insert("app");
        trie.search("app");     // 返回 True*/
