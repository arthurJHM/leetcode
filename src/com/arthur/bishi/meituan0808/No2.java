package com.arthur.bishi.meituan0808;

import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/8 9:40
 * @modifiedBy：
 * @version: 1.0
 */
public class No2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String rep = str.replace(" ", "");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(rep.charAt((0)));
        for (int i = 0; i < rep.length(); i++) {
            if(i + 1 >= rep.length()) {
                break;
            }
            if(String.valueOf(rep.charAt(i)).equals(String.valueOf(rep.charAt(i + 1)))) {
                continue;
            }
            stringBuilder.append(rep.charAt(i + 1));
        }
        System.out.println(stringBuilder.toString());
    }
}
