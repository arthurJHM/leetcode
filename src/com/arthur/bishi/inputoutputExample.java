package com.arthur.bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @title: inputoutputExample
 * @Author ArthurJi
 * @Date: 2021/3/20 10:32
 * @Version 1.0
 */
public class inputoutputExample {
    public static void main(String[] args) {
        in1();
        in2();
        in3();
        in4();
        in5();
    }

    private static void in1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a + b);
        }
    }

    private static void in2() {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < row; i++) {
            scanner.nextLine().split(" ");
        }
    }

    private static void in3() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int sum = 0;
            for (String s : scanner.nextLine().split(" ")) {
                sum += Integer.parseInt(s);
            }
            System.out.println(sum);
        }
    }

    private static void in4() {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < num; i++) {
            String[] s = scanner.nextLine().split(" ");
            Arrays.sort(s);
            for (String str : s) {
                System.out.println(str);
            }
            System.out.println();
        }

    }

    private static void in5() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().replaceAll("\"", "");
        String[] split = s.substring(1, s.length() - 1).split(",");
        int[] ints = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();

    }
}
