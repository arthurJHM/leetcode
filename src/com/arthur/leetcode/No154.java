package com.arthur.leetcode;

/**
 * @title: No154
 * @Author ArthurJi
 * @Date: 2021/4/9 11:50
 * @Version 1.0
 */
public class No154 {
    public static void main(String[] args) {
        new No154().findMin(new int[]{2, 2, 2, 0, 1});
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] == nums[right]) {
                right--;
            }
        }
        return nums[left];
    }
}

/*154. 寻找旋转排序数组中的最小值 II
        已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
        若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
        若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
        注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。

        给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。



        示例 1：

        输入：nums = [1,3,5]
        输出：1
        示例 2：

        输入：nums = [2,2,2,0,1]
        输出：0*/
/*
寻找旋转排序数组中的最小值 II（二分法，极简，图解）
        Krahets
        发布于 2019-06-18
        21.1k
        思路：
        旋转排序数组 numsnums 可以被拆分为 2 个排序数组 nums1nums1 , nums2nums2 ，并且 nums1任一元素 >= nums2任一元素；因此，考虑二分法寻找此两数组的分界点 nums[i]nums[i] (即第 2 个数组的首个元素)。
        设置 leftleft, rightright 指针在 numsnums 数组两端，midmid 为每次二分的中点：
        当 nums[mid] > nums[right]时，midmid 一定在第 1 个排序数组中，ii 一定满足 mid < i <= right，因此执行 left = mid + 1；
        当 nums[mid] < nums[right] 时，midmid 一定在第 2 个排序数组中，ii 一定满足 left < i <= mid，因此执行 right = mid；
        当 nums[mid] == nums[right] 时，是此题对比 153题 的难点（原因是此题中数组的元素可重复，难以判断分界点 ii 指针区间）；
        例如 [1, 0, 1, 1, 1][1,0,1,1,1] 和 [1, 1, 1, 0, 1][1,1,1,0,1] ，在 left = 0, right = 4, mid = 2 时，无法判断 midmid 在哪个排序数组中。
        我们采用 right = right - 1 解决此问题，证明：
        此操作不会使数组越界：因为迭代条件保证了 right > left >= 0；
        此操作不会使最小值丢失：假设 nums[right]nums[right] 是最小值，有两种情况：
        若 nums[right]nums[right] 是唯一最小值：那就不可能满足判断条件 nums[mid] == nums[right]，因为 mid < right（left != right 且 mid = (left + right) // 2 向下取整）；
        若 nums[right]nums[right] 不是唯一最小值，由于 mid < right 而 nums[mid] == nums[right]，即还有最小值存在于 [left, right - 1][left,right−1] 区间，因此不会丢失最小值。
        以上是理论分析，可以代入以下数组辅助思考：
        [1, 2, 3][1,2,3]
        [1, 1, 0, 1][1,1,0,1]
        [1, 0, 1, 1, 1][1,0,1,1,1]
        [1, 1, 1, 1][1,1,1,1]
        时间复杂度 O(logN)O(logN)，在特例情况下会退化到 O(N)O(N)（例如 [1, 1, 1, 1][1,1,1,1]）。
        图解：


        代码：

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else if (nums[mid] < nums[right]) right = mid;
            else right = right - 1;
        }
        return nums[left];
    }
}*/
