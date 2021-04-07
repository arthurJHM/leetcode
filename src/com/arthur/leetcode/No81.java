package com.arthur.leetcode;

import javax.security.auth.kerberos.KerberosKey;
import java.util.Arrays;

/**
 * @title: No81
 * @Author ArthurJi
 * @Date: 2021/4/7 13:02
 * @Version 1.0
 */
public class No81 {
    public static void main(String[] args) {
        new No81().search_1(new int[]{2, 5, 6, 0, 0, 1, 2}, 3);
    }

    public boolean search(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] == nums[left]) {
                left++;
            } else if (nums[mid] > nums[left]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[left]) {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public boolean search_1(int[] nums, int target) {
        Arrays.sort(nums);
        return Arrays.binarySearch(nums, target) >= 0;
    }
}

/*81. 搜索旋转排序数组 II
        已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。

        在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。

        给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。



        示例 1：

        输入：nums = [2,5,6,0,0,1,2], target = 0
        输出：true
        示例 2：

        输入：nums = [2,5,6,0,0,1,2], target = 3
        输出：false*/
/*

    搜索旋转排序数组 II
leetcode
        发布于 2019-08-21
        43.3k
        解题思路：
        本题是需要使用二分查找，怎么分是关键，举个例子：

        第一类
        1011110111 和 1110111101 这种。此种情况下 nums[start] == nums[mid]，分不清到底是前面有序还是后面有序，此时 start++ 即可。相当于去掉一个重复的干扰项。
        第二类
        22 33 44 55 66 77 11 这种，也就是 nums[start] < nums[mid]。此例子中就是 2 < 5；
        这种情况下，前半部分有序。因此如果 nums[start] <=target<nums[mid]，则在前半部分找，否则去后半部分找。
        第三类
        66 77 11 22 33 44 55 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2；
        这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]。则在后半部分找，否则去前半部分找。
        代码:

public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
        return false;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
        mid = start + (end - start) / 2;
        if (nums[mid] == target) {
        return true;
        }
        if (nums[start] == nums[mid]) {
        start++;
        continue;
        }
        //前半部分有序
        if (nums[start] < nums[mid]) {
        //target在前半部分
        if (nums[mid] > target && nums[start] <= target) {
        end = mid - 1;
        } else {  //否则，去后半部分找
        start = mid + 1;
        }
        } else {
        //后半部分有序
        //target在后半部分
        if (nums[mid] < target && nums[end] >= target) {
        start = mid + 1;
        } else {  //否则，去后半部分找
        end = mid - 1;

        }
        }
        }
        //一直没找到，返回false
        return false;

        }*/
