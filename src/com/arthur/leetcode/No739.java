package com.arthur.leetcode;

import java.util.Stack;

/**
 * @title: No739
 * @Author ArthurJi
 * @Date: 2021/2/19 13:36
 * @Version 1.0
 */
public class No739 {
    public static void main(String[] args) {
        int[] res = new No739().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] res = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while(!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int temp = stack.pop();
                res[temp] = i - temp;
            }
            stack.push(i);
        }
        return res;
    }
}

/*

 739.每日温度

第一个想法就是针对每个温度值 向后进行依次搜索 ，找到比当前温度更高的值，这是最容易想到的办法。

        其原理是从左到右除了最后一个数其他所有的数都遍历一次，最后一个数据对应的结果肯定是 0，就不需要计算。

        遍历的时候，每个数都去向后数，直到找到比它大的数，数的次数就是对应输出的值。

        代码如下：

public int[] dailyTemperatures(int[] T) {
    int length = T.length;
    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
        int current = T[i];
        if (current < 100) {
            for (int j = i + 1; j < length; j++) {
                if (T[j] > current) {
                    result[i] = j - i;
                    break;
                }
            }
        }
    }
    return result;
}

        这个题目的标签是 栈 ，我们考虑一下怎么借助 栈 来解决。

        不过这个栈有点特殊，它是 递减栈 ：栈里只有递减元素。

        具体操作如下：

        遍历整个数组，如果栈不空，且当前数字大于栈顶元素，那么如果直接入栈的话就不是 递减栈 ，所以需要取出栈顶元素，由于当前数字大于栈顶元素的数字，而且一定是第一个大于栈顶元素的数，直接求出下标差就是二者的距离。

        继续看新的栈顶元素，直到当前数字小于等于栈顶元素停止，然后将数字入栈，这样就可以一直保持递减栈，且每个数字和第一个大于它的数的距离也可以算出来。

        动画理解

        复杂度分析
        该方法只需要对数组进行一次遍历，每个元素最多被压入和弹出堆栈一次，算法复杂度是 O(n)O(n)。

        作者：MisterBooo
        链接：https://leetcode-cn.com/problems/daily-temperatures/solution/leetcode-tu-jie-739mei-ri-wen-du-by-misterbooo/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
