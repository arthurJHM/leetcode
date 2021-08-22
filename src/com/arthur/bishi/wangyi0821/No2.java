package com.arthur.bishi.wangyi0821;

import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/21 14:32
 * @modifiedBy：
 * @version: 1.0
 */
public class No2 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] split = scanner.nextLine().split(",");
//        int n = Integer.valueOf(split[0]);
//        int k = Integer.valueOf(split[1]);
//        char start = 'a';
//        StringBuilder sb = new StringBuilder();
//        sb.append("a");
//        for (int i = 1; i < n; i++) {
//            char[] chars = sb.toString().toCharArray();
//            for (int j = 0; j < chars.length; j++) {
//                chars[j] = (char) (96 + Math.abs(123 - chars[j]));
//            }
//            String s = new String(chars);
//            String reverse = new StringBuilder(s).reverse().toString();
//            sb.append((char) ('a' + i)).append(reverse);
//        }
//        System.out.println(sb.toString().charAt(k - 1));
    }

    public char findKthBit (int n, int k) {
        // write code here
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        for (int i = 1; i < n; i++) {
            char[] chars = sb.toString().toCharArray();
            for (int j = 0; j < chars.length; j++) {
                chars[j] = (char) (96 + Math.abs(123 - chars[j]));
            }
            String s = new String(chars);
            String reverse = new StringBuilder(s).reverse().toString();
            sb.append((char) ('a' + i)).append(reverse);
        }
        return sb.toString().charAt(k - 1);
    }
}
