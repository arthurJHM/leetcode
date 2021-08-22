package com.arthur.bishi.youzan;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/21 11:10
 * @modifiedBy：
 * @version: 1.0
 */
public class No2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return bool布尔型
     */
    public boolean isMonotonic (int[] nums) {
        boolean flag1 = true;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                continue;
            } else {
                flag1 = false;
            }
        }

        boolean flag2 = true;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]) {
                continue;
            } else {
                flag2 = false;
            }
        }
        return flag1 || flag2;
        // write code here
    }
}
