package com.arthur.bishi.tengxun0418;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @title: No3
 * @Author ArthurJi
 * @Date: 2021/4/18 20:59
 * @Version 1.0
 */
public class No3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int[][] nums = new int[n][2];
            for (int j = 0; j < n; j++) {
                nums[j][0] = scanner.nextInt();
            }
            for (int j = 0; j < n; j++) {
                nums[j][1] = scanner.nextInt();
            }
            int ans = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (map.get(nums[j][0]) != null) {
                    if(map.get(nums[j][0]) > nums[j][1]) {
                        ans += nums[j][1];
                    } else {
                        ans += map.get(nums[j][0]);
                        map.put(nums[j][0], nums[j][1]);
                    }
                } else {
                    map.put(nums[j][0], nums[j][1]);
                }
            }
            System.out.println(ans);
        }
    }
}

//扣除荣誉积分 获得勋章

