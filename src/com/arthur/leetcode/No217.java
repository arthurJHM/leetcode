package com.arthur.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @title: No217
 * @Author ArthurJi
 * @Date: 2021/3/27 10:27
 * @Version 1.0
 */
public class No217 {
    public boolean containsDuplicate(int[] nums) {
        return IntStream.of(nums).distinct().count() != nums.length;
    }
}

/*217. 存在重复元素
        给定一个整数数组，判断是否存在重复元素。

        如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。



        示例 1:

        输入: [1,2,3,1]
        输出: true
        示例 2:

        输入: [1,2,3,4]
        输出: false
        示例 3:

        输入: [1,1,1,3,3,4,3,2,4,2]
        输出: true*/
/*
题目描述
        判断给定数组里是否有重复元素。

        思路解析
        方法一 排序
        数组排序后，判断相邻元素是否相等。

        Java

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
时间复杂度 : O(n \log n)O(nlogn)。即排序的时间复杂度。扫描的时间复杂度 O(n)O(n) 可忽略。

        空间复杂度 : O(1)O(1)。 没有用到额外空间。如果深究 Arrays.sort(nums) 使用了栈空间，那就是 O(\log n)O(logn)。

        方法二 使用 set
        遍历数组，数字放到 set 中。如果数字已经存在于 set 中，直接返回 true。如果成功遍历完数组，则表示没有重复元素，返回 false。

        Java

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
方法二之炫技
        这题可以一行代码解决。
        Java 可以用 stream 实现一行将 int[] 转成 Set<Integer> 。为了更简短一些，可以直接利用 stream 的 distinct 和 count 算子。
        如果使用 Python 那更简单： len(set(nums)) != len(nums)。

        代码如下：

        JavaPython

class Solution {
    public boolean containsDuplicate(int[] nums) {
        return IntStream.of(nums).distinct().count() != nums.length;
    }
}
时间复杂度 : O(n)O(n)

        空间复杂度 : O(n)O(n)

        题目拓展
        这题类似题型非常之多，而且 大多都是面试高频题 。

        剑指 Offer 03. 数组中重复的数字
        题目额外限定了数组元素的大小范围，所以有时间复杂度 O(n)O(n)，空间复杂度 O(1)O(1) 的做法。

        287. 寻找重复数
        题目也是额外限定了数组元素的大小范围（注意限定条件和上题不同！），最优做法是快慢指针。关于快慢指针的练习，还可以看这题快乐一下：202. 快乐数，我精心写了题解。

        26. 删除排序数组中的重复项
        做法也是快慢指针。非常经典的题目，C++ 标准库的 unique 方法就是 这么实现的。非常值得一刷。

        136. 只出现一次的数字
        超级经典，我相信绝大多数人已经做过了，没有做过的速速去会会它。姊妹题：137. 只出现一次的数字 II 和 260. 只出现一次的数字 III。这两题也是必刷题，刷了以后会对异或有更深入的了解和认识。其中 剑指 Offer 56 - I. 数组中数字出现的次数 是重复题目，我提供了一种 使用二分解决的思路，值得一看哦～

        作者：sweetiee
        链接：https://leetcode-cn.com/problems/contains-duplicate/solution/chao-xiang-xi-kuai-lai-miao-dong-ru-he-p-sf6e/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
