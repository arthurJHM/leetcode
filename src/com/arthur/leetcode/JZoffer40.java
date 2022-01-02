package com.arthur.leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description: 最小的k个数
 * @title: JZoffer40
 * @Author hengmingji
 * @Date: 2022/1/2 16:34
 * @Version 1.0
 */
public class JZoffer40 {
    //    public int[] getLeastNumbers(int[] arr, int k) {
//        Arrays.sort(arr);
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < k; i++) {
//            list.add(arr[i]);
//        }
//        return list.stream().mapToInt(Integer::valueOf).toArray();
//    }
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> stack = new PriorityQueue<>(k);
        for (int i : arr) {
            stack.add(i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(stack.poll());
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
