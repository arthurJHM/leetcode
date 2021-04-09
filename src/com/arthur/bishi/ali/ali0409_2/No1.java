package com.arthur.bishi.ali.ali0409_2;

import sun.net.www.content.text.PlainTextInputStream;

import java.util.*;

/**
 * @title: No1
 * @Author ArthurJi
 * @Date: 2021/4/9 18:54
 * @Version 1.0
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            Deque<int[]> list = new ArrayDeque<>();
            int n = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                int join = scanner.nextInt();
                int left = scanner.nextInt();
                list.addLast(new int[]{join, left});
            }
            int time = 1;
            int Max = list.peekLast()[1];
            while (time < Max && !list.isEmpty()) {
                int[] num = list.removeFirst();
                if(num[1] < time) {
                    System.out.print(0);
                    System.out.print(' ');
                } else if (num[1] >= time && num[0] <= time) {
                    System.out.print(time);
                    System.out.print(' ');
                    time++;
                }
                time++;
            }
            System.out.println();
        }
    }
}