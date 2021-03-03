package com.arthur.leetcode;

/**
 * @title: No338
 * @Author ArthurJi
 * @Date: 2021/3/3 13:40
 * @Version 1.0
 */
public class No338 {
    public static void main(String[] args) {

    }

    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;
        for (int i = 1; i <= num; i++) {
            if((i & 1) == 0) {
                ans[i] = ans[i / 2];
            } else {
                ans[i] = ans[i - 1] + 1;
            }
        }
        return ans;
    }
}

//338. 比特位计数
/*
338. 比特位计数
        给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

        示例 1:

        输入: 2
        输出: [0,1,1]
        示例 2:

        输入: 5
        输出: [0,1,1,2,1,2]*/
/*
思路
        对于所有的数字，只有两类：

        奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
        举例：
        0 = 0       1 = 1
        2 = 10      3 = 11
        偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
        举例：
        2 = 10       4 = 100       8 = 1000
        3 = 11       6 = 110       12 = 1100
        另外，0 的 1 个数为 0，于是就可以根据奇偶性开始遍历计算了。

        代码

        vector<int> countBits(int num) {
        vector<int> result(num+1);
        result[0] = 0;
        for(int i = 1; i <= num; i++)
        {
        if(i % 2 == 1)
        {
        result[i] = result[i-1] + 1;
        }
        else
        {
        result[i] = result[i/2];
        }
        }

        return result;
        }

        作者：duadua
        链接：https://leetcode-cn.com/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
