package com.arthur.leetcode;

/**
 * @title: No4
 * @Author ArthurJi
 * @Date: 2021/4/13 10:24
 * @Version 1.0
 */
public class No4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int first = 0;
        int second = 0;
        double left = -1;
        double right = -1;
        for (int i = 0; i <= (len1 + len2) / 2; i++) {
            left = right;
            if (first < len1 && ((second >= len2) || nums1[first] < nums2[second])) {
                right = nums1[first++];
            } else {
                right = nums2[second++];
            }
        }
        if ((len1 + len2) % 2 == 1) {
            return right;
        } else {
            return (left + right) / 2;
        }
    }
}

/*4. 寻找两个正序数组的中位数
        给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。



        示例 1：

        输入：nums1 = [1,3], nums2 = [2]
        输出：2.00000
        解释：合并数组 = [1,2,3] ，中位数 2
        示例 2：

        输入：nums1 = [1,2], nums2 = [3,4]
        输出：2.50000
        解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
        示例 3：

        输入：nums1 = [0,0], nums2 = [0,0]
        输出：0.00000
        示例 4：

        输入：nums1 = [], nums2 = [1]
        输出：1.00000
        示例 5：

        输入：nums1 = [2], nums2 = []
        输出：2.00000*/
