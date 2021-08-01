package com.arthur.bishi.pdd0725;

import javax.sound.midi.SoundbankResource;
import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/7/25 20:18
 * @modifiedBy：
 * @version: 1.0
 */
public class No3 {
   /* public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            int[] temp = new int[d + 1];
            temp[d] = 1;
            for (int j=d; j >= a; j--) {
                if(j * c <= d && temp[j * c] == 1 || j + b <= d && temp[j + b] == 1) {
                    temp[j] = 1;
                }
            }
            if(temp[a] == 1) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }*/
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int N = scanner.nextInt();
       for (int i = 0; i < N; i++) {
           int a = scanner.nextInt();
           int b = scanner.nextInt();
           int c = scanner.nextInt();
           int d = scanner.nextInt();
           boolean[] temp = new boolean[d + 1];
           temp[a] = true;
           for (int j=a; j <= d; j++) {
               if(temp[j] == true) {
                   if(j * c <= d) {
                       temp[j * c] = true;
                   }
                   if(j + b <= d) {
                       temp[j + b] = true;
                   }
               }
           }
           if(temp[d] == true) {
               System.out.println(1);
           } else {
               System.out.println(0);
           }
       }
   }
}
