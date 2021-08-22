package com.arthur.bishi.wangyi0821;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/21 14:32
 * @modifiedBy：
 * @version: 1.0
 */
public class No3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.valueOf(s[i]);
        }
        int ans = 0;
        int[] count = new int[s.length];
        Arrays.fill(count, 1);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                count[i] = count[i - 1] + 1;
            }
        }
        if(nums[0] > nums[s.length - 1]) {
            count[0]++;
        }
        for (int i : count) {
            ans += i;
        }
        System.out.println(ans);
    }
}
