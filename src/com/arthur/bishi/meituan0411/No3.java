package com.arthur.bishi.meituan0411;


import java.util.Scanner;

/**
 * @title: No3
 * @Author ArthurJi
 * @Date: 2021/4/11 10:20
 * @Version 1.0
 */
public class No3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();

        int Zerocount = countZeor(s);
        int max = 2 * Zerocount - s.length();
        for (int i = 0; i < s.length() - 2; i++) {
            String sub = s.substring(i, i + 3);
            if(sub.equals("001") || sub.equals("101") || sub.equals("110")) {
                max += 1;
            }  else if(sub.equals("111")) {
                max += 3;
            }
        }
    }

    private static int countZeor(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                cnt++;
            }
        }
        return cnt;
    }


}
