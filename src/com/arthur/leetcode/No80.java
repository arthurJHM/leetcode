package com.arthur.leetcode;

/**
 * @title: No80
 * @Author ArthurJi
 * @Date: 2021/4/6 9:57
 * @Version 1.0
 */
public class No80 {
    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        int n = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (n < 2 || nums[i] != nums[n - 2]) {
                nums[n++] = nums[i];
            }
        }
        return n;
    }
}
/*
80. 删除有序数组中的重复项 II
        给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。

        不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。



        说明：

        为什么返回数值是整数，但输出的答案是数组呢？

        请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

        你可以想象内部操作如下:

// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
        int len = removeDuplicates(nums);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for (int i = 0; i < len; i++) {
        print(nums[i]);
        }


        示例 1：

        输入：nums = [1,1,1,2,2,3]
        输出：5, nums = [1,1,2,2,3]
        解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
        示例 2：

        输入：nums = [0,0,1,1,1,1,2,3,3]
        输出：7, nums = [0,0,1,1,2,3,3]
        解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的元素。*/
/*
【宫水三叶】关于「删除有序数组重复项」的通解 ...
        宫水三叶
        发布于 1 小时前
        472
        通用解法
        为了让解法更具有一般性，我们将原问题的「保留 2 位」修改为「保留 k 位」。

        对于此类问题，我们应该进行如下考虑：

        由于是保留 k 个相同数字，对于前 k 个数字，我们可以直接保留
        对于后面的任意数字，能够保留的前提是：与当前写入的位置前面的第 k 个元素进行比较，不相同则保留
        举个🌰，我们令 k=2，假设有如下样例

        [1,1,1,1,1,1,2,2,2,2,2,2,3]

        首先我们先让前 2 位直接保留，得到 1,1
        对后面的每一位进行继续遍历，能够保留的前提是与当前位置的前面 k 个元素不同（答案中的第一个 1），因此我们会跳过剩余的 1，将第一个 2 追加，得到 1,1,2
        继续这个过程，这时候是和答案中的第 2 个 1 进行对比，因此可以得到 1,1,2,2
        这时候和答案中的第 1 个 2 比较，只有与其不同的元素能追加到答案，因此剩余的 2 被跳过，3 被追加到答案：1,1,2,2,3
        代码：


class Solution {
    public int removeDuplicates(int[] nums) {
        return process(nums, 2);
    }
    int process(int[] nums, int k) {
        int u = 0;
        for (int x : nums) {
            if (u < k || nums[u - k] != x) nums[u++] = x;
        }
        return u;
    }
}
时间复杂度：O(n)O(n)
        空间复杂度：O(1)O(1)
        其他
        这是一种针对「数据有序，相同元素保留 k 位」问题更加本质的解法，该解法是从性质出发提炼的，利用了「数组有序 & 保留逻辑」两大主要性质。

        当你掌握这种通解之后，要解决 26. 删除有序数组中的重复项 ，只需要改上述代码一个数字即可（将相同数字保留 2 个修改为保留 1 个）。

        这种通解最早我也在 【宫水三叶】「双指针」&「通用」解法 讲过。

        最后
        如果有帮助到你，请给题解点个赞和收藏，让更多的人看到 ~ ("▔□▔)/

        如有不理解的地方，欢迎你在评论区给我留言，我都会逐一回复 ~

        也欢迎你 关注我 ，提供追求「证明」&「思路」的高质量题解*/
