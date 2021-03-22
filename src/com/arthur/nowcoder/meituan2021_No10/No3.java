package com.arthur.nowcoder.meituan2021_No10;

import java.io.*;

/**
 * @title: No3
 * @Author ArthurJi
 * @Date: 2021/3/22 15:10
 * @Version 1.0
 */
public class No3 {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int NN = Integer.parseInt(scanner.readLine());
        for (int i = 0; i < NN; i++) {
            int N = Integer.parseInt(scanner.readLine());
            int[] nums = new int[N];
            String s = scanner.readLine();
            for (int b = 0; b < s.length(); b++) {
                nums[b] = s.charAt(b) - '0';
            }
            int numberPeople = Integer.parseInt(scanner.readLine());
            String fm = scanner.readLine();
            for (int k = 0; k < fm.length(); k++) {
                boolean flag;
                if (fm.charAt(k) == 'F') {
                    int temp = 0;
                    flag = true;
                    for (int m = 0; m < N; m++) {
                        if (nums[m] == 0) {
                            nums[m] = 1;
//                            System.out.println(m + 1);
                            writer.write(Integer.toString(m + 1));
                            writer.newLine();
                            flag = true;
                            break;
                        }
                        if (nums[m] == 1 && flag) {
                            temp = m;
                            flag = false;
                        }
                    }
                    if (!flag) {
//                        System.out.println(temp + 1);
                        writer.write(Integer.toString(temp + 1));
                        writer.newLine();
                        flag = true;
                        nums[temp]++;
                    }
                } else if (fm.charAt(k) == 'M') {
                    int temp = 0;
                    flag = true;
                    for (int m = 0; m < N; m++) {
                        if (nums[m] == 1) {
                            nums[m] = 2;
//                            System.out.println(m + 1);
                            writer.write(Integer.toString(m + 1));
                            writer.newLine();
                            flag = true;
                            break;
                        }
                        if (nums[m] == 0 && flag) {
                            temp = m;
                            flag = false;
                        }
                    }
                    if (!flag) {
//                        System.out.println(temp + 1);
                        writer.write(Integer.toString(temp + 1));
                        writer.newLine();
                        flag = true;
                        nums[temp]++;
                    }

                }
            }
        }
        writer.flush();

    }
}

/* 美团2021校招笔试-编程题(通用编程试题,第10场) 企业提供原题00:22:36
         3/4
         [编程题]公司食堂
         时间限制：C/C++ 1秒，其他语言2秒

         空间限制：C/C++ 256M，其他语言512M

         小美和小团所在公司的食堂有N张餐桌，从左到右摆成一排，每张餐桌有2张餐椅供至多2人用餐，公司职员排队进入食堂用餐。小美发现职员用餐的一个规律并告诉小团：当男职员进入食堂时，他会优先选择已经坐有1人的餐桌用餐，只有当每张餐桌要么空着要么坐满2人时，他才会考虑空着的餐桌；

         当女职员进入食堂时，她会优先选择未坐人的餐桌用餐，只有当每张餐桌都坐有至少1人时，她才会考虑已经坐有1人的餐桌；

         无论男女，当有多张餐桌供职员选择时，他会选择最靠左的餐桌用餐。现在食堂内已有若干人在用餐，另外M个人正排队进入食堂，小团会根据小美告诉他的规律预测排队的每个人分别会坐哪张餐桌。


         输入描述:
         第一行输入一个整数T（1<=T<=10），表示数据组数。

         每组数据占四行，第一行输入一个整数N（1<=N<=500000）；

         第二行输入一个长度为N且仅包含数字0、1、2的字符串，第i个数字表示左起第i张餐桌已坐有的用餐人数；

         第三行输入一个整数M（1<=M<=2N且保证排队的每个人进入食堂时都有可供选择的餐桌）；

         第四行输入一个长度为M且仅包含字母M、F的字符串，若第i个字母为M，则排在第i的人为男性，否则其为女性。


         输出描述:
         每组数据输出占M行，第i行输出一个整数j（1<=j<=N），表示排在第i的人将选择左起第j张餐桌用餐。


         输入例子1:
         1
         5
         01102
         6
         MFMMFF

         输出例子1:
         2
         1
         1
         3
         4
         4*/
