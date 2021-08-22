package com.arthur.bishi.xiaohongshu0821;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/21 10:00
 * @modifiedBy：
 * @version: 1.0
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if (N % 2 == 1) {
            System.out.println("-1");
            return;
        }
        ArrayList<int[]> list = new ArrayList<int[]>();
        int hei = 0;
        int bai = 0;
        for (int i = 0; i < N; i++) {
            int temp = scanner.nextInt();
            if (temp == 0) {
                int[] stone = new int[2];
                stone[0] = scanner.nextInt();
                stone[1] = scanner.nextInt();
                list.add(stone);
            } else if (temp == 1) {
                bai++;
            } else if (temp == 2) {
                hei++;
            }
        }
        list.sort((o1, o2) -> {
            return ((o1[1] - o1[0]) - (o2[1] - o2[0]));
        });
        int ans = 0;
        hei = N / 2 - hei;
        for (int i = 0; i < list.size(); i++) {
            if(i < hei) {
                ans += list.get(i)[1];
            } else {
                ans += list.get(i)[0];
            }
        }
        System.out.println(ans);
    }
}
