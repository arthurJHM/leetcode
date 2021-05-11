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
