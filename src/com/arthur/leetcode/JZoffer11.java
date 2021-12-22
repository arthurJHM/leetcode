package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 旋转数组的最小数字
 * @title: JZoffer11
 * @Author hengmingji
 * @Date: 2021/12/21 13:56
 * @Version 1.0
 */
public class JZoffer11 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (numbers[right] > numbers[mid]) {
                right = mid;
            } else if(numbers[right] < numbers[mid]) {
                left = mid + 1;
            } else if(numbers[right] == numbers[mid]){
                right--;
            }
        }
        return numbers[left];
    }
}
