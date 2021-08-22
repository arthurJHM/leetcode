package com.arthur.leetcodeWeeklyContest.No255Week;

import java.math.BigInteger;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/22 10:53
 * @modifiedBy：
 * @version: 1.0
 */
public class No1 {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            max = Integer.max(max, num);
            min = Integer.min(min, num);
        }
        BigInteger maxB = new BigInteger(max + "");
        BigInteger minB = new BigInteger(min + "");
        return maxB.gcd(minB).intValue();
    }
}
