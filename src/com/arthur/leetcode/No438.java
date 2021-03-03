package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: No438
 * @Author ArthurJi
 * @Date: 2021/3/3 16:34
 * @Version 1.0
 */
public class No438 {
    public static void main(String[] args) {
        List<Integer> ans = new No438().findAnagrams("cbaebabacd", "abc");
        ans.forEach(System.out::println);
    }
    public List<Integer> findAnagrams(String s, String p) {
        int len = s.length();
        int plen = p.length();
        int[] pFreq = new int[26];
        int[] Freq = new int[26];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < plen; i++) {
            pFreq[p.charAt(i) - 'a']++;
        }
        int right = 0;
        for (int i = 0; i < len; i++) {
            Freq[s.charAt(i) - 'a']++;
            while (Freq[s.charAt(i) - 'a'] > pFreq[s.charAt(i) - 'a']) {
                Freq[s.charAt(right) - 'a']--;
                right++;
            }
            if(i - right + 1 == plen) {
                ans.add(right);
            }
        }
        return ans;
    }
}

//438. 找到字符串中所有字母异位词
 /*找到字符串中所有字母异位词
        给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

        字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

        说明：

        字母异位词指字母相同，但排列不同的字符串。
        不考虑答案输出的顺序。
        示例 1:

        输入:
        s: "cbaebabacd" p: "abc"

        输出:
        [0, 6]

        解释:
        起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
        起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。*/
/*

解题思路
        本题是典型的窗口滑动+左右索引指针的算法

        一开始还是先将字符串转换为字符数组，定义一个ans来接收结果

        这里使用了两个数组needs和window来分别记录需要得到的元素和滑动窗口遍历到的元素

        首先把目标数组arrP中有的元素都放入needs中，然后通过不断移动滑动窗口将目标元素的个数保存到window中

        如果window数组中记录的元素个数超过了needs数组的元素个数，则开始移动左窗口慢慢减少多余的个数

        最后把整个遍历过程中所有符合要求的左窗口索引放到ans中并返回即可。

        代码
        java

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        char[] arrS = s.toCharArray();
        char[] arrP = p.toCharArray();

        // 接收最后返回的结果
        List<Integer> ans = new ArrayList<>();

        // 定义一个 needs 数组来看 arrP 中包含元素的个数
        int[] needs = new int[26];
        // 定义一个 window 数组来看滑动窗口中是否有 arrP 中的元素，并记录出现的个数
        int[] window = new int[26];

        // 先将 arrP 中的元素保存到 needs 数组中
        for (int i = 0; i < arrP.length; i++) {
            needs[arrP[i] - 'a'] += 1;
        }

        // 定义滑动窗口的两端
        int left = 0;
        int right = 0;

        // 右窗口开始不断向右移动
        while (right < arrS.length) {
            int curR = arrS[right] - 'a';
            right++;
            // 将右窗口当前访问到的元素 curR 个数加 1
            window[curR] += 1;

            // 当 window 数组中 curR 比 needs 数组中对应元素的个数要多的时候就该移动左窗口指针
            while (window[curR] > needs[curR]) {
                int curL = arrS[left] - 'a';

                作者：Jason_H
                链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/20200321438median-by-jasion_han-r/
                来源：力扣（LeetCode）
                著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
