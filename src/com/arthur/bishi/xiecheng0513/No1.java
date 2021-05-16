package com.arthur.bishi.xiecheng0513;

import java.util.Scanner;

/**
 * @title: No1
 * @Author ArthurJi
 * @Date: 2021/5/13 20:21
 * @Version 1.0
 */
public class No1 {
    static int[] dp;
    public static void main(String[] args) {
        new No2();
        Scanner in = new Scanner(System.in);

        int _scores_size = 0;
        _scores_size = Integer.parseInt(in.nextLine().trim());
        int[] _scores = new int[_scores_size];
        for (int i = 0; i < _scores_size; i++) {
            _scores[i] = Integer.parseInt(in.nextLine().trim());
        }

        int _card_size = 0;
        _card_size = Integer.parseInt(in.nextLine().trim());
        int[] _card = new int[5];
        for (int i = 0; i < _card_size; i++) {
            _card[Integer.parseInt(in.nextLine().trim())]++;
        }

        dp = new int[_scores_size];
        int res = process(_scores, _card);
        System.out.println(res);

//        dp[i] = dp[i - 1]
    }

    /** 
    * @Description:  ceshifenzhi2
    * @Param: [scores, card] 
    * @return: int 
    * @Author: hengmingji
    * @Date: 2021/5/15-20:16
    */
    private static int process(int[] scores, int[] card) {
//        ceshi
//        ceshi
//        process()
        // TODO: 2021/5/15 这个代码怕是写不出来了  测试一下todo
        // FIXME: 2021/5/15 测试一下fixme
        return 0;
    }
}
