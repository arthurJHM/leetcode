package com.arthur.bishi.pdd0822;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/22 19:01
 * @modifiedBy：
 * @version: 1.0
 */
public class No3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            BigInteger ten = new BigInteger("10");
            BigInteger two = new BigInteger("2");
            BigInteger BN = new BigInteger("1");
            BigInteger BM = new BigInteger(M + "");
            BigInteger BMT = new BigInteger(M + "");
            while (N  > 1) {
                BN = BN.multiply(ten);
                N--;
            }
            while (BN.compareTo(BM) > 0) {
                BM = BM.multiply(two);
            }
            while (BN.compareTo(BM) <= 0) {
                BM = BM.subtract(BMT);
            }
            BM = BM.add(BMT);
            System.out.println(BM.toString());
        }
    }
}
