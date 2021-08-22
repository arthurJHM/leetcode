package com.arthur.bishi.tengxun0822;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/22 20:55
 * @modifiedBy：
 * @version: 1.0
 */
public class No2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            Integer[] nums = new Integer[N];
            for (int j = 0; j < N; j++) {
                nums[j] = scanner.nextInt() % 1000000007;
            }
            Arrays.sort(nums, (o1, o2) -> {
                return o2 - o1;
            });
            int ans = 0;
            for (Integer num : nums) {
                ans += num * getN(N - 1)  % 1000000007;
                N--;
            }
            System.out.println(ans);
        }
    }
    public static int getN(int N) {
        return (1 + N) * N / 2 + 1;
    }
}
