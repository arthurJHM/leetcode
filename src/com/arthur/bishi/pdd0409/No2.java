package com.arthur.bishi.pdd0409;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @title: No2
 * @Author ArthurJi
 * @Date: 2021/4/9 15:12
 * @Version 1.0
 */
public class No2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Math.abs(scanner.nextInt());
        int m = 1;
        while (true) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int r = n * m;
            int num = 0;
            while (r != 0) {
                int tmp = r % 10;
                r = r / 10;
                if (!map.containsKey(tmp) && tmp != 1 && tmp != 0) {
                    map.put(tmp, tmp);
                    num++;
                }
                if (num > 1)
                    break;
            }
            if (num == 1) {
                System.out.println(n * m);
                break;
            }
            m++;
        }
    }
}
