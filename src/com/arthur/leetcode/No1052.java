package com.arthur.leetcode;

/**
 * @title: No1052
 * @Author ArthurJi
 * @Date: 2021/2/23 22:25
 * @Version 1.0
 */
public class No1052 {
    public static void main(String[] args) {
        System.out.println(new No1052().maxSatisfied(new int[] {1,0,1,2,1,1,7,5}, new int[] {0,1,0,1,0,1,0,1}, 3));
        System.out.println(new No1052().maxSatisfied(new int[] {4, 10, 10}, new int[] {1,1,0}, 2));
    }
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int ans = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            ans += customers[i] * (1 - grumpy[i]);
        }
        int temp = 0;
        for (int i = 0; i < len; i++) {
            temp += customers[i] * grumpy[i];
            if(i - X >= 0) {
                temp -= customers[i - X] * grumpy[i - X];
            }
            max = Math.max(max, temp);
        }
        return max + ans;
    }
}

/*1052. 爱生气的书店老板
        今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。

        在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。

        书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。

        请你返回这一天营业下来，最多有多少客户能够感到满意的数量。


        示例：

        输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
        输出：16
        解释：
        书店老板在最后 3 分钟保持冷静。
        感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.*/
