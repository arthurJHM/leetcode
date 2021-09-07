package com.arthur.bishi.baidu0907;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/9/7 19:01
 * @modifiedBy：
 * @version: 1.0
 */
public class No2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < T; i++) {
            StringBuilder s = new StringBuilder(scanner.nextLine());
            for (int j = s.length() - 1; j >= 0; j--) {
                if(s.charAt(j) == '0') {
                    StringBuilder temp = new StringBuilder("1");
                    for (int k = 0; k < s.length() - 1 - j; j++) {
                        temp.append("0");
                    }
                    s = new StringBuilder((new BigInteger(s.toString())).subtract(new BigInteger(temp.toString())).toString());
                } else if(s.charAt(j) > '3'){
                    s.replace(j, j + 1, "3");
                }
            }
            System.out.println(s);
        }
    }
}
