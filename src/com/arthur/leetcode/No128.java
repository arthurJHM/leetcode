package com.arthur.leetcode;

import java.util.HashMap;

/**
 * @title: No128
 * @Author ArthurJi
 * @Date: 2021/4/3 19:48
 * @Version 1.0
 */
public class No128 {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                int left = map.getOrDefault(nums[i] - 1, 0);
                int right = map.getOrDefault(nums[i] + 1, 0);
                int currLen = left + right + 1;
                ans = Math.max(currLen, ans);
                map.put(nums[i], currLen);
                map.put(nums[i] - left, currLen);
                map.put(nums[i] + right, currLen);
            }
        }
        return ans;
    }
}
//有点并查集的意思

/*128. 最长连续序列
        给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。



        进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？



        示例 1：

        输入：nums = [100,4,200,1,3,2]
        输出：4
        解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
        示例 2：

        输入：nums = [0,3,7,2,5,8,4,6,0,1]
        输出：9*/
/*


解题思路：
        题目要求 O(n)O(n) 复杂度。

        用哈希表存储每个端点值对应连续区间的长度
        若数已在哈希表中：跳过不做处理
        若是新数加入：
        取出其左右相邻数已有的连续区间长度 left 和 right
        计算当前数的区间长度为：cur_length = left + right + 1
        根据 cur_length 更新最大长度 max_length 的值
        更新区间两端点的长度值
        Python

class Solution(object):
        def longestConsecutive(self, nums):
        hash_dict = dict()

        max_length = 0
        for num in nums:
        if num not in hash_dict:
        left = hash_dict.get(num - 1, 0)
        right = hash_dict.get(num + 1, 0)

        cur_length = 1 + left + right
        if cur_length > max_length:
        max_length = cur_length

        hash_dict[num] = cur_length
        hash_dict[num - left] = cur_length
        hash_dict[num + right] = cur_length

        return max_length


        作者：jalan
        链接：https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/dong-tai-gui-hua-python-ti-jie-by-jalan/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
