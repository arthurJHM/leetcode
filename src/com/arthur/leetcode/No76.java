package com.arthur.leetcode;

/**
 * @title: No76
 * @Author ArthurJi
 * @Date: 2021/4/12 10:04
 * @Version 1.0
 */
public class No76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        int left = 0;
        int right = 0;
        int start = 0;
        int size = Integer.MAX_VALUE;
        int sSize = s.length();
        int tSize = t.length();
        int count = tSize;
        int[] freq = new int[128];
        for (int i = 0; i < tSize; i++) {
            freq[t.charAt(i)]++;
        }
        while (right < sSize) {
            if (freq[s.charAt(right)] > 0) {
                count--;
            }
            freq[s.charAt(right)]--;
            if (count == 0) {
                while (freq[s.charAt(left)] < 0) {
                    freq[s.charAt(left)]++;
                    left++;
                }
                if (right - left + 1 < size) {
                    size = right - left + 1;
                    start = left;
                }
                count++;
                freq[s.charAt(left)]++;
                left++;
            }
            right++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
/*
76. 最小覆盖子串
        给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

        注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。



        示例 1：

        输入：s = "ADOBECODEBANC", t = "ABC"
        输出："BANC"
        示例 2：

        输入：s = "a", t = "a"
        输出："a"
*/
/*简简单单，非常容易理解的滑动窗口思想
        Mcdull

        发布于 2020-05-23
        31.8k
        题解
        滑动窗口的思想：
        用i,j表示滑动窗口的左边界和右边界，通过改变i,j来扩展和收缩滑动窗口，可以想象成一个窗口在字符串上游走，当这个窗口包含的元素满足条件，即包含字符串T的所有元素，记录下这个滑动窗口的长度j-i+1，这些长度中的最小值就是要求的结果。

        步骤一
        不断增加j使滑动窗口增大，直到窗口包含了T的所有元素

        步骤二
        不断增加i使滑动窗口缩小，因为是要求最小字串，所以将不必要的元素排除在外，使长度减小，直到碰到一个必须包含的元素，这个时候不能再扔了，再扔就不满足条件了，记录此时滑动窗口的长度，并保存最小值

        步骤三
        让i再增加一个位置，这个时候滑动窗口肯定不满足条件了，那么继续从步骤一开始执行，寻找新的满足条件的滑动窗口，如此反复，直到j超出了字符串S范围。

        面临的问题：
        如何判断滑动窗口包含了T的所有元素？
        我们用一个字典need来表示当前滑动窗口中需要的各元素的数量，一开始滑动窗口为空，用T中各元素来初始化这个need，当滑动窗口扩展或者收缩的时候，去维护这个need字典，例如当滑动窗口包含某个元素，我们就让need中这个元素的数量减1，代表所需元素减少了1个；当滑动窗口移除某个元素，就让need中这个元素的数量加1。
        记住一点：need始终记录着当前滑动窗口下，我们还需要的元素数量，我们在改变i,j时，需同步维护need。
        值得注意的是，只要某个元素包含在滑动窗口中，我们就会在need中存储这个元素的数量，如果某个元素存储的是负数代表这个元素是多余的。比如当need等于{'A':-2,'C':1}时，表示当前滑动窗口中，我们有2个A是多余的，同时还需要1个C。这么做的目的就是为了步骤二中，排除不必要的元素，数量为负的就是不必要的元素，而数量为0表示刚刚好。
        回到问题中来，那么如何判断滑动窗口包含了T的所有元素？结论就是当need中所有元素的数量都小于等于0时，表示当前滑动窗口不再需要任何元素。
        优化
        如果每次判断滑动窗口是否包含了T的所有元素，都去遍历need看是否所有元素数量都小于等于0，这个会耗费O(k)O(k)的时间复杂度，k代表字典长度，最坏情况下，k可能等于len(S)。
        其实这个是可以避免的，我们可以维护一个额外的变量needCnt来记录所需元素的总数量，当我们碰到一个所需元素c，不仅need[c]的数量减少1，同时needCnt也要减少1，这样我们通过needCnt就可以知道是否满足条件，而无需遍历字典了。
        前面也提到过，need记录了遍历到的所有元素，而只有need[c]>0大于0时，代表c就是所需元素

        图示
        以S="DOABECODEBANC"，T="ABC"为例
        初始状态：
        image.png
        步骤一：不断增加j使滑动窗口增大，直到窗口包含了T的所有元素，need中所有元素的数量都小于等于0，同时needCnt也是0
        image.png
        步骤二：不断增加i使滑动窗口缩小，直到碰到一个必须包含的元素A，此时记录长度更新结果
        image.png
        步骤三：让i再增加一个位置，开始寻找下一个满足条件的滑动窗口
        image.png

        代码

        def minWindow(self, s: str, t: str) -> str:
        need=collections.defaultdict(int)
        for c in t:
        need[c]+=1
        needCnt=len(t)
        i=0
        res=(0,float('inf'))
        for j,c in enumerate(s):
        if need[c]>0:
        needCnt-=1
        need[c]-=1
        if needCnt==0:       #步骤一：滑动窗口包含了所有T元素
        while True:      #步骤二：增加i，排除多余元素
        c=s[i]
        if need[c]==0:
        break
        need[c]+=1
        i+=1
        if j-i<res[1]-res[0]:   #记录结果
        res=(i,j)
        need[s[i]]+=1  #步骤三：i增加一个位置，寻找新的满足条件滑动窗口
        needCnt+=1
        i+=1
        return '' if res[1]>len(s) else s[res[0]:res[1]+1]    #如果res始终没被更新过，代表无满足条件的结果
        我们会用j扫描一遍S，也会用i扫描一遍S，最多扫描2次S，所以时间复杂度是O(n)O(n)，空间复杂度为O(k)O(k)，k为S和T中的字符集合。

        下一篇：最小覆盖子串（双指针：滑动窗口 + HashMap 存字符出现的次数☀）（再看+）
        © 著作权归作者所有
        36
        条评论
        精选评论(3)
        nu-li-fen-dou-huo-huo-huo
        努力奋斗火火火
        2020-09-06
        点赞楼主思路！根据楼主思路写的Java版本

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        int[] need = new int[128];
        //记录需要的字符的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        //l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        //遍历所有字符
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) {//需要字符c
                count--;
            }
            need[c]--;//把右边的字符加入窗口
            if (count == 0) {//窗口中已经包含所有字符
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;//释放右边移动出窗口的字符
                    l++;//指针右移
                }
                if (r - l + 1 < size) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    size = r - l + 1;
                    start = l;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                //l向右移动后窗口肯定不能满足了 重新开始循环
                //应该是释放左边移动出窗口的字符
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}*/
