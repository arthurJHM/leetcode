package com.arthur.leetcode;

/**
 * @title: No287_2
 * @Author ArthurJi
 * @Date: 2021/3/21 15:02
 * @Version 1.0
 */
public class No287_2 {
    public int findDuplicate(int[] nums) {
        int fast = nums[nums[0]];
        int slow = nums[0];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        int fast_2 = fast;
        int slow_2 = 0;
        while (fast_2 != slow_2) {
            fast_2 = nums[fast_2];
            slow_2 = nums[slow_2];
        }
        return fast_2;
    }
}

/*解题思路
        使用环形链表II的方法解题（142.环形链表II），使用 142 题的思想来解决此题的关键是要理解如何将输入的数组看作为链表。
        首先明确前提，整数的数组 nums 中的数字范围是 [1,n]。考虑一下两种情况：

        如果数组中没有重复的数，以数组 [1,3,4,2]为例，我们将数组下标 n 和数 nums[n] 建立一个映射关系 f(n)f(n)，
        其映射关系 n->f(n)为：
        0->1
        1->3
        2->4
        3->2
        我们从下标为 0 出发，根据 f(n)f(n) 计算出一个值，以这个值为新的下标，再用这个函数计算，以此类推，直到下标超界。这样可以产生一个类似链表一样的序列。
        0->1->3->2->4->null

        如果数组中有重复的数，以数组 [1,3,4,2,2] 为例,我们将数组下标 n 和数 nums[n] 建立一个映射关系 f(n)f(n)，
        其映射关系 n->f(n) 为：
        0->1
        1->3
        2->4
        3->2
        4->2
        同样的，我们从下标为 0 出发，根据 f(n)f(n) 计算出一个值，以这个值为新的下标，再用这个函数计算，以此类推产生一个类似链表一样的序列。
        0->1->3->2->4->2->4->2->……
        这里 2->4 是一个循环，那么这个链表可以抽象为下图：


        从理论上讲，数组中如果有重复的数，那么就会产生多对一的映射，这样，形成的链表就一定会有环路了，

        综上
        1.数组中有一个重复的整数 <==> 链表中存在环
        2.找到数组中的重复整数 <==> 找到链表的环入口

        至此，问题转换为 142 题。那么针对此题，快、慢指针该如何走呢。根据上述数组转链表的映射关系，可推出
        142 题中慢指针走一步 slow = slow.next ==> 本题 slow = nums[slow]
        142 题中快指针走两步 fast = fast.next.next ==> 本题 fast = nums[nums[fast]]

        代码
        Java

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre1 = 0;
        int pre2 = slow;
        while(pre1 != pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
}

作者：kirsche
        链接：https://leetcode-cn.com/problems/find-the-duplicate-number/solution/287xun-zhao-zhong-fu-shu-by-kirsche/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
