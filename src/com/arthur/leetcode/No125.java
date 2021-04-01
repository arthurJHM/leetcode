package com.arthur.leetcode;

import javax.xml.stream.events.Characters;
import java.util.EnumSet;

/**
 * @title: No125
 * @Author ArthurJi
 * @Date: 2021/4/1 18:06
 * @Version 1.0
 */
public class No125 {
    public static void main(String[] args) {
//        new No125().isPalindrome("A man, a plan, a canal: Panama");
        new No125().isPalindrome("");
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                right--;
                left++;
            } else {
                return false;
            }
        }
        return true;
    }
}
