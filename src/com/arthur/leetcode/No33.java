package com.arthur.leetcode;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @title: No33
 * @Author ArthurJi
 * @Date: 2021/4/16 14:03
 * @Version 1.0
 */
public class No33 {
    public static void main(String[] args) {
//        new No33().search(new int[]{1}, 1);
        new No33().search(new int[]{1}, 0);
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
//            if (nums[0] > nums[mid]) { //后半部分有序
            if (nums[left] > nums[mid]) { //后半部分有序  left或者0都行
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
//            } else if(nums[0] < nums[mid]) {
            } else {//这里面只能是0  不然会产生死循环
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = left + 1;
                }
            }
        }
        return -1;
    }
}
/*33. 搜索旋转排序数组
        整数数组 nums 按升序排列，数组中的值 互不相同 。

        在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

        给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。



        示例 1：

        输入：nums = [4,5,6,7,0,1,2], target = 0
        输出：4
        示例 2：

        输入：nums = [4,5,6,7,0,1,2], target = 3
        输出：-1
        示例 3：

        输入：nums = [1], target = 0
        输出：-1*/
