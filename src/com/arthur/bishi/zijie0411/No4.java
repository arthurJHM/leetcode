package com.arthur.bishi.zijie0411;

import java.util.*;
/**
 * @title: No4
 * @Author ArthurJi
 * @Date: 2021/4/11 19:46
 * @Version 1.0
 */
class No4 {
    static int[][] exchangeArray = new int[][]{
            {1, 4},
            {0, 2, 5},
            {1, 3, 6},
            {2, 7},
            {0, 5, 8},
            {1, 4, 6, 9},
            {2, 5, 7, 10},
            {3, 6, 11},
            {4, 9, 12},
            {5, 8, 10, 13},
            {6, 9, 11, 14},
            {7, 10, 15},
            {8, 13},
            {9, 12, 14},
            {10, 13, 15},
            {11, 14},
    };
    public static void main(String[] args) {
        int[][] nums = new int[4][4];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        System.out.println(slidingPuzzle(nums));
    }
    // 交换字符
    public static String exchangeString(String string, int src, int dis) {
        char[] chars = string.toCharArray();
        char temp = chars[dis];
        chars[dis] = chars[src];
        chars[src] = temp;
        return new String(chars);
    }

    public static int slidingPuzzle(int[][] board) {
        // 初始状态转字符串
        char[] chars = new char[16];
        int index = 0;
        for (int[] row : board) {
            for (int ch : row) {
                chars[index++] = (char) (ch + '0');
            }
        }
        String start = new String(chars);
        String target = "123456789:;<=>00";
        // BFS套路
        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        q.offer(start);
        int step = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                // 解开谜板
                if (cur.equals(target)) {
                    return step;
                }
                int first = cur.indexOf('0');
                int last = cur.lastIndexOf('0');
                int[] exchanges = exchangeArray[first];
                for (int next : exchanges) {
                    String s = exchangeString(cur, first, next);
                    if (!visited.contains(s)) {
                        q.offer(s);
                        visited.add(s);
                    }
                }
                exchanges = exchangeArray[last];
                for (int next : exchanges) {
                    String s = exchangeString(cur, last, next);
                    if (!visited.contains(s)) {
                        q.offer(s);
                        visited.add(s);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}

/*
        1 0 2 4
        5 7 3 8
        9 6 10 12
        13 14 0 11
        */
