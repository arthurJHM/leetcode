package com.arthur.leetcode;

import jdk.nashorn.internal.objects.NativeNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @title: No15
 * @Author ArthurJi
 * @Date: 2021/3/23 10:29
 * @Version 1.0
 */
public class No15 {
    public static void main(String[] args) {
//        new No15().threeSum(new int[]{-1,0,1,2,-1,-4});
        new No15().threeSum(new int[]{0, 0, 0});

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (len == 0 || nums[len - 1] < 0 || nums[0] > 0 || len < 3) {
            return lists;
        }
        for (int i = 0; i < len; i++) {

            int left = i + 1;
            int right = len - 1;
            if (right <= left) {
                break;
            }
            if (nums[i] > 0) {
                return lists;
            }
            int target = 0 - nums[i];
            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] == target) {
                    lists.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while (left < len - 1 && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right > 0 && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
            while (i < len - 1&& nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return lists;
    }
}

/*    题目描述
    评论 (2.3k)
    题解 (2.1k)
提交记录
        15. 三数之和
        给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

        注意：答案中不可以包含重复的三元组。



        示例 1：

        输入：nums = [-1,0,1,2,-1,-4]
        输出：[[-1,-1,2],[-1,0,1]]
        示例 2：

        输入：nums = []
        输出：[]
        示例 3：

        输入：nums = [0]
        输出：[]*/
/*排序 + 双指针
        本题的难点在于如何去除重复解。

        算法流程：
        特判，对于数组长度 nn，如果数组为 nullnull 或者数组长度小于 33，返回 [][]。
        对数组进行排序。
        遍历排序后数组：
        若 nums[i]>0nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 00，直接返回结果。
        对于重复元素：跳过，避免出现重复解
        令左指针 L=i+1L=i+1，右指针 R=n-1R=n−1，当 L<RL<R 时，执行循环：
        当 nums[i]+nums[L]+nums[R]==0nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,RL,R 移到下一位置，寻找新的解
        若和大于 00，说明 nums[R]nums[R] 太大，RR 左移
        若和小于 00，说明 nums[L]nums[L] 太小，LL 右移
        复杂度分析
        时间复杂度：O\left(n^{2}\right)O(n
        2
        )，数组排序 O(N \log N)O(NlogN)，遍历数组 O\left(n\right)O(n)，双指针遍历 O\left(n\right)O(n)，总体 O(N \log N)+O\left(n\right)*O\left(n\right)O(NlogN)+O(n)∗O(n)，O\left(n^{2}\right)O(n
        2
        )
        空间复杂度：O(1)O(1)
        Python3

class Solution:
        def threeSum(self, nums: List[int]) -> List[List[int]]:

        n=len(nums)
        res=[]
        if(not nums or n<3):
        return []
        nums.sort()
        res=[]
        for i in range(n):
        if(nums[i]>0):
        return res
        if(i>0 and nums[i]==nums[i-1]):
        continue
        L=i+1
        R=n-1
        while(L<R):
        if(nums[i]+nums[L]+nums[R]==0):
        res.append([nums[i],nums[L],nums[R]])
        while(L<R and nums[L]==nums[L+1]):
        L=L+1
        while(L<R and nums[R]==nums[R-1]):
        R=R-1
        L=L+1
        R=R-1
        elif(nums[i]+nums[L]+nums[R]>0):
        R=R-1
        else:
        L=L+1
        return res

        作者：wu_yan_zu
        链接：https://leetcode-cn.com/problems/3sum/solution/pai-xu-shuang-zhi-zhen-zhu-xing-jie-shi-python3-by/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

