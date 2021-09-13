package com.arthur.bishi.bzhan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/9/13 18:58
 * @modifiedBy：
 * @version: 1.0
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<int[]> nums = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            int[] t = Arrays.stream(temp.split("\\W+")).filter(s -> !s.isEmpty()).mapToInt(Integer::valueOf).toArray();
            nums.add(t);
        }
        int[][] grid = nums.toArray(new int[0][0]);
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        System.out.println(ans);
        ;
    }

    public static int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1) + 1;
    }
}
