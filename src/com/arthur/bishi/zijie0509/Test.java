package com.arthur.bishi.zijie0509;

/**
 * @title: Test
 * @Author ArthurJi
 * @Date: 2021/5/9 19:11
 * @Version 1.0
 */
public class Test {
    static int n = 0;
    public static void main(String[] args) {
        f(12);
        System.out.println(n);
    }
    public static int f(int x) {
        n++;
        if(x <= 2) {
            return 2;
        }
        return f(x - 3) + f(x - 4) + 2;
    }
}
