package com.arthur.bishi.aiqiyi0801;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Integer k = Integer.valueOf(line.split(":")[1]);
        String[] nums = line.split(":")[0].split(",");
        double max = Double.MIN_VALUE;
        double temp1 = 0;
        double temp2 = 0;
        for (Integer i = 0; i < k; i++) {
            temp2 += Integer.valueOf(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            temp1 = temp2;
            temp2 = temp2 - Integer.valueOf(nums[i - k]) + Integer.valueOf(nums[i]);
            double rate = (temp2 - temp1) / temp1;
            max = Double.max(max, rate);
        }
        max *= 100;
        System.out.printf("%.2f%%", max);
//        NumberFormat nf = NumberFormat.getPercentInstance();
//        nf.setMinimumFractionDigits(2);
//        nf.setRoundingMode(RoundingMode.HALF_UP);
//        String format = nf.format(max);
//        System.out.println(format);
    }
}
