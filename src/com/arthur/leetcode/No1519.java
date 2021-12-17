package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 换酒问题
 * @title: No1519
 * @Author hengmingji
 * @Date: 2021/12/17 20:44
 * @Version 1.0
 */
public class No1519 {
    public static void main(String[] args) {

    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        while (numBottles / numExchange != 0) {
            int exchange = numBottles / numExchange;
            total += exchange;
            numBottles = exchange + numBottles % numExchange;
        }
        return total;
    }
}
