package com.arthur.leetcode;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @title: No220
 * @Author ArthurJi
 * @Date: 2021/4/17 11:24
 * @Version 1.0
 */
public class No220 {
    public static void main(String[] args) {
        new No220().containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long cur = (long) nums[i];
            Long l = treeSet.floor(cur);
            Long r = treeSet.ceiling(cur);
            if (l != null && cur - l <= t) {
                return true;
            }
            if (r != null && r - cur <= t) {
                return true;
            }
            treeSet.add(cur);//这行如果放在最后一行，在k==0的时候，就会有错误
            if (i >= k) {
                treeSet.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}

/*
220. 存在重复元素 III
        给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。

        如果存在则返回 true，不存在返回 false。



        示例 1：

        输入：nums = [1,2,3,1], k = 3, t = 0
        输出：true
        示例 2：

        输入：nums = [1,0,1,1], k = 1, t = 2
        输出：true
        示例 3：

        输入：nums = [1,5,9,1,5,9], k = 2, t = 3
        输出：false

*/
/*

【宫水三叶】一题双解：「滑动窗口 & 二分」&「桶排序」解法
        宫水三叶
        发布于 2 小时前
        1.8k
        滑动窗口 & 二分
        根据题意，对于任意一个位置 ii（假设其值为 uu），我们其实是希望在下标范围为 [max(0, i - k), i)[max(0,i−k),i) 内找到值范围在 [u - t, u + t][u−t,u+t] 的数。

        因此我们可以使用一个「有序集合」去维护长度为 kk 的滑动窗口内的数。

        每次都在「有序集合」中应用「二分查找」，找到「小于等于 uu 的最大值」和「大于等于 uu 的最小值」，即「有序集合」中的最接近 uu 的数。然后判断两值是否落在 [u - t, u + t][u−t,u+t] 范围内。

        IMG_1693.PNG

        由于我们希望对「有序集合」应用「二分」，找到最接近 uu 的数，因此我们需要使用 TreeSetTreeSet 数据结构（基于红黑树，因此查找和插入都具有折半的效率），并且由于 numsnums 中的数较大，会存在 intint 溢出问题，我们需要使用 longlong 来存储。

        代码（感谢 @Benhao 和 @wqs 提供的其他语言版本 ）：


class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long u = nums[i] * 1L;
            // 从 ts 中找到小于等于 u 的最大值（小于等于 u 的最接近 u 的数）
            Long l = ts.floor(u);
            // 从 ts 中找到大于等于 u 的最小值（大于等于 u 的最接近 u 的数）
            Long r = ts.ceiling(u);
            if(l != null && u - l <= t) return true;
            if(r != null && r - u <= t) return true;
            // 将当前数加到 ts 中，并移除下标范围不在 [max(0, i - k), i) 的数（维持滑动窗口大小为 k）
            ts.add(u);
            if (i >= k) ts.remove(nums[i - k] * 1L);
        }
        return false;
    }
}
时间复杂度：TreeSetTreeSet 基于红黑树，查找和插入都是 O(log{k})O(logk) 复杂度。整体复杂度为 O(n\log{k})O(nlogk)
        空间复杂度：O(k)O(k)
        桶排序
        上述解法无法做到线性的原因是：我们需要在大小为 kk 的滑动窗口所在的「有序集合」中找到与 uu 接近的数。

        如果我们能够将 kk 个数字分到 kk 个桶的话，那么我们就能 O(1)O(1) 的复杂度确定是否有 [u - t, u + t][u−t,u+t] 的数字（检查目标桶是否有元素）。

        具体的做法为：令桶的大小为 size = t + 1size=t+1，根据 uu 计算所在桶编号：

        如果已经存在该桶，说明前面已有 [u - t, u + t][u−t,u+t] 范围的数字，返回 truetrue
        如果不存在该桶，则检查相邻两个桶的元素是有 [u - t, u + t][u−t,u+t] 范围的数字，如有 返回 truetrue
        建立目标桶，并删除下标范围不在 [max(0, i - k), i)[max(0,i−k),i) 内的桶
        代码（感谢 @Benhao 和 @answerer 提供的其他语言版本 ）：


class Solution {
    long size;
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<>();
        size = t + 1L;
        for (int i = 0; i < n; i++) {
            long u = nums[i] * 1L;
            long idx = getIdx(u);
            // 目标桶已存在（桶不为空），说明前面已有 [u - t, u + t] 范围的数字
            if (map.containsKey(idx)) return true;
            // 检查相邻的桶
            long l = idx - 1, r = idx + 1;
            if (map.containsKey(l) && u - map.get(l) <= t) return true;
            if (map.containsKey(r) && map.get(r) - u <= t) return true;
            // 建立目标桶
            map.put(idx, u);
            // 移除下标范围不在 [max(0, i - k), i) 内的桶
            if (i >= k) map.remove(getIdx(nums[i - k] * 1L));
        }
        return false;
    }
    long getIdx(long u) {
        return u >= 0 ? u / size : (u + 1) / size - 1;
    }
}
时间复杂度：O(n)O(n)
        空间复杂度：O(k)O(k)*/
