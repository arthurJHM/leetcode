package com.arthur.bishi.zijie0413;

import java.util.Arrays;

/**
 * @title: No1
 * @Author ArthurJi
 * @Date: 2021/4/13 15:41
 * @Version 1.0
 */
public class No1 {//下一个排列
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3,2,4,1};
        Arrays.sort(nums, 1,2, (o1,o2) -> o2 - o1);

        System.out.println(nums);
    }
}
