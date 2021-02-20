package com.arthur.leetcode;

import java.util.HashMap;

/**
 * @title: No697
 * @Author ArthurJi
 * @Date: 2021/2/20 14:01
 * @Version 1.0
 */
public class No697 {
    public static void main(String[] args) {
        System.out.println(new No697().findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }

    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        HashMap<Integer, Integer> counter = new HashMap<>();
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            left.putIfAbsent(nums[i], i);
            right.put(nums[i], i);
            counter.put(nums[i] , counter.getOrDefault(nums[i], 0) + 1);
            maxLen = Math.max(maxLen, counter.get(nums[i]));
        }
        int res = nums.length;
        for (Integer key : counter.keySet()) {
            if(counter.get(key) == maxLen) {
                res = Math.min(res, right.get(key) - left.get(key) + 1);
            }
        }
        return res;
    }
}

/*各位题友大家好！ 今天是 @负雪明烛 坚持日更的第 27 天。今天力扣上的每日一题是「697. 数组的度」。

        理解题意
        今天题目比较晦涩，需要我来解释一下题目。

        数组的度：数组中各元素出现次数的最大值。对于示例二 [1,2,2,3,1,4,2] ：数组中各元素出现的次数为： 1 出现 2 次， 2 出现 3 次， 3 出现 1 次， 4 出现 1 次，所以数组的度为 3（就是元素 2 出现的次数）。
        题目要求的是与 nums 拥有相同大小的度的最短连续子数组的长度。比如对于示例二 [1,2,2,3,1,4,2]，数组的度为 3，它的度为 3 的最短连续子数组是 [2,2,3,1,4,2] ，返回该子数组长度 6。
        解题思路
        本题可以按照两部分求解：

        先求原数组的度；
        再求与原数组相同度的最短子数组。
        求原数组的度
        求数组的度，本质还是求各个元素的出现次数，我们可以用 字典（哈希表）计数，字典的 key 是元素，value 是该元素出现的次数。因此，字典中所有 value 的最大值就是数组的度 degreedegree。

        求与原数组相同度的最短子数组
        要求的子数组的度与原数组相同度的相同，那么该子数组中也得有 degreedegree 个重复的元素。比如对于示例二[1,2,2,3,1,4,2]，出现次数最多的元素是 2，它的出现次数为 3， 所以数组的度为 3；我们要求的子数组得有 3 个 2 ，所以最短的子数组是 [2,2,3,1,4,2]。注意到了吗？我们要求的最短子数组的起始和终止位置，由出现次数最多的元素 第一次和最后一次出现的位置 确定。

        另外，需要注意的是出现次数最多的元素可能不止一个，比如示例一[1, 2, 2, 3, 1]，数字 1 和数字 2 都出现了 2 次。此时，我们必须分别对每个出现次数为 2 的元素（即数字 1 和数字 2 ）都求一次包含2个它的最短子数组的长度（分别为5和2），最终对所有最短子数组长度取 minmin，得到结果为 2。

        示例一的运行情况如下面动图所示：



        上面的动图对应的 PPT 在下面，可以点击观看。


        8 / 8

        代码
        使用 left 和 right 分别保存了每个元素在数组中第一次出现的位置和最后一次出现的位置；使用 counter 保存每个元素出现的次数。

        数组的度 degreedegree 等于 counter.values() 的最大值；

        对counter再次遍历：

        如果元素 k 出现的次数等于 degreedegree，则找出元素 k 最后一次出现的位置 和 第一次出现的位置，计算两者之差+1，即为子数组长度。
        对所有出现次数等于 degreedegree 的子数组的最短长度，取 minmin。
        PythonC++

class Solution:
        def findShortestSubArray(self, nums: List[int]) -> int:
        left, right = dict(), dict()
        counter = collections.Counter()
        for i, num in enumerate(nums):
        if num not in left:
        left[num] = i
        right[num] = i
        counter[num] += 1
        degree = max(counter.values())
        res = len(nums)
        for k, v in counter.items():
        if v == degree:
        res = min(res, right[k] - left[k] + 1)
        return res
        时间复杂度：O(N)O(N)，因为对数组遍历了一遍，对counter 遍历了两遍。
        空间复杂度：O(N)O(N)，因为 counter 在最坏情况下会跟 nums 的元素个数相等。

        作者：fuxuemingzhu
        链接：https://leetcode-cn.com/problems/degree-of-an-array/solution/xiang-xi-fen-xi-ti-yi-yu-si-lu-jian-ji-d-nvdy/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
