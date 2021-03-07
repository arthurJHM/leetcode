package com.arthur.leetcodeWeeklyContest.No231Week;

import java.math.BigInteger;

/**
 * @title: No2
 * @Author ArthurJi
 * @Date: 2021/3/7 10:48
 * @Version 1.0
 */
public class No2 {
    public static void main(String[] args) {

    }
    public int minElements(int[] nums, int limit, int goal) {
        BigInteger temp = new BigInteger("0");
        for (int num : nums) {
            BigInteger num_ = new BigInteger(num + "");
            temp.add(num_);
        }
        BigInteger goal_ = new BigInteger(goal + "");
        BigInteger diff = temp.subtract(goal_).abs();

        BigInteger limit_ = new BigInteger(limit + "");
        BigInteger ans = diff.divide(limit_).add(new BigInteger("1"));
        if(diff.multiply(limit_).equals("0")){
            ans.subtract(new BigInteger("1"));
        }
        return ans.intValue();
    }

    public int minElements_1(int[] nums, int limit, int goal) { //.....过了
        long temp = 0;
        for (int num : nums) {
            temp += num;
        }
        long diff = Math.abs(temp - goal);

        long ans = diff / limit + 1;
        if(diff % limit == 0){
            ans--;
        }
        return (int)ans;
    }
}
/*5698. 构成特定和需要添加的最少元素 显示英文描述
        通过的用户数1288
        尝试过的用户数1767
        用户总通过次数1289
        用户总提交次数3136
        题目难度Medium
        给你一个整数数组 nums ，和两个整数 limit 与 goal 。数组 nums 有一条重要属性：abs(nums[i]) <= limit 。

        返回使数组元素总和等于 goal 所需要向数组中添加的 最少元素数量 ，添加元素 不应改变 数组中 abs(nums[i]) <= limit 这一属性。

        注意，如果 x >= 0 ，那么 abs(x) 等于 x ；否则，等于 -x 。



        示例 1：

        输入：nums = [1,-1,1], limit = 3, goal = -4
        输出：2
        解释：可以将 -2 和 -3 添加到数组中，数组的元素总和变为 1 - 1 + 1 - 2 - 3 = -4 。
        示例 2：

        输入：nums = [1,-10,9,1], limit = 100, goal = 0
        输出：1*/
