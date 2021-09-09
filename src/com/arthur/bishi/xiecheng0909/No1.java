package com.arthur.bishi.xiecheng0909;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/9/9 19:09
 * @modifiedBy：
 * @version: 1.0
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        LinkedList<String> ans = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String s = scanner.nextLine();
            String[] temp = s.split(" ");
            if (temp[0].equals("pwd")) {
                if (ans.size() == 0) {
                    System.out.println("\\");
                } else {
                    for (String an : ans) {
                        System.out.print("\\");
                        System.out.print(an);
                    }
                }
            } else if (temp[0].equals("cd")) {
                if (temp[1].equals("..")) {
                    ans.removeLast();
                } else {
                    ans.add(temp[1]);
                }
            }
        }
    }
}
