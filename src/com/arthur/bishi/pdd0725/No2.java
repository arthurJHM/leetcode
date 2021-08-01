package com.arthur.bishi.pdd0725;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/7/25 19:16
 * @modifiedBy：
 * @version: 1.0
 */
public class No2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> ji = new LinkedList<>();
        LinkedList<Integer> ya = new LinkedList<>();
        int[] book = new int[14];
        for (int i = 0; i < N; i++) {
            ji.add(scanner.nextInt());
        }
        for (int i = 0; i < N; i++) {
            ya.add(scanner.nextInt());
        }

        int J = 0;
        int Y = 0;
        while (!ji.isEmpty() || !ya.isEmpty()) {
            Integer ta = ji.peek();
            if (ta != null) {
                if (book[ta] == 0) {
                    ji.remove();
                    stack.add(ta);
                    book[ta] = 1;
                } else {
                    ji.remove();
                    J++;
                    while (!stack.isEmpty() && stack.lastElement() != ta) {
                        book[stack.lastElement()] = 0;
                        J++;
                        stack.pop();
                    }
                    if (!stack.isEmpty()) {
                        J++;
                        book[stack.pop()] = 0;
                    }

                    if (!ji.isEmpty()) {
                        int t = ji.remove();
                        stack.add(t);
                        book[t] = 1;
                    }
                }
            }


            Integer tb = ya.peek();
            if (tb != null) {
                if (book[tb] == 0) {
                    ya.remove();
                    stack.add(tb);
                    book[tb] = 1;
                } else {
                    ya.remove();
                    Y++;
                    while (!stack.isEmpty() && stack.lastElement() != tb) {
                        book[stack.lastElement()] = 0;
                        Y++;
                        stack.pop();
                    }
                    if (!stack.isEmpty()) {
                        Y++;
                        book[stack.pop()] = 0;
                    }
                    if (!ya.isEmpty()) {
                        int t = ya.remove();
                        stack.add(t);
                        book[t] = 1;
                    }
                }
            }
        }

        int temp;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            if (temp % 2 == 1) {
                J++;
            } else {
                Y++;
            }
        }
        System.out.printf("%d %d", J, Y);
    }
}
