package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 按键持续时间最长的键
 * @title: No1629
 * @Author hengmingji
 * @Date: 2022/1/9 0:14
 * @Version 1.0
 */
public class No1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0];
        char ans = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            if (max < releaseTimes[i] - releaseTimes[i - 1]) {
                max = releaseTimes[i] - releaseTimes[i - 1];
                ans = keysPressed.charAt(i);
            } else if (max == releaseTimes[i] - releaseTimes[i - 1]) {
                if (ans < keysPressed.charAt(i)) {
                    ans = keysPressed.charAt(i);
                }
            }
        }
        return ans;
    }
}
