package com.arthur.bishi.pdd0409;

/**
 * @title: No3
 * @Author ArthurJi
 * @Date: 2021/4/9 15:57
 * @Version 1.0
 */

import java.util.Scanner;

public class No3 {//错的
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        String n = sca.nextLine();
        String s = sca.nextLine();

        int k = Integer.parseInt(n);
        if (strMax(s, k) == "A") {
            System.out.println(-1);
        }
        else {
            System.out.println(strMax(s, k));
        }
    }
    public static String strMax(String s, int k){
        int len = s.length();
        if(count(s, k)) {
            return s;
        }
        char[] c = s.toCharArray();
        for (int i = len - 1; i >= 0; i--) {
            while(c[i] - 'a' > 0){
                c[i] = (char) (c[i] - 1);
                if(count(new String(c), k)) {
                    return new String(c);
                }
            }
            c[i] = 'z';
        }
        return "A";
    }
    public static boolean count(String s, int k){
        int[] co = new int[26];
        for (int i = 0; i < s.length(); i++) {
            co[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < co.length; i++) {
            if(co[i] != 0 && co[i] % k != 0) {
                return false;
            }
        }
        return true;
    }
}