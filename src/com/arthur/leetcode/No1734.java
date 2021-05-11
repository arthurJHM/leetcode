package com.arthur.leetcode;

/**
 * @title: No1734
 * @Author ArthurJi
 * @Date: 2021/5/11 11:47
 * @Version 1.0
 */
public class No1734 {
    public static void main(String[] args) {

    }

    public int[] decode(int[] encoded) {
        int n = encoded.length;
        int[] ans = new int[n + 1];
        int a = 0;
        for (int i = 0; i < n; i+=2) {
            a ^= encoded[i];
        }
        int b = 0;
        for (int i = 1; i <= n + 1; i++) {
            b ^= i;
        }
        ans[n] = a ^ b;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i + 1] ^ encoded[i];
        }
        return ans;
    }
}
/*1734. 解码异或后的排列
        给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。

        它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。

        给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。



        示例 1：

        输入：encoded = [3,1]
        输出：[1,2,3]
        解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
        示例 2：

        输入：encoded = [6,5,4,6]
        输出：[2,4,1,5,3]


        提示：

        3 <= n < 105
        n 是奇数。
        encoded.length == n - 1*/
/*
基本分析
        我们知道异或运算有如下性质：

        相同数值异或，结果为 00
        任意数值与 00 进行异或，结果为数值本身
        异或本身满足交换律
        本题与 1720. 解码异或后的数组 的唯一区别是没有给出首位元素。

        因此，求得答案数组的「首位元素」或者「结尾元素」可作为本题切入点。

        数学 & 模拟
        我们定义答案数组为 ans[]，ans[] 数组的长度为 n，且 n 为奇数。

        即有 [ans[0], ans[1], ans[2], ... , ans[n - 1]][ans[0],ans[1],ans[2],...,ans[n−1]]。

        给定的数组 encoded[] 其实是 [ans[0] ⊕ ans[1], ans[1] ⊕ ans[2], ... , ans[n - 3] ⊕ ans[n - 2], ans[n - 2] ⊕ ans[n - 1]][ans[0]⊕ans[1],ans[1]⊕ans[2],...,ans[n−3]⊕ans[n−2],ans[n−2]⊕ans[n−1]]，长度为 n - 1。

        由于每相邻一位会出现相同的数组成员 ans[x]，考虑“每隔一位”进行异或：

        从 encoded[] 的第 00 位开始，每隔一位进行异或：可得 ans[0] ⊕ ans[1] ⊕ ... ⊕ ans[n - 2]ans[0]⊕ans[1]⊕...⊕ans[n−2]，即除了 ans[] 数组中的 ans[n - 1]ans[n−1] 以外的所有异或结果。

        利用 ans[] 数组是 n 个正整数的排列，我们可得 ans[0] ⊕ ans[1] ⊕ ... ⊕ ans[n - 2] ⊕ ans[n - 1]ans[0]⊕ans[1]⊕...⊕ans[n−2]⊕ans[n−1]，即 ans[] 数组中所有元素的异或结果。

        将两式进行「异或」，可得 ans[n - 1]ans[n−1]。

        有了结尾元素后，问题变为与 1720. 解码异或后的数组 类似的模拟题。

        代码：

        Java

class Solution {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[] ans = new int[n];
        // 求得除了 ans[n - 1] 的所有异或结果
        int a = 0;
        for (int i = 0; i < n - 1; i += 2) a ^= encoded[i];
        // 求得 ans 的所有异或结果
        int b = 0;
        for (int i = 1; i <= n; i++) b ^= i;
        // 求得 ans[n - 1] 后，从后往前做
        ans[n - 1] = a ^ b;
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = encoded[i] ^ ans[i + 1];
        }
        return ans;
    }
}
时间复杂度：O(n)O(n)
        空间复杂度：构建同等数量级的答案数组。复杂度为 O(n)O(n)

        作者：AC_OIer
        链接：https://leetcode-cn.com/problems/decode-xored-permutation/solution/gong-shui-san-xie-note-bie-pian-li-yong-zeh6o/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
