package com.arthur.nowcoder.meituan2021_No10;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @title: No1
 * @Author ArthurJi
 * @Date: 2021/3/22 14:52
 * @Version 1.0
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] nums = new int[n];
        int half = n / 2;
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        if (y < half) {
            System.out.println(-1);
        }
        Arrays.sort(nums);
        int x_ = Math.max(n - y, x) - 1;
        System.out.println(nums[x_]);

    }
}
/*
 美团2021校招笔试-编程题(通用编程试题,第10场) 企业提供原题00:17:32
         1/4
         [编程题]淘汰分数
         时间限制：C/C++ 1秒，其他语言2秒

         空间限制：C/C++ 256M，其他语言512M

         某比赛已经进入了淘汰赛阶段,已知共有n名选手参与了此阶段比赛，他们的得分分别是a_1,a_2….a_n,小美作为比赛的裁判希望设定一个分数线m，使得所有分数大于m的选手晋级，其他人淘汰。

         但是为了保护粉丝脆弱的心脏，小美希望晋级和淘汰的人数均在[x,y]之间。

         显然这个m有可能是不存在的，也有可能存在多个m，如果不存在，请你输出-1，如果存在多个，请你输出符合条件的最低的分数线。


         输入描述:
         输入第一行仅包含三个正整数n,x,y，分别表示参赛的人数和晋级淘汰人数区间。(1<=n<=50000,1<=x,y<=n)

         输入第二行包含n个整数，中间用空格隔开，表示从1号选手到n号选手的成绩。(1<=|a_i|<=1000)


         输出描述:
         输出仅包含一个整数，如果不存在这样的m，则输出-1，否则输出符合条件的最小的值。


         输入例子1:
         6 2 3
         1 2 3 4 5 6

         输出例子1:
         3
         Java(javac 1.8)
         ACM模式
         重置 自测
         1
         import java.util.Arrays;
         2
         import java.util.Scanner;
         3
public class Main {
4
    public static void main(String[] args) {
        5
        Scanner scanner = new Scanner(System.in);
        6
        int n = scanner.nextInt();
        7
        int x = scanner.nextInt();
        8
        int y = scanner.nextInt();
        9
        int[] nums = new int[n];
        10
        int half = n / 2;
        11
        for (int i = 0; i < n; i++) {
            12
            nums[i] = scanner.nextInt();
            13
        }
        14
        if (y < half) {
            15
            System.out.println(-1);
            16
        }
        17
        Arrays.sort(nums);
        18
        int x_ = Math.max(n - y, x) - 1;
        19
        System.out.println(nums[x_]);
        20
​
        21
    }
22
}
提交运行*/
