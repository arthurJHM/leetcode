package com.arthur.bishi.pdd0409;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

/**
 * @title: No4
 * @Author ArthurJi
 * @Date: 2021/4/9 16:29
 * @Version 1.0
 */
public class No4 {
    static int[] pri = new int[10010];
    static int[] sumx = new int[10010];
    static int index = 0;

    public static void main(String[] args) {
        int ans = Integer.MAX_VALUE;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        getpri(m);
        for (int i = 0; i < index; i++) {
            ans = Math.min(ans, getsumX(n, pri[i]) / sumx[i]);
        }
        System.out.println(ans);
    }



    static void getpri(int m)//分解质因数
    {
        for (int i = 2; i * i <= m; i++) {
            while (m % i == 0) {
                pri[index] = i;
                sumx[index]++;
                m /= i;
            }
            if (sumx[index] != 0) {
                index++;
            }
        }
        if (m > 1) {
            pri[index] = m;
            sumx[index++] = 1;
        }
    }
    static int  getsumX(int n, int p)//n！能分解出sumX个p
    {
        int  sumX = 0;
        while (n > 0) {
            sumX += n / p;
            n /= p;
        }
        return sumX;
    }
}




