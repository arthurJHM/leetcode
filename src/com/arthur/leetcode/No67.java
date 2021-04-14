package com.arthur.leetcode;

/**
 * @title: No67
 * @Author ArthurJi
 * @Date: 2021/4/13 11:21
 * @Version 1.0
 */
public class No67 {
    public static void main(String[] args) {

    }

    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int temp = 0;
        int tempA;
        int tempB;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            tempA = i >= 0 ? a.charAt(i) - '0' : 0;
            tempB = j >= 0 ? b.charAt(j) - '0' : 0;
            temp += (tempA + tempB);
            ans.append(temp % 2);
            temp /= 2;
        }
        ans.append((temp % 2 == 1) ? '1' : "");
        return ans.reverse().toString();
    }

}

/*67. 二进制求和
        给你两个二进制字符串，返回它们的和（用二进制表示）。

        输入为 非空 字符串且只包含数字 1 和 0。



        示例 1:

        输入: a = "11", b = "1"
        输出: "100"
        示例 2:

        输入: a = "1010", b = "1011"
        输出: "10101"
 */
/*    解题方案
            思路
整体思路是将两个字符串较短的用 00 补齐，使得两个字符串长度一致，然后从末尾进行遍历计算，得到最终结果。

        本题解中大致思路与上述一致，但由于字符串操作原因，不确定最后的结果是否会多出一位进位，所以会有 2 种处理方式：

        第一种，在进行计算时直接拼接字符串，会得到一个反向字符，需要最后再进行翻转
        第二种，按照位置给结果字符赋值，最后如果有进位，则在前方进行字符串拼接添加进位
        时间复杂度：O(n)O(n)

        代码
        JavaJavaScript

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }
}
画解

        1 / 3

        想看大鹏画解更多高频面试题，欢迎阅读大鹏的 LeetBook：《画解剑指 Offer 》，O(∩_∩)O

        作者：guanpengchn
        链接：https://leetcode-cn.com/problems/add-binary/solution/hua-jie-suan-fa-67-er-jin-zhi-qiu-he-by-guanpengch/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
