package com.arthur.bishi.tengxun0811;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/11 19:13
 * @modifiedBy：
 * @version: 1.0
 */
import java.util.Arrays;
import java.util.Scanner;
public class No1 {
    public static void main(String[] args) {
        String[] strings = new String[]{"12010001", "12010002", "13010001"};
        sort(strings);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static void sort(String[] nums) {
        Arrays.sort(nums, ( o1, o2) -> {
            if(o1.substring(4).compareTo(o2.substring(4)) == 0) {
                return o1.substring(0, 4).compareTo(o2.substring(0, 4));
            } else {
                return o1.substring(4).compareTo(o2.substring(4));
            }
        });
    }
}
