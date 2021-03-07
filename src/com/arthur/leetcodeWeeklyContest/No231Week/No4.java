package com.arthur.leetcodeWeeklyContest.No231Week;

/**
 * @title: No4
 * @Author ArthurJi
 * @Date: 2021/3/7 11:13
 * @Version 1.0
 */
public class No4 {
    public static void main(String[] args) {
//        new No4().minChanges(new int[]{1,2,4,1,2,5,1,2,6}, 3);
        System.out.println(new No4().minChanges(new int[]{26,19,19,28,13,14,6,25,28,19,0,15,25,11}, 3));
    }
    public int minChanges(int[] nums, int k) {
        int[] temp = new int[k];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            gettemp(nums, temp, i, k);
            int tempAns = 0;
            for (int j = 0; j < nums.length; j++) {
                if(temp[j % k] != nums[j]){
                    tempAns++;
                }
            }
            ans = Math.min(ans, tempAns);
        }
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            gettemp_2(nums, temp, i, k);
            int tempAns = 0;
            for (int j = nums.length - 1; j >= 0; j--) {
                int add = nums.length % k;
                if(temp[(j + add - 1) % k] != nums[j]){
                    tempAns++;
                }
            }
            ans = Math.min(ans, tempAns);
        }

        return ans;
    }

    private void gettemp(int[] nums, int[] temp, int i, int k) {
        int xor = 0;
        for (int j = 0; j < k; j++) {
            if(j != i){
                temp[j] = nums[j];
                xor ^= nums[j];
            }
            temp[i] = xor;
        }
    }
    private void gettemp_2(int[] nums, int[] temp, int i, int k) {
        int xor = 0;
        for (int j = nums.length - k; j <= nums.length - 1; j++) {
            if(j != i){
                temp[j - nums.length + k] = nums[j];
                xor ^= nums[j];
            }
            temp[i - nums.length + k] = xor;
        }
    }
}
/*5700. 使所有区间的异或结果为零 显示英文描述
        通过的用户数19
        尝试过的用户数70
        用户总通过次数19
        用户总提交次数105
        题目难度Hard
        给你一个整数数组 nums​​​ 和一个整数 k​​​​​ 。区间 [left, right]（left <= right）的 异或结果 是对下标位于 left 和 right（包括 left 和 right ）之间所有元素进行 XOR 运算的结果：nums[left] XOR nums[left+1] XOR ... XOR nums[right] 。

        返回数组中 要更改的最小元素数 ，以使所有长度为 k 的区间异或结果等于零。



        示例 1：

        输入：nums = [1,2,0,3,0], k = 1
        输出：3
        解释：将数组 [1,2,0,3,0] 修改为 [0,0,0,0,0]
        示例 2：

        输入：nums = [3,4,5,2,1,7,3,4,7], k = 3
        输出：3
        解释：将数组 [3,4,5,2,1,7,3,4,7] 修改为 [3,4,7,3,4,7,3,4,7]
        示例 3：

        输入：nums = [1,2,4,1,2,5,1,2,6], k = 3
        输出：3
        解释：将数组[1,2,4,1,2,5,1,2,6] 修改为 [1,2,3,1,2,3,1,2,3]


        提示：

        1 <= k <= nums.length <= 2000
        ​​​​​​0 <= nums[i] < 210*/
