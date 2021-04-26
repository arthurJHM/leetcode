package com.arthur.leetcode;

import java.lang.reflect.WildcardType;

/**
 * @title: No1011
 * @Author ArthurJi
 * @Date: 2021/4/26 11:42
 * @Version 1.0
 */
public class No1011 {
    public static void main(String[] args) {
        new No1011().shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
    }

    public int shipWithinDays(int[] weights, int D) {
        int l = 1;
        int r = Integer.MAX_VALUE;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(weights, mid, D)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private boolean check(int[] weights, int t, int d) {
        if(weights[0] > t) {
            return false;
        }
        int k = 1;
        for (int i = 1, sum = weights[0]; i < weights.length; sum = 0, k++) {
            if(weights[i] > t) {
                return false;
            }
            while (i < weights.length && sum + weights[i] <= t) {
                sum += weights[i++];
            }
        }
        return k - 1 <= d;
    }
}
/*
1011. 在 D 天内送达包裹的能力
        传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。

        传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。

        返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。



        示例 1：

        输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
        输出：15
        解释：
        船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
        第 1 天：1, 2, 3, 4, 5
        第 2 天：6, 7
        第 3 天：8
        第 4 天：9
        第 5 天：10

        请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
        示例 2：

        输入：weights = [3,2,2,4,1,4], D = 3
        输出：6
        解释：
        船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
        第 1 天：3, 2
        第 2 天：2, 4
        第 3 天：1, 4
        示例 3：

        输入：weights = [1,2,3,1,1], D = 4
        输出：3
        解释：
        第 1 天：1
        第 2 天：2
        第 3 天：3
        第 4 天：1, 1*/
/*
宫水三叶】利用「二段性」找分割点，以及如何确定「二分范围」
        宫水三叶
        发布于 3 小时前
        2.0k
        二分解法（精确边界）
        假定「D 天内运送完所有包裹的最低运力」为 ans，那么在以 ans 为分割点的数轴上具有「二段性」：

        数值范围在 (-\infty, ans)(−∞,ans) 的运力必然「不满足」 D 天内运送完所有包裹的要求
        数值范围在 (ans, +\infty)(ans,+∞) 的运力必然「满足」 D天内运送完所有包裹的要求
        即我们可以通过「二分」来找到恰好满足 D天内运送完所有包裹的分割点 ans。

        接下来我们要确定二分的范围，由于不存在包裹拆分的情况，考虑如下两种边界情况：

        理论最低运力：只确保所有包裹能够被运送，自然也包括重量最大的包裹，此时理论最低运力为 max，max 为数组 weights 中的最大值
        理论最高运力：使得所有包裹在最短时间（一天）内运算完成，此时理论最低运力为 sum，sum 为数组 weights 的总和
        由此，我们可以确定二分的范围为 [max, sum][max,sum]。

        代码（感谢 @nactran 和 @Benhao 同学提供的其他语言版本）：


class Solution {
    public int shipWithinDays(int[] ws, int d) {
        int max = 0, sum = 0;
        for (int w : ws) {
            max = Math.max(max, w);
            sum += w;
        }
        int l = max, r = sum;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(ws, mid, d)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
    boolean check(int[] ws, int t, int d) {
        int n = ws.length;
        int cnt = 1;
        for (int i = 1, sum = ws[0]; i < n; sum = 0, cnt++) {
            while (i < n && sum + ws[i] <= t) {
                sum += ws[i];
                i++;
            }
        }
        return cnt - 1 <= d;
    }
}
时间复杂度：二分范围为 [max, sum][max,sum]，check 函数的复杂度为 O(n)O(n)。整体复杂度为 O(n\log({\sum_{i= 0}^{n - 1}ws[i]}))O(nlog(∑
        i=0
        n−1
        ​
        ws[i]))
        空间复杂度：O(1)O(1)
        二分解法（粗略边界）
        当然，一个合格的「二分范围」只需要确保包含分割点 ans 即可。因此我们可以利用数据范围来确立粗略的二分范围（从而少写一些代码）：

        利用运力必然是正整数，从而确定左边界为 11
        根据 1 \leqslant D \leqslant weights.length \leqslant 500001⩽D⩽weights.length⩽50000 和 1 \leqslant weights[i] \leqslant 5001⩽weights[i]⩽500，从而确定右边界为 1e81e8
        PS. 由于二分查找具有折半效率，因此「确立粗略二分范围」不会比「通过循环取得精确二分范围」效率低。

        代码：


class Solution {
    public int shipWithinDays(int[] ws, int d) {
        int l = 1, r = (int)1e8;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(ws, mid, d)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
    boolean check(int[] ws, int t, int d) {
        if (ws[0] > t) return false;
        int n = ws.length;
        int cnt = 1;
        for (int i = 1, sum = ws[0]; i < n; sum = 0, cnt++) {
            if (ws[i] > t) return false;
            while (i < n && sum + ws[i] <= t) {
                sum += ws[i];
                i++;
            }
        }
        return cnt - 1 <= d;
    }
}
时间复杂度：二分范围为 [1, 1e8][1,1e8]，check 函数的复杂度为 O(n)O(n)。整体复杂度为 O(n\log{1e8})O(nlog1e8)
        空间复杂度：O(1)O(1)
        其他「二分」相关题解
        二分模板
        29. 两数相除 : 二分 + 倍增乘法解法（含模板）

        二分本质 & 恢复二段性处理

        33. 搜索旋转排序数组（找目标值） : 严格 O(logN)，一起看清二分的本质

        81. 搜索旋转排序数组 II（找目标值） : 详解为何元素相同会导致 O(n)，一起看清二分的本质

        153. 寻找旋转排序数组中的最小值（找最小值） : 严格 O(logN)，一起看清二分的本质

        154. 寻找旋转排序数组中的最小值 II（找最小值） : 详解为何元素相同会导致 O(n)，一起看清二分的本质

        二分 check 函数如何确定
        34. 在排序数组中查找元素的第一个和最后一个位置 : 考察对「二分」的理解，以及 check 函数的「大于 小于」怎么写*/
