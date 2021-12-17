package com.arthur.bishi.hangzhouyinghang1020;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description: bishi
 * @title: No1
 * @Author hengmingji
 * @Date: 2021/10/20 18:33
 * @Version 1.0
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int price = scanner.nextInt();
            if(!set.contains(price)) {
                list.add(price);
                set.add(price);
            }
        }
        Collections.sort(list);
        if(list.size() >= 2) {
            System.out.println(list.get(2));
        } else {
            System.out.println("-1");
        }
    }
}
