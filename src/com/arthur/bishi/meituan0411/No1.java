package com.arthur.bishi.meituan0411;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @title: No1
 * @Author ArthurJi
 * @Date: 2021/4/11 10:01
 * @Version 1.0
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            if(nums[i] == 0) {
                list.add(i);
            }
        }
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] != 0 && nums[i] <= k)  {
              int dis = cal(i, list);
              if(dis < min) {
                  min = dis;
                  res = i;
              }
            }
        }
        System.out.println(res + 1);
    }

    private static int cal(int cur, ArrayList<Integer> list) {
        int dis = 0;
        for (Integer i : list) {
            dis += Math.abs(cur - i);
        }
        return dis;
    }
}
