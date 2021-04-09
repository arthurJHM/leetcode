package com.arthur.bishi.yuanjing0408;

import java.util.Scanner;

/**
 * @title: No1
 * @Author ArthurJi
 * @Date: 2021/4/8 19:30
 * @Version 1.0
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }
    public int xxxxxxx(int n) {
        int ans = 0;
        while (n > 0) {
            ans += n / 5;
            n /= 5;
        }
        return ans;
    }
}
