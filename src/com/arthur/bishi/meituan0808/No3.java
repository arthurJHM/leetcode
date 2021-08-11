package com.arthur.bishi.meituan0808;

import org.omg.PortableInterceptor.INACTIVE;

import javax.sound.midi.SoundbankResource;
import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/8 9:40
 * @modifiedBy：
 * @version: 1.0
 */
public class No3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1 || n == 0) {
            System.out.println(0);
            return;
        }
        int[] aa = new int[n + 1];
        int[] pre = new int[n + 1];
        int mm = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            aa[i] = scanner.nextInt();
        }
        for (int i = 2; i <= n; i++) {
            mm = Integer.MIN_VALUE;
            for (int j = 1; j < i; j++) {
                if (aa[i] > aa[j] && aa[j] > mm) {
                    mm = aa[j];
                }
            }
            if (mm != Integer.MIN_VALUE) {
                pre[i] = mm;
            } else {
                pre[i] = 0;
            }
        }
        for (int i = 1; i < pre.length; i++) {
            sum += i * pre[i];
        }
        System.out.println(sum);
    }
}
