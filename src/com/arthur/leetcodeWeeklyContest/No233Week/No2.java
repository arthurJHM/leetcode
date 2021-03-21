package com.arthur.leetcodeWeeklyContest.No233Week;

import java.util.*;

/**
 * @title: No2
 * @Author ArthurJi
 * @Date: 2021/3/21 10:41
 * @Version 1.0
 */
public class No2 {
    public static void main(String[] args) {
        new No2().getNumberOfBacklogOrders(new int[][]{{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}});
    }

    public int getNumberOfBacklogOrders(int[][] orders) {
        int n = orders.length;
        //小根堆
        PriorityQueue<int[]> sell = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //大根堆
        PriorityQueue<int[]> buy = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for (int i = 0; i < n; i++) {
            if(orders[i][2] == 0) {//买  买要比卖大
                buy.offer(orders[i]);
                while (!buy.isEmpty() && !sell.isEmpty() && sell.peek()[0] <= buy.peek()[0]) {//价格
                    if (buy.peek()[1] >= sell.peek()[1]) {//数量
                        int[] temp = buy.poll();
                        temp[1] -= sell.poll()[1];
                        buy.offer(temp);
                    } else {//买的数量更少
                        int[] temp = sell.poll();
                        temp[1] -= buy.poll()[1];
                        sell.offer(temp);
                    }
                }
            } else if(orders[i][2] == 1) {
                //卖  卖要比买小
                sell.offer(orders[i]);
                while (!buy.isEmpty() && !sell.isEmpty() && buy.peek()[0] >= sell.peek()[0]) {//价格
                    if (sell.peek()[1] >= buy.peek()[1]) {//数量
                        int[] temp = sell.poll();
                        temp[1] -= buy.poll()[1];
                        sell.offer(temp);
                    } else {//卖的数量更少
                        int[] temp = buy.poll();
                        temp[1] -= sell.poll()[1];
                        buy.add(temp);
                    }
                }
            }
        }
        long num = 0;
        for (int[] s : sell) {
            num += s[1];
        }
        for (int[] b : buy) {
            num += b[1];
        }
        return (int) (num % 1000000007);
    }
}

/*
5710. 积压订单中的订单总数 显示英文描述
        通过的用户数8
        尝试过的用户数10
        用户总通过次数8
        用户总提交次数11
        题目难度Medium
        给你一个二维整数数组 orders ，其中每个 orders[i] = [pricei, amounti, orderTypei] 表示有 amounti 笔类型为 orderTypei 、价格为 pricei 的订单。

        订单类型 orderTypei 可以分为两种：

        0 表示这是一批采购订单 buy
        1 表示这是一批销售订单 sell
        注意，orders[i] 表示一批共计 amounti 笔的独立订单，这些订单的价格和类型相同。对于所有有效的 i ，由 orders[i] 表示的所有订单提交时间均早于 orders[i+1] 表示的所有订单。

        存在由未执行订单组成的 积压订单 。积压订单最初是空的。提交订单时，会发生以下情况：

        如果该订单是一笔采购订单 buy ，则可以查看积压订单中价格 最低 的销售订单 sell 。如果该销售订单 sell 的价格 低于或等于 当前采购订单 buy 的价格，则匹配并执行这两笔订单，并将销售订单 sell 从积压订单中删除。否则，采购订单 buy 将会添加到积压订单中。
        反之亦然，如果该订单是一笔销售订单 sell ，则可以查看积压订单中价格 最高 的采购订单 buy 。如果该采购订单 buy 的价格 高于或等于 当前销售订单 sell 的价格，则匹配并执行这两笔订单，并将采购订单 buy 从积压订单中删除。否则，销售订单 sell 将会添加到积压订单中。
        输入所有订单后，返回积压订单中的 订单总数 。由于数字可能很大，所以需要返回对 109 + 7 取余的结果。



        示例 1：


        输入：orders = [[10,5,0],[15,2,1],[25,1,1],[30,4,0]]
        输出：6
        解释：输入订单后会发生下述情况：
        - 提交 5 笔采购订单，价格为 10 。没有销售订单，所以这 5 笔订单添加到积压订单中。
        - 提交 2 笔销售订单，价格为 15 。没有采购订单的价格大于或等于 15 ，所以这 2 笔订单添加到积压订单中。
        - 提交 1 笔销售订单，价格为 25 。没有采购订单的价格大于或等于 25 ，所以这 1 笔订单添加到积压订单中。
        - 提交 4 笔采购订单，价格为 30 。前 2 笔采购订单与价格最低（价格为 15）的 2 笔销售订单匹配，从积压订单中删除这 2 笔销售订单。第 3 笔采购订单与价格最低的 1 笔销售订单匹配，销售订单价格为 25 ，从积压订单中删除这 1 笔销售订单。积压订单中不存在更多销售订单，所以第 4 笔采购订单需要添加到积压订单中。
        最终，积压订单中有 5 笔价格为 10 的采购订单，和 1 笔价格为 30 的采购订单。所以积压订单中的订单总数为 6 。
        示例 2：


        输入：orders = [[7,1000000000,1],[15,3,0],[5,999999995,0],[5,1,1]]
        输出：999999984
        解释：输入订单后会发生下述情况：
        - 提交 109 笔销售订单，价格为 7 。没有采购订单，所以这 109 笔订单添加到积压订单中。
        - 提交 3 笔采购订单，价格为 15 。这些采购订单与价格最低（价格为 7 ）的 3 笔销售订单匹配，从积压订单中删除这 3 笔销售订单。
        - 提交 999999995 笔采购订单，价格为 5 。销售订单的最低价为 7 ，所以这 999999995 笔订单添加到积压订单中。
        - 提交 1 笔销售订单，价格为 5 。这笔销售订单与价格最高（价格为 5 ）的 1 笔采购订单匹配，从积压订单中删除这 1 笔采购订单。
        最终，积压订单中有 (1000000000-3) 笔价格为 7 的销售订单，和 (999999995-1) 笔价格为 5 的采购订单。所以积压订单中的订单总数为 1999999991 ，等于 999999984 % (109 + 7) 。


        提示：

        1 <= orders.length <= 105
        orders[i].length == 3
        1 <= pricei, amounti <= 109
        orderTypei 为 0 或 1
*/
/*
class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        //小跟堆，用来存卖
        PriorityQueue<int[]> sell = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //大根堆，用来存买
        PriorityQueue<int[]> buy = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        int n = orders.length;
        for (int i = 0; i < n; i++) {
            if (orders[i][2] == 0) {   //买的情况
                if (sell.isEmpty() == true || sell.size() <= 0) {
                    buy.offer(orders[i]);
                } else {
                    int[] tempBuy = orders[i];
                    //查看积压订单中价格 最低 的销售订单 sell,条件符合
                    while (!sell.isEmpty() && sell.peek()[0] <= tempBuy[0] && tempBuy[1] > 0) {
                        int[] tempSell = sell.poll(); //取出堆顶
                        if(tempBuy[1] < tempSell[1]) { //销售订单数量大于当前的买，即tempSell用不完
                            tempSell[1]-=tempBuy[1];
                            tempBuy[1] = 0;				//置为0，用于后面判断
                            sell.offer(tempSell);		//将多余的放回去
                        }else if(tempBuy[1] > tempSell[1]) {	//当前采购订单多余堆顶的卖订单
                            tempBuy[1]-=tempSell[1]; 			//直接减去
                        }else {
                            tempBuy[1] = 0;						//相等的情况
                        }
                    }
                    if(tempBuy[1] > 0) { //条件不符合了，看买的订单数量是否大于0，大于就加入队列
                        buy.offer(tempBuy);
                    }
                }

            }else {   //卖，与买原理想等
                if(buy.isEmpty() && buy.size() < 1) {
                    sell.offer(orders[i]);
                }else {
                    int[] tempSell = orders[i];
                    while(!buy.isEmpty() && buy.peek()[0] >= tempSell[0] && tempSell[1] > 0) {
                        int[] tempBuy = buy.poll();
                        if(tempSell[1] < tempBuy[1]) {
                            tempBuy[1]-=tempSell[1];
                            tempSell[1] = 0;
                            buy.offer(tempBuy);
                        }else if(tempSell[1] > tempBuy[1]){
                            tempSell[1]-=tempBuy[1];
                        }else {
                            tempSell[1] = 0;
                        }
                    }
                    if(tempSell[1] > 0) {
                        sell.offer(tempSell);
                    }

                }
            }
        }
        //取出队列求和
        long res = 0;
        while(!buy.isEmpty()) {
            res+=buy.poll()[1];
            res= res % 1000000007;
        }
        while(!sell.isEmpty()) {
            res+=sell.poll()[1];
            res= res % 1000000007;
        }
        return (int) res;
    }
}

作者：starxing-2
        链接：https://leetcode-cn.com/problems/number-of-orders-in-the-backlog/solution/javazhi-jie-shi-yong-you-xian-dui-lie-mo-lp6p/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
