package com.arthur.bishi.ali413;

/**
 * @title: No1
 * @Author ArthurJi
 * @Date: 2021/4/13 11:04
 * @Version 1.0
 */
public class No1 {//二进制加法器
    public static void main(String[] args) {
        System.out.println(new No1().addBinary("111", "1a"));
        System.out.println(new No1().addBinary("111", "11"));
    }
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            if ((i < 0 || a.charAt(i) == '0' || a.charAt(i) == '1') && (j < 0 || b.charAt(j) == '0' || b.charAt(j) == '1')) {
                int sum = ca;
                sum += i >= 0 ? a.charAt(i) - '0' : 0;
                sum += j >= 0 ? b.charAt(j) - '0' : 0;
                ans.append(sum % 2);
                ca = sum / 2;
            } else {
                return null;
            }
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }
}
