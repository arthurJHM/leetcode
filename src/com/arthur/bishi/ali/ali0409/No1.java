package com.arthur.bishi.ali.ali0409;

/**
 * @title: No1
 * @Author ArthurJi
 * @Date: 2021/4/9 15:39
 * @Version 1.0
 */
public class No1 {
    public static void main(String[] args) {
        "Hello    world".replaceAll(" +"," ");
        StringBuilder str = new StringBuilder("Hello    world");
        int j = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            j++;
            if(str.charAt(i) == ' ' && str.charAt(i - 1) == ' ') {
                i++;
            }
            str.setCharAt(j, str.charAt(i));
        }
        System.out.println(str);
    }
}
