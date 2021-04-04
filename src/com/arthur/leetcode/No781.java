package com.arthur.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @title: No781
 * @Author ArthurJi
 * @Date: 2021/4/4 19:24
 * @Version 1.0
 */
public class No781 {
    public static void main(String[] args) {

    }

    public int numRabbits(int[] answers) {
        int len = answers.length;
        Arrays.sort(answers);
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int cur = answers[i];
            ans += cur + 1;
            while (cur-- > 0 && i + 1 < len && answers[i] == answers[i + 1]) {
                i++;
            }
        }
        return ans;
    }
}
/*
781. 森林中的兔子
        森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。

        返回森林中兔子的最少数量。

        示例:
        输入: answers = [1, 1, 2]
        输出: 5
        解释:
        两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
        之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
        设回答了 "2" 的兔子为蓝色。
        此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
        因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。

        输入: answers = [10, 10, 10]
        输出: 11

        输入: answers = []
        输出: 0*/
/*
基本分析
        首先，兔子它不会说谎 (｀・ω・´)，因此我们可以得出以下结论：

        同一颜色的兔子回答的数值必然是一样的
        但回答同样数值的，不一定就是同颜色兔子
        举个🌰，假如有 3 只白兔，每只白兔的回答必然都是 2（对应结论 1）；但假如有兔子回答了数值 2，可能只是三只白兔，也可能是三只白兔和三只灰兔同时进行了回答（对应结论 2）。

        答案要我们求最少的兔子数量。

        不妨设有某种颜色的兔子 mm 只，它们回答的答案数值为 cntcnt，那么 mm 和 cntcnt 满足什么关系？

        显然两者关系为 m = cnt + 1m=cnt+1。

        但如果是在 answersanswers 数组里，回答 cntcnt 的数量为 tt 的话呢？这时候我们需要分情况讨论：

        t \leqslant cnt + 1t⩽cnt+1 : 为达到「最少的兔子数量」，我们可以假定这 tt 只兔子为同一颜色，这样能够满足题意，同时不会导致「额外」兔子数量增加（颜色数量最少）。
        t > cnt + 1t>cnt+1 : 我们知道回答 cntcnt 的兔子应该有 cnt + 1cnt+1 只。这时候说明有数量相同的不同颜色的兔子进行了回答。为达到「最少的兔子数量」，我们应当将 tt 分为若干种颜色，并尽可能让某一种颜色的兔子为 cnt + 1cnt+1 只，这样能够满足题意，同时不会导致「额外」兔子数量增加（颜色数量最少）。
        换句话说，我们应该让「同一颜色的兔子数量」尽量多，从而实现「总的兔子数量」最少。

        证明
        我们来证明一下，为什么这样的贪心思路是对的：

        基于上述分析，我们其实是在处理 answersanswers 数组中每一个 cntcnt ，使得满足题意的前提下，数值 cntcnt 带来的影响（总的兔子数量，或者说总的颜色数量）最小。

        首先 answersanswers 中的每个数都会导致我们总的兔子数量增加，因此我们应该「让 answersanswers 的数字尽可能变少」，也就是我们需要去抵消掉 answersanswers 中的一些数字。

        对于 answersanswers 中的某个 cntcnt 而言（注意是某个 cntcnt，含义为一只兔子的回答），必然代表了有 cnt + 1cnt+1 只兔子，同时也代表了数值 cntcnt 最多在 answersanswers 数组中出现 cnt + 1cnt+1 次（与其颜色相同的兔子都进行了回答）。

        这时候我们可以从数组中移走 cnt + 1cnt+1 个数值 cntcnt（如果有的话）。

        当每次处理 cntcnt 的时候，我们都执行这样的抵消操作。最后得到的 answersanswers 数值数量必然最少（而固定），抵消完成后的 answersanswers 中的每个 cntcnt 对答案的影响也固定（增加 cnt + 1cnt+1），从而实现「总的兔子数量」最少。

        相反，如果不执行这样的操作的话，得到的 answersanswers 数值数量必然会更多，「总的兔子数量」也必然会更多，也必然不会比这样做法更优。

        模拟解法
        按照上述思路，我们可以先对 answersanswers 进行排序，然后根据遍历到某个 cntcnt 时，将其对答案的影响应用到 ansans 中（ans += cnt + 1），并将后面的 cntcnt 个 cntcnt 进行忽略。

        代码（感谢 @Qian、@宫水三叶的小迷妹 和 @007 三位同学提供的其他语言版本）：

        javac++pythongolang

class Solution {
    public int numRabbits(int[] cs) {
        Arrays.sort(cs);
        int n = cs.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = cs[i];
            ans += cnt + 1;
            // 跳过「数值 cnt」后面的 cnt 个「数值 cnt」
            int k = cnt;
            while (k-- > 0 && i + 1 < n && cs[i] == cs[i + 1]) i++;
        }
        return ans;
    }
}
时间复杂度：O(n\log{n})O(nlogn)
        空间复杂度：O(1)O(1)
        统计分配
        我们也可以先对所有出现过的数字进行统计，然后再对数值进行（颜色）分配。

        代码（感谢 @Qian 和 @007 两位同学提供的其他语言版本）：

        javac++golang

class Solution {
    int N = 1009;
    int[] counts = new int[N];
    public int numRabbits(int[] cs) {
        // counts[x] = cnt 代表在 cs 中数值 x 的数量为 cnt
        for (int i : cs) counts[i]++;
        int ans = counts[0];
        for (int i = 1; i < N; i++) {
            int per = i + 1;
            int cnt = counts[i];
            int k = cnt / per;
            if (k * per < cnt) k++;
            ans += k * per;
        }
        return ans;
    }
}
时间复杂度：O(n)O(n)
        空间复杂度：O(n)O(n)
        拓展
        保持题目现有的条件不变，问题改为「问兔子颜色数量可能有多少种」，又该如何求解呢？

        下午揭晓吧（因为要出门了 ~

        最后
        如果有帮助到你，请给题解点个赞和收藏，让更多的人看到 ~ ("▔□▔)/

        如有不理解的地方，欢迎你在评论区给我留言，我都会逐一回复 ~

        也欢迎你 关注我 ，提供追求「证明」&「思路」的高质量题解

        作者：AC_OIer
        链接：https://leetcode-cn.com/problems/rabbits-in-forest/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-v17p5/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
