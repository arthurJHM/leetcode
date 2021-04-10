package com.arthur.bishi.jingdong0410;

import java.util.*;

/**
 * @title: No1
 * @Author ArthurJi
 * @Date: 2021/4/10 19:33
 * @Version 1.0
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }
        ArrayList<int[]> ans = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int num1 = nums[i][0] - nums[j][0];
                int num2 = nums[j][1] - nums[i][1];
                int num3;
                if (num1 % num2 == 0 || num2 % num1 == 0 || num2 == 0 || num1 == 0) {
                    num3 = num2 / num1;
                } else {
                    continue;
                }
                int num4 = num3 * nums[j][0] + nums[j][1];
                ans.add(new int[]{num3, num4});
            }
        }

        HashMap<int[], Integer> res = new HashMap<>();
        for (int[] an : ans) {
            res.put(an, res.getOrDefault(an, 0) + 1);
        }
        for (int i = n - 1; i >= 0; i--) {

        }
    }
}
