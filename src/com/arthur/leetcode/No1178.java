package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title: No1178
 * @Author ArthurJi
 * @Date: 2021/2/26 14:55
 * @Version 1.0
 */
public class No1178 {
    public static void main(String[] args) {

    }
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int key = 0;
            for (char ch : word.toCharArray()) key |= 1 << ch - 'a';
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        List<Integer> res = new ArrayList<>(puzzles.length);
        for (String p : puzzles) {
            char[] puzzle = p.toCharArray();
            res.add(dfs(puzzle, 1, map, 1 << puzzle[0] - 'a'));// 首字符必选
        }
        return res;
    }
    public int dfs(char[] puzzle, int idx, Map<Integer, Integer> map, int key) {
        if (idx == puzzle.length) return map.getOrDefault(key, 0);
        // 首字符之外的字符可选可不选，两种情况
        return dfs(puzzle, idx + 1, map, key) + dfs(puzzle, idx + 1, map, key | 1 << puzzle[idx] - 'a');
    }
}
/*
各位题友大家好！ 今天是 @负雪明烛 坚持日更的第 33 天。今天力扣上的每日一题是「1178. 猜字谜」。

        解题思路
        本文的两个重点：

        把每个字符串用二进制数字表示（状态压缩）
        寻找所有子集（subset）
        大家好，今天的题虽然是 Hard，但是大家不要怕，本题解把难度降为了 Medium，肯定让你看懂。

        首先让所有 words 和 puzzle 两两匹配肯定是不行的，时间复杂度到了 O(M * N) = 10 ^ 9O(M∗N)=10
        9
        ，会超时。

        一个简单的思路是，对于每个 puzzle 没有必要遍历所以 words，只用找符合条件的 words 出现了多少次就行了。这就是很多题解的思路：状态压缩。

        题目给出了两个条件：

        单词 word 中包含谜面 puzzle 的第一个字母。
        单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
        第一步：状态压缩
        注意题目的第二个条件只要求能找到（出现一次即可），对出现次数没要求。为了解决这个问题，我们可以使用二进制数字来表每个 word 和 puzzle，该二进制数字就是 word 和 puzzle 的特征。这道题只包含 26 个小写字母，可以压缩到一个 int 中。int 中的每一位取0和1表示字符是否出现过。比如 "aabb" 可以用 11 表示，"accc" 可以用 101 表示。

        可以看出不同的单词可能映射成同一个数字，比如 "aabbb" 和 "ab" 都映射成了 11。这就是状态压缩。



        把每个 word 都做状态压缩，并用 hashmap 保存每个二进制数字出现的次数。

        第二步：匹配
        根据题目的两个条件，puzzle 的第一个字符必须跟 word 的第一个字符相同；word 中每一个字符都要在 puzzle 中找到，所以要找的是 word 状态压缩后的数字 和 puzzle[0] + subset(puzzle[1:N - 1]) 状态压缩后的数字相等。

        很多题解都在讨论二进制表示下的 subset 怎么求，我觉得都不好理解，直接做一下「78. 子集」不就得了？暴力求出puzzle[1:N - 1]的所有子集，然后计算 puzzle[0] + subset(puzzle[1:N - 1]) 对应的状态。

        题目说了 puzzle 的长度为 7 位，subset(puzzle[1:N - 1]) 的是时间复杂度为 O(2 ^ N)O(2
        N
        ) = 2 ^ 6 = 642
        6
        =64 次计算，比较快。

        求出puzzle[0] + subset(puzzle[1:N - 1]) 对应的二进制数字之后，累加 hashmap 中该二进制数字出现的次数，就是该 puzzle 对应的 word 有多少。

        代码
        Python 代码如下，直接用了 78 题的求 subset 代码。


class Solution:
        def findNumOfValidWords(self, words: List[str], puzzles: List[str]) -> List[int]:
        freq = collections.Counter()
        for word in words:
        mask = 0
        for c in word:
        mask |= 1 << (ord(c) - ord('a'))
        freq[mask] += 1
        res = []
        for puzzle in puzzles:
        total = 0
        for perm in self.subsets(puzzle[1:]):
        mask = 1 << (ord(puzzle[0]) - ord('a'))
        for c in perm:
        mask |= 1 << (ord(c) - ord('a'))
        total += freq[mask]
        res.append(total)
        return res

        def subsets(self, words: List[int]) -> List[List[int]]:
        res = [""]
        for i in words:
        res = res + [i + word for word in res]
        return res
        时间复杂度：O(M + N)O(M+N)。
        空间复杂度：O(M)O(M)。
        刷题心得
        不畏浮云遮望眼，透过现象看本质。

        作者：fuxuemingzhu
        链接：https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle/solution/zhuang-tai-ya-suo-zi-ji-ti-jie-yi-dong-c-bdx8/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
