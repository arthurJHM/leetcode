package com.arthur.bishi.zoom0828;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/28 16:45
 * @modifiedBy：
 * @version: 1.0
 */
public class No3 {
    public int[] slideWindow (int[] nums, int windowSize, int step) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int j = i + windowSize;
            j = Integer.min(j, n);
            int temp = Integer.MIN_VALUE;
            for (int k = i; k < j; k++) {
                temp = Integer.max(temp, nums[k]);
            }
            ans.add(temp);
            i = i + step;
        }
        int[] re = new int[ans.size()];
        for (int k = 0; k < re.length; k++) {
            re[k] = ans.get(k);
        }
        return re;
    }
}
