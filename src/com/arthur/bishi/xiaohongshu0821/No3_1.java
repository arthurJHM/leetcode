package com.arthur.bishi.xiaohongshu0821;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/21 21:11
 * @modifiedBy：
 * @version: 1.0
 */

public class No3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Movie[] movies = new Movie[n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            movies[i] = new Movie(s);
        }
        Arrays.sort(movies, Comparator.comparingInt(m -> m.begin));
        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (movies[j].begin >= movies[i].end) {
                    for (int k = j + 1; k < n; k++) {
                        if (movies[k].begin >= movies[j].end) {
                            maxTime = Math.max(maxTime, movies[i].during + movies[j].during + movies[k].during);
                        }
                    }
                }

            }
        }
        System.out.println(maxTime);
    }


    public static class Movie {
        public int begin;
        public int end;
        public int during;

        public Movie(String s) {
            String[] strs = s.split("-");
            this.begin = transferToInt(strs[0]);
            this.end = transferToInt(strs[1]);
            this.during = end - begin;
        }

        private int transferToInt(String begin) {
            String[] strs = begin.split(":");
            return Integer.parseInt(strs[0]) * 60 + Integer.parseInt(strs[1]);
        }

        @Override
        public String toString() {
            return "Movie{" +
                    "begin=" + begin +
                    ", end=" + end +
                    ", during=" + during +
                    '}';
        }
    }
}


