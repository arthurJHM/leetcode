package com.arthur.bishi.mihayou;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/15 20:12
 * @modifiedBy：
 * @version: 1.0
 */
public class No2 {
    public int computeN(int maxValue) {
        // write code here
        int digit = 1;
        int res = 0;
        int high = maxValue / 10, cur = maxValue % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
