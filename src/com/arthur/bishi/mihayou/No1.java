package com.arthur.bishi.mihayou;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/15 20:12
 * @modifiedBy：
 * @version: 1.0
 */
public class No1 {
    public ArrayList<String> restoreIpAddresses(String ipStr) {
        // write code here
        ArrayList<String> list = new ArrayList<>();
        if (ipStr.length() == 0) return list;
        back(ipStr, 0, 3, list);
        return list;
    }

    private void back(String s, int i, int cnt, ArrayList<String> list) {
        if (cnt == 0) {
            String[] strs = s.split("\\.");
            if (strs.length < 4) return;
            for (String str : strs) {
                if (str.length() > 1 && str.charAt(0) == '0') return;
                if (Integer.parseInt(str) < 0 || Integer.parseInt(str) > 255) return;
            }
            list.add(s);
            return;
        }
        if (i >= s.length()) return;
        int n = s.length();
        back(s.substring(0, i + 1) + "." + s.substring(i + 1, n), i + 2, cnt - 1, list);
        if (i + 2 < n) {
            back(s.substring(0, i + 2) + "." + s.substring(i + 2, n), i + 3, cnt - 1, list);
        }
        if (i + 3 < n) {
            back(s.substring(0, i + 3) + "." + s.substring(i + 3, n), i + 4, cnt - 1, list);
        }
    }
}
