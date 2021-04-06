package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @title: No239
 * @Author ArthurJi
 * @Date: 2021/4/6 10:52
 * @Version 1.0
 */
public class No239 {
    public static void main(String[] args) {

    }

    public int[] maxSlidingWindow_1(int[] nums, int k) {  //大根堆超时
        PriorityQueue<Integer> stack = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int len = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i < k - 1) {
                stack.offer(nums[i]);
            } else {
                stack.offer(nums[i]);
                ans.add(stack.peek());
                stack.remove(nums[i - k + 1]);
            }
        }
        int[] res = ans.stream().mapToInt(i -> i).toArray();
        return res;

    }

    public int[] maxSlidingWindow(int[] nums, int k) { //使用单调栈 不超时
        int len = nums.length;
        Queue queue = new Queue();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i < k - 1) {
                queue.add(nums[i]);
            } else {
                queue.add(nums[i]);
                res.add(queue.max());
                queue.remove(nums[i - k + 1]);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    class Queue {//单调栈类
        public LinkedList<Integer> list;

        public Queue() {
            list = new LinkedList<Integer>();
        }

        public void add(Integer n) {
            while (!list.isEmpty() && list.peekLast() < n) {
                list.pollLast();
            }
            list.addLast(n);
        }

        public void remove(Integer n) {
            if (!list.isEmpty() && list.peekFirst().equals(n)) {
                list.pollFirst();
            }
        }

        public int max() {
            return list.peekFirst();
        }
    }
}

/*
239. 滑动窗口最大值
        给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

        返回滑动窗口中的最大值。



        示例 1：

        输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
        输出：[3,3,5,5,6,7]
        解释：
        滑动窗口的位置                最大值
        ---------------               -----
        [1  3  -1] -3  5  3  6  7       3
        1 [3  -1  -3] 5  3  6  7       3
        1  3 [-1  -3  5] 3  6  7       5
        1  3  -1 [-3  5  3] 6  7       5
        1  3  -1  -3 [5  3  6] 7       6
        1  3  -1  -3  5 [3  6  7]      7
        示例 2：

        输入：nums = [1], k = 1
        输出：[1]
        示例 3：

        输入：nums = [1,-1], k = 1
        输出：[1,-1]
        示例 4：

        输入：nums = [9,11], k = 2
        输出：[11]
        示例 5：

        输入：nums = [4,-2], k = 2
        输出：[4]
*/
