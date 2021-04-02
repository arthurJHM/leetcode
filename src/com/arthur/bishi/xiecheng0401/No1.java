package com.arthur.bishi.xiecheng0401;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @title: No1
 * @Author ArthurJi
 * @Date: 2021/4/1 18:48
 * @Version 1.0
 */
public class No1 {
    public static void main(String[] args) {
        ArrayList<String> ans = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] split = s.split("\\s");
            for (int i = 0; i < split.length - 1; i++) {
                if (split[i].equals("from") && !split[i + 1].equals("(")) {
                    ans.add(split[i + 1]);
                }
                if (split[i].equals("join") && !split[i + 1].equals("(")) {
                    ans.add(split[i + 1]);
                }
            }
        }
        for (String an : ans) {
            System.out.println(an);
        }
    }
}
