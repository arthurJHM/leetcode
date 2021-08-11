package com.arthur.bishi.meituan0808;

import javax.sound.midi.SoundbankResource;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/8 9:40
 * @modifiedBy：
 * @version: 1.0
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }
            Arrays.sort(nums);
            if (nums[0] == 1 && k == 0) {
                System.out.println("NO");
            } else if (k == n) {
                if (nums[n - 1] == n) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                    System.out.println(nums[n - 1] + 1);
                }
            } else {
                if (nums[k - 1] == nums[k]){
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                    System.out.println(nums[k - 1] + 1);
                }
            }
        }
    }
}
