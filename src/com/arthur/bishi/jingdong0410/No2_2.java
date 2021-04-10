package com.arthur.bishi.jingdong0410;

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @title: No2_2
 * @Author ArthurJi
 * @Date: 2021/4/10 20:34
 * @Version 1.0
 */

public class No2_2 {
    private static int maxScore = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            Deque<Integer> leftStack = new LinkedList<>();
            Deque<Integer> rightStack = new LinkedList<>();
            dfs(nums, 0, 0, leftStack, rightStack);
            System.out.println(maxScore);
        }
    }

    private static void dfs(int[] nums, int pos, int score, Deque<Integer> leftStack, Deque<Integer> rightStack) {
        if (pos == nums.length) {
            maxScore = Math.max(maxScore, score);
            return;
        }
        int num = nums[pos];
        if (leftStack.isEmpty() || leftStack.peek() != num) {
            leftStack.push(num);
            dfs(nums, pos + 1, score, leftStack, rightStack);
            leftStack.pop();
        } else {
            dfs(nums, pos + 1, score + 1, leftStack, rightStack);
        }
        if (rightStack.isEmpty() || rightStack.peek() != num) {
            rightStack.push(num);
            dfs(nums, pos + 1, score, leftStack, rightStack);
            rightStack.pop();
        } else {
            dfs(nums, pos + 1, score + 1, leftStack, rightStack);
        }
    }
}