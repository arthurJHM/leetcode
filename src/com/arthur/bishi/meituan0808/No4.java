package com.arthur.bishi.meituan0808;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/8 9:40
 * @modifiedBy：
 * @version: 1.0
 */
public class No4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int m = n / 2;
        int ans = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            if(nums[i] != nums[i + m]) {
                if(!set.contains(""+nums[i]+","+nums[i+m])) {
                    ans++;
                    set.add(""+nums[i]+","+nums[i+m]);
                }
            }
        }
        System.out.println(ans);
    }
}
