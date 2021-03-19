package com.arthur.anyway;

/**
 * @title: Test
 * @Author ArthurJi
 * @Date: 2021/3/19 11:50
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(powTest(10,3));
    }
    public static int powTest(int a, int n) {
        return (int) Math.pow(a, n);
    }
}
