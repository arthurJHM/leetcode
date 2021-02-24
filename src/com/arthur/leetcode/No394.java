package com.arthur.leetcode;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @title: No394
 * @Author ArthurJi
 * @Date: 2021/2/24 19:02
 * @Version 1.0
 */
public class No394 {
    public static void main(String[] args) {

    }
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (char c :s.toCharArray()){
            if(c == '[') {
                stack_multi.add(multi);
                stack_res.add(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if(c == ']') {
                StringBuilder temp = new StringBuilder();
                int mul = stack_multi.removeLast();
                for (int i = 0; i < mul; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + temp);
            } else if(Character.isDigit(c)) {
                multi= multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}

//394. 字符串解码
/*解法一：辅助栈法
        本题难点在于括号内嵌套括号，需要从内向外生成与拼接字符串，这与栈的先入后出特性对应。

        算法流程：

        构建辅助栈 stack， 遍历字符串 s 中每个字符 c；
        当 c 为数字时，将数字字符转化为数字 multi，用于后续倍数计算；
        当 c 为字母时，在 res 尾部添加 c；
        当 c 为 [ 时，将当前 multi 和 res 入栈，并分别置空置 00：
        记录此 [ 前的临时结果 res 至栈，用于发现对应 ] 后的拼接操作；
        记录此 [ 前的倍数 multi 至栈，用于发现对应 ] 后，获取 multi × [...] 字符串。
        进入到新 [ 后，res 和 multi 重新记录。
        当 c 为 ] 时，stack 出栈，拼接字符串 res = last_res + cur_multi * res，其中:
        last_res是上个 [ 到当前 [ 的字符串，例如 "3[a2[c]]" 中的 a；
        cur_multi是当前 [ 到 ] 内字符串的重复倍数，例如 "3[a2[c]]" 中的 2。
        返回字符串 res。
        复杂度分析：

        时间复杂度 O(N)O(N)，一次遍历 s；
        空间复杂度 O(N)O(N)，辅助栈在极端情况下需要线性空间，例如 2[2[2[a]]]。

        1 / 8

        PythonJava

class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for(Character c : s.toCharArray()) {
            if(c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }
            else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for(int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(stack_res.removeLast() + tmp);
            }
            else if(c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }
        return res.toString();
    }
}
解法二：递归法
        总体思路与辅助栈法一致，不同点在于将 [ 和 ] 分别作为递归的开启与终止条件：

        当 s[i] == ']' 时，返回当前括号内记录的 res 字符串与 ] 的索引 i （更新上层递归指针位置）；
        当 s[i] == '[' 时，开启新一层递归，记录此 [...] 内字符串 tmp 和递归后的最新索引 i，并执行 res + multi * tmp 拼接字符串。
        遍历完毕后返回 res。
        复杂度分析：

        时间复杂度 O(N)O(N)，递归会更新索引，因此实际上还是一次遍历 s；
        空间复杂度 O(N)O(N)，极端情况下递归深度将会达到线性级别。
        PythonJava

class Solution {
    public String decodeString(String s) {
        return dfs(s, 0)[0];
    }
    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while(i < s.length()) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            else if(s.charAt(i) == '[') {
                String[] tmp = dfs(s, i + 1);
                i = Integer.parseInt(tmp[0]);
                while(multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            }
            else if(s.charAt(i) == ']')
                return new String[] { String.valueOf(i), res.toString() };
            else
                res.append(String.valueOf(s.charAt(i)));
            i++;
        }
        return new String[] { res.toString() };
    }
}

作者：jyd
        链接：https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
