package com.arthur.bishi.meituan0911;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/9/11 17:35
 * @modifiedBy：
 * @version: 1.0
 */
import java.util.*;

public class No1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            int src = Integer.parseInt(split[0]);
            int desc = Integer.parseInt(split[1]);
            map.put(src, map.getOrDefault(src, 0) + 1);
            map.put(desc, map.getOrDefault(desc, 0) + 1);
        }
        // 记录交换的情况
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = i;
        }
        for (int i = 0; i < q; i++) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
        }
        // 输出结果
        for (int i = 1; i <= n; i++) {
            if (i < n) {
                System.out.print(map.get(nums[i]).toString() + " ");
            } else {
                System.out.println(map.get(nums[n]).toString());
            }
        }
    }
}
