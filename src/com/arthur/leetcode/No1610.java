package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @program: leetcode
 * @description: 可见点的最大数目
 * @title: No1610
 * @Author hengmingji
 * @Date: 2021/12/17 21:33
 * @Version 1.0
 */
public class No1610 {
    public static void main(String[] args) {

    }

    double eps = 1e-9;
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int x = location.get(0);
        int y = location.get(1);
        double ang = angle * Math.PI / 180;
        int sameCnt = 0;
        ArrayList<Double> pointsAng = new ArrayList<>();
        int tempX;
        int tempY;
        for (List<Integer> point : points) {
            tempX = point.get(0);
            tempY = point.get(1);
            if(tempX == x && tempY == y) {
                sameCnt++;
                continue;
            }
            pointsAng.add(Math.atan2(tempY - y, tempX - x) + Math.PI);
        }
        Collections.sort(pointsAng);
        int n = pointsAng.size();
        for (int i = 0; i < n; i++) {
            pointsAng.add(pointsAng.get(i) + Math.PI * 2);
        }
        int max = 0;
        for (int i = 0, j = 0; j < pointsAng.size(); j++) {
            while (pointsAng.get(j) - pointsAng.get(i) > ang + eps && i < j) {
                i++;
            }
        max = Math.max(max, j - i + 1);
        }
        return max + sameCnt;
    }
}
