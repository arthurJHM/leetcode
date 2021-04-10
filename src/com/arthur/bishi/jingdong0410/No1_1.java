package com.arthur.bishi.jingdong0410;

/**
 * @title: No1_1
 * @Author ArthurJi
 * @Date: 2021/4/10 19:57
 * @Version 1.0
 */
import java.util.Scanner;

public class No1_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] k = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                k[i] = sc.nextInt();
                b[i] = sc.nextInt();
            }
            int[] t = new int[n - 1];
            for (int x = -1000; x <= 1000; x++) {
                for (int y = -1000; y <= 1000; y++) {
                    int count = 0;
                    for (int i = 0; i < n; i++) {
                        if (isInLine(k[i], b[i], x, y)) {
                            count++;
                        }
                    }
                    if (count >= 2) {
                        t[count - 2]++;
                    }
                }
            }
            // 输出
            for (int i = 0; i < n - 1; i++) {
                if (i != n - 2) {
                    System.out.print(t[i] + " ");
                } else {
                    System.out.println(t[i]);
                }
            }

        }
        sc.close();
    }

    private static boolean isInLine(int k, int b, int x, int y) {
        return y == k * x + b;
    }
}

