package com.arthur.leetcode;

/**
 * @title: No765
 * @Author ArthurJi
 * @Date: 2021/2/14 21:45
 * @Version 1.0
 */
public class No765 {
    int[] p;
    public static void main(String[] args) {
        System.out.println(new No765().minSwapsCouples(new int[]{0, 2, 1, 3}));
    }

    public  int minSwapsCouples(int[] row) {
        int n = row.length;
        int m = n / 2;
        p = new int[m];
        for (int i = 0; i < m; i++) { //每一个都是一个类  并且一共只有m类   需要完全割裂p[] 数组和原始的row  没有对应关系的  p[]数组只是用来不同类的标记
            p[i] = i;
        }
        for (int i = 0; i < n; i+=2) {
            union(row[i] / 2, row[i + 1] / 2);  //表明相邻的俩个数所对应的类需要合并
        }
        int num = 0;
        for (int i = 0; i < m; i++) {
            if(find(i) == i) {
                num++;
            }
        }
        return m - num;
    }

    private void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }

    private int find(int a) {//找到属于哪一类
        if(p[a] != a) {
            p[a] = find(p[a]); //路径压缩了
        }
        return p[a];
    }
}

  /*  N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。

        人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。

        这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。

        示例 1:

        输入: row = [0, 2, 1, 3]
        输出: 1
        解释: 我们只需要交换row[1]和row[2]的位置即可。
        示例 2:

        输入: row = [3, 2, 0, 1]
        输出: 0
        解释: 无需交换座位，所有的情侣都已经可以手牵手了。*/

