package com.arthur.bishi.aiqiyi0801;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/1 16:36
 * @modifiedBy：
 * @version: 1.0
 */
public class No2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] rains = Arrays.asList(line.substring(1, line.length() - 1).split(",")).stream().mapToInt(Integer::parseInt).toArray();
        int[] copy = rains.clone();
        int len = rains.length;
        int[] res = new int[len];
        boolean[] ff = new boolean[len];
        for (int i = 0; i < len; i++) {
            if(rains[i] != 0) {
                if(ff[rains[i] - 1]) {
                    System.out.printf("[]");
                }
                res[i] = -1;
                ff[rains[i] - 1] = true;
            }
            else {
                if(i < rains.length - 1) {
                    for (int j = i+ 1; j < rains.length; j++) {
                        if(copy[j] != 0) {
                            res[i] = copy[j];
                            ff[copy[j] - 1] = false;
                            copy[j] = 0;
                            break;
                        }
                    }
                } else {
                    res[i] = -1;
                }
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
